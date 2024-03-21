<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8");
	String name= request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	


%>
<h3>이름:  <%= name %></h3>
<h3>나이:  <%= age %></h3>
</body>
</html>