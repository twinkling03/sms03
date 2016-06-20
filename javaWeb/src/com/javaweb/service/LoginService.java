package com.javaweb.service;

import com.javaweb.javabean.LoginUser;

public interface LoginService {
	LoginUser queryByNameAndPwd(String username,String pwd);
}
