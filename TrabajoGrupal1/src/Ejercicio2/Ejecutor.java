/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import Ejercicio1.Ejer1;

/**
 *
 * @author SALAS
 */
public class Ejecutor {
    public static void main(String args[]) {
        Ejer2 aplicacion = new Ejer2();

        aplicacion.abrirArchivo();
        aplicacion.leer_informacion();
        aplicacion.cerrarArchivo();
    } // fin de main
}
