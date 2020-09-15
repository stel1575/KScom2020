<%@page import="vo.Cpu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mainboardView.jsp</title>
<link rel="stylesheet" href="css/form.css">
</head>
<body>
<jsp:include page="template.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>

<section>
<h2>${mainboard.name}의 상세정보</h2>
	
	<article>	
		<img src="images/${mainboard.image}" class="add_image"/>
	</article>
	
	
			<b>브랜드: </b> ${mainboard.brand}<br>
			<b>이름 : </b> ${mainboard.name}<br>
			<b>제품 분류: </b>${mainboard.kind }<br>
			<b>소켓 :</b>${mainboard.socket }<br>
			<b>칩셋 :</b>${mainboard.chipset }<br>
			<b>규격 :</b>${mainboard.form_factor }<br>
			<b>가격 : </b> ${mainboard.price}<br>
		<aside>	
			<p id="desc">
			<b>제품 설명 : </b> ${mainboard.content}<br>
			</p>
		</aside>
		<div style="clear:both"></div>
		<div id = "commandList">
			<a href="mainboardList.do">쇼핑계속하기</a>
			<a href="mainboardCartAdd.do?id=${mainboard.id}">장바구니에담기</a>
		</div>

</section>

</body>
</html>