<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<link rel="stylesheet" href="css/form.css">
</head>
<body>
<jsp:include page="template.jsp"></jsp:include>
<nav>
<section id = "memberListArea">
<form name="listform" 
	action="./memberListAction.me" method="post">
<table>
	<tr>
		<td colspan=2><h1>관리자 메뉴</h1></td>
	</tr>
	<tr>
		<td colspan=2>
			<a href="javascript:manage.submit()">회원 목록 및 편집</a>
		</td>
	</tr>
	<tr>
		<td colspan=2>
			<a href="template.jsp">홈으로 돌아가기</a>
		</td>
	</tr>

</table>
</form>
</section>
</nav>
</body>
</html>