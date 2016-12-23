<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%
    String mainPath = request.getScheme() + "://" + request.getServerName() + ":";
    String basePath = mainPath + request.getServerPort() + request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试信息</title>
</head>
<body>
	<sf:form modelAttribute="info" id="editForm" method="post">
		<sf:input path="id" />
		<sf:input path="code" />
		<sf:input path="mark" />
		<sf:input path="imageSrc" />
		<sf:input path="name" />
		<sf:input path="createTime" />
		<sf:input path="type" />
		<sf:input path="typeName" />
	</sf:form>
</body>
</html>