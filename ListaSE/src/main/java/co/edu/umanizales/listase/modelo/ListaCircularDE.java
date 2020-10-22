/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umanizales.listase.modelo;

/**
 *
 * @author camis
 */
public class ListaCircularDE {
    private NodoDE cabeza;
    private int totalPerros =0;

    public NodoDE getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoDE cabeza) {
        this.cabeza = cabeza;
    }

    public int getTotalPerros() {
        return totalPerros;
    }

    public void setTotalPerros(int totalPerros) {
        this.totalPerros = totalPerros;
    }
    
    
    
    
    public void adicionarListaCircularDE (Perro dato){
       
        if (cabeza==null){
            cabeza = new NodoDE(dato);
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
            
        }
        else {
            NodoDE temp = new NodoDE(dato);
            cabeza.getAnterior().setSiguiente(temp);
            temp.setSiguiente(cabeza);
            temp.setAnterior(cabeza.getAnterior());
            cabeza.setAnterior(temp);
            
        
        }
        totalPerros++;
    }
    
        public int contarNodosDE() {

        if (cabeza != null) {
            NodoDE temp = cabeza;
            int cont = 1;

            while (temp.getSiguiente() != cabeza) {
                temp = temp.getSiguiente();
                cont++;
            }
            return cont;
        } else {
            return 0;
        }
    }
        public int sumarAlReves (String tipo){
       totalPerros = contarNodosDE();
            int suma=0;
            NodoDE temp=cabeza.getAnterior();
                
            if(tipo.equalsIgnoreCase("par")){
                if(totalPerros%2 != 0)
                { temp.getAnterior();}
            
              while (temp.getAnterior()!= cabeza){
                  temp.getAnterior().getAnterior();
                  suma += temp.getDato().getNumero();
              }
                  suma+=temp.getDato().getNumero();
            }else if (tipo.equalsIgnoreCase("impar")) {
                
                 if(totalPerros%2 == 0){temp.getAnterior();
                    }
                                 
              while (temp.getAnterior()!= cabeza){
                  temp.getAnterior().getAnterior();
                  suma += temp.getDato().getNumero();
              }suma+=temp.getDato().getNumero();
              
            
        }return suma;
}
}