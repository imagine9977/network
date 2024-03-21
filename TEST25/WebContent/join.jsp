<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입</h2>
	<table>
		<!-- 아이디 만들기 -->
		<tr>
			<th><label for="id">아이디</label></th>
			<td><input type="text" name="id" id="id" placeholder="아이디 입력"
				pattern="[a-z0-9]{6,}" autofocus required>
				<button type="button"
					style="background: deepskyblue; color: darkmagenta">아이디 중복
					확인</button> <input type="hidden" name="idck" id="idck" value="no"></td>
			<!--pattern: 조건 설정: {6}=6글자, {6,} = 6글자 이상-->
		</tr>
		<tr>
			<th><label for="name1">이름</label></th>
			<td><input type="text" name="name1" id="name1" placeholder="이름"
				pattern="{2,12}" required></td>
		</tr>
		<!--비밀번호확인-->
		<tr>
			<th><label for="name2">이름 확인</label></th>
			<td><input type="text" name="name2" id="name2"
				placeholder="이름 확인" pattern="{2,12}" required></td>
		</tr>
		<tr>
			<th><label for="gender">성별</label></th>
			<td><input type="radio" name="gender" id="gender1" value="1"
				checked> <label for="gender1">남</label> <br> <input
				type="radio" name="gender" id="gender2" value="2"> <label
				for="gender2">여</label></td>
		</tr>


	</table>
	<form action="joinpro.jsp" method="post">
		<button type="submit">회원가입</button>
		<br> <br> <a href="test10.jsp"> 뒤로가기 </a>
		</td>
	</form>
</body>
</html>