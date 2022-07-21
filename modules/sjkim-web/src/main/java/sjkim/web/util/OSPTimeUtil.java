package sjkim.web.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class OSPTimeUtil {
	private static final ZoneId zoneId = ZoneId.of("Asia/Seoul");
	private static DateTimeFormatter formatterSecond;
	private static DateTimeFormatter formatterDay;
	private static DateTimeFormatter formatterDayEmpty;
	private static DateTimeFormatter formatterDay6type;
	private static DateTimeFormatter formatterYear2type;
	private static DateTimeFormatter formatterYearDateTime;
	private static DateTimeFormatter formatterYear;
	
	static{
		formatterSecond = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		formatterDay =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formatterDayEmpty =  DateTimeFormatter.ofPattern("yyyyMMdd");
		formatterDay6type =  DateTimeFormatter.ofPattern("yyMMdd");
		formatterYear2type =  DateTimeFormatter.ofPattern("yy");
		formatterYearDateTime =  DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		formatterYear =  DateTimeFormatter.ofPattern("yyyy");
	}
	
	/**
	 * 년타입 변경
	 * @param date - DB에 있는 DATE값 그대로 입력
	 * @return String
	 */
	public static String getTimeByYear(Date date) {
		LocalDateTime parsedLocalDateTime = date.toInstant().atZone(zoneId).toLocalDateTime();
		return parsedLocalDateTime.format(formatterYear);
	}
	
	/**
	 * 년-월-일 시간:분:초 타입 변경
	 * @param date - DB에 있는 DATE값 그대로 입력
	 * @return String
	 */
	public static String getTimeBySecond(Date date) {
		if(date != null) {
			LocalDateTime parsedLocalDateTime = date.toInstant().atZone(zoneId).toLocalDateTime();
			return parsedLocalDateTime.format(formatterSecond);
		}else {
			return "-";
		}
	}
	
	
	/**
	 * 년-월-일  타입 변경
	 * @param date - DB에 있는 DATE값 그대로 입력
	 * @return String
	 */
	public static String getTimeByDay(Date date) {
		if(date != null && date.toString() != "") {
			LocalDateTime parsedLocalDateTime = date.toInstant().atZone(zoneId).toLocalDateTime();
			return parsedLocalDateTime.format(formatterDay);
		}else {
			return "";
		}
	}
	
	/**
	 * 년-월-일  타입 변경
	 * @param date - DB에 있는 DATE값 그대로 입력
	 * @return String
	 */
	public static String getTimeByDayEmpty(Date date) {
		LocalDateTime parsedLocalDateTime = date.toInstant().atZone(zoneId).toLocalDateTime();
		return parsedLocalDateTime.format(formatterDayEmpty);
	}
	
	/**
	 * 년월일  타입 변경 (6자리)
	 * @param date - DB에 있는 DATE값 그대로 입력
	 * @return String
	 */
	public static String getTimeByDaySixType(Date date) {
		LocalDateTime parsedLocalDateTime = date.toInstant().atZone(zoneId).toLocalDateTime();
		return parsedLocalDateTime.format(formatterDay6type);
	}
	
	/**
	 * 년  타입 변경 (2자리)
	 * @param date - DB에 있는 DATE값 그대로 입력
	 * @return String
	 */
	public static String getTimeByYearTwoType(Date date) {
		LocalDateTime parsedLocalDateTime = date.toInstant().atZone(zoneId).toLocalDateTime();
		return parsedLocalDateTime.format(formatterYear2type);
	}
	
	/**
	 * 년-월-일  타	입 변경(14자리 / 년월일시분초)
	 * @param date - DB에 있는 DATE값 그대로 입력
	 * @return
	 */
	public static String getTimeByYearDayTime(Date date) {
		LocalDateTime parsedLocalDateTime = date.toInstant().atZone(zoneId).toLocalDateTime();
		return parsedLocalDateTime.format(formatterYearDateTime);
	}
	
	/**
	 * Target 날짜가 Compare 날짜보다 이후 날짜인지 체크
	 * @param targetDate
	 * @param compareDate
	 * @return
	 */
	public static boolean isAfterDate(Date targetDate, Date compareDate) {
		return targetDate.after(compareDate);
	}
	
	/**
	 * Target 날짜가 Compare 날짜보다 이전 날짜인지 체크 
	 * @param targetDate + 1
	 * @param compareDate
	 * @return
	 */
	public static boolean isBeforeDate(Date targetDate, Date compareDate) {
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(targetDate);
		endCalendar.add(Calendar.DATE, 1);
		targetDate = endCalendar.getTime();
		return targetDate.before(compareDate);
	}
	
	/**
	 * Compare 날짜가 beforeDate보다 크고 afterDate보다 작은지 체크 
	 * @param beforeDate
	 * @param afterDate
	 * @param compareDate
	 * @return
	 */
	public static boolean comparedDate(Date beforeDate, Date afterDate, Date compareDate) {
		boolean compared = false;
		// compareDate가 before보다 크고			&& compareDate가 after보다 작은지
		if(isAfterDate(compareDate, beforeDate) && isBeforeDate(afterDate, compareDate)) compared = true;
		
		return compared;
	}
	
	/**
	 * date가 startDate와 EndDate 사이에 있는지 반환  
	 * 
	 * @param date yyyymmdd
	 * @param startDate yyyymmdd
	 * @param endDate yyyymmdd
	 * @return
	*/
	public static boolean isWithinRange(String date, String startDate, String endDate){
		if(date.length() != 8 || startDate.length() != 8 || endDate.length() != 8){
			return false;
		}
		
		date = date.substring(0,4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
		startDate = startDate.substring(0,4) + "-" + startDate.substring(4, 6) + "-" + startDate.substring(6, 8);
		endDate = endDate.substring(0,4) + "-" + endDate.substring(4, 6) + "-" + endDate.substring(6, 8);
		
		LocalDate localdate = LocalDate.parse(date);
		LocalDate startLocalDate = LocalDate.parse(startDate);
		LocalDate endLocalDate = LocalDate.parse(endDate);
		endLocalDate = endLocalDate.plusDays(1); // endDate는 포함하지 않으므로 +1일을 해줘야함.
		
		return ( ! localdate.isBefore( startLocalDate ) ) && ( localdate.isBefore( endLocalDate ) );
	}
}

