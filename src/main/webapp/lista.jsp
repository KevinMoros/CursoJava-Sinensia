<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.cursojava.model.Producto"%>
<%@ page import="com.cursojava.service.AlmacenService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de productos</title>
</head>


<body>
<%
AlmacenService service = new AlmacenService();
List<Producto>productos = service.listaProductos();
%>
	<h2>Lista de productos.</h2>
	<%
	productos = service.listaProductos();
	%>
	<%
	if (productos != null && !productos.isEmpty()) {
	%>
	<table border="1">
		<tr>
			<td>Nombre</td>
			<td>Seccion</td>
			<td>Precio</td>
			<td>Stock</td>
		</tr>
		<%
		for (Producto producto : productos) {
		%>
		<tr>
			<td><%=producto.getNombre()%></td>
			<td><%=producto.getSeccion()%></td>
			<td><%=producto.getPrecio()%></td>
			<td><%=producto.getStock()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	%>
	<br>
	<a href="formularioInicio.html">Volver al inicio.</a>
</body>
</html>