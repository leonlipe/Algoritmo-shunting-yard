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
public class ColaListaLigada<T> {
    
  private Lista<T> lista = new Lista<T>();
  
   public void push(T dato){
       lista.insertaInicio(dato);       
   }
   
   public T pop() throws Exception{
       try {
           return lista.obtenUltimoElemento();
       } catch (Exception ex) {
           throw new Exception("La pila está vacía");
       }
   }
   
    public T peek() throws Exception{
       try {
           return lista.obtenUltimoElementoSinEliminar();
       } catch (Exception ex) {
           throw new Exception("La pila está vacía");
       }
   }
    
    public boolean vacia(){
        return lista.getInicio()==null;
    }

    public String toString(){
        String resultado = "";
            Nodo<T> aux = lista.invertir().getInicio();
            while (aux != null) {
                resultado = resultado + aux.getInfo().toString();
                aux = aux.getLiga();
        }
            return resultado;
    }
}
