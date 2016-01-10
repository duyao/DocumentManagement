package com.dy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dy
 *ĳһ�������ܹ����͵Ĳ����б�
 */
@Entity
@Table(name = "dept_scope")
public class DeptScope {
	private int id;
	private int deptId;
	private Department department;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * ���õĲ���
	 * @return
	 */
	@Column(name = "dept_id")
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	/**
	 * ӳ��Ĳ���
	 * @return
	 */
	@Column(name = "s_dept_id")
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

}
