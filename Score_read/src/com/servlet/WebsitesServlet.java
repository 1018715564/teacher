package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.biz.IClassinfoImpl;
import com.biz.IIpquery;
import com.biz.IQuestionImpl;
import com.biz.ISendSuggestImpl;
import com.entity.ClassInformation;
import com.entity.IPqueryentity;
import com.entity.Suggesttable;
import com.entity.paperclasstable;

import net.sf.json.JSONObject;

@WebServlet("/WebsitesServlet.do")
public class WebsitesServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext app = request.getServletContext();
		PrintWriter o = response.getWriter();
		String type = request.getParameter("type");
		if ("information".equals(type)) {
			IIpquery ips = new IIpquery();
			response.setContentType("text/html;charset=utf-8");
			// ��ȡ�������ֵ
			String username = request.getParameter("username");
			String Professional = request.getParameter("Professional");
			String Class = request.getParameter("Class");
			String Teacher = request.getParameter("Teacher");
			String Course = request.getParameter("Course");
			// �ѻ�����Ϣ�����session��
			//�ѻ�ȡ����teachernameת����id�������ݿ���
			//����biz����
			IQuestionImpl biz=new IQuestionImpl();
			List<Object> list=biz.getteacherid(Teacher);
			//�Ѽ���ת��Ϊint����
			String teacher_id=StringUtils.join(list,"");
			//�浽session��
			session.setAttribute("teacher_id", teacher_id);
			session.setAttribute("teacher_name", Teacher);
			session.setAttribute("usernamedata", username);
			session.setAttribute("Professional", Professional);
			session.setAttribute("Class", Class);
			session.setAttribute("Teacher", Teacher);
			session.setAttribute("Course", Course);
			// //��ȡip�͵�ַ
			// String ip=request.getParameter("ip");
			// String address=request.getParameter("address");
			// System.out.println(ip+""+address);
			// //�ѻ�ȡ��ip�͵�ַ,����ҵ���߼��㱣��ip�͵�ַ����־�����ݿ�
			// IIpquery biz=new IIpquery();
			// //��ip and address�ŵ�ʵ����
			// IPqueryentity en=new IPqueryentity();
			// en.setIp(ip);
			// en.setAddress(address);
			// boolean bb=ips.IPHave(en);
			// ������·ÿ;ͽ���ҳ��
			// �������ɹ�
			// JSONObject js=new JSONObject();
			o.print("yes");
			o.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
		PrintWriter o = response.getWriter();
		HttpSession session = request.getSession();
		if ("user".equals(type)) {
			IQuestionImpl qu = new IQuestionImpl();
			response.setContentType("text/json;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			JSONObject json = new JSONObject();
			json.put("usernamedata", session.getAttribute("usernamedata"));
			// ����������
			List<Object> list = qu.getquestion(1);
			String questionname = StringUtils.join(list, "");
			json.put("questionname", questionname);
			o.print(json);
			o.close();
		} else if ("page".equals(type)) {
			String index = request.getParameter("index");
			// ����biz
			IQuestionImpl biz = new IQuestionImpl();
			JSONObject json = new JSONObject();
			List<Object> list = biz.getquestion(Integer.valueOf(index));
			// �����ĳ���
			String questionname = StringUtils.join(list, "");
			int tablerow = biz.getquestionrow();
			json.put("tablerow", tablerow);
			json.put("questionname", questionname);
			o.print(json);
			o.close();
		} else if ("tablerow".equals(type)) {
			// ����biz
			IQuestionImpl biz = new IQuestionImpl();
			int tablerow = biz.getquestionrow();
			JSONObject json = new JSONObject();
			json.put("tablerow", tablerow);
			o.print(json);
			o.close();
		} else if ("submitUp".equals(type)) {
			JSONObject json = new JSONObject();
			// ��ȡip�͵�ַ
			String cityname = request.getParameter("cityname");
			String cityip = request.getParameter("cityip");
			// ��ȡpass
			String pass = request.getParameter("pass");
			// ����biz
			IIpquery ip = new IIpquery();
			IPqueryentity ipHave = new IPqueryentity();
			ipHave.setIp(cityip);
			ipHave.setAddress(cityname);
			if (ip.IPHave(ipHave)) {
				// ���û�������ַ��ip�Ļ������Է��������ӵĲ���
				if (ip.IPquery(ipHave)) {
					// ���ip�������ӳɹ�
					IQuestionImpl qu = new IQuestionImpl();
					paperclasstable en = new paperclasstable();
					// ��ȡ3���ʴ���ķ���
					String que1 = request.getParameter("que1");
					String que2 = request.getParameter("que2");
					String que3 = request.getParameter("que3");
					// ��ȡ�ܷ�
					String Allscore = request.getParameter("allScore");
					// ֮����ʾ���Ϣ��sessionȡ��
					String username = (String) session.getAttribute("usernamedata");
					String Professional = (String) session.getAttribute("Professional");
					String Class = (String) session.getAttribute("Class");
					String Teacher_id = (String) session.getAttribute("teacher_id");
					String Teacher_name = (String) session.getAttribute("teacher_name");
					String Course = (String) session.getAttribute("Course");
					// ����biz
					en.setUser_name(username);
					en.setZhuanye_name(Professional);
					en.setClass_name(Class);
					en.setTeacher_name(Teacher_name);
					en.setTeacher_id(Teacher_id);
					en.setKecheng_name(Course);
					en.setQue1(Integer.valueOf(que1));
					en.setQue2(Integer.valueOf(que2));
					en.setQue3(Integer.valueOf(que3));
					en.setAllScore(Allscore);
					boolean bb=qu.insertInformation(en);
					if (bb) {
						// �����ӳɹ�
						json.put("yes", "yes");
						o.print(json);
					} else {
						json.put("no", "no");
						o.print(json);
					}
				}
			} else {
				// ������ݿ����д�ip�ͼ�¼���Ļ���ִ������ķ���
				json.put("ipDown", "ipDown");
				o.print(json);
				o.close();
			}

		} else if ("suggest".equals(type)) {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String ClassName = request.getParameter("Class");
			String Name = request.getParameter("Name");
			String Text = request.getParameter("Text");
			// ���÷���
			Suggesttable en = new Suggesttable();
			ISendSuggestImpl biz = new ISendSuggestImpl();
			en.setClassName(ClassName);
			en.setName(Name);
			en.setSuggest_Text(Text);
			boolean bb = biz.addSuggest(en);
			if (bb) {
				// �����ӳɹ�
				o.print("success");
			} else {
				o.print("err");
			}
		}else if("class".equals(type)){
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			//��ȡ��Կ
			String pass=request.getParameter("pass");
			//��ȡ��ip
			String ip=request.getParameter("cityip");
			String Professional = (String) session.getAttribute("Professional");
			String Class = (String) session.getAttribute("Class");
			String Teacher_id = (String) session.getAttribute("teacher_id");
			String Course = (String) session.getAttribute("Course");
			//����ʵ����
			ClassInformation cn=new ClassInformation();
			cn.setClassname(Class);
			cn.setProfessional(Professional);
			cn.setCourse(Course);
			cn.setTeacher(Teacher_id);
			cn.setPass(pass);
			//���÷���
			IClassinfoImpl biz=new IClassinfoImpl();
			if(biz.getclassinfo(cn)){
					//����ܲ鵽��¼��˵����Կ�Լ���Ϣ��ȷ
					o.print("keysuccess");
					o.close();
			}else{
				//���û�ܲ�ѯ����¼��˵����Կ�Լ���Ϣ��ԭ���ݲ�����
				//��Ҫ�����ip�����û������ύ
				//����ip��biz����
				IIpquery ipbiz=new IIpquery();
				if(ipbiz.deleteIp(ip)){
						//���ɾ���ɹ�
						o.print("keyerr");
						o.close();
				}
			}
		}
		doGet(request, response);
	}

}
