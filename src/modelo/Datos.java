/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.ManipulaArchivos;
import java.io.Serializable;

/**
 *
 * @author otjos
 */
public class Datos implements Serializable
{
    private static int contadorGeneral=ManipulaArchivos.cargarContador("contador.dat");

    public static int getContadorGeneral()
    {
        return contadorGeneral;
    }
    private final String clave;
    private final String nombre;

    public Datos(String nombre, String prefijo)
    {
        contadorGeneral++;
        this.clave = String.format("%s.%03d",prefijo,contadorGeneral);
        this.nombre = nombre;
    }
    
   
    /**
     * @return the clave
     */
    public String getClave()
    {
        return clave;
    }

    /**
     * @return the nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    @Override
    public String toString()
    {
        return clave + "-" + nombre;
    }
    
    
}
