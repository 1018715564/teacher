package com.biz;

import java.util.List;

import com.entity.paperclasstable;

public interface Question {
		//��ѯ���ݿ��е���
		public List<Object> getquestion(int pages);
		//��ȡ���ݿ��ж�����
		public int getquestionrow();
		//���������Ϣ
		public boolean insertInformation(paperclasstable en);
		//ͨ����ʦ���ֲ�ѯ����id
		public List<Object> getteacherid(String name);
}
