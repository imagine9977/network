<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인</h2>
	<table>
		<tr>
			<td>
				<form action="loginpro.jsp" method="post">
					<input type="text" name="id" id="id" placeholder="아이디" required><br>
					<br> <input type="text" name="name" id="name" placeholder="이름"
						required><br>
					<br>
					<button type="submit">로그인</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="reset">취소</button>
					<br>
					<br> <a href="test10.jsp"> 뒤로가기 </a>

				</form>
			</td>
		</tr>

	</table>

</body>
</html>