package com.dy.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dy.dao.IDepartmentDao;
import com.dy.model.Department;
import com.dy.model.DeptScope;

@Service("departmentService")
public class DepartmentService implements IDepartmentService {
	private IDepartmentDao dao;

	public IDepartmentDao getDao() {
		return dao;
	}

	@Resource
	public void setDao(IDepartmentDao dao) {
		this.dao = dao;
	}

	public void add(Department department) {
		dao.add(department);
	}

	public void delete(int id) {
		//1.该部门是否有员工
		//2.删除该部门所管理或被管理的联系
		String hql = "delete DeptScope ds where ds.deptId = ? or ds.department.id = ?";
		dao.excuteByHql(hql, new Object[]{id,id});
		//3.删除该部门
		dao.delte(id);
	}

	public void update(Department department) {
		dao.update(department);
	}

	public Department load(int id) {
		return dao.load(id);
	}

	public List<Department> listAllDep() {
		return dao.list("from Department");
	}

	public void addScopeDep(int depId, int sDepId) {
		//先查询是否存在
		String hql = "select ds from DeptScope ds where ds.deptId = ? and ds.department.id = ?";
		DeptScope ds = (DeptScope) dao.queryByHql(hql, new Object[]{depId, sDepId});
		if(ds != null){
			return;
		}
		//不存在添加
		ds = new DeptScope();
		ds.setDeptId(depId);
		ds.setDepartment(dao.load(sDepId));
		dao.addObj(ds);
	}

	public void addScopeDeps(int dep, int[] sDepIds) {
		// TODO
		//1.找到原来的设置的发文部门
		//2.进行比较，新出先的添加，没有的删除
		for (int sid : sDepIds) {
			addScopeDep(dep, sid);
		}
	}

	public void deleteScopeDep(int depId, int sDepId) {
		String hql = "delete DeptScope ds where ds.deptId = ? and ds.department.id = ?";
		dao.excuteByHql(hql, new Object[]{depId, sDepId});
	}

	public void deleteScopeDep(int depId) {
		String hql = "delete DeptScope ds where ds.deptId = ?";
		dao.excuteByHql(hql, new Object[]{depId});
	}

	public List<Department> listUserDep(int userId) {
		//TODO unfinish
		String hql = "select d from Department d left join User u where u.id = ? and u.department.id = d.id";
		return null;
	}

	public List<Department> listDepScopeDep(int depId) {
		//自己和自己关联查出所有
		//因为ds中有dept这个属性
		String hql = "select dep from DeptScope ds left join ds.department dep where ds.deptId = ?";
		return dao.list(hql, depId);
	}

	public List<Integer> listDepScopeDepId(int depId) {
		//TODO 
		//自己和自己关联查出所有
		List<Department> deps = listDepScopeDep(depId);
		List<Integer> depIds = new ArrayList<Integer>();
		for(Department dep : deps){
			depIds.add(dep.getId());
		}
		return depIds;
	}

}
