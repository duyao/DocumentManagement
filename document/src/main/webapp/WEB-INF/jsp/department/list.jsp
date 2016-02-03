<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<title>部门列表</title>
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th>部门id</th>
				<th>部门名称</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="#ds">
				<tr>
					<td>${id }</td>
					<td><a href="department_show.action?id=${id}">${name }</a></td>
					<td>
						<ul class="nav nav-pills">
							<li><a href="department_updateInput.action?id=${id}">更新</a></li>
							<li><a href="department_delete.action?id=${id}">删除</a></li>
							<li><a href="department_setDeptScopeInput.action?id=${id}">设置可发文部门</a></li>
						</ul>
				</tr>
			</s:iterator>

		</tbody>
	</table>
</body>
</html>