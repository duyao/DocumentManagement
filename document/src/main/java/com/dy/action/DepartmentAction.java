package com.dy.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.dy.model.Department;
import com.dy.service.IDepartmentService;
import com.dy.util.ActionUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//ModelDriver
//transfer the form data into the object automatically
@SuppressWarnings("serial")
@Controller("departmentAction")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
	private IDepartmentService service;
	private Department department;
	
	public IDepartmentService getService() {
		return service;
	}

	@Resource
	public void setService(IDepartmentService service) {
		this.service = service;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Department getModel() {
		if(department == null){
			department = new Department();
		}
		return department;
	}
	
	public String list(){
		ActionContext.getContext().put("ds", service.listAllDep());
		return SUCCESS;
	}
	
	public String addInput(){
		return SUCCESS;
	}
	
	public String add(){
		return ActionUtil.REDIRECT;
	}
	
	

}
