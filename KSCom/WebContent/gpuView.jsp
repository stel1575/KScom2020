<%@page import="vo.Cpu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>gpuView.jsp</title>
<link rel="stylesheet" href="css/form.css">
</head>
<body>
<jsp:include page="template.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>

<section>
<h2>${gpu.name}의 상세정보</h2>
	<article>
			<img src="images/${gpu.image} " class="add_image"/>
	</article>
		
			<b>브랜드: </b> ${gpu.brand}<br>
			<b>칩셋 제조사 : </b> ${gpu.chipset_maker}<br>
			<b>세부 칩셋: </b>${gpu.detail_chipset }<br>
			<b>용량 :</b>${gpu.vram }<br>
			<b>이름 :</b>${gpu.name }<br>
			<b>가격 : </b> ${gpu.price}<br>
			<aside>
			<p id="desc">
			<b>제품 설명 : </b> ${gpu.content}<br>
			</p>
			</aside>
		
		<div style="clear:both"></div>
		<div id = "commandList">
			<a href="gpuList.do">쇼핑계속하기</a>
			<a href="gpuCartAdd.do?id=${gpu.id}">장바구니에담기</a>
		</div>

</section>

</body>
</html>