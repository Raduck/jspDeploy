package kr.or.ddit.user.model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserVo implements HttpSessionBindingListener{
	private Logger logger = LoggerFactory.getLogger(UserVo.class);
	
	private String userId;
	private String password;
	private String userNm;

	public UserVo() {

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public boolean validData(String userId, String password) {
		if (this.getUserId().equals(userId)
				&& this.getPassword().equals(password)) {
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", password=" + password
				+ ", userNm=" + userNm + "]";
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		//session객체에서 session.setAttribute("userVo",userVo)가 호출 되었을 때
		logger.debug("httpSessionBinding valueBound"+event.getName());
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		//session객체에서 session.removeAttribute("userVo")가 호출 되었을 때
		logger.debug("httpSessionUnBinding valueUnBound"+event.getName());
	}

}
