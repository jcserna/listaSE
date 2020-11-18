/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umanizales.listase.modelo.juego;

import java.io.Serializable;

/**
 *
 * @author camis
 */
public class Oportunidades implements Serializable{
    
    private Infante infante;
    private int oportunidades;

    public Oportunidades() {
    }

    public Oportunidades(Infante infante, int oportunidades) {
        this.infante = infante;
        this.oportunidades = oportunidades;
    }

    public Infante getInfante() {
        return infante;
    }

    public void setInfante(Infante infante) {
        this.infante = infante;
    }

    public int getOportunidades() {
        return oportunidades;
    }

    public void setOportunidades(int oportunidades) {
        this.oportunidades = oportunidades;
    }
    
    
        
}
