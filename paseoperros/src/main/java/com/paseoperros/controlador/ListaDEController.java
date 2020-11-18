/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paseoperros.controlador;

import co.edu.umanizales.listase.modelo.ListaDE;
import co.edu.umanizales.listase.modelo.ListaSE;
import co.edu.umanizales.listase.modelo.Nodo;
import co.edu.umanizales.listase.modelo.NodoDE;
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
 * @author camis
 */
@Named(value = "listaDEController")
@SessionScoped
public class ListaDEController implements Serializable {

    private ListaDE listaPerrosDE;
    private Perro perroMostrar;
    private NodoDE temp;
    private byte numero;
    private Perro perroEncontrado;
    private DefaultDiagramModel model;
    private int seleccionUbicacion1 = 0;
    private int seleccionUbicacion2 = 0;
    private String genero;

    /**
     * Creates a new instance of ListaDEController
     */
    public ListaDEController() {
    }

    @PostConstruct
    private void iniciar() {
        listaPerrosDE = new ListaDE();
        // Conectaría a un archivo plano o a una base de datos para llenar la lista de perros
        listaPerrosDE.adicionarNodoDE(new Perro("Pastor", (byte) 1, (byte) 3, "macho"));
        listaPerrosDE.adicionarNodoDE(new Perro("Lulú", (byte) 2, (byte) 4, "hembra"));
        listaPerrosDE.adicionarNodoDE(new Perro("Firulais", (byte) 3, (byte) 6, "macho"));
        listaPerrosDE.adicionarAlInicio(new Perro("Rocky", (byte) 4, (byte) 5, "macho"));
        perroMostrar = listaPerrosDE.getCabeza().getDato();
        temp = listaPerrosDE.getCabeza();

        inicializarModelo();
    }

    public NodoDE getTemp() {
        return temp;
    }

    public void setTemp(NodoDE temp) {
        this.temp = temp;
    }

    public Perro getPerroMostrar() {
        return perroMostrar;
    }

    public void setPerroMostrar(Perro perroMostrar) {
        this.perroMostrar = perroMostrar;
    }

    public ListaDE getListaPerrosDE() {
        return listaPerrosDE;
    }

    public void setListaPerrosDE(ListaDE listaPerrosDE) {
        this.listaPerrosDE = listaPerrosDE;
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

    public int getSeleccionUbicacion1() {
        return seleccionUbicacion1;
    }

    public void setSeleccionUbicacion1(int seleccionUbicacion1) {
        this.seleccionUbicacion1 = seleccionUbicacion1;
    }

    public int getSeleccionUbicacion2() {
        return seleccionUbicacion2;
    }

    public void setSeleccionUbicacion2(int seleccionUbicacion2) {
        this.seleccionUbicacion2 = seleccionUbicacion2;
    }

    public void irSiguiente() {
        //if(temp.getSiguiente()!=null)
        //{
        temp = temp.getSiguiente();
        perroMostrar = temp.getDato();
        //}
        inicializarModelo();
    }

    public void irAnterior() {
        //if(temp.getSiguiente()!=null)
        //{
        temp = temp.getAnterior();
        perroMostrar = temp.getDato();
        //}
        inicializarModelo();
    }

    public void irPrimero() {
        temp = listaPerrosDE.getCabeza();
        perroMostrar = temp.getDato();
        inicializarModelo();
    }

    public void irUltimo() {

        temp = listaPerrosDE.getCabeza();
        while (temp.getSiguiente() != null) {
            temp = temp.getSiguiente();
        }
        /// Parado en el último nodo
        perroMostrar = temp.getDato();
        inicializarModelo();
    }

    public void invertir() {
        listaPerrosDE.invertirDE();
        irPrimero();
        
        inicializarModelo();
    }

    public void intercambiar() {
        listaPerrosDE.intercambiarPosiciones(seleccionUbicacion1, seleccionUbicacion2);
        irPrimero();
       inicializarModelo();
        pintarIntercambio();

    }

    public int getSeleccionUbicacion() {
        return seleccionUbicacion1;
    }

    public void setSeleccionUbicacion(int seleccionUbicacion) {
        this.seleccionUbicacion1 = seleccionUbicacion;
    }

    public void eliminar(byte numero) {

        if (temp.getSiguiente() != null) {
            listaPerrosDE.eliminarActualDE(numero);
            irPrimero();
            inicializarModelo();
        } else {
            listaPerrosDE.eliminarActualDE(numero);
            perroMostrar = new Perro();
            inicializarModelo();

        }
    }

    public void encontrarPerro() {

        perroEncontrado = listaPerrosDE.encontrarPosicion(numero);
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
        listaPerrosDE.filtrarGenero(this.genero);
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
        if (listaPerrosDE.getCabeza() != null) {

            NodoDE ayudante = listaPerrosDE.getCabeza(); //ayudante, y ubicarlo en el primer elemento
            //En qué posicion se encuentran los elementos 
            int posX = 2;
            int posY = 2;

            while (ayudante != null) {
                //"em" unidad de medida para usar proporsiones de la pantalla para usar el responsive
                Element perroPintar = new Element(ayudante.getDato().getNombre(), posX + "em", posY + "em");

                perroPintar.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_RIGHT)); //Adicionar punto para la conexión (Derecha para la salida)
                perroPintar.addEndPoint(new BlankEndPoint(EndPointAnchor.TOP_RIGHT)); //Adicionar punto para la conexión (izquierda para la llegada)
                perroPintar.addEndPoint(new BlankEndPoint(EndPointAnchor.TOP_LEFT)); //Adicionar punto para la conexión (izquierda para la salida hacia atras)
                perroPintar.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_LEFT)); //Adicionar punto para la conexión (izquierda para la llegada)

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
                model.connect(createConnection(model.getElements().get(i + 1).getEndPoints().get(2), model.getElements().get(i).getEndPoints().get(3), null));

            }
        }
    }

    public void pintarEncontrado() {
        model = new DefaultDiagramModel();
        model.setMaxConnections(-1);
        if (listaPerrosDE.getCabeza() != null) {

            NodoDE ayudante = listaPerrosDE.getCabeza();
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

    public void pintarIntercambio() {

        model = new DefaultDiagramModel();
        model.setMaxConnections(-1);
        if (listaPerrosDE.getCabeza() != null) {
            NodoDE ayudante = listaPerrosDE.getCabeza();
            NodoDE ayudante1 = listaPerrosDE.getCabeza();
            int contador = 0;
            int contador1 = 0;

            int posX = 2;
            int posY = 2;
            while (ayudante != null) {
                Element perroPintar = new Element(ayudante.getDato().getNombre(), posX + "em", posY + "em");
            
                if (contador == seleccionUbicacion1-1 && ayudante == temp) {
                    perroPintar.setStyleClass("ui-diagram-success");                 
                }
                 if (contador1 == seleccionUbicacion2-1 && ayudante1 == temp) {
                        perroPintar.setStyleClass("ui-diagram-success");
                    }
                perroPintar.addEndPoint(new BlankEndPoint(EndPointAnchor.RIGHT));
                perroPintar.addEndPoint(new BlankEndPoint(EndPointAnchor.LEFT));
                model.addElement(perroPintar);
                ayudante = ayudante.getSiguiente();
                ayudante1 = ayudante1.getSiguiente();
                contador++;
                contador1++;
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
        return "crearDE";
    }

    public void guardarPerro() {

        switch (seleccionUbicacion1) {
            case 1:
                listaPerrosDE.adicionarAlInicio(perroEncontrado);
                break;
            case 2:
                listaPerrosDE.adicionarNodoDE(perroEncontrado);
                break;
            default:
                listaPerrosDE.adicionarNodoDE(perroEncontrado);
        }
        //  listaPerros.adicionarNodo(perroEncontrado);
        perroEncontrado = new Perro();
        JsfUtil.addSuccessMessage("Se ha adicionado el perro a la lista DE");

    }

    public String irHome() {

        perroEncontrado = new Perro();
        inicializarModelo();
        return "home";
    }

    public String irListaDE() {

        perroEncontrado = new Perro();
        inicializarModelo();
        return "listade";
    }
}
