/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paseoperros.controlador.juego;

import co.edu.umanizales.listase.modelo.juego.ListaDE;
import co.edu.umanizales.listase.modelo.juego.Infante;
import co.edu.umanizales.listase.modelo.juego.ListaCircularDE;
import co.edu.umanizales.listase.modelo.juego.NodoDE;
import co.edu.umanizales.listase.modelo.juego.Oportunidades;
import com.paseoperros.controlador.JsfUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
@Named(value = "controladorTingoBean")
@SessionScoped
public class ControladorTingoBean implements Serializable {

    private Infante infanteGuardar;
    private Infante infanteMostrar; // XXXXX
    private Oportunidades infanteReingresar;
    private ArrayList<Infante> listadoInfantes;
    private ListaCircularDE tingoTango;
    private boolean estadoJuego;
//    private int cantidadInfantes = listadoInfantes.size(); //XXXXX
    private int numeroOportunidades;
    private int posicionIngreso;
    private Infante ayudante; //XXXX
//    private Hashtable tablaOportunidades;
    private byte cantidadJugando;
    private List<Oportunidades> listaOportunidades;
    private int[] arregloAleatorio;
    private DefaultDiagramModel model;
    private String botonJugar;
    private boolean estadoCiclo;
    private String colorBoton;
    private NodoDE ayudanteColor;
    private NodoDE temp;
    private boolean sentido;
    private String infanteOportunidades;
    private int cantidadOportunidades;
    private int nuevasOportunidades;
    private ListaDE listaReingresar;
    private boolean generoReingreso;

    /**
     * Creates a new instance of ControladorTingoBean
     */
    public ControladorTingoBean() {

    }

    @PostConstruct
    private void iniciar() {
        listadoInfantes = new ArrayList<>();
        listadoInfantes.add(new Infante("Juan", (byte) 1, true));
        listadoInfantes.add(new Infante("Ana", (byte) 2, false));
        listadoInfantes.add(new Infante("Sebastián", (byte) 3, true));
        listadoInfantes.add(new Infante("Laura", (byte) 4, false));
        listadoInfantes.add(new Infante("a", (byte) 5, true));

        listaOportunidades = new ArrayList<>();
        tingoTango = new ListaCircularDE();
        infanteGuardar = new Infante();
        botonJugar = "Jugar";
        estadoCiclo = false;
        colorBoton = "blue";
        listaReingresar = new ListaDE();
        temp = listaReingresar.getCabeza();
        ayudanteColor = tingoTango.getCabeza();
    }

    public Infante getInfanteGuardar() {
        return infanteGuardar;
    }

    public void setInfanteGuardar(Infante infanteGuardar) {
        this.infanteGuardar = infanteGuardar;
    }

    public Infante getInfanteMostrar() {
        return infanteMostrar;
    }

    public void setInfanteMostrar(Infante infanteMostrar) {
        this.infanteMostrar = infanteMostrar;
    }

    public ArrayList<Infante> getListadoInfantes() {
        return listadoInfantes;
    }

    public void setListadoInfantes(ArrayList<Infante> listadoInfantes) {
        this.listadoInfantes = listadoInfantes;
    }

    public String getBotonJugar() {
        return botonJugar;
    }

    public void setBotonJugar(String botonJugar) {
        this.botonJugar = botonJugar;
    }

    public boolean isEstadoCiclo() {
        return estadoCiclo;
    }

    public void setEstadoCiclo(boolean estadoCiclo) {
        this.estadoCiclo = estadoCiclo;
    }

    public ListaCircularDE getTingoTango() {
        return tingoTango;
    }

    public void setTingoTango(ListaCircularDE tingoTango) {
        this.tingoTango = tingoTango;
    }

    public boolean isEstadoJuego() {
        return estadoJuego;
    }

    public void setEstadoJuego(boolean estadoJuego) {
        this.estadoJuego = estadoJuego;
    }

    public int getNumeroOportunidades() {
        return numeroOportunidades;
    }

    public void setNumeroOportunidades(int numeroOportunidades) {
        this.numeroOportunidades = numeroOportunidades;
    }

    public int getPosicionIngreso() {
        return posicionIngreso;
    }

    public void setPosicionIngreso(int posicionIngreso) {
        this.posicionIngreso = posicionIngreso;
    }

    public Infante getAyudante() {
        return ayudante;
    }

    public void setAyudante(Infante ayudante) {
        this.ayudante = ayudante;
    }

    public byte getCantidadJugando() {
        return cantidadJugando;
    }

    public void setCantidadJugando(byte cantidadJugando) {
        this.cantidadJugando = cantidadJugando;
    }

    public List<Oportunidades> getListaOportunidades() {
        return listaOportunidades;
    }

    public void setListaOportunidades(List<Oportunidades> listaOportunidades) {
        this.listaOportunidades = listaOportunidades;
    }

    public int[] getArregloAleatorio() {
        return arregloAleatorio;
    }

    public void setArregloAleatorio(int[] arregloAleatorio) {
        this.arregloAleatorio = arregloAleatorio;
    }

    public DiagramModel getModel() {
        return model;
    }

    public String getColorBoton() {
        return colorBoton;
    }

    public void setColorBoton(String colorBoton) {
        this.colorBoton = colorBoton;
    }

    public NodoDE getAyudanteColor() {
        return ayudanteColor;
    }

    public void setAyudanteColor(NodoDE ayudanteColor) {
        this.ayudanteColor = ayudanteColor;
    }

    public NodoDE getTemp() {
        return temp;
    }

    public void setTemp(NodoDE temp) {
        this.temp = temp;
    }

    public boolean isSentido() {
        return sentido;
    }

    public void setSentido(boolean sentido) {
        this.sentido = sentido;
    }

    public String getInfanteOportunidades() {
        return infanteOportunidades;
    }

    public Oportunidades getInfanteReingresar() {
        return infanteReingresar;
    }

    public void setInfanteReingresar(Oportunidades infanteReingresar) {
        this.infanteReingresar = infanteReingresar;
    }

    public void setInfanteOportunidades(String infanteOportunidades) {
        this.infanteOportunidades = infanteOportunidades;
    }

    public int getCantidadOportunidades() {
        return cantidadOportunidades;
    }

    public void setCantidadOportunidades(int cantidadOportunidades) {
        this.cantidadOportunidades = cantidadOportunidades;
    }

    public int getNuevasOportunidades() {
        return nuevasOportunidades;
    }

    public void setNuevasOportunidades(int nuevasOportunidades) {
        this.nuevasOportunidades = nuevasOportunidades;
    }

    public ListaDE getListaReingresar() {
        return listaReingresar;
    }

    public boolean isGeneroReingreso() {
        return generoReingreso;
    }

    public void setGeneroReingreso(boolean generoReingreso) {
        this.generoReingreso = generoReingreso;
    }

    public void guardarInfante() {
        boolean existenciaId = false;

        for (Infante infante : listadoInfantes) {
            if (infante.getIdentificador() == infanteGuardar.getIdentificador()) {
                existenciaId = true;
            }
        }

        if (existenciaId == true) {
            JsfUtil.addErrorMessage("El identificador ya existe");

        } else {
            listadoInfantes.add(infanteGuardar);
            JsfUtil.addSuccessMessage("Se ha agregado el infante " + infanteGuardar.getNombre());
            infanteGuardar = new Infante();

        }

    }

    public void participarEnJuego() {
        tingoTango = new ListaCircularDE();
        listaOportunidades = new ArrayList<>();

        if (cantidadJugando > listadoInfantes.size()) {
            JsfUtil.addErrorMessage("No existen suficientes jugadores");
        } else {

            arregloAleatorio = new int[cantidadJugando];
            int i = 0;

            int rango = listadoInfantes.size();
            arregloAleatorio[i] = (int) (Math.random() * rango);

            for (i = 1; i < cantidadJugando; i++) {
                arregloAleatorio[i] = (int) (Math.random() * rango);
                for (int j = 0; j < i; j++) {
                    if (arregloAleatorio[i] == arregloAleatorio[j]) {
                        i--;
                    }

                }
            }
            for (int k = 0; k < cantidadJugando; k++) {

                ayudante = listadoInfantes.get(arregloAleatorio[k]);
                tingoTango.adicionarListaCircularDE(ayudante);
                adicionarTablaOportunidades(ayudante);

            }
        }

        inicializarModelo();
        ayudanteColor = tingoTango.getCabeza();

    }

    public void reingresarInfante() {

        for (Oportunidades inf : listaOportunidades) {
            if (infanteMostrar.equals(inf.getInfante()) && inf.getOportunidades() == 0) {
                infanteReingresar = inf;
                inf.setOportunidades(nuevasOportunidades);
                tingoTango.agregarNodoDE(posicionIngreso, infanteReingresar.getInfante());
                cantidadJugando++;
                listaReingresar.eliminarActualDE(infanteReingresar.getInfante().getIdentificador());
                inicializarModelo();
                temp = listaReingresar.getCabeza();
            }
        }
    }

    public void adicionarTablaOportunidades(Infante infante) {
        listaOportunidades.add(new Oportunidades(infante, numeroOportunidades));
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

        FlowChartConnector connector = new FlowChartConnector();
//        connector.setPaintStyle("{strokeStyle:'#092CB0',lineWidth:3}");
//        model.setDefaultConnector(connector);

        if (tingoTango.getCabeza() != null) {

            NodoDE ayudanteModel = tingoTango.getCabeza(); //ayudante, y ubicarlo en el primer elemento
            //En qué posicion se encuentran los elementos 
            int posX = 5;
            int posY = 5;
            if (ayudanteModel == tingoTango.getCabeza()) {
                Element infantePintar = new Element(ayudanteModel.getDato().getNombre(), posX + "em", posY + "em");
                if (ayudanteModel.equals(ayudanteColor)) {
                    infantePintar.setStyleClass("ui-diagram-success");
                }
                    infantePintar.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_RIGHT)); //Adicionar punto para la conexión (Derecha para la salida)
                infantePintar.addEndPoint(new BlankEndPoint(EndPointAnchor.TOP_RIGHT)); //Adicionar punto para la conexión (izquierda para la llegada)
                infantePintar.addEndPoint(new BlankEndPoint(EndPointAnchor.TOP_LEFT)); //Adicionar punto para la conexión (izquierda para la salida hacia atras)
                infantePintar.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_LEFT)); //Adicionar punto para la conexión (izquierda para la llegada)
                model.addElement(infantePintar);
                posX = posX + 7;
                posY = posY + 7;
                ayudanteModel = ayudanteModel.getSiguiente();
                
                //        connector.setPaintStyle("{strokeStyle:'#092CB0',lineWidth:3}");
//       model.setDefaultConnector(connector);
            }
            while (ayudanteModel != tingoTango.getCabeza()) {

                Element infantePintar = new Element(ayudanteModel.getDato().getNombre(), posX + "em", posY + "em");
                if (ayudanteModel.equals(ayudanteColor)) {
                    infantePintar.setStyleClass("ui-diagram-success");
                }
                infantePintar.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_RIGHT)); //Adicionar punto para la conexión (Derecha para la salida)
                infantePintar.addEndPoint(new BlankEndPoint(EndPointAnchor.TOP_RIGHT)); //Adicionar punto para la conexión (izquierda para la llegada)
                infantePintar.addEndPoint(new BlankEndPoint(EndPointAnchor.TOP_LEFT)); //Adicionar punto para la conexión (izquierda para la salida hacia atras)
                infantePintar.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_LEFT)); //Adicionar punto para la conexión (izquierda para la llegada)

                model.addElement(infantePintar);
                ayudanteModel = ayudanteModel.getSiguiente();
                posX = posX + 7;
                posY = posY + 7;
            }

        }

for (int i = 0; i <= model.getElements().size() - 1; i++) {
                if (i == model.getElements().size() - 1) {
                    model.connect(createConnection(model.getElements().get(i).getEndPoints().get(0),
                            model.getElements().get(0).getEndPoints().get(1), null));
                    model.connect(createConnection(model.getElements().get(0).getEndPoints().get(2),
                            model.getElements().get(i).getEndPoints().get(3), null));
                } else {
                    model.connect(createConnection(model.getElements().get(i).getEndPoints().get(0),
                            model.getElements().get(i + 1).getEndPoints().get(1), null));
                    model.connect(createConnection(model.getElements().get(i + 1).getEndPoints().get(2),
                            model.getElements().get(i).getEndPoints().get(3), null));
                }
            }
    }

    public void controlarCiclo() {
        botonJugar = "Jugar";
        colorBoton = "blue";
        estadoCiclo = !estadoCiclo;
        if (estadoCiclo) {
            botonJugar = "Parar";
            colorBoton = "red";

        }
        retirarPerdedor();
        inicializarModelo();
    }

    public void iniciarJuego() {
        inicializarModelo();
//        for (int i = 0; i < cantidadJugando - 1; i++) {
        if (sentido == true) {
            ayudanteColor = ayudanteColor.getSiguiente();
            inicializarModelo();
        } else if (sentido == false) {
            ayudanteColor = ayudanteColor.getAnterior();
            inicializarModelo();

        }
//        }
    }

    public String irTingoTango() {
        infanteGuardar = new Infante();
        return "juegotingotango";
    }

    public String irCrearInfante() {
        infanteGuardar = new Infante();
        return "crear";
    }

    public void retirarPerdedor() {

        if (estadoCiclo == false) {
            for (Oportunidades opor : listaOportunidades) {
                if (opor.getInfante() == ayudanteColor.getDato()) {
                    opor.setOportunidades(opor.getOportunidades() - 1);
                    if (opor.getOportunidades() == 0) {
                        listaReingresar.adicionarNodoDE(opor.getInfante());
                        tingoTango.eliminarEnSitio(ayudanteColor.getDato());
                        infanteMostrar = opor.getInfante();
                        cantidadJugando--;
                        inicializarModelo();
                    }
                }
            }
//                JsfUtil.addSuccessMessage("el ganador es"+ ayudanteColor.getDato().getNombre());

        }
        temp = listaReingresar.getCabeza();

//    }
    }

    public void irSiguiente() {

        if (temp.getSiguiente() != null) {
            temp = temp.getSiguiente();
            infanteMostrar = temp.getDato();
        }

    }

    public void irAnterior() {

        if (temp.getAnterior() != null) {
            temp = temp.getAnterior();
            infanteMostrar = temp.getDato();
        }
    }

    public void reingresarPorGenero() {

        if (generoReingreso == true) {
            for (Oportunidades infReingresar : listaOportunidades) {
                if (infReingresar.getOportunidades() == 0 && infReingresar.getInfante().isGenero() == true) {
                    infReingresar.setOportunidades(nuevasOportunidades);
                    tingoTango.adicionarListaCircularDEInicio(infReingresar.getInfante());
                    listaReingresar.eliminarActualDE(infReingresar.getInfante().getIdentificador());
                    inicializarModelo();
                }
            }
        } else if (generoReingreso == false) {
            for (Oportunidades infReingresar : listaOportunidades) {
                if (infReingresar.getOportunidades() == 0 && infReingresar.getInfante().isGenero() == false) {
                    infReingresar.setOportunidades(nuevasOportunidades);
                    tingoTango.adicionarListaCircularDEInicio(infReingresar.getInfante());
                    listaReingresar.eliminarActualDE(infReingresar.getInfante().getIdentificador());
                    inicializarModelo();
                }
            }

        }
        temp = listaReingresar.getCabeza();

    }

    public void retirarPorGenero() {
        if (!listaOportunidades.isEmpty()) {
            if (revisarGeneros() == true) {
                if (generoReingreso == true) {
                    for (Oportunidades infRetirar : listaOportunidades) {
                        if (infRetirar.getOportunidades() != 0 && infRetirar.getInfante().isGenero() == true) {
                            infRetirar.setOportunidades(0);
                            tingoTango.eliminarEnSitio(infRetirar.getInfante());
                            listaReingresar.adicionarNodoDE(infRetirar.getInfante());
                            inicializarModelo();
                        }
                    }
                } else if (generoReingreso == false) {
                    for (Oportunidades infRetirar : listaOportunidades) {
                        if (infRetirar.getOportunidades() != 0 && infRetirar.getInfante().isGenero() == false) {
                            infRetirar.setOportunidades(0);
                            tingoTango.eliminarEnSitio(infRetirar.getInfante());
                            listaReingresar.adicionarNodoDE(infRetirar.getInfante());
                            inicializarModelo();
                        }
                    }

                }
            }
        } else if (listaOportunidades.isEmpty()) {
            JsfUtil.addErrorMessage("La lista de oportunidades está vacía");
        }
        {

        }

        temp = listaReingresar.getCabeza();
    }

    public boolean revisarGeneros() {
        boolean posible = false;
        if (generoReingreso == true) {
            for (Oportunidades revisor : listaOportunidades) {
                if (revisor.getInfante().isGenero() == false && revisor.getOportunidades() != 0) {
                    posible = true;
                }
            }

        } else if (generoReingreso == false) {
            for (Oportunidades revisor : listaOportunidades) {
                if (revisor.getInfante().isGenero() == true && revisor.getOportunidades() != 0) {
                    posible = true;
                }
            }

        }
        if (posible == false) {
            JsfUtil.addErrorMessage("La lista no puede quedar vacía");
        }
        return posible;
    }

}
