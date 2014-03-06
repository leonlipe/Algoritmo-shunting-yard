/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pilas;

/**
 * Excepción que hereda de Exception para mandar errores en el demo
 * @author leon
 */
public class LinkedListException extends Exception {

    public LinkedListException() {
    }
    
    public LinkedListException(String mensaje) {
        super(mensaje);
    }
    
    
}
