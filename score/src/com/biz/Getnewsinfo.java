package com.biz;

import java.util.List;

import com.entity.newstable;

public interface Getnewsinfo {
	/**
	 * ��ȡȫ������Ϣ�б�
	 */
	public List<List<Object>> getnews(int pageindex);
	/**
	 * �޸ĵ�������Ϣ״̬
	 */
	public boolean updatesimple(int ids);
	/**
	 * ȷ��һ�����ж���ҳ
	 */
	public int gettablepage(int pageindex); 
	/**
	 * ��ȡ���з�ҳ��ʾ
	 */
	public List<List<Object>> getallfenye(int page);
}
