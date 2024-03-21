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
		String msg = request.getParameter("msg");

	String pageData = (String) pageContext.getAttribute("pageData");
	String reqData = (String) request.getAttribute("reqData");
	String sesData = (String) session.getAttribute("sesData");
	String appData = (String) application.getAttribute("appData");
	
	%>
<div>
	<p>msg(request on) : <%= msg %></p>
	<p>pageData(pageContext) :<%=pageData %> </p>
	<p>reqData(request off) :<%=reqData %> </p>
	<p>sesData(session) :<%=sesData %> </p>
	<p>appData(application) :<%=appData %> </p>
</div>
<% session.invalidate();
%>
<p>세션 종료 </p>
<p>sesData(session) :<%=sesData %> </p>
	<p>appData(application) :<%=appData %> </p>
	<p>web.xml 전역 변수: <%=application.getInitParameter("admin") %> </p>
	
</body>
</html>