package com.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.paperclasstable;

public class servlettxwj extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��ȡ�û�
		req.setCharacterEncoding("utf-8");
		String option = req.getParameter("option");
		if (option.equals("login")) {
			// �������Ϊ��½�ͱ����û���д����Ϣ��������
			// List<Object> list=new ArrayList<Object>();
			// ��ȡ��Ϣ
			String username = req.getParameter("username");
			String select = req.getParameter("select");
			String teacher = req.getParameter("teacher");
			String clas = req.getParameter("clas");
			paperclasstable en = new paperclasstable();
			// �������ȷŵ�ʵ����
			//�����ݷ���session������
			req.getSession().setAttribute("Username",username);
			req.getSession().setAttribute("select",select);
			req.getSession().setAttribute("teacher",teacher);
			req.getSession().setAttribute("clas",clas);
			// ���û������ʼ����ʱ��ת�������ҳ��
			req.getRequestDispatcher("html/paper.jsp").forward(req, resp);
		}
	}
}
