package com.javaweb.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * ������������ȡ���ݿ����ӣ�
 * step1. �������ݿ�����,ֻ����һ��
 * step2. ��ȡ���ݿ�����
 * step3. ��ɾ�Ĳ������CRUD��
 * step4. �ر����ݿ�����
 * @author Administrator
 *
 */
public class DBConnection {
	
	static{
	//step1 �������ݿ�����,ֻ����һ�Σ�static�еĴ������
	//��ǰ��DBConnection��JVM���ص��ڴ��ʱ��ִ�С�
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};

	private static Connection conn;
	private static String dbURL="jdbc:sqlserver://172.16.1.253:1433;databaseName=Student";
	
	private DBConnection(){}
	
	/**
	 * step2. ��ȡ���ݿ�����
	 * @return
	 */
	public static Connection getConnection(){
		try {
			if(conn==null || conn.isClosed()){
				conn=DriverManager.getConnection(dbURL,"sa","123");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * �ر����ݿ�����
	 */
	public static void closeConnection(){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * �رղ�ѯ
	 */
	public static void closeSatement(Statement stmt){
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		if(DBConnection.getConnection()!=null){
			System.out.println("DB connected");
		}else{
			System.out.println("Can't connect to DB");
		}
	}
}
