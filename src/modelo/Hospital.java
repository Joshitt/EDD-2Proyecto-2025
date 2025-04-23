/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author otjos
 */
public class Hospital extends Datos implements Serializable
{

    private String nivel;
    private String direccion;

    public Hospital(String nivel, String direccion, String nombre)
    {
        super(nombre, "H");
        this.nivel = nivel;
        this.direccion = direccion;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public String getNivel()
    {
        return nivel;
    }

    public void setNivel(String nivel)
    {
        this.nivel = nivel;
    }

    @Override
    public String toString()
    {
        return super.toString() + " [Nivel: " + nivel + "]";
    }

}
