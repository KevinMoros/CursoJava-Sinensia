package com.cursojava.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.cursojava.model.Producto;
import com.cursojava.service.AlmacenService;

/**
 * Servlet implementation class ServletAltaProducto
 */
public class ServletAltaProducto extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String seccion = request.getParameter("seccion");
		double precio = Double.parseDouble(request.getParameter("precio"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		
		Producto producto = new Producto(
				nombre,
				seccion,
				precio,
				stock);
		
		if(AlmacenService.addProducto(producto)) {
			RequestDispatcher rd = request.getRequestDispatcher("listaProducto.html");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("formularioInicio.html");
			rd.forward(request, response);
		}

	}

}
