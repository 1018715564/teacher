package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IDaojdbcImpl implements Daojdbc {

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.dao.UserDao#getSimpleObject(java.lang.String, java.util.List)
	 * 
	 * ��ѯ������¼��
	 */
	public List<Object> getSimpleObject(String sql, List<Object> list) {
		List<Object> list1 = new ArrayList<>();
			try {
				PreparedStatement st = Tool.getConnection().prepareStatement(sql);
				if(list!=null){
				// ѭ��list ������
				for (int i = 0; i < list.size(); i++) {
					st.setObject(i + 1, list.get(i));
				}
			}
				// ִ�в�ѯ�ķ���
				ResultSet rs = st.executeQuery();
				// ��ȡ��Ķ���
				ResultSetMetaData da = rs.getMetaData();
				while (rs.next()) {
					for (int i = 0; i < da.getColumnCount(); i++) {
						String coluName = da.getColumnName(i + 1);
						Object coluVale = rs.getObject(coluName);
						list1.add(coluVale);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		
		return list1;
	}

	/**
	 * ��ѯ�����¼��
	 */
	public List<List<Object>> getManyObject(String sql, List<Object> list) {
		//����list
		List<List<Object>> list1 = new ArrayList<>();

		try {
			PreparedStatement st = Tool.getConnection().prepareStatement(sql);
			// ѭ��list ������
			if(list!=null) {
				for (int i = 0; i < list.size(); i++) {
					st.setObject(i + 1, list.get(i));
				}
			}
			// ִ�в�ѯ�ķ���
			ResultSet rs = st.executeQuery();
			// ��ȡ��Ķ���
			ResultSetMetaData da = rs.getMetaData();
			while (rs.next()) {
				 List<Object> list2=new ArrayList<>();
				for (int i = 0; i < da.getColumnCount(); i++) {

					String coluName = da.getColumnName(i + 1);

					Object coluVale = rs.getObject(coluName);
					list2.add(coluVale);
				}
				list1.add(list2);
				
			}
			//��ÿ��ѭ����list2 �ŵ�list1��
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list1;
	}

	@Override
	public boolean execute(String sql, List<Object> list) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement st =Tool.getConnection().prepareStatement(sql);
			// ѭ��list ������
			if(list!=null) {
				for (int i = 0; i < list.size(); i++) {
					st.setObject(i + 1, list.get(i));
				}
			}
			
		    int bb=st.executeUpdate();
		    if(bb>0) {
		    	 return true;
		    }
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return false;
		
	}

	@Override
	public int gettablerow(String sql) {
		int num=0;
		try {
			PreparedStatement st =Tool.getConnection().prepareStatement(sql);
			ResultSet ss=st.executeQuery();
			while(ss.next()){
				num=ss.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	public List<List<Object>> getblurObject(String sql, List<Object> list) {
		//����list
				List<List<Object>> list1 = new ArrayList<>();
				try {
					PreparedStatement st = Tool.getConnection().prepareStatement(sql);
					// ѭ��list ������
					if(list!=null) {
						for (int i = 0; i < list.size();i++) {
							st.setObject(i + 1, list.get(i));
						}
					}
					// ִ�в�ѯ�ķ���
					ResultSet rs = st.executeQuery();
					// ��ȡ��Ķ���
					ResultSetMetaData da = rs.getMetaData();
					while (rs.next()) {
						 List<Object> list2=new ArrayList<>();
						for (int i = 0; i < da.getColumnCount(); i++) {
							String coluName = da.getColumnName(i + 1);
							Object coluVale = rs.getObject(coluName);
							if(coluName.equals("teacher_name")){
								coluVale=rs.getObject("%"+coluVale+"%");
							}
							list2.add(coluVale);
						}
						list1.add(list2);
					}
					//��ÿ��ѭ����list2 �ŵ�list1��
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return list1;
	}

	
}
