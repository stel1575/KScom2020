<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/form.css">

<title>컴퓨터리스트</title>
</head>
<body>
<jsp:include page="template.jsp"></jsp:include>
<nav>
<form action="">
<ul>
	<li><a href="cpuList.do">CPU</a></li>
	<li><a href="ramList.do">RAM</a></li>
 	<li><a href="mainboardList.do">MainBoard</a></li>
 	<li><a href="gpuList.do">그래픽카드</a></li>
</ul>
</form>
</nav>



</body>
</html>