/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leon
 */
public class Notaciones {

    public ColaListaLigada<String> convertirPostfija(String infija) throws Exception {
        ColaListaLigada<String> colaPostfija = new ColaListaLigada<>();
        PilaListaLigada<String> pila = new PilaListaLigada<>();
       
        for (char cLetra :  infija.toCharArray()) {
            String letra = String.valueOf(cLetra);
            if (letra.equals("(")) {
                pila.push(letra);
            } else {
                if (letra.equals(")")) {
                    while (!pila.peek().equals("(")) {
                        colaPostfija.push(pila.pop());
                    }
                    pila.pop();
                } else {
                    if (Simbolos.isOperando(letra)) {
                        colaPostfija.push(letra);
                    } else {
                        while (!pila.vacia() && Simbolos.lessOrEqualThan(letra, pila.peek()) && !pila.peek().equals("(")) {
                            colaPostfija.push(pila.pop());
                        }
                        pila.push(letra);
                    }
                }
            }
        }
        while (!pila.vacia()) {
            colaPostfija.push(pila.pop());
        }

        return colaPostfija;
    }

    public static void main(String[] args) {
        Notaciones notaciones = new Notaciones();
        try {
            System.out.println(notaciones.convertirPostfija("(4+5)^3/4+(3-2)"));
        } catch (Exception ex) {
            Logger.getLogger(Notaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
