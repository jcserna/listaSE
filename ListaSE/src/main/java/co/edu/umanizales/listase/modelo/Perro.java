/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umanizales.listase.modelo;

import java.io.Serializable;

/**
 *
 * @author Camilo
 */
public class Perro implements Serializable
{
    private String nombre;
    private byte numero;
    private byte edad;
    private String genero;
    
    public Perro()
    {
    }

    public Perro(String nombre, byte numero, byte edad, String genero)
    {
        this.nombre = nombre;
        this.numero = numero;
        this.edad = edad;
        this.genero = genero;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public byte getNumero()
    {
        return numero;
    }

    public void setNumero(byte numero)
    {
        this.numero = numero;
    }

    public byte getEdad()
    {
        return edad;
    }

    public void setEdad(byte edad)
    {
        this.edad = edad;
    }

    public String getGenero()
    {
        return genero;
    }

    public void setGenero(String genero)
    {
        this.genero = genero;
    }
    
//    @Override
//    public String toString()
//    {
//        return "Perro{" + "nombre=" + nombre + ", numero=" + numero + ", edad=" + edad + '}';
//    }
//    

    @Override
    public String toString()
    {
        return "Perro{" + "nombre=" + nombre + ", numero=" + numero + ", edad=" + edad + ", genero=" + genero + '}';
    }
    
}
