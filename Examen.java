/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author instalador
 */
public class Examen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    File fiche;
    Ficheros fichero = new Ficheros(); 
    fichero.crearCarpeta();
    fiche = fichero.crearFichero();
    Nota nota = fichero.crearAlumno();
    fichero.crearNota(nota, fiche);
    fichero.leerNota(fiche);
    fichero.guardaXML(nota);
fichero.leerXML(fiche);

    }
    
}
