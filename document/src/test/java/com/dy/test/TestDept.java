package com.dy.test;

import java.io.IOException;
import java.sql.SQLException;

import javax.inject.Inject;

import org.dbunit.dataset.DataSetException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.dy.dao.IDepartmentDao;
import com.dy.model.Department;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestDept {
	@Inject
	private IDepartmentDao departmentDao;
	@Inject
	private SessionFactory sessionFactory;
	
	@Before
	public void setUp() throws DataSetException, SQLException, IOException {
		Session s = sessionFactory.openSession();
		//绑定session
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
	}
	@Test
	public void test01(){
		Department department = new Department();
		department.setId(1);
		department.setName("财务处");
		departmentDao.add(department);
	}
	
	

}
