<%@page import="vo.Cpu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cpuView</title>
<link rel="stylesheet" href="css/form.css">
</head>
<body>
<jsp:include page="template.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>

<section>
<h2>${cpu.name}의 상세정보</h2>
	<article>	
		<img src="images/${cpu.image}" class="add_image"/>
	</article>
			<b>이름 : </b> ${cpu.name}<br>
			<b>코어 : </b> ${cpu.core}<br>
			<b>브랜드: </b> ${cpu.cpu_package}<br>
			<b>가격 : </b> ${cpu.price}<br>
		<aside>
			<p id="desc">
			<b>제품 설명 : </b><br> ${cpu.content}<br>
			</p>
		</aside>
		<div style="clear:both"></div>
		<div id = "commandList">
			<a href="cpuList.do">쇼핑계속하기</a>
			<a href="cpuCartAdd.do?id=${cpu.id}">장바구니에담기</a>
		</div>
	
</section>

</body>
</html>