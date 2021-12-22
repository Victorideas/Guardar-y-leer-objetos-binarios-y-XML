/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMLocator.*;
import javax.xml.transform.stream.StreamResult.*;
import java.io.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.SAXException;


/**
 *
 * @author iVictor
 */
public class Ficheros {
    File carpeta;
    File fichero;
    String direccion;
    File fi;
        
    public void crearCarpeta (){
        carpeta = new File("examenEv1");
        carpeta.mkdir();         
        direccion = carpeta.getAbsolutePath();         
    }
    
    public File crearFichero (){
        fichero = new File (direccion, "examen_Victor_Rodriguez.dat");
        return fichero;
    }
    
    public Nota crearAlumno(){
        Alumno alumno = new Alumno ("Paco", "Perez");
        Materia materia = new Materia ("Ingles", "3");
        double[] listaNotas = new double [2];
        listaNotas[0] = 8;
        listaNotas[1] = 9;
        Nota nota = new Nota(alumno, materia, listaNotas);
        //System.out.println(nota.toString());
        return nota;
    }
    
    public void crearNota(Nota nota, File fichero){
        try {
            FileOutputStream salida = new FileOutputStream(fichero, true);
            ObjectOutputStream out = new ObjectOutputStream(salida);
            out.writeObject(nota);
            out.close();
            System.out.println("El alumno y su nota se han guardado correctamente");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void leerNota(File fichero){
        Nota nota;

        FileInputStream leer = null;
        ObjectInputStream in = null;
        try {
            leer = new FileInputStream (fichero);
            in = new ObjectInputStream (leer);
            
            nota = (Nota)in.readObject();            
            System.out.println(nota.toString());       
            
            in.close();
           
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void crear(String nodo, String valor, Element ele, Document document){
            Element mio = document.createElement(nodo);
            Text text = document.createTextNode(valor);
            mio.appendChild(text);
            ele.appendChild(mio);
        }
    
    public void guardaXML(Nota nota){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            DOMImplementation implement = builder.getDOMImplementation();
            Document document = implement.createDocument(null,"Lista", null);
            document.setXmlVersion("1.0");
            
            Element ele = document.createElement("alumn");
            document.getDocumentElement().appendChild(ele);
            
            crear("Nombre", nota.getAlumno().getNombre(), ele, document );
            crear("Apellido",nota.getAlumno().getApellidos(), ele, document);
            crear("Materia",nota.getMateria().getNombre(), ele, document);
            crear("Fecha",nota.getFecha().toString(), ele, document);
            int valor = nota.getValor().length;
            double[] lis = nota.getValor();
            for (int i =0; i<lis.length; i++){
                crear("Nota", String.valueOf(lis[i]), ele, document);
            }
                        
                        
            fi = new File(direccion).getAbsoluteFile(); 
            System.out.println(fi);
            Source source = new DOMSource(document);
            Result result = new StreamResult(fi+ "examen_Victor_Rodriguez.xml");
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.transform(source, result);
            
            
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        }  
                      
       /* Element[] list = new Element[2];
        for (int i=0; i< list.length; i++){
            list[i] = document.createElement("alumno");
            document.getDocumentElement().appendChild(list[i]);
            crearElemento ()            
        }*/
    }
    public void leerXML(File fichero){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
           // System.out.println(fichero.getParent());
            Document d = builder.parse(new File(fi+ "examen_Victor_Rodriguez.xml"));
            String a = d.getElementsByTagName("Nombre").item(0).getFirstChild().getNodeValue();
            String b = d.getElementsByTagName("Apellido").item(0).getFirstChild().getNodeValue();
            String c = d.getElementsByTagName("Materia").item(0).getFirstChild().getNodeValue();
            //String d = d.getElementsByTagName("Fecha").item(0).getFirstChild().getNodeValue();
            String e = d.getElementsByTagName("Nota").item(0).getFirstChild().getNodeValue();
            String f = d.getElementsByTagName("Nota").item(0).getFirstChild().getNodeValue();
            System.out.println("Nombre " + a + " Apellidos " + b + " Materia " + c + " Nota " + e + " " + e);
            
    }   catch (ParserConfigurationException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
}