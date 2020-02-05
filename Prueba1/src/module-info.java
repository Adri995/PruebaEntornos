/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aceptaelreto380;
import java.util.*;
/**
 *
 * @author adry_
 */
public class Prueba1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         int cantidadGastos = 0;
         String [] datos;
         int sumas = 0;
         
         do{
             cantidadGastos = Integer.parseInt(in.nextLine());
             if(cantidadGastos > 0){
                sumas = 0;
                datos = in.nextLine().split(" ");
                for(int i = 0; i < cantidadGastos; i++){
                sumas += Integer.parseInt(datos[i]);
                }
                 System.out.println(sumas);
             }   
         }while(cantidadGastos > 0);
    }
    
}