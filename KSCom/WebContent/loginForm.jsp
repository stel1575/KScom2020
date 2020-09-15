<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" href="css/form.css">
</head>
<body>
<jsp:include page="template.jsp"></jsp:include>
<nav>
<section id = "loginformArea">
<form action="login" name="loginform" method="post">
<table>
	<tr>
		<td colspan="2">
			<h1>로그인 페이지</h1>
		</td>
	</tr>
	<tr><td><label for = "MEMBER_ID">아이디 : </label></td><td><input type="text" name="MEMBER_ID" id = "MEMBER_ID"/></td></tr>
	<tr><td><label for = "MEMBER_PW">비밀번호 : </label></td><td><input type="password" name="MEMBER_PW" id = "MEMBER_PW"/></td></tr>
	<tr>
		<td colspan="2">
			<a href="javascript:loginform.submit()">로그인</a>&nbsp;&nbsp;
			<a href="signUp.jsp">회원가입</a>&nbsp;&nbsp;
			<a href="template.jsp">홈으로</a>
		</td>
	</tr>
</table>
</form>
</section>
</nav>
</body>
</html>