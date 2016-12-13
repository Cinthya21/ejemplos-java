/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer2;

/**
 *
 * @author SALAS
 */
public class ClaseMisteriosa {
     public int misterio(int arreglo2[], int tamanio) {
        if (tamanio == 1) {
            return arreglo2[0];
        } else {
            return arreglo2[tamanio - 1] + misterio(arreglo2, tamanio - 1 ); 
        }
         
    } // fin del método misterio
} // fin de la clase ClaseMisteriosa


    

