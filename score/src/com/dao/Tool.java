package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.sql.DataSource;

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
		public static String imagesupload(HttpServletRequest req,String name){
			Part part;
			String path = null;
			try {
				part = req.getPart(name);
				String header=part.getHeader("content-disposition");
				String filename=header.substring(header.indexOf("filename=")+10,header.length()-1);
				String filepath=req.getServletContext().getRealPath("upload/"+filename);
				path="upload/"+filename;
				part.write(filepath);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//��ȡ��Ϣͷ��Ϣ
			return path;
		};
}
