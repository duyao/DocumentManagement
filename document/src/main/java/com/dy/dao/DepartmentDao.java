package com.dy.dao;


import org.springframework.stereotype.Repository;

import com.dy.basic.dao.BaseDao;
import com.dy.model.Department;
@Repository("departmentDao")
public class DepartmentDao extends BaseDao<Department> implements IDepartmentDao {

	
}
