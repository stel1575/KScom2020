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
<style>


</style>
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
			location.href="mainboardCartQtyDown.do?name="+ encodeURIComponent(name);
		}
	}
	function checkQtyGpu(name,qty){
		if(qty != 1){
			location.href="gpuCartQtyDown.do?name="+ encodeURIComponent(name);
		}
	}
</script>
</head>
<body>
<jsp:include page="template.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>

<c:if test="${startMoney !=null }">
	<c:set var="startMoney" value="${startMoney}"></c:set>
</c:if>
<c:if test="${endMoney !=null }">
	<c:set var="endMoney" value="${endMoney}"></c:set>
</c:if>
<section>

   <h2>장바구니 목록</h2>
	<form method="post">
      <table>
    	<tr id="select">
    		<td colspan="6">
    		<select id = "startMoney" name="startMoney">
    			<option>=최하=</option>
    			<c:choose>
    				<c:when test="${startMoney==10000 }">
    					<option selected="selected">10000</option>
    					<option>20000</option>
    					<option>30000</option>
	    				<option>40000</option>
    				</c:when>
    				<c:when test="${startMoney==20000 }">
    					<option>10000</option>
    					<option selected="selected">20000</option>
    					<option>30000</option>
	    				<option>40000</option>
    				</c:when>
    				<c:when test="${startMoney==30000 }">
    					<option>10000</option>
    					<option>20000</option>
    					<option selected="selected">30000</option>
	    				<option>40000</option>
    				</c:when>
    				<c:when test="${startMoney==40000 }">
    					<option>10000</option>
    					<option>20000</option>
    					<option>30000</option>
	    				<option selected="selected">40000</option>
    				</c:when>
    				<c:otherwise>
    					<option>10000</option>
    					<option>20000</option>
    					<option>30000</option>
    					<option>40000</option>
    				</c:otherwise>
    			</c:choose>
    		</select>
    		<select id = "endMoney" name="endMoney">
    			<option>=최고=</option>
    			<c:choose>
    				<c:when test="${endMoney==10000 }">
    					<option selected="selected">10000</option>
    					<option>20000</option>
    					<option>30000</option>
	    				<option>40000</option>
    				</c:when>
    				<c:when test="${endMoney==20000 }">
    					<option>1000</option>
    					<option selected="selected">20000</option>
    					<option>30000</option>
	    				<option>40000</option>
    				</c:when>
    				<c:when test="${endMoney==30000 }">
    					<option>10000</option>
    					<option>20000</option>
    					<option selected="selected">30000</option>
	    				<option>40000</option>
    				</c:when>
    				<c:when test="${endMoney==40000 }">
    					<option>10000</option>
    					<option>20000</option>
    					<option>30000</option>
	    				<option selected="selected">40000</option>
    				</c:when>
    				<c:otherwise>
    					<option>10000</option>
    					<option>20000</option>
    					<option>30000</option>
    					<option>40000</option>
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
<!-- CPU 값 들어가는 폼 -->
<c:if test="${cartList ne null && cartList.size()>0 }">
		<tr>
			<td colspan="7"><h2>CPU</h2></td>
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
        </c:if>
<!--  RAM 폼 들어가는 부분 -->

<c:if test="${ramcartList ne null && ramcartList.size()> 0 }">
       	<tr>
        	<td colspan="7"><h2>RAM</h2></td>
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
        </c:if>
<!-- 메인보드 들어가는 폼 부분         -->
<c:if test="${mainboardcartList ne null && mainboardcartList.size()>0 }">
         <tr>
        	<td colspan="7"><h2>MainBoard</h2></td>
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
        </c:if>
<!-- 그래픽카드 입력 폼         -->
<c:if test="${gpucartList ne null && gpucartList.size()>0 }">
         <tr>
        	<td colspan="7"><h2>그래픽카드</h2></td>
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
        </c:if>
<!-- //TODO         -->
<!-- 하드디스크값 들어가는 부분         -->
<c:if test="${hddcartList ne null && hddcartList.size()>0 }">
 <tr>
        	<td colspan="7"><h2>HDD</h2></td>
        </tr>
         <c:forEach var="hddcart" items="${hddcartList }" varStatus="status">
        <tr>
        		
        	 <td><input type="checkbox" id="remove" name="remove" value="${hddcart.name }"/></td>
             <td>
             ${status.index+1}<!-- 번호값계산 -->
            </td>
             <td>
             <img src = "images/${hddcart.image }" id ="cartImage"/>
            </td>
             <td>
             ${hddcart.name }
            </td>
             <td>
             ${hddcart.price }
            </td>
             <td>
             <a href="hddCartQtyUp.do?name=${hddcart.name }">
             <img src="images/up.jpg" id = "upImage"/>
             </a><br>
             ${hddcart.qty }<br>
            <a href="javascript:checkQtyMainboard('${hddcart.name}',${hddcart.qty})">
            <img src="images/down.jpg" id = "downImage" />
             </a>
            </td>
             <td style="text-align:center;">
         	<input type="submit" value="삭제" formaction="hddCartRemove.do"/>
         </td>
         </tr>
        </c:forEach>
     </c:if>
      
<!-- power값 들어가는 부분         -->
<c:if test="${powercartList ne null && powercartList.size()>0 }">
 		<tr>
        	<td colspan="7"><h2>Power</h2></td>
        </tr>
         <c:forEach var="powercart" items="${powercartList }" varStatus="status">
        <tr>
        		
        	 <td><input type="checkbox" id="remove" name="remove" value="${powercart.name }"/></td>
             <td>
             ${status.index+1}<!-- 번호값계산 -->
            </td>
             <td>
             <img src = "images/${powercart.image }" id ="cartImage"/>
            </td>
             <td>
             ${powercart.name }
            </td>
             <td>
             ${powercart.price }
            </td>
             <td>
             <a href="powerCartQtyUp.do?name=${powercart.name }">
             <img src="images/up.jpg" id = "upImage"/>
             </a><br>
             ${powercart.qty }<br>
            <a href="javascript:checkQtyMainboard('${powercart.name}',${powercart.qty})">
            <img src="images/down.jpg" id = "downImage" />
             </a>
            </td>
             <td style="text-align:center;">
         	<input type="submit" value="삭제" formaction="powerCartRemove.do"/>
         </td>
         </tr>
        </c:forEach>
        </c:if>
        
<!-- SSD 값 들어가는 부분         -->
<c:if test="${ssdcartList ne null && ssdcartList.size()>0 }">
 		<tr>
        	<td colspan="7"><h2>SSD</h2></td>
        </tr>
         <c:forEach var="ssdcart" items="${ssdcartList }" varStatus="status">
        <tr>
        		
        	 <td><input type="checkbox" id="remove" name="remove" value="${ssdcart.name }"/></td>
             <td>
             ${status.index+1}<!-- 번호값계산 -->
            </td>
             <td>
             <img src = "images/${ssdcart.image }" id ="cartImage"/>
            </td>
             <td>
             ${ssdcart.name }
            </td>
             <td>
             ${ssdcart.price }
            </td>
             <td>
             <a href="ssdCartQtyUp.do?name=${ssdcart.name }">
             <img src="images/up.jpg" id = "upImage"/>
             </a><br>
             ${ssdcart.qty }<br>
            <a href="javascript:checkQtyMainboard('${ssdcart.name}',${ssdcart.qty})">
            <img src="images/down.jpg" id = "downImage" />
             </a>
            </td>
             <td style="text-align:center;">
         	<input type="submit" value="삭제" formaction="ssdCartRemove.do"/>
         </td>
         </tr>
        </c:forEach>       
        </c:if> 
        
 <!-- com_case 값 들어가는 부분         -->
 
 <c:if test="${com_casecartList ne null && com_casecartList.size()>0 }">
 		<tr>
        	<td colspan="7"><h2>케이스</h2></td>
        </tr>
         <c:forEach var="com_casecart" items="${com_casecartList }" varStatus="status">
        <tr>
        		
        	 <td><input type="checkbox" id="remove" name="remove" value="${com_casecart.name }"/></td>
             <td>
             ${status.index+1}<!-- 번호값계산 -->
            </td>
             <td>
             <img src = "images/${com_casecart.image }" id ="cartImage"/>
            </td>
             <td>
             ${com_casecart.name }
            </td>
             <td>
             ${com_casecart.price }
            </td>
             <td>
             <a href="com_caseCartQtyUp.do?name=${com_casecart.name }">
             <img src="images/up.jpg" id = "upImage"/>
             </a><br>
             ${com_casecart.qty }<br>
            <a href="javascript:checkQtyMainboard('${com_casecart.name}',${com_casecart.qty})">
            <img src="images/down.jpg" id = "downImage" />
             </a>
            </td>
             <td style="text-align:center;">
         	<input type="submit" value="삭제" formaction="com_caseCartRemove.do"/>
         </td>
         </tr>
        </c:forEach> 
        </c:if>    
                  
<!-- other_product 값 들어가는 부분         -->
<c:if test="${other_productcartList ne null && other_productcartList.size()>0 }">
 		<tr>
        	<td colspan="7"><h2>SSD</h2></td>
        </tr>
         <c:forEach var="other_productcart" items="${other_productcartList }" varStatus="status">
        <tr>
        		
        	 <td><input type="checkbox" id="remove" name="remove" value="${other_productcart.name }"/></td>
             <td>
             ${status.index+1}<!-- 번호값계산 -->
            </td>
             <td>
             <img src = "images/${other_productcart.image }" id ="cartImage"/>
            </td>
             <td>
             ${other_productcart.name }
            </td>
             <td>
             ${other_productcart.price }
            </td>
             <td>
             <a href="other_productCartQtyUp.do?name=${other_productcart.name }">
             <img src="images/up.jpg" id = "upImage"/>
             </a><br>
             ${other_productcart.qty }<br>
            <a href="javascript:checkQtyMainboard('${other_productcart.name}',${other_productcart.qty})">
            <img src="images/down.jpg" id = "downImage" />
             </a>
            </td>
             <td style="text-align:center;">
         	<input type="submit" value="삭제" formaction="other_productCartRemove.do"/>
         </td>
         </tr>
        </c:forEach>      
        </c:if>                 
        
   
       
        
<!--  토탈 금액 수정 바람        -->
      <tr>
         <td colspan="7" style="text-align:center;">
            총 금액 : ${totalMoney}원
         </td>
      </tr>
      
      </table>
</form>
	 
	 

   		<a href="comList.jsp">쇼핑 계속하기</a>
 
   
</section>

</body>
</html> 