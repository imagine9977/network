<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String name1 = request.getParameter("name1");
	String name2 = request.getParameter("name2");

if(name1.equals(name2)){
	session.setAttribute("sid", id);
	session.setAttribute("sname",name1);
	response.sendRedirect("test10.jsp");
	
}else{
	response.sendRedirect("join.jsp");
}
%>
</body>
</html>