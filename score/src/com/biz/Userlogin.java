package com.biz;

import java.math.BigDecimal;

import com.entity.Usertable;

public interface Userlogin {
	/**
	 * �û���½��ҵ��
	 */
	public boolean UserLogin(Usertable user);
	/**
	 * �û�ע���ҵ��
	 */
	public boolean UserRigster(Usertable user);
	/**
	 * �ж��Ƿ�Ϊ����Ա�ķ���
	 */
	public boolean manage(Usertable user);
	/**
	 * �ж�ע���Ƿ��д��û�
	 */
	public boolean havepeople(Usertable user);
	/**
	 * ����Ա�ж��û�������
	 */
	public BigDecimal columnuser();
	/**
	 * ����Ա�ж���Ϣ������
	 */
	public BigDecimal columnnews();
	/**
	 * ����Ա�ж����������ƽ����
	 * 
	 */
	public BigDecimal getque1();
	public BigDecimal getque2();
	public BigDecimal getque3();

}
