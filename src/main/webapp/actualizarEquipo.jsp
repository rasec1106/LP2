<%@page import="service.MarcaService"%>
<%@page import="service.PaisService"%>
<%@page import="beans.EquipoDTO"%>
<%@page import="beans.MarcaDTO"%>
<%@page import="beans.PaisDTO"%>
<%@page import="java.util.List"%>
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
   EquipoDTO obj = (EquipoDTO) request.getAttribute("equipo");
   %>
   <form action="ServletEquipo?tipo=actualizar" id="frmactualizar"
      method="post">
      <input type="hidden" name="txt_cod"
         value="${requestScope.equipo.codigo}">
      <table align="center">
         <tr>
            <td>Descripción:</td>
            <td><input type="text" name="txt_des"
               value="${requestScope.equipo.descripcion}"></td>
         </tr>
         <tr>
            <td>Precio:</td>
            <td><input type="text" name="txt_pre"
               value="${requestScope.equipo.precio}"></td>
         </tr>
         <tr>
            <td>Stock:</td>
            <td><input type="text" name="txt_stock"
               value="${requestScope.equipo.stock}"></td>
         </tr>
         <tr>
            <td>Marca:</td>
            <td>
            	<select name="cbo_marca">
                  <%
                  	List<MarcaDTO> marcas = new MarcaService().listaMarca();
                  	String estadoMarca = "";
                  	for (MarcaDTO marca: marcas) {
                     	if (obj.getCodMarca() == marca.getCodigo()) {
                     		estadoMarca = "selected";
                     	} else {
                     		estadoMarca = "";
                     	}
                  %>
                  <option value="<%=marca.getCodigo()%>" <%=estadoMarca%>>
                     <%=marca.getNombre()%></option>
                  <%
                     }
                  %>
            	</select>
            </td>
         </tr>
         <tr>
            <td>Pais:</td>
            <td>
            	<select name="cbo_pais">
                  <%
                  	List<PaisDTO> paises = new PaisService().listaPais();
                  	String estadoPais = "";
                  	for (PaisDTO pais: paises) {
                     	if (obj.getCodPais() == pais.getCodigo()) {
                     		estadoPais = "selected";
                     	} else {
                     		estadoPais = "";
                     	}
                  %>
                  <option value="<%=pais.getCodigo()%>" <%=estadoPais%>>
                     <%=pais.getNombre()%></option>
                  <%
                     }
                  %>
            	</select>
            </td>
         </tr>
         <tr>
            <td colspan="2" align="right"><input type="submit"
               value="Actualizar"></td>
         </tr>
      </table>
   </form>
</body>
</html>