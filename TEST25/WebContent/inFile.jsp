<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String name = (String) pageContext.getAttribute("name");
	String age =(String) pageContext.getAttribute("age");
	//String id = (String) pageContext.getAttribute("id");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<p>name: <%= name %> </p>
		<p>age: <%= age %> </p>
	</div>
</body>
</html>