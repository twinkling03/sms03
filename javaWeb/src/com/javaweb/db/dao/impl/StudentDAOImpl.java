package com.javaweb.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaweb.db.dao.IStudent;
import com.javaweb.dbutil.DBConnection;
import com.javaweb.javabean.Student;

public class StudentDAOImpl implements IStudent {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private final String SELECT_ALL_STU="SELECT ID,STUNO,STUNAME,STUAGE FROM STUDENT WHERE STATUS=0 ORDER BY ID DESC;";
	private final String DELETE_STUDENT="UPDATE STUDENT SET STATUS=1 WHERE ID=?";
	private final String UPDATE_STUDENT="UPDATE STUDENT SET STUNO=?,STUNAME=?,STUAGE=? WHERE ID=?";
	private final String CHK_EXT_SXH="SELECT COUNT(STUNO)  NUM FROM STUDENT WHERE STUNO=?;";
	
	public List<Student> queryAllStudents() {
		// TODO Auto-generated method stub
		List<Student> stus_list=new ArrayList<Student>();
		try {
			conn=DBConnection.getConnection();
			pstmt=conn.prepareStatement(SELECT_ALL_STU);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Student stu=new Student();
				stu.setId(rs.getInt("id"));
				stu.setXuehao(rs.getString("stuno"));
				stu.setName(rs.getString("stuname"));
				stu.setAge(rs.getInt("stuage"));
				stus_list.add(stu);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.closeSatement(pstmt);
			DBConnection.closeConnection();
		}
		
		return stus_list;
	}


	public void deleteStudent(int id) {
		try {
			conn=DBConnection.getConnection();
			pstmt=conn.prepareStatement(DELETE_STUDENT);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.closeSatement(pstmt);
			DBConnection.closeConnection();
		}
		
	}


	public void saveStudent(Student stu) {
		try {
			conn=DBConnection.getConnection();
			pstmt=conn.prepareStatement(UPDATE_STUDENT);
			pstmt.setString(1,stu.getXuehao());
			pstmt.setString(2,stu.getName());
			pstmt.setInt(3,stu.getAge());
			pstmt.setInt(4,stu.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.closeSatement(pstmt);
			DBConnection.closeConnection();
		}
		
	}


	public boolean checkExistForStuNo(String xuehao) {
		boolean result=false;
		try {
			conn=DBConnection.getConnection();
			pstmt=conn.prepareStatement(CHK_EXT_SXH);
			pstmt.setString(1,xuehao);

			rs=pstmt.executeQuery();
			if(rs.next()){
				int r=rs.getInt("NUM");
				if(r>0){
					result=true;//代表学号已经在数据库中存在
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.closeSatement(pstmt);
			DBConnection.closeConnection();
		}
		return result;
	}

}
