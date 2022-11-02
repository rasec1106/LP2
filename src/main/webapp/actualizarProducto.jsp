<%@page import="beans.ProductoDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <%
      ProductoDTO obj = (ProductoDTO) request.getAttribute("Producto");
   %>
   <form action="ServletProducto?tipo=actualizar" id="frmactualizar"
      method="post">
      <input type="hidden" name="txt_cod"
         value="${requestScope.Producto.codigo}">
      <table align="center">
         <tr>
            <td>Descripción:</td>
            <td><input type="text" name="txt_des"
               value="${requestScope.Producto.descripcion}"></td>
         </tr>
         <tr>
            <td>Precio:</td>
            <td><input type="text" name="txt_pre"
               value="${requestScope.Producto.precio}"></td>
         </tr>
         <tr>
            <td>Stock:</td>
            <td><input type="text" name="txt_stock"
               value="${requestScope.Producto.stock}"></td>
         </tr>
         <tr>
            <td>Marca:</td>
            <td><select name="cbo_marca">
                  <%
                     String marca[] = { "", "SAMSUNG", "HP", "SONY" };
                  String estado = "";
                  for (int i = 1; i < marca.length; i++) {
                     System.out.println("Objeto:" + obj.getNomMarca());
                     System.out.println("Arreglo:" + marca[i]);
                     if (Integer.parseInt(obj.getNomMarca()) == i) {
                        System.out.println("en selección");
                        String dato = obj.getNomMarca();
                        estado = "selected";
                     } else {
                        estado = "";
                     }
                  %>
                  <option value="<%=i%>" <%=estado%>>
                     <%=marca[i]%></option>
                  <%
                     }
                  %>
            </select></td>
         </tr>
         <tr>
            <td colspan="2" align="right"><input type="submit"
               value="Actualizar"></td>
         </tr>
      </table>
   </form>
</body>
</html>