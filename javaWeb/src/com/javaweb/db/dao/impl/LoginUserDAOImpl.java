package com.javaweb.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javaweb.db.dao.ILoginUser;
import com.javaweb.dbutil.DBConnection;
import com.javaweb.javabean.LoginUser;


public class LoginUserDAOImpl implements ILoginUser {
	
	private Connection conn=DBConnection.getConnection();
	private PreparedStatement pstmt;
	private ResultSet rs;
	private final String SELECT_LOGIN_NAME_PWD="SELECT ID,NAME,PASSWD FROM LOGIN WHERE NAME=? AND passwd=?;";
	
	

	public LoginUser queryByNameAndPwd(String username,
			String pwd) {
		// TODO Auto-generated method stub
		LoginUser user=null;
		try {
			pstmt=conn.prepareStatement(SELECT_LOGIN_NAME_PWD);
			pstmt.setString(1, username);
			pstmt.setString(2, pwd);
			
			rs=pstmt.executeQuery();
			if(rs.next()){
				user=new LoginUser();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.closeSatement(pstmt);
			DBConnection.closeConnection();
		}
		return user;
	}

}
