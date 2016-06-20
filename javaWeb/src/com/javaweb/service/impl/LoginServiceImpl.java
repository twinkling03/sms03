package com.javaweb.service.impl;

import com.javaweb.db.dao.ILoginUser;
import com.javaweb.db.dao.impl.LoginUserDAOImpl;
import com.javaweb.javabean.LoginUser;
import com.javaweb.service.LoginService;

public class LoginServiceImpl implements LoginService {

	public LoginUser queryByNameAndPwd(String username, String pwd) {
		// TODO Auto-generated method stub
		ILoginUser userdao=new LoginUserDAOImpl();
		LoginUser user=userdao.queryByNameAndPwd(username, pwd);
	
		return user;
	}

}
