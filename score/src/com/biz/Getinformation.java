package com.biz;

import java.util.List;

import com.entity.Teachertable;

public interface Getinformation {
		/**
		 * ��ȡ�б���Ϣ����ҳ����������ǰҳ����
		 */
	public List<List<Object>> getall(int pageindex);
	/**
	 * ͨ��idɾ����Ϣ
	 */
	public boolean deleteinformation(int ids);
	/**
	 * ���ӵ�����Ϣ
	 */
	public boolean addinformation(Teachertable en);
	/**
	 * ͨ��id��ѯ��Ϣ
	 */
	public List<Object> getsimpleinformation(int ids);
	/**
	 * �޸ĵ���
	 */
	public boolean updatesimple(Teachertable en);
	/**
	 * ȷ��һ�������ж���ҳ
	 */
	public int gettablepage(int pagesize);
	/**
	 * �������ֲ�ѯ
	 */
	public List<List<Object>> getusernamelist(int pageindex,String username);
	/**
	 * ����id��ѯ
	 */
	public List<List<Object>> getusernumlist(int pageindex,String username);
	
}
