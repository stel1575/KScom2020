<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "vo.Member" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = (String)session.getAttribute("id");
    String grade = (String)session.getAttribute("grade");
    Member member = (Member)session.getAttribute("member");
    if(id == null){
%>
	<a href = "loginForm.html">로그인</a>
<%
    }
    else{
%>
	[등급 : <%if(grade!=null&&grade.equals("S")){%>관리자
	<%}else if(grade!=null&&grade.equals("N")) { %>회원<%} %>]<br>
	${id}님 환영합니다.
	<a href = "logout">로그아웃</a>
<%
    }
%>
</body>
</html>