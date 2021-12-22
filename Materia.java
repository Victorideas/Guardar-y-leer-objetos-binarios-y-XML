/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;
import java.io.Serializable;

/**
 * 
 * @author Jesús
 * @version 1.0
 */
public class Materia implements Serializable {
	private String nombre; //obligatorio
	private String nivel; //opcional

	/**
	 * Constructor de la clase materia 
	 * @param nombre String con el nombre
	 * @param nivel String con el nivel. Es opcional introducirlo.
	 */
	public Materia(String nombre, String nivel) {
		if (nombre == null || nombre=="") {
			throw new NullPointerException("El nombre de la materia es obligatorio.");
		}
		this.nombre = nombre;
	}
	

	/**
	 * Devuelve el nombre del alumno.
	 * @return String con el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Actualiza el nombre
	 * @param nombre String con nombre el nuevo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the nivel
	 */
	public String getNivel() {
		return nivel;
	}

	/**
	 * @param nivel String con nivel a actualizar
	 */
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}



}
