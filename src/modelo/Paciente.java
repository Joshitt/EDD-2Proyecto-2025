/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author otjos
 */
public class Paciente extends Datos implements Serializable
{

    private String sexo;
    private String status;
    private  LocalDate vigencia;

    public Paciente(String sexo, String status, LocalDate vigencia, String nombre)
    {
        super(nombre, "P");
        this.sexo = sexo;
        this.status = status;
        this.vigencia = vigencia;
    }

    public String getSexo()
    {
        return sexo;
    }

    public void setSexo(String sexo)
    {
        this.sexo = sexo;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
    

    @Override
    public String toString()
    {
        return super.toString() + "Sexo: " + sexo + "Status: " + status + "Vigencia: " + vigencia;
    }

    public LocalDate getVigencia()
    {
        return vigencia;
    }

    public void setVigencia(LocalDate vigencia)
    {
        this.vigencia = vigencia;
    }

}
