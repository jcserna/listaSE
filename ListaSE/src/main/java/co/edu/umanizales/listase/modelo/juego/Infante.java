/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umanizales.listase.modelo.juego;

/**
 *
 * @author camis
 */
public class Infante {
    private String nombre;
    private byte identificador;
    private boolean genero;

    public Infante() {
        
    }

    
    public Infante(String nombre, byte identificador, boolean genero) {
        this.nombre = nombre;
        this.identificador = identificador;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getIdentificador() {
        return identificador;
    }

    public void setIdentificador(byte identificador) {
        this.identificador = identificador;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Infante{" + "nombre=" + nombre + ", identificador=" + identificador + ", genero=" + genero + '}';
    }
    
    
    
}
