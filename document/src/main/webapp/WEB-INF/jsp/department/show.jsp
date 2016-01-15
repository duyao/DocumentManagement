<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<title>部门展示</title>
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	<table class="table table-bordered table-hover">
		<%-- <s:debug></s:debug> --%>
			<tr><td>部门id</td><td>${department.id }</td></tr>
			<tr><td>部门名称</td><td>${department.name },${dep.name }</td></tr>
			<tr><td colspan="2">可发文部门</td></tr>
			<tr>
			  <td colspan="2">
			  <s:iterator value="#ds">${name },</s:iterator>
			  </td>
			</tr>
		
	</table>
</body>
</html>