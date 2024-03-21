<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
	pageContext.setAttribute("name", "박동빈");
    pageContext.setAttribute("age", "25");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include</title>
</head>
<body>
<h2>디렉티브 이용한 include</h2> <!-- 이 방식이 아래 방식보다 훨씬 간편함 -->
<%@ include file="inFile.jsp" %>

<hr>
<h2> 액션 태그를 활용한 include</h2>
<jsp:include page="inFile.jsp"></jsp:include>
</body>
</html>