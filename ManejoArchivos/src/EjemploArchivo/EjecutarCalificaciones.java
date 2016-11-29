/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemploArchivo;

import java.io.FileNotFoundException;



/**
 *
 * @author SALAS
 */
public class EjecutarCalificaciones {

    public static void main(String args[]) throws FileNotFoundException {
        Calificaciones cali = new Calificaciones();

        cali.abrir_archivo();
        cali.agregar_informacion();
        cali.cerrar_archivo();
    } // fin de main
} // fin de la clase PruebaCrearArchivoTexto

