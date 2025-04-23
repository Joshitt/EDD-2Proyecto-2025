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
public class Multilista implements Serializable
{

    private NodoM r;
    boolean b = false;

    public NodoM getR()
    {
        return r;
    }

    public void setR(NodoM r)
    {
        this.r = r;
    }

//    Este método inserta un nodo obj dentro de una lista en un nivel específico del arreglo s, que representa una jerarquía (por ejemplo, {"México", "Jalisco", "Guadalajara"}).
//
//obj: el nodo que quieres insertar.
//
//r: la raíz del nivel actual.
//
//s: arreglo con la jerarquía de niveles.
//
//nivel: el nivel actual donde estamos parados.
    //r -> La raiz general 
    public NodoM inserta(NodoM obj, NodoM r, String[] s, int nivel)
    {
        if (s == null || s.length == 0)
        {
            ListaDLCircularML l = new ListaDLCircularML();
            l.setR(r);
            l.inserta(obj);
            return l.getR();
        }
        //la longitud del arreglo -1 es el nivel deseado donde se va a insertar el obj
        if (s.length - 1 == nivel)//es el nivel al que quiero insertar(si ya llegue al nivel deseado,ahi se hace la insercion)
        {
            ListaDLCircularML l = new ListaDLCircularML();//tecnico
            l.setR(r);//tecnico recibe la r que va a modificar,la raiz de la lista a modificar
            l.inserta(obj);//inserta el obj en la lista previamente elegida
            b = true;
            return l.getR();
        } else
        {
            NodoM aux = busca(r, s[nivel]);//nivel es 0 siempre la primera vez,lo que me dara la longitud es el numero de recursiones 
            if (aux != null)
            {
                aux.setAbajo(inserta(obj, aux.getAbajo(), s, nivel + 1));
                if (b)
                {
                    obj.setArriba(aux);
                    b = false;
                }
            }
            return r;
        }
    }

    public String desp(NodoM r, String t)
    {
        String s = "";
        if (r != null)
        {
            NodoM aux = r.getSiguiente();
            do
            {
                s += t + aux.getEt() + "\n" + desp(aux.getAbajo(), t + "\t");
                aux = aux.getSiguiente();
            } while (aux != r.getSiguiente());
        }
        return s;
    }

    //r:NodoMNodo raíz del nivel actual
    //arr:NodoM[]:Arreglo de dos nodos: arr[0] será el nodo eliminado, arr[1] el nuevo inicio del nivel tras la eliminación
    //s String[]:Ruta jerárquica, ejemplo: { "UNAM", "ISW", "EDD" }
    //nivel:int	Nivel actual del arreglo s que se está evaluando
    public void elimina(NodoM r, NodoM[] arr, String[] s, int nivel)//inserta en cualquier nivel de la multilista
    {
        if (nivel == s.length - 1)
        {
            ListaDLCircularML l = new ListaDLCircularML();
            l.setR(r);
            arr[0] = l.elimina(s[nivel]);
            arr[1] = l.getR();
        } else
        {
            NodoM aux = busca(r, s[nivel]);
            if (aux != null)
            {
                elimina(aux.getAbajo(), arr, s, nivel + 1);
                aux.setAbajo(arr[1]);
            }
            arr[1] = r;
        }
    }

    public boolean eliminarRuta(String[] ruta)
    {
        NodoM[] arr = new NodoM[2];
        this.elimina(this.getR(), arr, ruta, 0);
        if (arr[0] != null)
        {
            System.out.println("Dato eliminado: " + arr[0].getEt());
            this.setR(arr[1]);
            return true;
        } else
        {
            System.out.println("No se encontro el nodo para eliminar.");
            return false;
        }
    }

    public String desplegar(NodoM r, String t)
    {
        String s = "";
        if (r != null)
        {
            NodoM aux = r.getSiguiente();
            do
            {
                if (aux.getArriba() != null)
                {
                    s += t + aux.getEt() + "(" + ((Datos) aux.getObj()).getClave() + ")-> " + aux.getArriba().getEt() + "\n";
                } else
                {
                    s += t + aux.getEt() + "(" + ((Datos) aux.getObj()).getClave() + ")" + "\n";
                }
                s += desplegar(aux.getAbajo(), t + "\t");
                aux = aux.getSiguiente();
            } while (aux != r.getSiguiente());
        }
        return s;
    }

    public NodoM busca(NodoM r, String s)
    {
        //para saber en que luegar voy a insertar ,suponiendo que voy a poner un estado 
        //necesito saber si esta el pais 
        ListaDLCircularML obj = new ListaDLCircularML();
        obj.setR(r);
        return obj.busca(s);
    }

    public NodoM busca2(NodoM nodoRaiz, int nivel, String[] ruta, String etq)
    {
        if (ruta.length - 1 == nivel)
        {
            NodoM nodo = buscaAux(nodoRaiz, etq);
            return nodo;
        } else
        {
            NodoM aux = buscaAux(nodoRaiz, ruta[nivel]);
            if (aux != null)
            {
                return busca2(aux.getAbajo(), nivel + 1, ruta, etq);
            }
        }
        return null;
    }

    public NodoM buscaAux(NodoM nodoRaiz, String etq)
    {
        if (nodoRaiz != null)
        {
            NodoM aux = nodoRaiz;
            do
            {
                if (aux.getEt().equalsIgnoreCase(etq))
                {
                    return aux;
                }
                aux = aux.getSiguiente();
            } while (aux != nodoRaiz);
        }
        return null;
    }

    public NodoM buscarRuta(NodoM r, String[] ruta, int nivel)
    {
        if (r == null || nivel >= ruta.length)
        {
            return r;
        }

        NodoM aux = buscaAux(r, ruta[nivel]);
        if (aux != null)
        {
            return buscarRuta(aux.getAbajo(), ruta, nivel + 1);
        }
        return null;
    }

}
