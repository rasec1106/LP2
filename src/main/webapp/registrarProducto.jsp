<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <jsp:include page="cabecera.jsp" />
   <form action="ServletProducto?tipo=registrar" id="frmagregar"
      method="post">
      <table align="center">
         <tr>
            <td>Descripción:</td>
            <td><input type="text" name="txt_des" class="required"></td>
         </tr>
         <tr>
            <td>Precio:</td>
            <td><input type="text" name="txt_pre" class="required"></td>
         </tr>
         <tr>
            <td>Stock:</td>
            <td><input type="text" name="txt_stock" class="required"></td>
         </tr>
         <tr>
            <td>Marca:</td>
            <td><select name="cbo_marca" style="width: 150px">
                  <option value="1">SAMSUNG</option>
                  <option value="2">HP</option>
                  <option value="3">SONY</option>
            </select></td>
         </tr>
         <tr>
            <td colspan="2" align="right"><input type="submit"
               value="Registrar"></td>
         </tr>
      </table>
   </form>
</body>
</html>