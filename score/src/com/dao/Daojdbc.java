package com.dao;

import java.util.List;

public interface Daojdbc {
	 /**
     *  ����һ����¼
     */
	public List<Object> getSimpleObject(String sql,List<Object> list);
	
	
	
	/*
	 * 
	 * ��ѯ������¼
	 */
	public List<List<Object>> getManyObject(String sql,List<Object> list);
	
	
	
	/*
	 * ɾ�������¡��޸�
	 */
	public boolean execute(String sql,List<Object> list);
	/**
	 * ��ѯ�����ж��ټ�¼
	 */
	public int gettablerow(String sql);
	/**
	 * ģ����ѯ
	 */
	public List<List<Object>> getblurObject(String sql,List<Object> list);
}
