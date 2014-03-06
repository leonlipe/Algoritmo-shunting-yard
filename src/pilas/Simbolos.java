/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

/**
 *
 * @author leon
 */
public class Simbolos {

    public static Simbolo[] operadores = {
        new Simbolo("("),
        new Simbolo(")"),
        new Simbolo("^"),
        new Simbolo("*"),
        new Simbolo("/"),
        new Simbolo("+"),
        new Simbolo("-")
    };
    
    public static boolean greaterOrEqualThan(String simbolo01, String simbolo02){
        return new Simbolo(simbolo01).greaterOrEqualThan(simbolo02);
    }

    public static boolean greaterThan(String simbolo01, String simbolo02){
        return new Simbolo(simbolo01).greaterThan(simbolo02);
    }
    
    public static boolean lessOrEqualThan(String simbolo01, String simbolo02){
        return new Simbolo(simbolo01).lessOrEqualThan(simbolo02);
    }
    
    public static boolean lessThan(String simbolo01, String simbolo02){
        return new Simbolo(simbolo01).lessThan(simbolo02);
    }
    
    public static boolean isOperando(String simbolo) {
        return !(contains(operadores, new Simbolo(simbolo)));

    }

    public static boolean isOperador(String simbolo) {
        return (contains(operadores, new Simbolo(simbolo)));

    }

    private static boolean contains(Simbolo[] arreglo, Simbolo simbolo) {
        boolean resultado = false;
        for (Simbolo obj : arreglo) {
            if (obj.equals(simbolo)) {
                resultado = true;
                break;
            }
        }
        return resultado;
    }

    private static enum Tipo {

        OPERANDO, OPERADOR;
    }

    private static class Simbolo {

        String simbolo;
        Tipo tipo;
        Integer prioridad;

        public Simbolo(String simbolo, Tipo tipo, Integer prioridad) {
            this.simbolo = simbolo;
            this.tipo = tipo;
            this.prioridad = prioridad;
        }

        public Simbolo(String simbolo) {
            this.simbolo = simbolo;
            switch (simbolo) {
                case "^":
                    this.tipo = Tipo.OPERADOR;
                    this.prioridad = -1;
                    break;
                case "*":
                    this.tipo = Tipo.OPERADOR;
                    this.prioridad = -2;
                    break;
                case "/":
                    this.tipo = Tipo.OPERADOR;
                    this.prioridad = -2;
                    break;
                case "+":
                    this.tipo = Tipo.OPERADOR;
                    this.prioridad = -3;
                    break;
                case "-":
                    this.tipo = Tipo.OPERADOR;
                    this.prioridad = -3;
                    break;
                case "(":
                    this.tipo = Tipo.OPERADOR;
                    this.prioridad = 0;
                    break;
                case ")":
                    this.tipo = Tipo.OPERADOR;
                    this.prioridad = 0;
                    break;

            }
        }

        @Override
        public boolean equals(Object object) {
            return (this.simbolo.equals(((Simbolo)object).simbolo));
        }
        
        public boolean greaterThan(String simbolo){
            return this.prioridad > new Simbolo(simbolo).prioridad;
        }
        
         public boolean greaterOrEqualThan(String simbolo){
            return this.prioridad >= new Simbolo(simbolo).prioridad;
        }
        
        public boolean lessThan(String simbolo){
            return this.prioridad < new Simbolo(simbolo).prioridad;
        }
        
         public boolean lessOrEqualThan(String simbolo){
            return this.prioridad <= new Simbolo(simbolo).prioridad;
        }

    }

}
