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

    public void eliminarPosicionDE(byte numeroNodo) {

        if (cabeza != null) {
            if (cabeza.getSiguiente() == null) {
                cabeza = null;
//            ListaDE nueva=new ListaDE();
            }
            else{

            NodoDE temp = cabeza;
            int cont = 1;

            if (cont == numeroNodo) {
                //Eliminar cabeza

                cabeza = temp.getSiguiente();

                cabeza.setAnterior(null);
                temp = cabeza;
            } else {
                while (numeroNodo != cont) {
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
    
    public void intercambiarDatos(byte pos1, byte pos2){
        if (cabeza != null){
            byte contador1=1;
            byte contador2=1;
            NodoDE temp1=cabeza;
            NodoDE temp2=cabeza;
            
            while (contador1!=pos1){
                temp1=temp1.getSiguiente();
                contador1++;
                
                while(contador2!=pos2){
                    temp2= temp2.getSiguiente();
                    
                }
            }
        }
    }
}
