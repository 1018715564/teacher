package com.biz;

import com.entity.IPqueryentity;

public interface IPquery {
		//����ip���ݿ���
		public boolean IPquery(IPqueryentity en);
		//��ѯ����ip�Ƿ���ڵ����ݿ���
		public boolean IPHave(IPqueryentity en);
		//ɾ��ĳ��ip��¼��
		public boolean deleteIp(String ip);
}
