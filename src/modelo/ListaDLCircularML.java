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
public class ListaDLCircularML<T> implements Serializable
{

    private NodoM r = null;

    public NodoM getR()
    {
        return r;
    }

    public void setR(NodoM r)
    {
        this.r = r;
    }

    public void inserta(NodoM n)
    {
        if (n != null)
        {
            if (r != null)
            {
                if (n.getEt().compareTo(r.getSiguiente().getEt()) < 0 || n.getEt().compareTo(r.getEt()) > 0)
                {
                    n.setSiguiente(r.getSiguiente());
                    n.setAnterior(r);
                    r.setSiguiente(n);
                    n.getSiguiente().setAnterior(n);
                    if (n.getEt().compareTo(r.getEt()) > 0)
                    {
                        r = r.getSiguiente();
                    }
                } else
                {
                    NodoM aux = r.getSiguiente();
                    while (aux.getSiguiente() != r.getSiguiente())
                    {
                        if (aux.getSiguiente().getEt().compareTo(n.getEt()) > 0)
                        {
                            n.setSiguiente(aux.getSiguiente());
                            n.setAnterior(aux);
                            aux.setSiguiente(n);
                            n.getSiguiente().setAnterior(n);
                            break;
                        } else
                        {
                            aux = aux.getSiguiente();
                        }
                    }
                }
            } else
            {
                r = n;
                r.setSiguiente(r);
                r.setAnterior(r);
            }

        } else
        {
            System.out.println("No se puede insertar");
        }
    }

    public NodoM elimina(String et)
    {
        NodoM elimina = null;
        if (r != null)
        {
            if (et.compareTo(r.getSiguiente().getEt()) >= 0 && et.compareTo(r.getEt()) <= 0)
            {
                if (r.getSiguiente().getEt().equals(et))
                {
                    elimina = r.getSiguiente();
                    r.setSiguiente(elimina.getSiguiente());
                    elimina.getSiguiente().setAnterior(r);
                    elimina.setSiguiente(null);
                    elimina.setAnterior(null);
                    if (r == elimina)
                    {
                        r = null;
                    }
                } else
                {
                    NodoM aux = r.getSiguiente();
                    boolean band = true;
                    do
                    {
                        if (aux.getSiguiente().getEt().equals(et))
                        {
                            elimina = aux.getSiguiente();
                            aux.setSiguiente(elimina.getSiguiente());
                            elimina.getSiguiente().setAnterior(aux);
                            if (r == elimina)
                            {
                                r = aux;
                            }
                            elimina.setAnterior(null);
                            elimina.setSiguiente(null);
                            band = false;
                        } else
                        {
                            aux = aux.getSiguiente();
                            if (et.compareTo(aux.getEt()) < 0)
                            {
                                System.out.println("ya no esta: " + et);
                                band = false;
                            }
                        }
                    } while (band);
                }
            } else
            {
                System.out.println("No se encuentra el elemento: " + et);
            }
        } else
        {
            System.out.println("lista vacia");
            return null;
        }
        return elimina;
    }

    public String despAdelante()
    {
        String s = " ";
        if (r != null)
        {
            NodoM<T> aux = r.getSiguiente();
            do
            {
                s += aux.getEt() + "\t";
                aux = aux.getSiguiente();
            } while (aux != r.getSiguiente());
        }
        return s;
    }

    public String desplegarEA()
    {
        String s = "";
        if (r != null)
        {
            NodoM<T> aux = r; // Iniciamos desde el último nodo
            do
            {
                s += aux.getEt() + "\t";
                aux = aux.getAnterior(); // Nos movemos hacia atrás
            } while (aux != r); // Se asegura de recorrer todo en sentido contrario
        }
        return s;
    }

    public NodoM busca(String et)
    {

        if (r != null)
        {
            NodoM aux = r.getSiguiente();
            if (et.compareTo(r.getSiguiente().getEt()) < 0 || et.compareTo(r.getEt()) > 0)
            {
                System.out.println("No existe el dato: " + et);
                return null;
            } else
            {
                if (aux.getEt().equals(et))
                {
                    //System.out.println("se encontro: " + et);
                    return aux;
                } else
                {
                    if (aux.getAnterior().getEt().equals(et))
                    {
                        aux=aux.getAnterior(); 
                        return aux;
                    } else
                    {
                        do
                        {
                            if (aux.getSiguiente().getEt().equals(et))
                            {
                                aux = aux.getSiguiente();
                                return aux;
                            } else
                            {
                                aux = aux.getSiguiente();
                                if (aux.getSiguiente().getEt().compareTo(et) > 0
                                        || aux.getSiguiente().getEt().equals(r.getEt()))
                                {
                                    System.out.println("el siguiente valor es mayor(no esta)");
                                    return null;
                                }
                            }
                        } while (aux != r);
                    }
                    return aux;
                }
            }
        } else
        {
            System.out.println("Lista vacia ");
            return null;
        }
    }
}
