package com.biz;

import java.util.List;

import com.entity.Usertable;

public interface GetuserInfo {
	/**
	 * �޸�ͷ��
	 */
	public boolean insertimg(Usertable en);
	/**
	 * �����˺ź������ѯͷ�����Ϣ��ֻͷ��
	 */
	public List<Object> getheadimg(Usertable en);
}
