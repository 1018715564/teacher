package com.action;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.IGetinfomationImpl;
import com.biz.IGetnewsinfoImpl;
import com.biz.IGetquestionImpl;
import com.biz.IGetuserInfoImpl;
import com.entity.Usertable;

public class navservlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String option=req.getParameter("option");
			doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String option=req.getParameter("option");
		ServletContext app=req.getServletContext();
		if(option.equals("teacher")){
			app.setAttribute("pages",1);
			IGetinfomationImpl teabiz=new IGetinfomationImpl();
			List<List<Object>> teacherlist=teabiz.getall(1);
			req.setAttribute("teacherlist",teacherlist);
			req.getRequestDispatcher("html/teacher_list.jsp").forward(req, resp);
		}
		if(option.equals("news")){
			IGetnewsinfoImpl biz=new IGetnewsinfoImpl();
			List<List<Object>> newslist=biz.getnews(1);
			req.setAttribute("newslist",newslist);
			app.setAttribute("newsPage", biz.getallfenye(5));
			req.getRequestDispatcher("html/news.jsp").forward(req, resp);
		}
		if("userinfo".equals(option)){
			//�ѵ�½���û����������ȡ��
			IGetuserInfoImpl biz=new IGetuserInfoImpl();
			Usertable en=new Usertable();
			en.setUser_id(req.getSession().getAttribute("username"));
			en.setUser_pd(req.getSession().getAttribute("password"));
			//����Ƭ����ȥ�Ժ󣬾ͽ������������request������
			List<Object> list=biz.getheadimg(en);
			app.setAttribute("imghead",list.get(0));
			req.getRequestDispatcher("html/userinfo.jsp").forward(req, resp);
		}
		if("question".equals(option)){
			//��ȡ����б�
			IGetquestionImpl que=new IGetquestionImpl();
			List<List<Object>> list=que.getalllist(1);
			//��list�ŵ�request��Χ�ı�����
			req.setAttribute("questionlist",list);
			//ת����jspҳ��
			req.getRequestDispatcher("html/question.jsp").forward(req, resp);
		}
	}
}