/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umanizales.listase.modelo.prueba;

import co.edu.umanizales.listase.modelo.ListaCircularDE;
import co.edu.umanizales.listase.modelo.ListaDE;
import co.edu.umanizales.listase.modelo.ListaSE;
import co.edu.umanizales.listase.modelo.Perro;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Camilo
 */
public class ProbarListaSE {

    public static void main(String... args) {
//            ListaSE listaPerros = new ListaSE();
//            Perro lulu = new  Perro("Lulú", (byte)1, (byte)9,"hembra");
//            listaPerros.adicionarNodo(lulu);
////            
////              Perro firulais = new  Perro("Firulais", (byte)2, (byte)4,"macho");
////            listaPerros.adicionarNodo(firulais);
////            
////              Perro pastor = new  Perro("Tobby", (byte)3, (byte)6,"macho");
////            listaPerros.adicionarNodo(pastor);
//            
//    listaPerros.eliminarNodo((byte)1);
//            System.out.println("datos: "+listaPerros.contarNodos());

//            ListaDE listaPerrosDE = new ListaDE();
//            ListaCircularDE listaCircular = new ListaCircularDE();
//            
//               ListaSE listaPerros = new ListaSE();
//            Perro lulu = new  Perro("Lulú", (byte)4, (byte)9,"hembra");
//            listaPerrosDE.adicionarNodoDE(lulu);
//            
//              Perro firulais = new  Perro("Firulais", (byte)5, (byte)4,"macho");
//            listaPerrosDE.adicionarNodoDE(firulais);
//            
//              Perro pastor = new  Perro("Tobby", (byte)8, (byte)6,"macho");
//            listaPerrosDE.adicionarNodoDE(pastor);
//            
//          listaPerrosDE.intercambiarPosiciones(1, 2);
//         System.out.println(listaPerrosDE.mostrarDatos());
//            
        ListaCircularDE listaCircular = new ListaCircularDE();

        Perro lulu = new Perro("Lulú", (byte) 1, (byte) 9, "hembra");
        listaCircular.adicionarListaCircularDE(lulu);

        Perro firulais = new Perro("Firulais", (byte) 2, (byte) 4, "macho");
        listaCircular.adicionarListaCircularDE(firulais);
//        
        Perro pastor = new Perro("Tobby", (byte) 3, (byte) 6, "macho");
        listaCircular.adicionarListaCircularDE(pastor);

        ArrayList<Perro> perros = new ArrayList<Perro>(); 
        perros.add(lulu);
//        perros.add(firulais); 

        
        
   
        
        // listaCircular.adicionarListaCircularDE(new Perro("robin", (byte) 4, (byte) 5, "macho"));
        //System.out.println(listaPerros.encontrarPosicion(4).getDato().getNombre());
        //listaPerros.adicionarNodoPorPosicion(3, new Perro("robin", (byte)4, (byte)5,"macho"));

//        System.out.println(listaCircular.sumarAlReves("par"));

    }

}
