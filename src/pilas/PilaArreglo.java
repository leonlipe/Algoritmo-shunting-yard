/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pilas;

import java.lang.reflect.Array;

/**
 *
 * @author leon
 */
public class PilaArreglo<T> {
    T [] pila;
    int tam = 10;
    int tope = -1;

    public PilaArreglo() {
        pila = (T[]) new Object[tam];
    }
    
    public PilaArreglo(int tamanio) {
        this.tam = tamanio;
        pila = (T[]) new Object[tam];
    }
    
    public void push(T dato) throws Exception{
        if (tope+1 == tam){
            throw new Exception("La pila está llena");
        }else {
            pila[++tope] = dato;

        }
    }
    
    public T pop() throws Exception{
        if (tope == -1){
            throw new Exception("La pila está vacía");
        }else {
            return pila[tope--];
        }
    }
    
    
    
}
