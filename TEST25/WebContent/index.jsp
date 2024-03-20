<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%-- 각주  : 해당 코드에 대한 설명문--%>
<%-- <%@디렉티브%> : 현재 페이지에 필요한 설정이나 리소스 로딩--%>
<%!private String name;
	String title = "메인 페이지";
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}%>
<%-- 선언문(declare) :익명의 클래스로서 현재 문서에서만 유효함 --%>
<%-- <% %> 자바명령문 Scriptlet : 해당페이지에 자바언어로 프로그래밍한 코드부--%>
<%-- <%=  %> 표현식Expression : 해당 결과를 출력 또는 표현 시 사용--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=title  %></title>
</head>
<body>
<% setName("박동빈"); %>
<h2><%= getName() %>의 홈페이지</h2>
<hr>
<nav>
	<ul>
		<li><a href="test01.jsp"> JSP 페이지의 기본 구성 요소</a></li>
		<li><a href="test02.jsp?name='김기태'&age=45&point=80"> Get Data 전송</a></li>
		<li><a href="test03.jsp"> POST Data 전송</a></li>
	</ul>
	
	
</nav>
</body>
</html>