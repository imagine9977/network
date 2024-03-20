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
	String name = request.getParameter("name");
	int age =Integer.parseInt(request.getParameter("age"));
	int point =Integer.parseInt(request.getParameter("point"));
	%>
</body>
<h2> 요청된 데이터</h2>
<%
	String grade ="";
	if(point >=90){
		grade = "A";
	}else if(point >=80){
		grade = "B";
	}else if(point >=70){
		grade = "C";
	}else if(point >=60){
		grade = "D";
	}else grade = "F";
	%>
<ul>
<li><strong>이름</strong> : <span><%=name %></span></li>
 <li><strong>나이</strong> : <span><%=age %></span></li>
 <li><strong>점수</strong> : <span><%=point %></span></li>
 <li><strong>학점</strong> : <span><%=grade %></span></li>
</ul>
</html>