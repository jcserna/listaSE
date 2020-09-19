/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umanizales.listase.modelo;

/**
 *
 * @author Camilo
 */
public class ListaSE
{

    private Nodo cabeza;

    public ListaSE()
    {
    }

    public Nodo getCabeza()
    {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza)
    {
        this.cabeza = cabeza;
    }

    public void adicionarNodo(Perro dato)
    {
        if (cabeza == null)
        {
            //No tiene perros
            cabeza = new Nodo(dato);
        }
        else
        {
            // tiene perros
            Nodo temp = cabeza;
            while (temp.getSiguiente() != null)
            {
                temp = temp.getSiguiente();
            }
            //Ubicado o parado en el último
            temp.setSiguiente(new Nodo(dato));
        }
    }

    public int contarNodos()
    {

        if (cabeza != null)
        {
            Nodo temp = cabeza;
            int cont = 1;

            while (temp.getSiguiente() != null)
            {
                temp = temp.getSiguiente();
                cont++;
            }
            return cont;
        }
        else
        {
            return 0;
        }
    }

    public void adicionarNodoInicio(Perro perro)
    {
        if (cabeza != null)
        {
            Nodo temp = new Nodo(perro);
            temp.setSiguiente(cabeza);
            cabeza = temp;
        }
        else
        {
            cabeza = new Nodo(perro);
        }
    }

    public void eliminarNodo(byte numero)
    {
        Nodo anterior = cabeza;

        if (anterior.getDato().getNumero() == numero)
        {
            //Eliminar cabeza
            cabeza = anterior.getSiguiente();
        }
        else
        {
            //Mientras el siguiente del ayudante tenga un numero diferente al id
            //sigue pasano de nodo a nodo hasta que el id del nodo coincida con el ingresado                
            while (anterior.getSiguiente().getDato().getNumero() != numero)
            {
                anterior = anterior.getSiguiente();
            }
            //Si el seiguiente del nodo encontrado en el ciclo es null, se debe eliminar el anterior al nodo
            if (anterior.getSiguiente().getSiguiente() == null)
            {
                anterior.setSiguiente(null);
            }
            else
            {
                anterior.setSiguiente(anterior.getSiguiente().getSiguiente());

            }
        }

    }

    public void invertir()
    {
        if (cabeza != null)
        {
            ListaSE listaTemporal = new ListaSE();
            Nodo temp = cabeza;
            while (temp != null)//Recorre de principio a fin
            {
                listaTemporal.adicionarNodoInicio(temp.getDato());
                temp = temp.getSiguiente();//Ayudante pase al siguiente perro
            }
            cabeza = listaTemporal.getCabeza();
        }
    }

    public void intercambiarExtremos()
    {
        if (cabeza != null)
        {
            Nodo temp = cabeza;
            while (temp.getSiguiente() != null)
            {
                temp = temp.getSiguiente();
            }
            /// Parado en el último nodo
            Perro perrotemp = cabeza.getDato();
            cabeza.setDato(temp.getDato());
            temp.setDato(perrotemp);
        }
    }

    public Nodo encontrarPosicion(byte numeroNodo)
    {
       

//        if (pos <= contarNodos())
//        {
        int cont = 1;
        Nodo temp = cabeza;
        Nodo pos=cabeza;
        byte posicion=1;
        
        while (pos!=temp){
            posicion++;
            
        }
        while (temp.getSiguiente() != null) //Mientras el lazo este lleno
        {
            if (cont == numeroNodo)
            {
                return temp;
            }
            else
            {
                temp = temp.getSiguiente(); // Ayudante pase al siguiente perro
                cont++;
            }
        }
        return temp;
//        }
//        else
//        {
//            return null;
//        }
    }

    public void filtrarGenero(String genero)
    {
        Nodo temp = cabeza;
        ListaSE nuevaLista = new ListaSE();
        if (genero.equalsIgnoreCase("macho"))
        {
            while (temp.getSiguiente() != null)
            {
                if (temp.getDato().getGenero().equalsIgnoreCase("macho"))
                {
                    nuevaLista.adicionarNodoInicio(temp.getDato());
                }
                else if (temp.getDato().getGenero().equalsIgnoreCase("hembra"))
                {
                    nuevaLista.adicionarNodo(temp.getDato());
                }
                temp = temp.getSiguiente();
            }
            if (temp.getDato().getGenero().equalsIgnoreCase("macho"))
                {
                    nuevaLista.adicionarNodoInicio(temp.getDato());
                }
                else if (temp.getDato().getGenero().equalsIgnoreCase("hembra"))
                {
                    nuevaLista.adicionarNodo(temp.getDato());
                }
           cabeza = nuevaLista.getCabeza();
        }
        else if (genero.equalsIgnoreCase("hembra"))
        {
            while (temp.getSiguiente() != null)
            {
                if (temp.getDato().getGenero().equalsIgnoreCase("hembra"))
                {
                    nuevaLista.adicionarNodoInicio(temp.getDato());
                }
                else if (temp.getDato().getGenero().equalsIgnoreCase("macho"))
                {
                    nuevaLista.adicionarNodo(temp.getDato());
                }
                temp = temp.getSiguiente();
            }
            if (temp.getDato().getGenero().equalsIgnoreCase("hembra"))
                {
                    nuevaLista.adicionarNodoInicio(temp.getDato());
                }
                else if (temp.getDato().getGenero().equalsIgnoreCase("macho"))
                {
                    nuevaLista.adicionarNodo(temp.getDato());
                }
            cabeza = nuevaLista.getCabeza();
        }

    }


}
