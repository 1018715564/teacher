package com.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.ISugggesttableImpl;
import com.entity.Sugggesttable;

public class servletsuggest extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		  resp.setContentType("text/html;charset=UTF-8");
		//��ȡ����
		String option=req.getParameter("option");
			if(option.equals("submit")){
				//��ȡ�ı�������
				String name=req.getParameter("name");
				String clas=req.getParameter("clas");
				System.out.println(clas);
				String text=req.getParameter("text");
				//����ʵ����
				Sugggesttable en =new Sugggesttable();
				en.setClass_name(clas);
				en.setUser_name(name);
				en.setText(text);
				//����biz
				ISugggesttableImpl biz=new ISugggesttableImpl();
				if(biz.add(en)){
					//���Ϊ��ת�����ύ�ɹ�ҳ��
					req.getRequestDispatcher("html/success.jsp").forward(req, resp);
				}else{
					resp.sendRedirect("up_sugggest.jsp");
				}
				
			}
	}
}
