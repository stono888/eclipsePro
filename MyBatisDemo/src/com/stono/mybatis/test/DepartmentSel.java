package com.stono.mybatis.test;

import java.util.List;

import com.stono.mybatis.bean.Department;
import com.stono.mybatis.dao.DepartmentDao;

public class DepartmentSel {

	public static void main(String[] args) {
		DepartmentDao departmentDao = new DepartmentDao();
		List<Department> departmentList = departmentDao.queryDepartmentList();
		for (Department department : departmentList) {
			System.out.println(department);
		}
	}

}
