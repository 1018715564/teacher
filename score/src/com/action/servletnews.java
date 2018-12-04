package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.IGetnewsinfoImpl;

public class servletnews extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter oo = resp.getWriter();
		ServletContext app = req.getServletContext();
		String option = req.getParameter("option");
		if ("update".equals(option)) {
			// �鿴������¼�ķ���
		}
		if ("shouli".equals(option)) {
			// �޸ĵ�����¼�ķ���
			// ��ȡids
			String ids = req.getParameter("ids");
			// ����ҵ���߼���ķ���
			IGetnewsinfoImpl biz = new IGetnewsinfoImpl();
			if (biz.updatesimple(Integer.parseInt(ids))) {
				// ����޸ĳɹ����ӡ��yes
				oo.print("yesupdate");
			} else {
				oo.print("errupdate");
				// ���ʧ�����ӡ��err
			}
		}
		if ("fenye".equals(option)) {
			IGetnewsinfoImpl biz = new IGetnewsinfoImpl();
			// ��ȡֵ
			String page = req.getParameter("page");
			// ���ҳ������Ϊ����ִ��
			if (Integer.parseInt(page) <= 0) {
				req.setAttribute("news", 1);
			}
			if (Integer.parseInt(page) > biz.gettablepage(5)) {
				req.setAttribute("news", biz.gettablepage(5) + 1);
			}
			List<List<Object>> list = biz.getallfenye(Integer.parseInt(page));
			req.getSession().setAttribute("newsend", biz.gettablepage(Integer.parseInt(page)));
			req.setAttribute("newslist", list);
			req.getRequestDispatcher("/html/news.jsp").forward(req, resp);
		}
	}

}
