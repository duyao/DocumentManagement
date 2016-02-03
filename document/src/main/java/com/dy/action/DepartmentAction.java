package com.dy.action;

import java.util.List;

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
	//用户设置的发文部门编号
	//private int[] sDepIds;
	private int sDepIds;
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
	
	public int getsDepIds() {
		return sDepIds;
	}

	public void setsDepIds(int sDepIds) {
		this.sDepIds = sDepIds;
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
		department = service.load(department.getId());
		List<Department> list= service.listDepScopeDep(department.getId());
		ActionContext.getContext().put("ds",list);
		System.out.println(list.size());
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
		//先载入，再修改
		Department dd = service.load(department.getId());
		dd.setName(department.getName());
		service.update(dd);
		ActionUtil.setURL("department_list.action");
		return ActionUtil.REDIRECT;
	}
	
	public String setDeptScopeInput(){
		//设置发文部门，获取内容
		//1.该部门的信息
		//2.所有部门名称
		//3.该部门已经设置的已经发文的部门
		department = service.load(department.getId());
		List<Department> deps = service.listAllDep();
		deps.remove(department);
		ActionContext.getContext().put("ds", deps);
		ActionContext.getContext().put("checked_ds", service.listDepScopeDepId(department.getId()));
		return SUCCESS;
	}
	
	public String setDeptScope(){
		System.out.println("sdepids"+sDepIds);
//		for(int id : sDepIds){
//			System.out.println(id);
//		}
//		service.addScopeDeps(department.getId(), sDepIds);
		ActionUtil.setURL("department_setDeptScopeInput.action?id="+department.getId());
		return ActionUtil.REDIRECT;
	}

	
	

}
