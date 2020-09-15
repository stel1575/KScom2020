<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "vo.MemberBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/form.css">
</head>
<body>
<header>
	<ul>
	<li>
		<%
			String MEMBER_ID = (String)session.getAttribute("MEMBER_ID");
		    MemberBean memberbean = (MemberBean)session.getAttribute("memberbean");
		    if(MEMBER_ID == null){
		%>
			<a href = "loginForm.jsp">로그인</a>
		<%
		    }
		    else{
		%>
			<li>[등급 : <%if(MEMBER_ID!=null&&MEMBER_ID.equals("admin")){%>관리자
			<a href ="#">-회원관리-</a>
				<%}else { %>일반<%} %>]<br>
				${MEMBER_ID}님 환영합니다.
			<a href = "logout">로그아웃</a>
		<%
		    }
		%>
		</li>
		<li><a href="signUp.jsp">회원가입</a></li>
		<li><a href="cpuCartList.do">장바구니</a></li>
		<li><a href="comList.jsp">제품보러가기</a></li>
	</ul>
</header>

<nav>

</nav>
</body>
</html>