package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Tool {
/**
 * 
 * writer��Shenhao
 * �����ࣺ������ر����ݿ�
 * TIME��2018/5/31
 * 0.5��
 */
	static Connection con=null;
	static ResultSet rs=null;
	/**
	 * �������ݿ�
	 * 
	 */
	public static Connection getConnection(){
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","swq891012");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	/**
	 * �ر����ݿ�����
	 */
	public static void sqlclose(){
		try{
			if(con!=null){
				con.close();
			}
			if(rs!=null){
				rs.close();
			}
		}catch(Exception e){
			
		}
		
	}
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
