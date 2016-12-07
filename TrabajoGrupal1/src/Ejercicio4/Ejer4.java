/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author SALAS
 */
public class Ejer4 {

    private Formatter salida; // objeto usado para enviar texto al archivo

    // permite al usuario abrir el archivo
    public void abrir_archivo() {
        try {
            salida = new Formatter("ventas.txt");
        } // fin de try
        catch (SecurityException securityException) {
            System.err.println(
                    "No tiene acceso de escritura a este archivo.");
            System.exit(1);
        } // fin de catch
        catch (FileNotFoundException filesNotFoundException) {
            System.err.println("Error al crear el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método abrir_archivo

    // agrega registros al archivo
    public void agregar_informacion() {
        // el archivo permite el ingreso
        // de edad, nombre, apellido de una persona

        Scanner entrada = new Scanner(System.in);
        double costo = 0.0;
        double sub = 0.0;
        String producto = " ";
        int res;
        int cant;
        try // envía valores al archivo
        {
            // obtiene los datos que se van a enviar
            System.out.print("Ingrese nombre: ");
            String nom = entrada.next();
            System.out.print("Ingrese ciudad: ");
            String ciu = entrada.next();

            salida.format("\n\n--- COMERCIAL VENTAS Y REVENTAS ---\n"
                    + "Nombre: %s\nCiudad: %s\n"
                    + "----------------------------------------\n"
                    + "PRODUCTO\tCANTIDAD\tPRECIO\n", nom, ciu);
            do {
                System.out.println("\t--- QUE DESEA COMPRAR?  ---");
                System.out.printf("* 1) Arroz: costo del kilo $2.50\n"
                        + "* 2) Azúcar: costo del kilo $1.50\n"
                        + "* 3) Aceite: costo $ 1.30 por unidad\n"
                        + "* 4) Tallarines: costo $ 1.50\n"
                        + "* 5) Sal: costo del kilo $1.00\n");
                System.out.print("Ingrese opcion: ");
                int opc = entrada.nextInt();
                System.out.print("\nIngrese cantidad: ");
                cant = entrada.nextInt();
                switch (opc) {
                    case 1:
                        costo = 2.50 * cant;
                        producto = "Arroz      ";
                        break;
                    case 2:
                        costo = 1.50 * cant;
                        producto = "Azucar     ";
                        break;
                    case 3:
                        costo = 1.30 * cant;
                        producto = "Aceite     ";
                        break;
                    case 4:
                        costo = 1.50 * cant;
                        producto = "Tallarines ";
                        break;
                    case 5:
                        costo = 1.00 * cant;
                        producto = "Sal        ";
                        break;
                    default:
                        System.out.println("Numero ingresado no existe");
                        break;
                }

                salida.format("%s\t\t%d\t\t%.2f\n", producto, cant, costo);
                sub = sub + costo;
                System.out.println("Quiere comprar otro producto?: \n\t1) SI 2) NO");
                res = entrada.nextInt();
            } while (res != 2);
            //cant += cant;

            double iva = sub * 0.14;
            double total = sub + iva;
            salida.format("----------------------------------------\n"
                    + "\t\t\t\tSubtotal: %.2f\n \t\t\t\tIVA 14:    %.2f \n \t\t\t\tTotal:    %.2f\n"
                    + "-----------------------------------------", sub, iva, total);

        } // fin de try
        catch (FormatterClosedException formatterClosedException) {
            System.err.println("Error al escribir en el archivo.");
            return;
        } // fin de catch
        catch (NoSuchElementException elementException) {
            System.err.println("Entrada invalida. Intente de nuevo.");
            entrada.nextLine(); // descarta la entrada para que el usuario intente de nuevo
        } // fin de catch

    } // fin del método agregarRegistros

    // cierra el arrchivo
    public void cerrar_archivo() {
        if (salida != null) {
            salida.close();
        }
    } // fin del método cerrarArchivo
}
