package com.stono.mybatis.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.stono.mybatis.bean.Department;
import com.stono.mybatis.db.DBAccess;

/**
 * �벿�ű��Ӧ�����ݿ����DAO
 */
public class DepartmentDao {

	/**
	 * ��ѯ��ȡ���Ŷ��󼯺ϣ�
	 * @return
	 */
	public List<Department> queryDepartmentList(){
		List<Department> departments = new ArrayList<Department>();
		DBAccess dbAccess = new DBAccess();
		SqlSession session = null;
		try {
			session = dbAccess.getSqlSession();
			//ͨ��sqlSessionִ��sql���
			departments = session.selectList("Department.queryDepartmentList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null ){
				session.close();
			}
		}
		return departments;
	}
}
