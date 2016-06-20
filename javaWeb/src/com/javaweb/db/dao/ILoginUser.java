package com.javaweb.db.dao;

import com.javaweb.javabean.LoginUser;

public interface ILoginUser {

	//insert
	
	//update
	
	//select
	LoginUser queryByNameAndPwd(String username,String pwd);
	
	//delete
	
}
