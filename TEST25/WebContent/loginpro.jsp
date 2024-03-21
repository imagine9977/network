<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	String userId = "user1";
	String username= "dbpark";
    %>
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

String name = request.getParameter("name");
if(id.equals(userId)&&name.equals(username)){
	session.setAttribute("sid", id);
	session.setAttribute("sname",name);
	response.sendRedirect("test10.jsp");
	
}else{
	response.sendRedirect("login.jsp");
}
%>
</body>
</html>