package com.biz;

import java.util.List;

import com.entity.EnInformation;

public interface Information {

		//����һ����¼
		public boolean add(EnInformation  en,String teacherid);
		//��ѯ�Ƿ����ظ���¼
		public boolean Cover(EnInformation  en);
		//ͨ����ʦ���ֲ�ѯid
		public List<Object> getid(String name);
}
