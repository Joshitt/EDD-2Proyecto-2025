package modelo;

import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author otjos
 */
public class NodoM<T> implements Serializable
{
    private T obj;
    private String et;
    private NodoM siguiente;
    private NodoM anterior;
    private NodoM arriba;
    private NodoM abajo;
   

    public NodoM(T obj, String et)
    {
        this.obj = obj;
        this.et = et;
    }

    /**
     * @return the obj
     */
    public T getObj()
    {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(T obj)
    {
        this.obj = obj;
    }

    /**
     * @return the et
     */
    public String getEt()
    {
        return et;
    }

    /**
     * @param et the et to set
     */
    public void setEt(String et)
    {
        this.et = et;
    }

    /**
     * @return the siguiente
     */
    public NodoM getSiguiente()
    {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoM siguiente)
    {
        this.siguiente = siguiente;
    }

    /**
     * @return the anterior
     */
    public NodoM getAnterior()
    {
        return anterior;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(NodoM anterior)
    {
        this.anterior = anterior;
    }

    /**
     * @return the arriba
     */
    public NodoM getArriba()
    {
        return arriba;
    }

    /**
     * @param arriba the arriba to set
     */
    public void setArriba(NodoM arriba)
    {
        this.arriba = arriba;
    }

    /**
     * @return the abajo
     */
    public NodoM getAbajo()
    {
        return abajo;
    }

    /**
     * @param abajo the abajo to set
     */
    public void setAbajo(NodoM abajo)
    {
        this.abajo = abajo;
    }
}
