package com.javaweb.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 该类是用来获取数据库链接：
 * step1. 加载数据库驱动,只加载一次
 * step2. 获取数据库链接
 * step3. 增删改查操作（CRUD）
 * step4. 关闭数据库链接
 * @author Administrator
 *
 */
public class DBConnection {
	
	static{
	//step1 加载数据库驱动,只加载一次，static中的代码会在
	//当前类DBConnection由JVM加载到内存的时候执行。
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
	 * step2. 获取数据库链接
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
	 * 关闭数据库连接
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
	 * 关闭查询
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
