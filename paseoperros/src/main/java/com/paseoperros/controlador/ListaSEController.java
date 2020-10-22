/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paseoperros.controlador;

import co.edu.umanizales.listase.modelo.ListaSE;
import co.edu.umanizales.listase.modelo.Nodo;
import co.edu.umanizales.listase.modelo.Perro;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.DiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.FlowChartConnector;
import org.primefaces.model.diagram.endpoint.BlankEndPoint;
import org.primefaces.model.diagram.endpoint.EndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;
import org.primefaces.model.diagram.overlay.ArrowOverlay;
import org.primefaces.model.diagram.overlay.LabelOverlay;

/**
 *
 * @author Camilo
 */
@Named(value = "listaSEController")
@SessionScoped
public class ListaSEController implements Serializable {

    private ListaSE listaPerros;
    private Perro perroMostrar ;
    private Nodo temp;
    private byte numero;
    private Perro perroEncontrado;
    private DefaultDiagramModel model;
    private int seleccionUbicacion = 0;
    private String genero;

    /**
     * Creates a new instance of ListaSEController
     */
    public ListaSEController() {
    }

    @PostConstruct
    private void iniciar() {
        listaPerros = new ListaSE();
        // Conectaría a un archivo plano o a una base de datos para llenar la lista de perros
        listaPerros.adicionarNodo(new Perro("Pastor", (byte) 1, (byte) 3, "macho"));
        listaPerros.adicionarNodo(new Perro("Lulú", (byte) 2, (byte) 4, "hembra"));
        listaPerros.adicionarNodo(new Perro("Firulais", (byte) 3, (byte) 6, "macho"));

        listaPerros.adicionarNodoInicio(new Perro("Rocky", (byte) 4, (byte) 5, "macho"));
        perroMostrar = listaPerros.getCabeza().getDato();
        temp = listaPerros.getCabeza();
        inicializarModelo();
    }

    public Nodo getTemp() {
        return temp;
    }

    public void setTemp(Nodo temp) {
        this.temp = temp;
    }

    public Perro getPerroMostrar() {
        return perroMostrar;
    }

    public void setPerroMostrar(Perro perroMostrar) {
        this.perroMostrar = perroMostrar;
    }

    public ListaSE getListaPerros() {
        return listaPerros;
    }

    public void setListaPerros(ListaSE listaPerros) {
        this.listaPerros = listaPerros;
    }

    public byte getNumero() {
        return numero;
    }

    public void setNumero(byte numero) {
        this.numero = numero;
    }

    public Perro getPerroEncontrado() {
        return perroEncontrado;
    }

    public void setPerroEncontrado(Perro perroEncontrado) {
        this.perroEncontrado = perroEncontrado;
    }

    public void irSiguiente() {
        //if(temp.getSiguiente()!=null)
        //{
        temp = temp.getSiguiente();
        perroMostrar = temp.getDato();
        //}
        inicializarModelo();
    }

    public void irPrimero() {
        temp = listaPerros.getCabeza();
        perroMostrar = temp.getDato();
        inicializarModelo();
    }

    public void irUltimo() {

        temp = listaPerros.getCabeza();
        while (temp.getSiguiente() != null) {
            temp = temp.getSiguiente();
        }
        /// Parado en el último nodo
        perroMostrar = temp.getDato();
        inicializarModelo();
    }

    public void invertir() {
        listaPerros.invertir();
        irPrimero();
        inicializarModelo();
    }

    public void intercambiar() {
        listaPerros.intercambiarExtremos();
        irPrimero();
        // inicializarModelo();
        pintarExtremos();

    }

    public int getSeleccionUbicacion() {
        return seleccionUbicacion;
    }

    public void setSeleccionUbicacion(int seleccionUbicacion) {
        this.seleccionUbicacion = seleccionUbicacion;
    }

    public void eliminar(byte numero) {
//        listaPerros.eliminarNodo(numero);
        
        if(temp.getSiguiente() != null){    
        listaPerros.eliminarNodo(numero);       
            irPrimero();
            inicializarModelo();
        }else{
            listaPerros.eliminarNodo(numero);
            perroMostrar = new Perro();
            inicializarModelo();
            
            
    }}

    public void encontrarPerro() {

        perroEncontrado = listaPerros.encontrarPosicion(numero);
        // inicializarModelo();
        pintarEncontrado();

    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public DiagramModel getModel() {
        return model;
    }

    public void filtroGenero(String genero) {
        listaPerros.filtrarGenero(this.genero);
        irPrimero();
        inicializarModelo();
    }

    private Connection createConnection(EndPoint from, EndPoint to, String label) {
        Connection conn = new Connection(from, to);
        conn.getOverlays().add(new ArrowOverlay(20, 20, 1, 1));

        if (label != null) {
            conn.getOverlays().add(new LabelOverlay(label, "flow-label", 0.5));
        }

        return conn;
    }

    public void inicializarModelo() {
        model = new DefaultDiagramModel();
        //Definir el modelo la cantidad de enlaces -1 (Infinito)
        model.setMaxConnections(-1);
        //Pregunto si hay datos
        if (listaPerros.getCabeza() != null) {

            Nodo ayudante = listaPerros.getCabeza(); //ayudante, y ubicarlo en el primer elemento
            //En qué posicion se encuentran los elementos 
            int posX = 2;
            int posY = 2;

            while (ayudante != null) {
                //"em" unidad de medida para usar proporsiones de la pantalla para usar el responsive
                Element perroPintar = new Element(ayudante.getDato().getNombre(), posX + "em", posY + "em");

                perroPintar.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_RIGHT)); //Adicionar punto para la conexión (Derecha para la salida)
                perroPintar.addEndPoint(new BlankEndPoint(EndPointAnchor.TOP)); //Adicionar punto para la conexión (izquierda para la llegada)
                if (ayudante.getDato().getNumero() == perroMostrar.getNumero()) {
                    perroPintar.setStyleClass("ui-diagram-success"); //Cambiar el estilo del elemento seleccionado
                }
                model.addElement(perroPintar);

                ayudante = ayudante.getSiguiente();
                posX = posX + 5;
                posY = posY + 5;
                //Cada que se crea un elemento se agregan 5 em para que se muestre en un diferente posicion
            }
            //Sale del ciclo cuando ayudante es ta vacio (recorrio la lista)

            ////Crear conectores
            FlowChartConnector connector = new FlowChartConnector();
            connector.setPaintStyle("{strokeStyle:'#092CB0',lineWidth:3}");
            model.setDefaultConnector(connector);

            for (int i = 0; i < model.getElements().size() - 1; i++) { //Crear conexiones menos en el último
                //Se crea unaconexión i = actual con i+1 = siguiente
                model.connect(createConnection(model.getElements().get(i).getEndPoints().get(0), model.getElements().get(i + 1).getEndPoints().get(1), null));

            }
        }
    }

    public void pintarEncontrado() {
        model = new DefaultDiagramModel();
        model.setMaxConnections(-1);
        if (listaPerros.getCabeza() != null) {

            Nodo ayudante = listaPerros.getCabeza();
            int posX = 2;
            int posY = 2;
            while (ayudante != null) {
                Element perroPintar = new Element(ayudante.getDato().getNombre(), posX + "em", posY + "em");
                //Entrar a la condicion si el numero del perro buscado es igual al que está seleccionado
                if (ayudante.getDato().getNumero() == perroEncontrado.getNumero()) {
                    perroPintar.setStyleClass("ui-diagram-success"); //Cambiar el estilo del elemento seleccionado
                }
                perroPintar.addEndPoint(new BlankEndPoint(EndPointAnchor.RIGHT));
                perroPintar.addEndPoint(new BlankEndPoint(EndPointAnchor.LEFT));
                model.addElement(perroPintar);
                ayudante = ayudante.getSiguiente();
                posX = posX + 5;
                posY = posY + 5;
            }
            FlowChartConnector connector = new FlowChartConnector();
            connector.setPaintStyle("{strokeStyle:'#092CB0',lineWidth:3}");
            model.setDefaultConnector(connector);
            for (int i = 0; i < model.getElements().size() - 1; i++) {
                model.connect(createConnection(model.getElements().get(i).getEndPoints().get(0), model.getElements().get(i + 1).getEndPoints().get(1), null));
            }
        }
    }

    public void pintarExtremos() {
        model = new DefaultDiagramModel();
        model.setMaxConnections(-1);
        if (listaPerros.getCabeza() != null) {
            Nodo ayudante = listaPerros.getCabeza();
            int posX = 2;
            int posY = 2;
            while (ayudante != null) {
                Element perroPintar = new Element(ayudante.getDato().getNombre(), posX + "em", posY + "em");
                //Sepinta el dato primero y ultimo 
                if (ayudante.getSiguiente() == null || ayudante == temp) {
                    perroPintar.setStyleClass("ui-diagram-success"); //Cambia el color de los elementos primero y ultimo
                }
                perroPintar.addEndPoint(new BlankEndPoint(EndPointAnchor.RIGHT));
                perroPintar.addEndPoint(new BlankEndPoint(EndPointAnchor.LEFT));
                model.addElement(perroPintar);
                ayudante = ayudante.getSiguiente();
                posX = posX + 5;
                posY = posY + 5;
            }
            FlowChartConnector connector = new FlowChartConnector();
            connector.setPaintStyle("{strokeStyle:'#092CB0',lineWidth:3}");
            model.setDefaultConnector(connector);
            for (int i = 0; i < model.getElements().size() - 1; i++) {
                model.connect(createConnection(model.getElements().get(i).getEndPoints().get(0), model.getElements().get(i + 1).getEndPoints().get(1), null));
               
            }
        }
    }

    public String irCrearPerro() {

        perroEncontrado = new Perro();
        return "crear";
    }

    public void guardarPerro() {

        switch (seleccionUbicacion) {
            case 1:
                listaPerros.adicionarNodoInicio(perroEncontrado);
                break;
            case 2:
                listaPerros.adicionarNodo(perroEncontrado);
                break;
            default:
                listaPerros.adicionarNodo(perroEncontrado);
        }
        //  listaPerros.adicionarNodo(perroEncontrado);
        perroEncontrado = new Perro();
        JsfUtil.addSuccessMessage("Se ha adicionado el perro a la lista");

    }

    public String irHome() {

        perroEncontrado = new Perro();
        inicializarModelo();
        return "home";
    }
}
