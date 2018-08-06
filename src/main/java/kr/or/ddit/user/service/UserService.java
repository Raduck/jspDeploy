package kr.or.ddit.user.service;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.dao.UserDaoInf;
import kr.or.ddit.user.model.UserVo;

public class UserService implements UserServiceInf{

	@Override
	public UserVo getUser(String userId) {
		UserDaoInf userDao = new UserDao();
		return userDao.getUser(userId);
	}

}
