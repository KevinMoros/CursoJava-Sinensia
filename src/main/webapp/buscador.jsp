<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.cursojava.model.Producto"%>
<%@ page import="com.cursojava.service.AlmacenService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buscador</title>
</head>
<body>

<form>
<%
String seccion = request.getParameter("seccion");
AlmacenService service = new AlmacenService();
List<Producto>productos = service.buscador(seccion);
%>

<%if(productos != null && !productos.isEmpty()){%>
	<h2>Sección: <%=seccion%>.</h2>
	
	<table border="1">
	<tr>
		<td>Nombre</td>
		<td>Seccion</td>
		<td>Precio</td>
		<td>Stock</td>
	</tr>
	<% for (Producto producto : productos){%>
	<tr>
		<td><%=producto.getNombre()%></td> 
		<td><%=producto.getSeccion()%></td>
		<td><%=producto.getPrecio()%></td>
		<td><%=producto.getStock()%></td>
	</tr>
	<%}%>
	</table>

	<%}else{%>
	<h2>No hay datos de la sección <%=seccion%> solicitada.</h2>
	<% }
	
%>

</form>
<br>
<a href="formularioInicio.html">Volver al inicio.</a>

</body>
</html>