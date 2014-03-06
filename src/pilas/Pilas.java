/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pilas;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leon
 */
public class Pilas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        pilaListasDemo();
       
    }
    
    public static void pilaListasDemo(){
        try {
            PilaListaLigada<Integer> pila = new PilaListaLigada<>();
            pila.push(1);
            pila.push(2);
            pila.push(3);
            System.out.println(pila.pop());
            System.out.println(pila.pop());
            System.out.println(pila.pop());
        } catch (Exception ex) {
            Logger.getLogger(Pilas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void pilaArregloDemo(){
         // Pila implementada con arreglos
        PilaArreglo<Integer> pilaArreglo = new PilaArreglo<>();
        try {
            pilaArreglo.push(10);
            pilaArreglo.push(12);
            System.out.println("Elemento:"+pilaArreglo.pop());
            System.out.println("Elemento:"+pilaArreglo.pop());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
        }
        
    }
    
}
