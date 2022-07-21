package sjkim.web.display;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.LabelItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItem;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

import javax.portlet.PortletURL;

public interface DisplayContextInterface {
	
	/*Default Portlet URL*/
	public PortletURL getPortletURL();
	
	/*Toolbar ClearResultsURL*/
	public String getClearResultsURL();
	
	/*Toolbar searchActionURL*/
	public String getSearchActionURL();
	
	/*Toolbar sortingURL*/
	public String getSortingURL();
	
	/*Toolbar showCreationMenu*/
	public boolean showCreationMenu();
	
	/*Toolbar creationMenu*/
	public CreationMenu getCreationMenu();
	
	/**
	 * Toolbar viewTypeItems
	 * Card, List, Table Selector
	 * */
	public List<ViewTypeItem> getViewTypeItems();
	
	/* Toolbar filterDropdownItems */
	public List<DropdownItem> getFilterDropdownItems();
	
	/* Toolbar filterLabelItems - navigation filer가 존재 할 경우에만 구현*/
	public List<LabelItem> getFilterLabelItems();
	
	/*Column Drop Down List - row에 dropdown 이 있을 경우에만 구현*/
	public List<DropdownItem> getColumnDropdownItems();
	
	/*검색 관련 비즈니스 로직*/
	public SearchContainer getSearchContainer() throws PortalException;

	
	
}
