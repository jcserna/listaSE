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
public class ListaCircularDE {

    private NodoDE cabeza;
    private int totalInfantes = contarNodosDE();

    public ListaCircularDE() {
    }

    public NodoDE getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoDE cabeza) {
        this.cabeza = cabeza;
    }

    public int getTotalInfantes() {
        return totalInfantes;
    }

    public void setTotalPerros(int totalPerros) {
        this.totalInfantes = totalPerros;
    }

    public void adicionarListaCircularDE(Infante dato) {

        if (cabeza == null) {
            cabeza = new NodoDE(dato);
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);

        } else {
            NodoDE temp = new NodoDE(dato);
            cabeza.getAnterior().setSiguiente(temp);
            temp.setSiguiente(cabeza);
            temp.setAnterior(cabeza.getAnterior());
            cabeza.setAnterior(temp);

        }
        totalInfantes++;
    }

    public void adicionarListaCircularDEInicio(Infante dato) {

        if (cabeza == null) {
            cabeza = new NodoDE(dato);
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);

        } else {
            NodoDE temp = new NodoDE(dato);
            cabeza.getAnterior().setSiguiente(temp);
            temp.setSiguiente(cabeza);
            temp.setAnterior(cabeza.getAnterior());
            cabeza.setAnterior(temp);
            cabeza = temp;

        }
        totalInfantes++;
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
    
        public void agregarNodoDE(int pos, Infante dato) {
       
        NodoDE temporal = cabeza;
         int contador = 1;
        if (contador == pos) {
            adicionarListaCircularDEInicio(dato);
        } else {
            
                while (contador != pos && temporal.getSiguiente() != cabeza) {
                    temporal = temporal.getSiguiente();
                    contador++;
                }

                NodoDE temp1 = temporal.getAnterior();
                temporal.setAnterior(new NodoDE(dato));
                temporal.getAnterior().setAnterior(temp1);
                temp1.setSiguiente(temporal.getAnterior());
                temporal.getAnterior().setSiguiente(temporal);
            }
        } 

    public void eliminarEnSitio(Infante infanteEliminar) {
        if (cabeza != null) {
            NodoDE temp = cabeza;
            while (temp.getDato().getIdentificador() != infanteEliminar.getIdentificador()) {
                temp = temp.getSiguiente();
            }
            if (temp == cabeza) {
                //Eliminar cabeza
                cabeza = temp.getSiguiente();
                cabeza.setAnterior(cabeza.getAnterior().getAnterior());
                cabeza.getAnterior().setSiguiente(cabeza);
                totalInfantes--;

            } else {
                temp.getSiguiente().setAnterior(temp.getAnterior());
                temp.getAnterior().setSiguiente(temp.getSiguiente());
                totalInfantes--;

            }

        }
    }
    
     


//         public void agregarNodo(int pos, Infante infanteReingresar) {
//        if (cabeza != null) {
//            int cont = 1;
//            NodoDE temp = cabeza;
//            if (pos == cont) {
//               in
//            } else {
//                while (cont != pos && temp.getSiguiente() != null) {
//                    temp = temp.getSiguiente();
//                }
//                cont++;
//            }
//            if (cont < pos) {
//                adicionarNodoDE(infanteReingresar);
//            } else {
//                NodoDE temp1 = temp.getAnterior();
//                temp.setAnterior(new NodoDE(dato));
//                temp.getAnterior().setAnterior(temp1);
//                temp1.setSiguiente(temp.getAnterior());
//                temp.getAnterior().setSiguiente(temp);
//
//            }
//        } else {
//            adicionarNodoDE(infanteReingresar);
//
//        }
//    }




}
