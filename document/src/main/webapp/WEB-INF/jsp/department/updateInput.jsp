<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<title>部门更新</title>
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	<s:form action="department_update.action" method="post">
		<s:hidden name="id"></s:hidden>
		<s:textfield label="部门名称" name="name" />
		<s:submit value="更新部门" />

	</s:form>
</body>
</html>