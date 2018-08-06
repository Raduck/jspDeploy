package kr.or.ddit.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import kr.or.ddit.user.model.UserVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SessionAttributeListener implements HttpSessionAttributeListener{
	private Logger logger = LoggerFactory.getLogger(SessionAttributeListener.class);
	private Map<String, UserVo> loginSessionMap = new HashMap<String, UserVo>();
	
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		logger.debug("session attr added");
		logger.debug("se.getName"+se.getName());
		//login : 사용자가 정상적으로 로그인을 할경우 session에 userVo를 설정함
		//lisetener에서 userVo 같이 설정되는지 모니터링
		if(se.getName().equals("userVo")){
			se.getSession().getServletContext().setAttribute("loginSessionMap", loginSessionMap);
			UserVo userVo = (UserVo)se.getValue();
			loginSessionMap.put(userVo.getUserId(), userVo);
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		logger.debug("session attr removed");
		if(se.getName().equals("userVo")){
			UserVo userVo = (UserVo)se.getValue();
			loginSessionMap.remove(userVo.getUserId());
			//loginSessionMap.remove(userVo.getUserId(), userVo); 버젼
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		logger.debug("session attr replaced");
	}

}
