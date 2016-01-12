package com.dy.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dy.service.IDepartmentService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestService {
	private IDepartmentService departmentService;

	public IDepartmentService getDepartmentService() {
		return departmentService;
	}
	@Resource
	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@Test
	public void test01(){
		departmentService.addScopeDeps(7, new int[]{1,2,3,4,5,6});
	}
	
	@Test
	public void test02(){
		departmentService.deleteScopeDep(7, 6);
	}
	
	

}
