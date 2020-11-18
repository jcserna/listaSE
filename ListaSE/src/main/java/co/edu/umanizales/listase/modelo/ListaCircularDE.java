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
    private int totalPerros = 0;

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

    public void adicionarListaCircularDE(Perro dato) {

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

    public int sumarAlReves(String tipo) {
        //Encontramos el número de elementos de la lista
        totalPerros = contarNodosDE();
        //inicializamos la suma en 0
        int suma = 0;
        //Creamos un nodo ayudante para que recorra la lista de atras hacia adelante
        //Ubicamos este ayudante en el ultimo elemento
        NodoDE temp = cabeza.getAnterior();

        //Si el usuario ingresa par
        if (tipo.equalsIgnoreCase("par")) {
            //en caso que la lista sea impar el ayudante se ubica en el ultimo elemento que sería par
            if (totalPerros % 2 != 0) {
                temp = temp.getAnterior();
            }
            //Se van sumando los nodos pares y se recorre la lista al revés de dos en dos
            //hasta que elelemento este ubicado en la segunda posicion
            suma += temp.getDato().getNumero();
            while (temp.getAnterior() != cabeza) {
                temp = temp.getAnterior().getAnterior();
                suma += temp.getDato().getNumero();

            }
            //Como en la segunda posicion no entra al ciclo también la suma 

            //Si el ususario indica impar
        } else if (tipo.equalsIgnoreCase("impar")) {
            //si la lista es par y se ubica en el penultimo que en este caso sería impar
            if (totalPerros % 2 == 0) {
                temp = temp.getAnterior();
            }
            //Si la lista es impar se ubica en el ultimo
            //Recorre la lista de dos en dos hasta que el ayudante sea la cabeza 
            //Y va sumando los impares
            suma += temp.getDato().getNumero();

            while (temp.getAnterior() != cabeza.getAnterior()) {
                temp = temp.getAnterior().getAnterior();
                suma += temp.getDato().getNumero();

            }

        }
        return suma;
    }
    
    public void filtrarGenero(String genero) {
        NodoDE temp = cabeza;
        ListaDE nuevaLista = new ListaDE();
        if (genero.equalsIgnoreCase("Masculino")) {
            while (temp != null) {
                if (temp.getDato().getGenero().equalsIgnoreCase("macho")) {
                    nuevaLista.adicionarAlInicio(temp.getDato());
                } else if (temp.getDato().getGenero().equalsIgnoreCase("hembra")) {
                    nuevaLista.adicionarNodoDE(temp.getDato());
                }
                temp = temp.getSiguiente();
            }
//            if (temp.getDato().getGenero().equalsIgnoreCase("macho")) {
//                nuevaLista.adicionarNodoInicio(temp.getDato());
//            } else if (temp.getDato().getGenero().equalsIgnoreCase("hembra")) {
//                nuevaLista.adicionarNodo(temp.getDato());
//            }
            cabeza = nuevaLista.getCabeza();
        } else if (genero.equalsIgnoreCase("hembra")) {
            while (temp != null) {
                if (temp.getDato().getGenero().equalsIgnoreCase("hembra")) {
                    nuevaLista.adicionarAlInicio(temp.getDato());
                } else if (temp.getDato().getGenero().equalsIgnoreCase("macho")) {
                    nuevaLista.adicionarNodoDE(temp.getDato());
                }
                temp = temp.getSiguiente();
            }
//            if (temp.getDato().getGenero().equalsIgnoreCase("hembra")) {
//                nuevaLista.adicionarNodoInicio(temp.getDato());
//            } else if (temp.getDato().getGenero().equalsIgnoreCase("macho")) {
//                nuevaLista.adicionarNodo(temp.getDato());
//            }
            cabeza = nuevaLista.getCabeza();
        }

    }
}
