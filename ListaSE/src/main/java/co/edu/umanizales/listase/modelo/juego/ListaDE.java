/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umanizales.listase.modelo.juego;

/**
 *
 * @author camis
 */
public class ListaDE {

    private NodoDE cabeza;

    public NodoDE getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoDE cabeza) {
        this.cabeza = cabeza;
    }

    public void adicionarNodoDE(Infante dato) {
        if (cabeza == null) {
            //No tiene infantes
            cabeza = new NodoDE(dato);
        } else {
            // tiene perros
            NodoDE temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            //Ubicado o parado en el último
            temp.setSiguiente(new NodoDE(dato));
            temp.getSiguiente().setAnterior(temp);

        }

    }
    
        public byte contarNodosDE() {

        if (cabeza != null) {
            NodoDE temp = cabeza;
            byte cont = 1;

            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
                cont++;
            }
            return cont;
        } else {
            return 0;
        }
    }
        
        public void eliminarActualDE(byte numeroInfante) {

        //Preguntar si la lista es vacía
        if (cabeza != null) {

            //Si el unico dato es cabeza, eliminarlo
            if (cabeza.getSiguiente() == null) {
                cabeza = null;

            } //Sino crear un ayudante y ubicarlo en cabeza
            else {

                NodoDE temp = cabeza;

                //Si el temp(cabeza) tiene el mismo numero del parametro ingresado, se debe eliminar el primero
                if (numeroInfante == temp.getDato().getIdentificador()) {

                    //Cabeza se convierte en el siguiente al temporal
                    cabeza = temp.getSiguiente();

                    //Se suelta el anterior 
                    cabeza.setAnterior(null);
                    temp.setSiguiente(null);

                    //si no es el primero
                } else {

                    //Recorre la lista hasta que el parametro ingresado sea ifual al numero de temp
                    while (temp.getDato().getIdentificador() != numeroInfante) {
                        temp = temp.getSiguiente();

                    }
                    //Si se debe eliminar el ultimo, se suelta el temporal
                    if (temp.getSiguiente() == null) {
                        temp.getAnterior().setSiguiente(null);
                        temp.setAnterior(null);

                        //Sino el lazo siguiente al temporal lo ubica en el anterior
                        // y enlaza el anterior con el siguiente 
                    } else {
                        temp.getSiguiente().setAnterior(temp.getAnterior());
                        temp.getAnterior().setSiguiente(temp.getSiguiente());
                    }
                }
            }
        }

    }
}
