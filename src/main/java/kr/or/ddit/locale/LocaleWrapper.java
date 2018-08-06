package kr.or.ddit.locale;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class LocaleWrapper extends HttpServletRequestWrapper{
	private Map<String, String[]> map;

	
	public LocaleWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
		
		//기존 request 객체의 파라미터 map 복사
		map = new HashMap<String, String[]>(request.getParameterMap());
		
		//locale 파라미터가 없으면 기본 "ko"
		String[] localeComps = map.get("locale");
		
		if(localeComps==null || localeComps[0].equals("")){
			map.put("locale", new String[]{"ja"});
		}
		
		
	}


	@Override
	public String getParameter(String name) {
		String[] values = getParameterValues(name);
		if(values!=null)
			return values[0];
		else
			return null;
	}


	@Override
	public Map<String, String[]> getParameterMap() {
		// TODO Auto-generated method stub
		return map;
	}


	@Override
	public Enumeration<String> getParameterNames() {
		//첫번째? 값 호출
		Collections.enumeration(map.keySet());
		return super.getParameterNames();
	}


	@Override
	public String[] getParameterValues(String name) {
		return map.get(name);
	}

	
}
