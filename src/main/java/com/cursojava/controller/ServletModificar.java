package com.cursojava.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.cursojava.model.Producto;
import com.cursojava.service.AlmacenService;

/**
 * Servlet implementation class ServletModificar
 */
public class ServletModificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		double precio = Double.parseDouble(request.getParameter("precio"));
		
		AlmacenService.buscarNombre(nombre).setPrecio(precio);
		RequestDispatcher rd = request.getRequestDispatcher("formularioBuscar.html");
		rd.forward(request, response);
	}

}
