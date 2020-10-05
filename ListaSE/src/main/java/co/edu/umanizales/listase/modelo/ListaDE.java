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
    
    public void adicionarAlInicio(Perro dato){
        if (cabeza != null){
            //SI hay datos
            NodoDE temp = new NodoDE(dato);
            temp.setSiguiente(cabeza);
            cabeza.setAnterior(temp);
            cabeza=temp;
        }
        else{
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

        if (cabeza != null) {
            if (cabeza.getSiguiente() == null) {
                cabeza = null;
//            ListaDE nueva=new ListaDE();
            }
            else{

            NodoDE temp = cabeza;
        

            if (numeroPerro == temp.getDato().getNumero()) {
                //Eliminar cabeza

                cabeza = temp.getSiguiente();

                cabeza.setAnterior(null);
                
            } else {
                while (temp.getDato().getNumero() != numeroPerro) {
                    temp = temp.getSiguiente();
        
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
    
    public void eliminarPosicionDE(byte posicion) {

        if (cabeza != null) {
            if (cabeza.getSiguiente() == null) {
                cabeza = null;
//            ListaDE nueva=new ListaDE();
            }
            else{

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
    }}

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
    
}
