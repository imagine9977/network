<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="org.kh.dto.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL(Java Standard Tag Library)</title>
</head>
<body>
	<%
		List<Member> mList = new ArrayList<Member>();
	mList.add(new Member(1, "kim", "1234", "김민석"));
	mList.add(new Member(2, "kim", "1234", "김민석"));
	mList.add(new Member(3, "kim", "1234", "김민석"));
	%>
	<%@ include file="menu.jsp"%>


	<c:out value="김기태 천사" />
	<c:set var="name" value="김기태" scope="session" />
	<c:out value="${name }" />
	<hr>
	<h3>03. Import문 c:import</h3>
	<c:set var="path1" value="/login.jsp/" />
	<%--<c:import url="${path1}"/> --%>
	<h3>04. 조건문</h3>
	<c:set var="age" value="27" />
	<c:if test="${age >= 20 }">
		<c:out value="성년" />
	</c:if>
	<c:if test="${age < 20 }">
		<c:out value="미성년" />
	</c:if>
	<hr>
	<h3>5. 선택문 c:choose</h3>
	<c:set var="point" value="85" />
	<c:choose>
		<c:when test="${point >=90 }">
			<span>수</span>
		</c:when>
		<c:when test="${point >=80 }">
			<span>우</span>
		</c:when>
		<c:when test="${point >=70 }">
			<span>미</span>
		</c:when>
		<c:otherwise>
			<span>집에가</span>
		</c:otherwise>
	</c:choose>
	<hr>
	<h3>06. 제거문 c:remove</h3>
	<c:remove var="age" />
	<hr>
	<h3>07. 반복실행문 c:forEach</h3>
	<c:forEach var="mem" items="${mList }" varStatus="status">
		<ul>
			<li>연번: ${status.count }</li>
			<li>아이디: ${status.id }</li>
			<li>이름: ${status.name }</li>
		</ul>
	</c:forEach>
	<hr>
	<h3>08 토큰이 있는 반복 실행문 c:forTokens</h3>
	<c:forTokens items="유정환-김민아-김윤정-강범준" delims="-" var="name">
		<p>${name }
		<p>
	</c:forTokens>
	<hr>
	<c:forTokens items="유정환-김민아,김윤정 강범준" delims="-, " var="irum">
		<p>${irum }
		<p>
	</c:forTokens>
	<hr>
	<h3>09. 인터넷 주소 정의문 c:url</h3>
	<c:url var="kkt" value="test11.jsp">
		<c:param name="id" value="kim" />
		<c:param name="pw" value="1234" />
		
	</c:url>
	<a href="${kkt }">데이터 던지기</a>
	<!--  "test11.jsp?id=kim&pw1234" 와 동일 -->
</body>
</html>