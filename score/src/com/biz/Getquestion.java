package com.biz;

import java.util.List;

import com.entity.question;

public interface Getquestion {
	//��ȡ�����б����Ϣ
	public List<List<Object>> getalllist(int pageindex);
	//���һ����
	public boolean addquestion(question  qu);
	//ͨ��id������
	public List<Object> getsimple(question  qu);
	//ͨ��id�޸�����
	public boolean nameupdate(question  qu);
	//ͨ��idɾ������
	public boolean delete(question  qu);
	//��������ĩҳ
	public int gettablerow(int simplepagenum);
}
