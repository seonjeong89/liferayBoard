package sjkim.web.util;

import com.liferay.petra.string.StringPool;

import java.util.Base64;
import java.util.Random;

public class OSPStringUtil {
	
	public static String strNull(Object o) {
		if (o == null) {
			return StringPool.BLANK;
		}
		
		return deleteScriptTag(o.toString());
	}
	
	public static String deleteScriptTag(String str) {
		String returnStr = null;
		try {
			returnStr = replace(str,"<%","&lt;%");             
			returnStr = replace(returnStr,"%>","%&gt;");             
			returnStr = replace(returnStr,"<script","&lt;script");   
			returnStr = replace(returnStr,"</script","&lt;/script"); 
			returnStr = replace(returnStr,"javascript",""); 
			returnStr = replace(returnStr,"alert",""); 
			//returnStr = replace(returnStr,"<img","&lt;img"); 
		} catch (Exception e) {}
		return returnStr;
	}
	
	public static String strNull(Object o, String str) {
		if (o == null || o.toString().equals("")) {
			return str;
		}
		return deleteScriptTag(o.toString());
	}
	
	public static String replace(String str, String oldStr, String newStr) {
		StringBuffer result = new StringBuffer(str.length());
		int index1 = 0, index2 = 0;

		while((index2=str.indexOf(oldStr, index1)) >= 0)
		{
			result.append(str.substring(index1, index2));
			result.append(newStr);
			index1 = index2+oldStr.length();
		}
		result.append(str.substring(index1));           

		return result.toString();
	}
	
	/**
	 * JAVA String 난수 발생기
	 * @param index - 자릿수
	 * @param duplicate - 난수간 중복 허용
	 * @return
	 */
	public static String getRandomNumber(int index, boolean duplicate){
		Random rand = new Random();
		String numStr = "";
		
		for(int i=0;i<index;i++) {
			String ran = Integer.toString(rand.nextInt(10));
			
			if(duplicate){
				numStr += ran;
			}else{
				if(!numStr.contains(ran)) {
					numStr += ran;
				}else {
					 i-=1;
				}
			}
		}
		
		return numStr;
	}
	
	public static String enCodeBase64(String text) {
		return Base64.getEncoder().encodeToString(text.getBytes());
	}
	
	public static String deCodeBase64(String enCodeStr) {
		return new String(Base64.getDecoder().decode(enCodeStr));
	}
	
	/**
	 * 문자열 개인정보 보호 * 문자 치환 <br>
	 * 4글자에 * 한개씩 추가 <br>
	 * (ex. AA -> A*, AAAA -> A**A, AAAAAA -> AA**AA, AAAAAAAA -> AAA***AA) <br>
	 * @param privateText
	 * @return 
	 *
	 */
	public static String privateTextConverter(String privateText) {
		StringBuffer sb = new StringBuffer();
		sb.append(privateText);
		
		if(privateText.length() > 1) {
			int reminder = -1;
			int quotient2 = privateText.length() / 2;
			int quotient4 = privateText.length() / 4;
			
			if(privateText.length() > 2) {
				reminder += privateText.length() % 2;
			} else {
				reminder = 0;
			}
			
			for(int i = 0; i < (quotient4 + 1); i++) {
				int start = quotient2 + i + reminder;
				sb.replace(start, start+1, "*");
			}
			
			return sb.toString();
		}else {
			return privateText;
		}
	}
	
	/**
	 * 문자열 개인정보 보호 * 문자 치환 <br>
	 * 2의 배수로 증가 <br>
	 * (ex. AA -> A*, AAAA -> AA**, AAAAAA -> AA****, AAAAAAAA -> AAA*****) <br>
	 * @param privateText
	 * @return 
	 *
	 */
	public static String privateTextConverter2(String privateText) {
		StringBuffer sb = new StringBuffer();
		sb.append(privateText);
		
		int power = 0;
		if(privateText.length() > 1) {
			power++;
			for(int textLength = privateText.length(); textLength > 2; textLength /= 2) {
				power++;
			}
			
			for(int i = power; i< privateText.length(); i++) {
				sb.replace(i, i+1, "*");
			}
			
			return sb.toString();
		}else {
			return privateText;
		}
	}
	
	/**
	 * E-mail 개인정보 보호 * 문자 치환 (@ 이전 문자열만 치환) <br>
	 * @param emailText
	 * @return 
	 *
	 */
	public static String privateEmailConverter(String emailText) {
		if(emailText.indexOf("@") > 0) {
			return privateTextConverter(emailText.substring(0, emailText.indexOf("@"))).concat(emailText.substring(emailText.indexOf("@"), emailText.length()));
		}else {
			return privateTextConverter(emailText);
		}
	}
	
	/**
	 * E-mail 개인정보 보호 * 문자 치환2 (@ 이전 문자열만 치환) <br>
	 * @param emailText
	 * @return 
	 *
	 */
	public static String privateEmailConverter2(String emailText) {
		if(emailText.indexOf("@") > 0) {
			return privateTextConverter2(emailText.substring(0, emailText.indexOf("@"))).concat(emailText.substring(emailText.indexOf("@"), emailText.length()));
		}else {
			return privateTextConverter2(emailText);
		}
	}
}
