<%@page import="com.sun.org.apache.bcel.internal.generic.Select"%>
<%@page import="vo.Cart"%>
<%@page import="vo.Cpu"%>
<%@page import="dao.CpuDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 목록</title>
<link rel="stylesheet" href="css/form.css">
<script>
	function checkAll(theForm){
		if(theForm.remove.length == undefined){
			theForm.remove.checked = theForm.allCheck.checked;
		}else{
			for(var i=0;i<theForm.remove.length;i++){
				theForm.remove[i].checked = theForm.allCheck.checked;
			}
		}
	}
	
	function checkQty(name,qty){
		if(qty != 1){
			location.href="cpuCartQtyDown.do?name="+ encodeURIComponent(name);
		}
	}
	function checkQtyRam(name,qty){
		if(qty != 1){
			location.href="ramCartQtyDown.do?name="+ encodeURIComponent(name);
		}
	}
	function checkQtyMainboard(name,qty){
		if(qty != 1){
			location.href="gpuCartQtyDown.do?name="+ encodeURIComponent(name);
		}
	}
</script>
</head>
<body>
<jsp:include page="template.jsp"></jsp:include>
<nav>
<c:if test="${startMoney !=null }">
	<c:set var="startMoney" value="${startMoney}"></c:set>
</c:if>
<c:if test="${endMoney !=null }">
	<c:set var="endMoney" value="${endMoney}"></c:set>
</c:if>
<section id="listForm">
	<c:if test="${cartList !=null ||ramcartList !=null }">
   <h2>장바구니 목록</h2>
<form method="post">
      <table>
    	<tr id="select">
    		<td colspan="6">
    		<select id = "startMoney" name="startMoney">
    			<option>=최하=</option>
    			<c:choose>
    				<c:when test="${startMoney==1000 }">
    					<option selected="selected">1000</option>
    					<option>2000</option>
    					<option>3000</option>
	    				<option>4000</option>
    				</c:when>
    				<c:when test="${startMoney==2000 }">
    					<option>1000</option>
    					<option selected="selected">2000</option>
    					<option>3000</option>
	    				<option>4000</option>
    				</c:when>
    				<c:when test="${startMoney==3000 }">
    					<option>1000</option>
    					<option>2000</option>
    					<option selected="selected">3000</option>
	    				<option>4000</option>
    				</c:when>
    				<c:when test="${startMoney==4000 }">
    					<option>1000</option>
    					<option>2000</option>
    					<option>3000</option>
	    				<option selected="selected">4000</option>
    				</c:when>
    				<c:otherwise>
    					<option>1000</option>
    					<option>2000</option>
    					<option>3000</option>
    					<option>4000</option>
    				</c:otherwise>
    			</c:choose>
    		</select>
    		<select id = "endMoney" name="endMoney">
    			<option>=최고=</option>
    			<c:choose>
    				<c:when test="${endMoney==1000 }">
    					<option selected="selected">1000</option>
    					<option>2000</option>
    					<option>3000</option>
	    				<option>4000</option>
    				</c:when>
    				<c:when test="${endMoney==2000 }">
    					<option>1000</option>
    					<option selected="selected">2000</option>
    					<option>3000</option>
	    				<option>4000</option>
    				</c:when>
    				<c:when test="${endMoney==3000 }">
    					<option>1000</option>
    					<option>2000</option>
    					<option selected="selected">3000</option>
	    				<option>4000</option>
    				</c:when>
    				<c:when test="${endMoney==4000 }">
    					<option>1000</option>
    					<option>2000</option>
    					<option>3000</option>
	    				<option selected="selected">4000</option>
    				</c:when>
    				<c:otherwise>
    					<option>1000</option>
    					<option>2000</option>
    					<option>3000</option>
    					<option>4000</option>
    				</c:otherwise>
    			</c:choose>
    		</select>
    		
    		
    		<input type="submit" value="검색" formaction="cpuCartSearch.do"/>
    		</td>
    	</tr>
        <tr class = "tr_top">
        	<td><input type="checkbox" id = "allCheck" name="allCheck" onclick="checkAll(this.form)"/> </td>
             <td>번호</td>
             <td>상품 이미지</td>
             <td>상품명</td>
             <td>가격</td>
             <td>수량</td>
         </tr>
         
<!-- 여기서 부터 값 들어가는 부분 -->
		<tr>
			<td>CPU</td>
		</tr>
		
        <c:forEach var="cart" items="${cartList }" varStatus="status">
        <tr>
        		
        	 <td><input type="checkbox" id="remove" name="remove" value="${cart.name }"/></td>
             <td>
             ${status.index+1}<!-- 번호값계산 -->
            </td>
             <td>
             <img src = "images/${cart.image }" id ="cartImage"/>
            </td>
             <td>
             ${cart.name }
            </td>
             <td>
             ${cart.price }
            </td>
             <td>
             <a href="cpuCartQtyUp.do?name=${cart.name }">
             <img src="images/up.jpg" id = "upImage"/>
             </a><br>
             ${cart.qty }<br>
            <a href="javascript:checkQty('${cart.name}',${cart.qty})">
            <img src="images/down.jpg" id = "downImage" />
             </a>
            </td>
             <td style="text-align:center;">
         	<input type="submit" value="삭제" formaction="cpuCartRemove.do"/>
         </td>
         </tr>
        </c:forEach>
        <tr>
        	<td>RAM</td>
        </tr>
         <c:forEach var="ramcart" items="${ramcartList }" varStatus="status">
        <tr>
        		
        	 <td><input type="checkbox" id="remove" name="remove" value="${ramcart.name }"/></td>
             <td>
             ${status.index+1}<!-- 번호값계산 -->
            </td>
             <td>
             <img src = "images/${ramcart.image }" id ="cartImage"/>
            </td>
             <td>
             ${ramcart.name }
            </td>
             <td>
             ${ramcart.price }
            </td>
             <td>
             <a href="ramCartQtyUp.do?name=${ramcart.name }">
             <img src="images/up.jpg" id = "upImage"/>
             </a><br>
             ${ramcart.qty }<br>
            <a href="javascript:checkQtyRam('${ramcart.name}',${ramcart.qty})">
            <img src="images/down.jpg" id = "downImage" />
             </a>
            </td>
             <td style="text-align:center;">
         	<input type="submit" value="삭제" formaction="ramCartRemove.do"/>
         </td>
         </tr>
        </c:forEach>
         <tr>
        	<td>MainBoard</td>
        </tr>
         <c:forEach var="mainboardcart" items="${mainboardcartList }" varStatus="status">
        <tr>
        		
        	 <td><input type="checkbox" id="remove" name="remove" value="${mainboardcart.name }"/></td>
             <td>
             ${status.index+1}<!-- 번호값계산 -->
            </td>
             <td>
             <img src = "images/${mainboardcart.image }" id ="cartImage"/>
            </td>
             <td>
             ${mainboardcart.name }
            </td>
             <td>
             ${mainboardcart.price }
            </td>
             <td>
             <a href="mainboardCartQtyUp.do?name=${mainboardcart.name }">
             <img src="images/up.jpg" id = "upImage"/>
             </a><br>
             ${mainboardcart.qty }<br>
            <a href="javascript:checkQtyMainboard('${mainboardcart.name}',${mainboardcart.qty})">
            <img src="images/down.jpg" id = "downImage" />
             </a>
            </td>
             <td style="text-align:center;">
         	<input type="submit" value="삭제" formaction="mainboardCartRemove.do"/>
         </td>
         </tr>
        </c:forEach>
        
         <tr>
        	<td>그래픽카드</td>
        </tr>
         <c:forEach var="gpucart" items="${gpucartList }" varStatus="status">
        <tr>
        		
        	 <td><input type="checkbox" id="remove" name="remove" value="${gpucart.name }"/></td>
             <td>
             ${status.index+1}<!-- 번호값계산 -->
            </td>
             <td>
             <img src = "images/${gpucart.image }" id ="cartImage"/>
            </td>
             <td>
             ${gpucart.name }
            </td>
             <td>
             ${gpucart.price }
            </td>
             <td>
             <a href="gpuCartQtyUp.do?name=${gpucart.name }">
             <img src="images/up.jpg" id = "upImage"/>
             </a><br>
             ${gpucart.qty }<br>
            <a href="javascript:checkQtyMainboard('${gpucart.name}',${gpucart.qty})">
            <img src="images/down.jpg" id = "downImage" />
             </a>
            </td>
             <td style="text-align:center;">
         	<input type="submit" value="삭제" formaction="gpuCartRemove.do"/>
         </td>
         </tr>
        </c:forEach>
      <tr>
         <td colspan="5" style="text-align:center;">
            총 금액 : ${totalMoney}원
         </td>
      </tr>
      <tr>
         <td colspan="5" style="text-align:center;">
         	<input type="submit" value="삭제" formaction="cpuCartRemove.do"/>
         </td>
      </tr>
      </table>
</form>
	</c:if>
	<c:if test="${cartList == null }">
      <section class="div_empty">
     컴퓨터 정보가 없습니다.
      </section>
	</c:if>
 
   		<a href="comList.jsp">쇼핑 계속하기</a>
 
   
</section>
</nav>
</body>
</html> 