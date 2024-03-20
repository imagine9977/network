<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!private String name;
	String title = "메인 페이지";
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String printN(int n){
		String numbers ="";
		for(int i=1;i<=n;i++){
			numbers+=i+", ";
		}
		return numbers;
	}
	%>
<html>
<head>
<meta charset="UTF-8">
<title><%= title %></title>
</head>
<body>
<% setName("숫자 연습"); %>
<h2><%=getName()+"하는 페이지" %></h2>
<hr>
<h3> <%= printN(10) %></h3>
</body>
</html>