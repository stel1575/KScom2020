<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>램등록폼</title>
<link rel="stylesheet" href="css/form.css">

</head>
<body>
<jsp:include page="template.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>

<section>
   
      <h2>Mainboard등록</h2>
   
      <form action="mainboardRegist.do" method="post" name = "writeForm" enctype="multipart/form-data">
      
   <table>
    
   <tr>
      <td class = "td_left">
         <label for = "brand">브랜드 : </label>
      </td>
      <td class = "td_right">
         <select id="brand" name="brand">
         <option value="MSI">MSI</option>
         <option value="ASUS">ASUS</option>
         <option value="ASrock">애즈락</option>
         <option value="GIGABYTE">기가바이트</option>
         <option value="BIOSTAR">바이오스타</option>
         </select>
      </td>
   </tr>
    <tr>
      <td class = "td_left">
         <label for = "name">제품 이름 : </label>
      </td>
      <td class = "td_right">
         <input type = "text" name = "name" id ="name" required="required"/>
      </td>
   </tr>
   <tr class="td_left">
   	<td><label for ="kind">제품 분류 :</label></td>
   	<td class="td_right">
   		<select id="brand" name="brand">
         <option value="intelCPU">인텔 CPU용</option>
         <option value="amdCPU">AMD CPU용</option>
         <option value="Imbedded">임베디드</option>
         </select>
   	</td>
   	</tr>
   <tr>
      <td class = "td_left">
         <label for = "socket">소켓 : </label>
      </td>
      <td class = "td_right">
         <select id="socket" name="socket">
         <optgroup label="intel">
        <option value="intel_1200">인텔 소켓1200</option>
        <option value="intel_1151v2">인텔 소켓1152v2</option>
        <option value="intel_1151">인텔 소켓 1151</option>
        <option value="intel_2066">인텔 소켓 2066</option>
        <option value="intel_3647">인텔 소켓 3647</option>
        </optgroup>
        <optgroup label="amd">
        <option value="amd_AM4">소켓AM4</option>
        <option value="amd_sTRX4">소켓sTRX4</option>
        <option value="amd_TR4">소켓TR4</option>
        <option value="amd_SP3">소켓SP3</option>
        
        </optgroup>
         </select>
      </td>
   </tr>
   <tr>
      <td class = "td_left">
         <label for = "chipset">칩셋 : </label>
      </td>
      <td class = "td_right">
         <select id="chipset" name="chipset">
         <optgroup label="intel">
        <option value="intel_z490">z490</option>
        <option value="intel_h470">h470</option>
        <option value="intel_b460">b460</option>
        <option value="intel_h410">h410</option>
        <option value="intel_x299">x299</option>
        </optgroup>
        <optgroup label="amd">
        <option value="amd_x570">X570</option>
        <option value="amd_b550">B550</option>
        <option value="amd_a520">A520</option>
        <option value="amd_b450">B450</option>
        <option value="amd_a320">A320</option>
        </optgroup>
         </select>
      </td>
   </tr>
   <tr>
      <td class = "td_left">
         <label for = "form_factor">폼팩터 : </label>
      </td>
      <td class = "td_right">
         <select id="form_factor" name="form_factor">
         
        <option value="ATX">ATX</option>
        <option value="M-ATX">M-ATX</option>
        <option value="M-iTX">M-iTX</option>
        <option value="E-ATX">E-ATX</option>
        <option value="M-STX">M-STX</option>
        
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
         <label for = "content">제품 설명 : </label>
      </td>
      <td class = "td_right">
         <textarea name="content" id="content" rows="13" cols="70" wrap="virtual"></textarea>
      </td>
   </tr>
   <tr>
      <td colspan="2" id = "commandCell"> 
         <input type = "submit" value = "상품등록"/>      
         <input type = "reset" value = "다시작성"/>      
         <input type = "button" value = "상품목록보기" onClick="window.location.href='mainboardList.do'"/>      
      </td>
   </tr>   
   </table>
   </form>
   
</section>

</body>
</html>