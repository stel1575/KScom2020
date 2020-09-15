<%@page import="java.util.HashMap"%>
<%@page import="vo.Cpu"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/form.css">
<title>cpu 리스트</title>

</head>
<body>
<jsp:include page="template.jsp"></jsp:include>
<nav>
<section id = "listForm">
<c:if test="${cpuList != null}">
<h2>cpu 정보</h2>	
 
<table>
	<tr>
		<c:forEach var = "cpu" items="${cpuList }" varStatus="status">
		<td>
			<a href="cpuView.do?id=${cpu.id}">
			<img src="images/${cpu.image}" id="productImage"/>
			</a><br>
			상품명:${cpu.name}<br>
			가격:${cpu.price}<br>
			조회수:${cpu.readcount }<br>
		</td>
		<c:if test="${((status.index+1) mod 4)==0 }">
			</tr>
			<tr>
		</c:if>
		</c:forEach>
	</tr>
</table>
</c:if>
<c:if test="${cpuList==null }">
	<div class="div_empty">
	없음
	</div>
</c:if>
<c:if test="${todayImageList !=null }">

<a href="ramList.do"><div id="light_com">ram리스트 가기</div></a>


<div id ="todayImageList">
	<h2>오늘 본 상품 목록</h2>
<table>
	<tr>
		<c:forEach var="todayImage" items="${todayImageList}" varStatus="status">
		<td>
			<img src="images/${todayImage}" id="todayImage"/>
		</td>
			<c:if test="${((status.index+1) mod 4)==0 }">
			</tr>
			<tr>
		</c:if>
		</c:forEach>
	</tr>
</table>
</div>
</c:if>
</section>

<!-- 관리자만 보이는 페이지 -->

	<ul>
		<div id="insertProduct">
		<li><a href="cpuRegistForm.do">CPU등록</a></li>
		<li><a href="ramRegistForm.do">램 등록</a></li>
 		<li><a href="mainboardRegistForm.do">메인보드 등록</a></li>
 		<li><a href="gpuRegistForm.do">그래픽카드 등록</a></li>
 		</div>
 	</ul>
  
</nav>

</body>
</html>