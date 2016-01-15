package com.dy.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
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
@Scope("prototype")
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
	
	public void validateAdd() {
		if(ActionUtil.isEmpty(department.getName())){
			this.addFieldError("name", "部门名称不能为空");
		}
	}
	
	public String addInput(){
		return SUCCESS;
	}
	
	public String add(){
		System.out.println(department.getName()+department.getId());
		service.add(department);
		ActionUtil.setURL("department_list.action");
		return ActionUtil.REDIRECT;
	}
	
	public String delete(){
		service.delete(department.getId());
		ActionUtil.setURL("department_list.action");
		return ActionUtil.REDIRECT;
	}
	
	public String show(){
		ActionContext.getContext().put("ds",service.listDepScopeDep(department.getId()));
		System.out.println(department.getName());
		return SUCCESS;
	}
	
	public String updateInput(){
		
		return SUCCESS;
	}
	
	public void validateUpdate(){
		if(ActionUtil.isEmpty(department.getName())){
			this.addFieldError("name", "部门名称不能为空");
		}
	}
	
	public String update(){
		System.out.println(department.getName());
		service.update(service.load(department.getId()));
		ActionUtil.setURL("department_list.action");
		return ActionUtil.REDIRECT;
	}

}
