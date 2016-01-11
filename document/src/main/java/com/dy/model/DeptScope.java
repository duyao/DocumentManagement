package com.dy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author dy
 *记录部门与被管理部门的联系
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
	 * 要设置的部门id
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
	 * 对应的部门映射
	 * @return
	 */
	@ManyToOne
	@JoinColumn(name = "s_dept_id")
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

}
