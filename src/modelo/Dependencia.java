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
public class Dependencia extends Datos implements Serializable
{

    private String tipo;

    public Dependencia(String tipo, String nombre)
    {
        super(nombre, "D");
        this.tipo = tipo;
    }
    
    

    @Override
    public String toString()
    {
        return super.toString() + " [" + tipo + "]";
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

}
