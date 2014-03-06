/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

/**
 * Esta clase implementa una lista simplemente ligada, usando para ello la clase
 * Nodo
 * @author leon
 */
public class Lista<T> {

    /**
     * Este es el inicio de la lista.
     */
    private Nodo<T> inicio;

    /**
     * Este metodo solo genera un string para mostrar la lista de manera
     * "grafica"
     *
     * @return
     */
    public String generaStringComoLista() {
        String resultado = "";
        if (getInicio() == null) {
            return "Lista vacía";
        } else {
            Nodo<T> aux = inicio;
            while (aux != null) {
                resultado = resultado + aux.getInfo().toString() + "=>";
                aux = aux.getLiga();
            }
        }
        return resultado + "nil";
    }

    /**
     * Sobreescritura del metodo toString para usarlo en un system.out.println
     *
     * @return
     */
    public String toString() {
        String resultado = "{";
        if (getInicio() == null) {
            return "Lista vacía";
        } else {
            Nodo<T> aux = inicio;
            while (aux != null) {
                resultado = resultado + aux.getInfo().toString() + ",";
                aux = aux.getLiga();
            }
        }
        return resultado.substring(0, resultado.length() - 1) + "}";

    }

    /**
     * @return the inicio
     */
    public Nodo<T> getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(Nodo<T> inicio) {
        this.inicio = inicio;
    }

    /**
     * Método que inserta al inicio de la lista
     *
     * @param dato
     */
    public void insertaInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setLiga(inicio);
        inicio = nuevo;

    }

    /**
     * Método que inserta al final de la lista
     *
     * @param dato
     */
    public void insertaFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        Nodo<T> aux = inicio;
        if (inicio == null) {
            inicio = nuevo;
        } else {
            while (aux.getLiga() != null) {
                aux = aux.getLiga();
            }
            aux.setLiga(nuevo);

        }
    }
    /**
     * Método que inserta un dato antes de otro tomado como referencia
     * @param dato El dato a insertar
     * @param datoInicial El dato como referencia
     * @throws LinkedListException 
     */
    public void insertaAntesDato(T dato, T datoInicial) throws LinkedListException {
        if (inicio == null) {
            throw new LinkedListException("La lista está vacía.");
        }
        Nodo<T> actual = inicio;
        Nodo<T> anterior = null;
        boolean band = false;
        while (!actual.getInfo().equals(datoInicial) && !band) {
            if (actual.getLiga() != null) {
                anterior = actual;
                actual = actual.getLiga();
            } else {
                band = true;
            }

        }
        if (!band) {
            Nodo<T> nodo = new Nodo<>(dato);
            if (actual == inicio) { // El nodo dado como referencia es el primero
                nodo.setLiga(inicio);
                inicio = nodo;
            } else {
                anterior.setLiga(nodo);
                nodo.setLiga(actual);
            }

        } else {
            throw new LinkedListException("El nodo dado como referencia no está en la lista");
        }
    }

    /**
     * Método que inserta un dato después de otro tomado como referencia
     * @param dato El dato a insertar
     * @param datoInicial El dato como referencia
     * @throws LinkedListException 
     */
    public void insertaDespuesDato(T dato, T datoInicial) throws LinkedListException {
        if (inicio == null) {
            throw new LinkedListException("La lista está vacía.");
        }
        Nodo<T> actual = inicio;
        boolean band = false;
        while (!actual.getInfo().equals(datoInicial) && !band) {
            if (actual.getLiga() != null) {
                actual = actual.getLiga();
            } else {
                band = true;
            }

        }
        if (!band) {
            Nodo<T> nodo = new Nodo<>(dato);
            nodo.setLiga(actual.getLiga());
            actual.setLiga(nodo);
        } else {
            throw new LinkedListException("El nodo dado como referencia no está en la lista");
        }
    }

    /**
     * Borrar el primer elemento de la lista.
     */
    public void borrarPrimerElemento() {
        if (inicio != null) {
            inicio = inicio.getLiga();
        }
    }

     /**
     * Borrar el primer elemento de la lista.
     */
    public T obtenPrimerElemento() throws Exception {
        T dato =null;
        if (inicio != null) {
            dato = inicio.getInfo();
            inicio = inicio.getLiga();
        }else {
            throw new Exception("La lista está vacía");
        }
        return dato;
    }
    
    public T obtenPrimerElementoSinEliminar() throws Exception {
        T dato =null;
        if (inicio != null) {
            dato = inicio.getInfo();
            
        }else {
            throw new Exception("La lista está vacía");
        }
        return dato;
    }
    
    /**
     * Borrar el último elemento de la lista
     */
    public void borrarUltimoElemento() {
        Nodo<T> aux = inicio;
        Nodo<T> anterior = null;
        if (inicio.getLiga() == null) {
            inicio = null;
        } else {
            while (aux.getLiga() != null) {
                anterior = aux;
                aux = aux.getLiga();
            }
            anterior.setLiga(null);
        }
    }
    
     /**
     * Borrar el último elemento de la lista
     */
    public T obtenUltimoElemento() {
        Nodo<T> aux = inicio;
        Nodo<T> anterior = null;
        T resultado = null;
        if (inicio.getLiga() == null) {
            resultado = inicio.getInfo();
            inicio = null;
        } else {
            while (aux.getLiga() != null) {
                anterior = aux;
                aux = aux.getLiga();
            }
            resultado = aux.getInfo();
            anterior.setLiga(null);
        }
        return resultado;
    }
    
    public T obtenUltimoElementoSinEliminar() {
        Nodo<T> aux = inicio;
        Nodo<T> anterior = null;
        T resultado = null;
        if (inicio.getLiga() == null) {
            resultado = inicio.getInfo();
            //inicio = null;
        } else {
            while (aux.getLiga() != null) {
                anterior = aux;
                aux = aux.getLiga();
            }
            resultado = aux.getInfo();
            //anterior.setLiga(null);
        }
        return resultado;
    }

    /**
     * Borrar toda la lista ligada
     * En otros lenguajes es necesario recorrer la lista primero para liberar
     * la memoria de cada nodo de la misma.
     */
    public void clear() {
        inicio = null;
    }
    
    
    public Lista<T> invertir(){
        Lista<T> resultado = new Lista<>();
        Nodo<T> aux = inicio;
        while (aux != null){
            resultado.insertaInicio(aux.getInfo());
            aux = aux.getLiga();
        }
        return resultado;
    }

}
