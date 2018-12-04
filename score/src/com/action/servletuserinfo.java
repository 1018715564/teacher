package com.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.biz.IGetuserInfoImpl;
import com.dao.Tool;
import com.entity.Usertable;
@WebServlet("/userinfo.do")
@MultipartConfig
public class servletuserinfo extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext app=req.getServletContext();
		//�ѵ�½���û����������ȡ��
		req.getSession().getAttribute("username");
		req.getSession().getAttribute("password");
		//ʵ����
		Usertable en=new Usertable();
		en.setUser_id(req.getSession().getAttribute("username"));
		en.setUser_pd(req.getSession().getAttribute("password"));
		en.setUser_img(Tool.imagesupload(req, "file"));
		//����ҵ���߼��㷽��
		IGetuserInfoImpl biz=new IGetuserInfoImpl();
		biz.insertimg(en);
		//����Ƭ����ȥ�Ժ󣬾ͽ������������request������
		List<Object> list=biz.getheadimg(en);
		System.out.println(list);
		app.setAttribute("imghead",list.get(0));
		System.out.println(list.get(0));
		req.getRequestDispatcher("html/userinfo.jsp").forward(req, resp);
	}
}
