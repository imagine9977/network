<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %> 
<%@ page import="org.kh.dto.Member" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<hr>
<h2>FMT</h2>
<c:set var="num" value="123456.897654" />
<c:set var="data" value="3652733" />
<c:set var="su1" value="0" />
<c:set var="su2" value="4" />
<c:set var="su3" value="-65000" />
<c:set var="today" value="<%=new Date() %>" />
<br><hr><br>
<h3>01. 숫자표시형식 변환문</h3>
<c:out value="${data }"/>
<p><fmt:parseNumber value="${data }" pattern="0,000" var ="num2" /></p>
<p>${num2 }</p>
<p>1년은 ${num2/10000 }일입니다.</p>
<h3> groupingUsed 천단위 묶기</h3>
<p><fmt:formatNumber value="${num }" groupingUsed="true" /></p>
<p><fmt:formatNumber value="${su1 }" groupingUsed="true" /></p>
<p><fmt:formatNumber value="${su3 }" groupingUsed="true" /></p>
<hr>
<p><fmt:formatNumber value="${num }" pattern="#,##0" /></p>
<p><fmt:formatNumber value="${su1 }" pattern="#,##0" /></p>
<p><fmt:formatNumber value="${su3 }" pattern="#,##0" /></p>
<hr>
<p><fmt:formatNumber value="${num }" pattern="#.##" /></p>
<p><fmt:formatNumber value="${su1 }" pattern="#.##" /></p>
<p><fmt:formatNumber value="${su3 }" pattern="#.##" /></p>
<hr>
<p><fmt:formatNumber value="${num }" pattern="0.00" /></p>
<p><fmt:formatNumber value="${su1 }" pattern="0.00" /></p>
<p><fmt:formatNumber value="${su3 }" pattern="0.00" /></p>
<hr>
</body>
</html>