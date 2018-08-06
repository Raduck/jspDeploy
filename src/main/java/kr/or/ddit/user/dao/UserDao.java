package kr.or.ddit.user.dao;

import kr.or.ddit.user.model.UserVo;

public class UserDao implements UserDaoInf{

	/**
	* Method : getUser
	* 최초작성일 : 2018. 7. 4.
	* 작성자 : PC20
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 :
	*/
	@Override
	public UserVo getUser(String userId) {
		//원래대로라면 : orm, jdbc 등을 이용하여 db를 통해 조회한 결과를 반환
		//servlet 테스트목적으로 임의의 고정된 값을 반환
		UserVo userVo = new UserVo();
		userVo.setUserId("brown");
		userVo.setPassword("1234");
		userVo.setUserNm("임현");
		return userVo;
	}

	
	
}
