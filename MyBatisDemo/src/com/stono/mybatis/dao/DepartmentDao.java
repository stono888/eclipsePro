package com.stono.mybatis.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.stono.mybatis.bean.Department;
import com.stono.mybatis.db.DBAccess;

/**
 * 与部门表对应的数据库操作DAO
 */
public class DepartmentDao {

	/**
	 * 查询获取部门对象集合；
	 * @return
	 */
	public List<Department> queryDepartmentList(){
		List<Department> departments = new ArrayList<Department>();
		DBAccess dbAccess = new DBAccess();
		SqlSession session = null;
		try {
			session = dbAccess.getSqlSession();
			//通过sqlSession执行sql语句
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
