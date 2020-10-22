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
public class ListaDE {

    private NodoDE cabeza;

    public NodoDE getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoDE cabeza) {
        this.cabeza = cabeza;
    }

    public void adicionarNodoDE(Perro dato) {
        if (cabeza == null) {
            //No tiene perros
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

    public void adicionarAlInicio(Perro dato) {
        if (cabeza != null) {
            //SI hay datos
            NodoDE temp = new NodoDE(dato);
            temp.setSiguiente(cabeza);
            cabeza.setAnterior(temp);
            cabeza = temp;
        } else {
            cabeza = new NodoDE(dato);
        }
    }

    public int contarNodosDE() {

        if (cabeza != null) {
            NodoDE temp = cabeza;
            int cont = 1;

            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
                cont++;
            }
            return cont;
        } else {
            return 0;
        }
    }

//    public void eliminarActualDE(byte numeroNodo) {
//
//        if (cabeza != null) {
//            if (cabeza.getSiguiente() == null) {
//                cabeza = null;
////            ListaDE nueva=new ListaDE();
//            }
//            else{
//
//            NodoDE temp = cabeza;
//            int cont = 1;
//
//            if (cont == numeroNodo) {
//                //Eliminar cabeza
//
//                cabeza = temp.getSiguiente();
//
//                cabeza.setAnterior(null);
//                temp = cabeza;
//            } else {
//                while (numeroNodo != cont) {
//                    temp = temp.getSiguiente();
//                    cont++;
//                }
//                if (temp.getSiguiente() == null) {
//                    temp.getAnterior().setSiguiente(null);
//
//                } else {
//                    temp.getSiguiente().setAnterior(temp.getAnterior());
//                    temp.getAnterior().setSiguiente(temp.getSiguiente());
//                }
//            }
//        }
//    }
//
//}
    public void eliminarActualDE(byte numeroPerro) {

        //Preguntar si la lista es vacía
        if (cabeza != null) {

            //Si el unico dato es cabeza, eliminarlo
            if (cabeza.getSiguiente() == null) {
                cabeza = null;

            } //Sino crear un ayudante y ubicarlo en cabeza
            else {

                NodoDE temp = cabeza;

                //Si el temp(cabeza) tiene el mismo numero del parametro ingresado, se debe eliminar el primero
                if (numeroPerro == temp.getDato().getNumero()) {

                    //Cabeza se convierte en el siguiente al temporal
                    cabeza = temp.getSiguiente();

                    //Se suelta el anterior 
                    cabeza.setAnterior(null);
                    temp.setSiguiente(null);

                    //si no es el primero
                } else {

                    //Recorre la lista hasta que el parametro ingresado sea ifual al numero de temp
                    while (temp.getDato().getNumero() != numeroPerro) {
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

    public void eliminarPosicionDE(byte posicion) {

        if (cabeza != null) {
            if (cabeza.getSiguiente() == null) {
                cabeza = null;
//            ListaDE nueva=new ListaDE();
            } else {

                NodoDE temp = cabeza;
                int cont = 1;

                if (cont == posicion) {
                    //Eliminar cabeza

                    cabeza = temp.getSiguiente();

                    cabeza.setAnterior(null);

                } else {
                    while (posicion != cont) {
                        temp = temp.getSiguiente();
                        cont++;
                    }
                    if (temp.getSiguiente() == null) {
                        temp.getAnterior().setSiguiente(null);

                    } else {
                        temp.getSiguiente().setAnterior(temp.getAnterior());
                        temp.getAnterior().setSiguiente(temp.getSiguiente());
                    }
                }
            }
        }
    }

    public String mostrarDatos() {
        String mensaje;
        NodoDE temp = cabeza;
        mensaje = cabeza.getDato().getNombre();
        while (temp.getSiguiente() != null) {
            temp = temp.getSiguiente();
            mensaje += " " + temp.getDato().getNombre();

        }
        return mensaje;
    }

    public void intercambiarPosiciones(int pos1, int pos2) {
        byte cont1 = 1;
        byte cont2 = 1;
        NodoDE temp1 = cabeza;
        NodoDE temp2 = cabeza;

        //Ubicar el temporal 1 en la posicion 1 buscada
        while (cont1 != pos1) {
            temp1 = temp1.getSiguiente();
            cont1++;
        }
        //Ubicar el temporal 1 en la posicion 2 buscada
        while (cont2 != pos2) {
            temp2 = temp2.getSiguiente();
            cont2++;
        }

        //Tomar los datos (lo que hay dentro de los nodos) e intercambiarlos, los nodos no se mueven 
        Perro perrotemp = temp1.getDato();
        temp1.setDato(temp2.getDato());
        temp2.setDato(perrotemp);
    }

    //Pedir la posición en donde va a ir el nodo
    //Preguntar si la lista esta vacía
    //  Si está vacía, ubicar el nodo en la cabeza
    //Si la posicion dada es igual a 1 agregar el nodo en la primera posición, con cabeza.setAnterior nodo nuevo 
    //nodo nuevo.set siguiente cabeza
    // Hacer cabeza igual a nodo nuevo
    //Agragar un contador que inicie en 0 y un temporal para recorrer la  lista
    //Recorrer la lista
    //En caso que el contador sea igual a la psoición menos 1, ubicase ahí
    //al siguiente del temporal cambiar el lazo anterior y unirlo con el nodo nuevo
    // y el nodo nuevo cambiar el lazo siguiente por el seiguiente a temporal 
    //Al nodo nuevo cambiar el lazo anterior por el temporal
    //A temporal cambiar el seguiente por el nodo nuevo
    public void agregarNodo(int pos, Perro dato) {
        if (cabeza != null) {
            int cont = 1;
            NodoDE temp = cabeza;
            if (pos == cont) {
                adicionarAlInicio(dato);
            } else {
                while (cont != pos && temp.getSiguiente() != null) {
                    temp = temp.getSiguiente();
                }
                cont++;
            }
            if (cont < pos) {
                adicionarNodoDE(dato);
            } else {
                NodoDE temp1 = temp.getAnterior();
                temp.setAnterior(new NodoDE(dato));
                temp.getAnterior().setAnterior(temp1);
                temp1.setSiguiente(temp.getAnterior());
                temp.getAnterior().setSiguiente(temp);

            }
        } else {
            adicionarNodoDE(dato);

        }
    }

    public void invertirDE() {
        if (cabeza != null) {
            ListaDE listaTemporalDE = new ListaDE();
            NodoDE temp = cabeza;
            while (temp != null)//Recorre de principio a fin
            {
                listaTemporalDE.adicionarAlInicio(temp.getDato());
                temp = temp.getSiguiente();//Ayudante pase al siguiente perro
            }
            cabeza = listaTemporalDE.getCabeza();
        }
    }

    public Perro encontrarPosicion(byte numeroNodo) {

        if (cabeza != null) {
            NodoDE temp = cabeza;
            int cont = 1;
            while (numeroNodo != cont) {
                temp = temp.getSiguiente();
                cont++;
            }
            return temp.getDato();
        }
        return null;
    }

    public void filtrarGenero(String genero) {
        NodoDE temp = cabeza;
        ListaDE nuevaLista = new ListaDE();
        if (genero.equalsIgnoreCase("macho")) {
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
