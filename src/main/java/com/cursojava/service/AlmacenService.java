package com.cursojava.service;

import java.util.ArrayList;
import java.util.List;

import com.cursojava.model.Producto;

public class AlmacenService {

	/**
	 * Lista en la cual instancio objetos de tipo Prodcuto Para posteriormente
	 * probar el metodo Buscador.
	 */
	static List<Producto> productos = new ArrayList<>(List.of(new Producto("detergente", "limpieza", 13.50, 10),
			new Producto("pasta", "alimentos", 2.50, 15), new Producto("arroz", "alimentos", 1.50, 20),
			new Producto("shampoo", "cuidado", 3.50, 5), new Producto("perfume", "perfumeria", 5.65, 4)));

	/**
	 * Metodo buscador.
	 * 
	 * @param seccion representa el campo por el cual se desea buscar.
	 * @return devuelve una lista de productos por dihca seccion.
	 */
	public List<Producto> buscador(String seccion) {
		return productos.stream().filter(x -> x.getSeccion().equals(seccion)).toList();
	}

	/**
	 * Metodo que lista todos los productos
	 * @return lista de productos
	 */
	public List<Producto> listaProductos() {
		return productos;
	}

	/**
	 * Método añadir producto
	 * 
	 * @param producto representa el pproducto que se añade a la lista de productos.
	 */
	public static boolean addProducto(Producto producto) {
		if (validarProducto(producto)) {
			productos.add(producto);
			return true;
		}
		return false;
	}

	/**
	 * Método para validar el producto Valida si el nombre del producto pasado por
	 * parametro es igual al que se encuentra en la lista.
	 * 
	 * @param producto
	 * @return
	 */
	private static boolean validarProducto(Producto producto) {
		return productos.stream().filter(x -> x.getNombre().equalsIgnoreCase(producto.getNombre())).findFirst()
				.orElse(null) != null ? false : true;
	}

	/**
	 * Método para buscar un producto por su nombre. Con un bucle foreach recorro la
	 * lista de productos y obtengo el objeto que coincida con el parametro.
	 * 
	 * @param nombre representa el nombre del producto que se desea buscar.
	 * @return producto devuelve el producto encontrado.
	 * @return sino retorna null.
	 */
	public static Producto buscarNombre(String nombre) {
		return productos.stream().filter(x -> x.getNombre().equals(nombre)).findFirst().get();
	}

	/**
	 * Método que elimina un producto.
	 * 
	 * @param nombre representa el nombre del producto el cual se desea eliminar.
	 */
	public static void eliminarProducto(String nombre) {
		productos.remove(AlmacenService.buscarNombre(nombre));
	}

}
