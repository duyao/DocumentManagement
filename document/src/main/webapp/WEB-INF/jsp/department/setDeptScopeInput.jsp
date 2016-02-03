<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>设置发文部门</title>
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	<form action="department_setDeptScope.action" method="post">
		<table class="table table-bordered table-hover">
			<%-- <s:debug></s:debug> --%>
			<tr>
				<td>部门id</td>
				<td>${department.id }</td>
			</tr>
			<tr>
				<td>部门名称</td>
				<td>${department.name }</td>
			</tr>
			<tr>
				<td colspan="2">设置可发文部门</td>
			</tr>
			<tr>
				<td colspan="2">
					<!-- value表示checked是否标记 --> 
					<s:checkboxlist list="#ds" value="#checked_ds" listKey="id" 
					listValue="name" name="sDepIds" theme="simple"/>
				</td>
				
				<!-- %{department.id }表示字符串 -->
				<s:hidden name="id" value="%{department.id }"></s:hidden>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交"/>
				</td>

			</tr>

		</table>
	</form>
</body>
</html>