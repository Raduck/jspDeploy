package kr.or.ddit.cookie.util;

public class CookieUtil {

	public String getCookie(String cookie, String name) {
		// cookie : userId=brown; rememberMe=y

		String[] cookies = cookie.split("; ");
		String cookieResult = "";
		//cookieStr : userId=brown, rememberMe=y; checkYn=n
		for (String cookieStr : cookies) {
			String[] cookieNameValue = cookieStr.split("=");
			
			String cookieName = cookieNameValue[0];
			String cookieValue = cookieNameValue[1];
			
			if(name.equals(cookieName)){
				cookieResult = cookieValue;
				break;
			}
		
		}

		return cookieResult;
	}
}
