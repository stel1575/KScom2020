<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cpu등록 폼</title>
<link rel="stylesheet" href="css/form.css">
</head>
<body>
<jsp:include page="template.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>
<section>
   
      <h2>CPU등록</h2>
   
      <form action="cpuRegist.do" method="post" name = "writeForm" enctype="multipart/form-data">
      
   <table>
   <tr>
      <td class = "td_left">
         <label for = "name">제품 이름 : </label>
      </td>
      <td class = "td_right">
         <input type = "text" name = "name" id ="name" required="required"/>
      </td>
   </tr>
   
   <tr>	
      <td class = "td_left">
         <label for = "core">코어 : </label>
      </td>
      <td class = "td_right">
         <select id="core" name="core">
         
         <option value="dual">듀얼코어</option>
         <option value="quad">쿼드코어</option>
         <option value="hexa">헥사코어</option>
         <option value="octa">옥사코어</option>
         <option value="another">기타코어</option>
       
         </select>
      </td>
   </tr>
   
   
   <tr>
      <td class = "td_left">
         <label for = "cpu_package">브랜드 : </label>
      </td>
      <td class = "td_right">
         <select id="cpu_package" name="cpu_package">
         
         <option value="인텔">인텔</option>
         <option value="amd">AMD</option>
         <option value="기타">기타</option>
       
         </select>
      </td>
   </tr>
   
   <tr>
      <td class = "td_left">
         <label for = "image">상품이미지 : </label>
      </td>
      <td class = "td_right">
         <input type = "file" name = "image" id ="image"/>
      </td>
   </tr>
   <tr>
      <td class = "td_left">
         <label for = "price">가격 : </label>
      </td>
      <td class = "td_right">
         <input type = "text" name = "price" id ="price" placeholder="숫자만 입력"/>
      </td>
   </tr>
   
    <tr>
      <td class = "td_left">
         <label for = "content">제품 정보 : </label>
      </td>
      <td class = "td_right">
         <textarea name="content" id="content" rows="13" cols="70" wrap="virtual"></textarea>
      </td>
   </tr>
   <tr>
      <td colspan="2" id = "commandCell"> 
         <input type = "submit" value = "상품등록"/>      
         <input type = "reset" value = "다시작성"/>      
         <input type = "button" value = "상품목록보기" onClick="window.location.href='cpuList.do'"/>      
      </td>
   </tr>   
   </table>
   </form>
   
</section>

</body>
</html>