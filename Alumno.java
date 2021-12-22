/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.io.Serializable;

/**
 * @author Victor
 * @version 1.0
 */
public class Alumno implements Serializable {
	private String nombre;
	private String apellidos;


	/**
	 * Constructor de la clase Alumno.
	 * @param nombre String con el nombre del alumno.
	 * @param apellidos String con los apelllidos del alumno. Es opcional
	 */
	public Alumno(String nombre, String apellidos) {
		if (nombre==null || nombre =="") {
			throw new NullPointerException("El nombre del alumno es obligatorio.");
		}
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	/**
	 * Devuelve el nombre del alumno.
	 * @return String con el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Actualiza el nombre del alumno
	 * @param nombre String con el nombre que se va actualizar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return String con los apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos String con los nuevos apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



}
