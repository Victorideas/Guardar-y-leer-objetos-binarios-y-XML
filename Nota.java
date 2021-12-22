/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Victor
 * @version 1.0
 */
public class Nota implements Serializable {

	private Alumno alumno;
	private Materia materia;
	private Date fecha;
	private double[] valoresNotas;
	
	

	/**
	 * Constructor de la clase Nota
	 * @param alumno Alumno con los datos del alumno.
	 * @param materia Materia con los datos de la materia
	 * @param valoresNotas double[] con diversos valores
	 */
	public Nota(Alumno alumno, Materia materia, double[] valoresNotas) {
		this.alumno = alumno;
		this.materia = materia;
		this.fecha = new Date();
		this.valoresNotas = valoresNotas;
	}
	/**
	 * Devuelve un Alumno 
	 * @return devuelve el objeto Alumno
	 */
	public Alumno getAlumno() {
		return alumno;
	}
	/**
	 * @param alumno nuevo objeto Alumno que se actualiza
	 */
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	/**
	 * Devuelve la materia
	 * @return devuelve el objeto Materia
	 */
	public Materia getMateria() {
		return materia;
	}
	/**
	 * @param materia objeto Materia que se actualiza
	 */
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	/**
	 * @return devuelve la fecha de creación de la nota
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * 
	 * @return double[] con valores de notas
	 */
	public double[] getValor() {
		return valoresNotas;
	}

	
	@Override
	public String toString() {
		if (alumno.getApellidos()==null) {
			return "Nota [alumno=" + alumno.getNombre()+ ", materia=" + materia.getNombre() + ", fecha=" + fecha + ", valor="
					+ Arrays.toString(valoresNotas) +", media="+notaMedia()+ "]";
		}
		return "Nota [alumno=" + alumno.getNombre()+" "+alumno.getApellidos()+ ", materia=" + materia.getNombre() + ", fecha=" + fecha + ", valor="
				+ Arrays.toString(valoresNotas) +", media="+notaMedia()+ "]";
	}
	
	/**
	 * Método que devuelve la media aritmética de las notas de una materia.
	 * @return double con la nota media de una materia
	 */
	public double notaMedia() {
		double aux = 0;
		for (int i=0; i<this.valoresNotas.length; i++) {
			aux+=this.valoresNotas[i];
		}
		return aux/this.valoresNotas.length;
	}
	


}
