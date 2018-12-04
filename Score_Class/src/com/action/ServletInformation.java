package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.biz.IInformationImpl;
import com.entity.EnInformation;

@WebServlet("/submitinformation.do")
public class ServletInformation extends HttpServlet {
	EnInformation en = new EnInformation();
	IInformationImpl biz = new IInformationImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		if ("information".equals(type)) {
			System.out.println("login");
			// ��ȡ��Ϣ
			String ClassName = request.getParameter("ClassName");
			String ClassZhuanye = request.getParameter("ClassZhuanye");
			String ClassTeacher = request.getParameter("ClassTeacher");
			String ClassKecheng = request.getParameter("ClassKecheng");
			String Passport = request.getParameter("Passport");
			// ����ʵ���װ������
			en.setClassName(ClassName);
			en.setClassZhuanye(ClassZhuanye);
			en.setClassTeacher(ClassTeacher);
			en.setClassKecheng(ClassKecheng);
			en.setPassport(Passport);
			// �ж���ʦid
			List<Object> list = biz.getid(ClassTeacher);
			if (list.size() == 0) {
				// ���û�������ʦ
				out.print("noteacher");
				out.close();
			} else {
				// ����ת��int���Ͳ��ұ��浽���ݿ�����Ϊ�����teacherid
				String id=StringUtils.join(list,"");
				// �ж������ֵ�����ݿ����Ƿ����
				boolean bb = biz.Cover(en);
				if (bb) {
					// ���Ϊ�棬˵����ֵ
					out.print("false");
					out.close();
				} else {
					// ����ҵ���߼���
					if (biz.add(en, id)) {
						// ����ɹ�
						out.print("success");
						out.close();
					} else {
						// ���ʧ��
						out.print("false");
						out.close();
					}
				}
			}
		}
	}

}
