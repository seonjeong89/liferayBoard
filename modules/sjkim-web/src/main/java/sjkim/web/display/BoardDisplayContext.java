package sjkim.web.display;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.LabelItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.LabelItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItem;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;

import sjkim.model.Board;
import sjkim.service.BoardLocalServiceUtil;
import sjkim.service.persistence.BoardPersistence;
import sjkim.web.constants.SjkimWebCommandKeys;
import sjkim.web.constants.SjkimWebPortletKeys;
import sjkim.web.util.CustomUtil;
import sjkim.web.util.OSPRequestUtil;

public class BoardDisplayContext implements DisplayContextInterface{

	// 파라미터 세팅
	public BoardDisplayContext(
		HttpServletRequest httpServletRequest, RenderRequest renderRequest,
		RenderResponse renderResponse) {
		
		this._httpServletRequest = httpServletRequest;
		this._renderRequest = renderRequest;
		this._renderResponse = renderResponse;
		
		ThemeDisplay themeDisplay = (ThemeDisplay)_httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		this._userId = themeDisplay.isSignedIn() ? themeDisplay.getUserId() : 0;
		this._groupId = themeDisplay.getScopeGroupId();
	}
	
	@Override
	public PortletURL getPortletURL() {
		PortletURL portletURL = _renderResponse.createRenderURL();

		String keywords = _getKeywords();
		if (Validator.isNotNull(keywords)) {
			portletURL.getRenderParameters().removeParameter("keywords");
			portletURL.getRenderParameters().setValue("keywords", keywords);
		}
		
		String navigation = _getNavigation();
		if (Validator.isNotNull(navigation)) {
			portletURL.getRenderParameters().setValue("navigation", navigation);
		}
		
		portletURL.getRenderParameters().setValue("orderByCol", _getOrderByCol());
		portletURL.getRenderParameters().setValue("orderByType", _getOrderByType());
		
		return portletURL;
	}

	@Override
	public String getClearResultsURL() {
		PortletURL clearResultsURL = getPortletURL();
		clearResultsURL.getRenderParameters().removeParameter("keywords");
		clearResultsURL.getRenderParameters().removeParameter("navigation");
		clearResultsURL.getRenderParameters().setValue("orderByCol", StringPool.BLANK);
		clearResultsURL.getRenderParameters().setValue("orderByType", StringPool.BLANK);
		
		return clearResultsURL.toString();
	}

	@Override
	public String getSearchActionURL() {
		PortletURL searchActionURL = getPortletURL();
		return searchActionURL.toString();
	}

	@Override
	public String getSortingURL() {
		PortletURL sortingURL = getPortletURL();
		sortingURL.getRenderParameters().setValue("orderByType", Objects.equals(_getOrderByType(), "asc") ? "desc" : "asc");
		return sortingURL.toString();
	}

	// + 버튼
	@Override
	public boolean showCreationMenu() {
		long userId = _userId;
		if(userId>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public CreationMenu getCreationMenu() {
		PortletURL portletURL = PortletURLFactoryUtil.create(_renderRequest, SjkimWebPortletKeys.SJKIMWEB , PortletRequest.RENDER_PHASE);
		try {
			portletURL.setPortletMode(PortletMode.VIEW);
			portletURL.setWindowState(LiferayWindowState.MAXIMIZED);
		} catch (WindowStateException | PortletModeException e) {
			e.printStackTrace();
		}
		
		return new CreationMenu() {
			
			{
				addDropdownItem(dropdownItem -> {
					dropdownItem.setHref(
						portletURL,
						"mvcRenderCommandName", SjkimWebCommandKeys.BOARD_REGIST_RENDER, 
						"backURL", PortletURLUtil.getCurrent(_renderRequest, _renderResponse).toString());
					dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "등록"));
				});
			}
		};
	}

	@Override
	public List<ViewTypeItem> getViewTypeItems() {
		return null;
	}

	@Override
	public List<DropdownItem> getFilterDropdownItems() {
		return new DropdownItemList() {
			{
				
				addGroup(
					dropdownGroupItem -> {
						dropdownGroupItem.setDropdownItems(_getFilterNavigationDropdownItems());
						dropdownGroupItem.setLabel(LanguageUtil.get(_httpServletRequest, "status"));
					}
				);
				
				addGroup(
					dropdownGroupItem -> {
						dropdownGroupItem.setDropdownItems(_getOrderByDropdownItems());
						dropdownGroupItem.setLabel(LanguageUtil.get(_httpServletRequest, "order-by"));
					}
				);
			}
		};
	}

	@Override
	public List<LabelItem> getFilterLabelItems() {
		final String navigation = _getNavigation();
		
		return new LabelItemList() {
			{
				if (!navigation.equals(LanguageUtil.get(_httpServletRequest, "ALL"))){
					add(labelItem -> {
						PortletURL removeLabelURL = getPortletURL();
						removeLabelURL.getRenderParameters().setValue("navigation", LanguageUtil.get(_httpServletRequest, "ALL"));

						labelItem.putData("removeLabelURL", removeLabelURL.toString());
						labelItem.setCloseable(true);
						labelItem.setLabel(LanguageUtil.get(_httpServletRequest, 
								"getFilterLabelItems"
								));
					});
				}
			}
		};
	}

	@Override
	public List<DropdownItem> getColumnDropdownItems() {
		return DropdownItemList.of(() -> {
			DropdownItem dropdownItem = new DropdownItem();
			dropdownItem.putData("action", Constants.REMOVE);
			dropdownItem.setHref(StringBundler.concat("javascript:", _renderResponse.getNamespace(),"remove();"));
			dropdownItem.setIcon("minus-circle");
			dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, Constants.REMOVE));
			dropdownItem.setQuickAction(true);
			return dropdownItem;
		});
	}
	
	// jspf에서 호출한 dropdown 버튼
	public List<DropdownItem> getDataDropdownItems(long boardNo, String boardWriter, Boolean isAdmin) {
		// 현재 로그인한 아이디가 admin인지 확인 후 맞으면 전체 글에 ... 버튼을 생성한다.
		if(isAdmin) {
			return new DropdownItemList() {
				{	
					addGroup(
						dropdownGroupItem -> {
							dropdownGroupItem.setDropdownItems(_getDataExecuteDropdownItems(boardNo));
						});
				}
			};
		} else {	// admin이 아닐때 본인이 작성한 글만 ... 버튼 나오도록 구현
		
			// 현재 로그인한 유저 정보를 가져온다.
			ThemeDisplay themeDisplay = (ThemeDisplay)_httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
			User user = themeDisplay.getUser();
			String writer = (String) user.getScreenName();
			
			// 게시글 작성자와 로그인한 유저 정보가 일치하면 ... 버튼을 생성한다.
			if(writer.equals(boardWriter)) {
				return new DropdownItemList() {
					{	
						addGroup(
							dropdownGroupItem -> {
								dropdownGroupItem.setDropdownItems(_getDataExecuteDropdownItems(boardNo));
							});
					}
				};
			} else {
				return null;
			}
		}	
	}
	
	private List<DropdownItem> _getDataExecuteDropdownItems(long boardNo) {
		return new DropdownItemList() {
			{	
				add(
					dropdownItem -> {
						//다국어 처리 예시 하지만 우린 다국어 안하니까 그냥 한글로 하드코딩
						dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "수정"));
						//스크립트 function 호출
						dropdownItem.setHref(StringBundler.concat("javascript:","updateFormBoard("+ boardNo +");"));
					});
				
				add(
					dropdownItem -> {
						dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "삭제"));
						dropdownItem.setHref(StringBundler.concat("javascript:","deleteBoardAction("+ boardNo +");"));
					});
			}
		};
	}


	@Override
	public SearchContainer getSearchContainer() throws PortalException {
		if (_searchContainer != null) {
			return _searchContainer;
		}
		
		SearchContainer searchContainer = new SearchContainer(
				_renderRequest, 
				PortletURLUtil.getCurrent(_renderRequest, _renderResponse), 
				ListUtil.fromString("name,type,status"), 
				"no-results-were-found"
				
		);
		// 정렬 세팅
		String orderByCol = _getOrderByCol();
		String orderByType = _getOrderByType();
		OrderByComparator orderByComparator = OrderByComparatorFactoryUtil.create("Board", orderByCol, orderByType.equals("asc"));
		searchContainer.setOrderByCol(orderByCol);
		searchContainer.setOrderByType(orderByType);
		searchContainer.setOrderByComparator(orderByComparator);
		
		// 페이징 세팅
		int start = searchContainer.getStart();
		int end = searchContainer.getEnd();
		// 검색어 세팅
		String keyword = _getKeywords();
		
		ThemeDisplay themeDisplay = (ThemeDisplay) _renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<Board> results = null;
		
		long total = 0;
		results = BoardLocalServiceUtil.searchBoardList("%"+keyword+"%", start, end, orderByComparator);
		total = BoardLocalServiceUtil.getBoardsCount();
		searchContainer.setResults(results);
		searchContainer.setTotal(BoardLocalServiceUtil.searchBoardListCount("%"+keyword+"%"));
		_searchContainer = searchContainer;
		return _searchContainer;
	}
	
	// 검색어 가져오기
	private String _getKeywords() {
		if (_keywords == null) {
			_keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		}

		return _keywords;
	}
	
	// 필터 컬럼 가져오기
	private String _getNavigation() {
		if (_navigation == null) {
			_navigation = CustomUtil.strNull(OSPRequestUtil.getParameterMap(_httpServletRequest).get("navigation"), "ALL");
		}
		return _navigation;
	}
	
	// 정렬 컬럼 가져오기
	private String _getOrderByCol() {
		if (_orderByCol == null) {
			_orderByCol = CustomUtil.strNull(OSPRequestUtil.getParameterMap(_httpServletRequest).get("orderByCol"), "boardWriteDate");
		}
		return _orderByCol;
	}
	
	// 정렬 오름차순, 내림차순
	private String _getOrderByType() {
		if (_orderByType == null) {
			_orderByType = CustomUtil.strNull(OSPRequestUtil.getParameterMap(_httpServletRequest).get("orderByType"), "desc");
		}
		return _orderByType;
	}

	// 필터
	private List<DropdownItem> _getFilterNavigationDropdownItems() {
		DropdownItemList navigationDropdownitems = new DropdownItemList();
		
		navigationDropdownitems.add(dropdownItem -> {
			PortletURL portletUrl = getPortletURL();
			dropdownItem.setActive(Objects.equals(_getNavigation(), "ALL"));
			dropdownItem.setHref(portletUrl, "navigation", "ALL");
			dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, LanguageUtil.get(_httpServletRequest, "All")));
		});
		
		return navigationDropdownitems;
	}

	private PortletURL _getCurrentSortingURL() throws PortletException {
		PortletURL sortingURL = getPortletURL();
		sortingURL.getRenderParameters().setValue("orderByCol", _getOrderByCol());
		return sortingURL;
	}

	// 정렬
	private List<DropdownItem> _getOrderByDropdownItems() {
		return new DropdownItemList() {
			{
				add(
						dropdownItem -> {
							dropdownItem.setActive(Objects.equals(_getOrderByCol(), "boardWriteDate"));
							dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol","boardWriteDate");
							dropdownItem.setLabel(
									LanguageUtil.get(_httpServletRequest,"WriteDate"));
						}
					);
				
				add(
					dropdownItem -> {
						dropdownItem.setActive(Objects.equals(_getOrderByCol(), "boardTitle"));
						dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol","boardTitle");
						dropdownItem.setLabel(
								LanguageUtil.get(_httpServletRequest,"Title"));
					}
				);
				
			
			}
		};
	}

	private static Log _log = LogFactoryUtil.getLog(BoardDisplayContext.class);
	
	private final HttpServletRequest _httpServletRequest;
	private final RenderRequest _renderRequest;
	private final RenderResponse _renderResponse;
	
	private final long _userId;
	private final long _groupId;
	private String _navigation;
	private String _keywords;
	private String _orderByType;
	private String _orderByCol;
	
	private SearchContainer _searchContainer;
}
