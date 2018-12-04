package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.IScoreinfoImpl;
import com.entity.paperclasstable;

import net.sf.json.JSONObject;
public class servletScore extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req, resp);
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//��ȡ����
			String option=req.getParameter("option");
			//ƥ�����
			if("submit".equals(option)){
				//��ȡajax�������Ĳ���
				String que1=req.getParameter("que1");
				String que2=req.getParameter("que2");
				String que3=req.getParameter("que3");
				String que4=req.getParameter("que4");
				String user=(String)req.getSession().getAttribute("username");
				//�Ѳ�����װ��ʵ������
				paperclasstable en = new paperclasstable();
				IScoreinfoImpl biz=new IScoreinfoImpl();
				// �������ȷŵ�ʵ����
				//��session�����ŵ�ʵ����
				String Username=(String)req.getSession().getAttribute("Username");
				String select=(String)req.getSession().getAttribute("select");
				String teacher=(String)req.getSession().getAttribute("teacher");
				String clas=(String)req.getSession().getAttribute("clas");
				en.setSelect(select);
				en.setTeacher(teacher);
				en.setClas(clas);
				en.setUsername(Username);
				en.setUser_id(Integer.parseInt(user));
				en.setQue1(que1);
				en.setQue2(que2);
				en.setQue3(que3);
				en.setQue4(que4);
				//���������
				PrintWriter oo=resp.getWriter();
				//����bizҵ���߼���
				if(biz.addscore(en)){
					//���Ϊ�����json�������
					JSONObject js=new JSONObject();
					js.put("que",en);
					oo.print(js);
					oo.close();
				}
				
			}
		}
}
