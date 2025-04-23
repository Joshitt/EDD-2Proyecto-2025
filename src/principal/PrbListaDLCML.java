package principal;
import modelo.ListaDLCircularML;
import modelo.NodoM;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author otjos
 */
public class PrbListaDLCML
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ListaDLCircularML listaDBCi = new ListaDLCircularML();

        NodoM n1 = new NodoM(1, "c");
        NodoM n2 = new NodoM(1, "e");
        NodoM n3 = new NodoM(1, "g");
        NodoM n4 = new NodoM(1, "h");
        NodoM n5 = new NodoM(1, "i");

        listaDBCi.inserta(n1);
        listaDBCi.inserta(n2);
        listaDBCi.inserta(n3);
        listaDBCi.inserta(n4);
        listaDBCi.inserta(n5);

        System.out.println(listaDBCi.despAdelante());
        System.out.println(listaDBCi.desplegarEA());
        
        listaDBCi.busca("a");
        listaDBCi.busca("j");
        listaDBCi.busca("c");
        listaDBCi.busca("i");
        listaDBCi.busca("d");
        listaDBCi.busca("f");

        NodoM n6 = new NodoM(1, "c");
        listaDBCi.inserta(n6);
        System.out.println("\n");
        System.out.println(listaDBCi.despAdelante());
        System.out.println(listaDBCi.desplegarEA());
        System.out.println("\n");

        System.out.println("Nodo a eliminar: " + listaDBCi.elimina("a"));
        System.out.println(listaDBCi.despAdelante());
        System.out.println(listaDBCi.desplegarEA());
        System.out.println("\n");

        System.out.println("Nodo a eliminar: " + listaDBCi.elimina("d"));
        System.out.println(listaDBCi.despAdelante());
        System.out.println(listaDBCi.desplegarEA());
        System.out.println("\n");

        System.out.println("Nodo a eliminar: " + listaDBCi.elimina("f"));
        System.out.println(listaDBCi.despAdelante());
        System.out.println(listaDBCi.desplegarEA());
        System.out.println("\n");

        System.out.println("Nodo a eliminar: " + listaDBCi.elimina("a"));
        System.out.println(listaDBCi.despAdelante());
        System.out.println(listaDBCi.desplegarEA());
        System.out.println("\n");

        System.out.println("Nodo a eliminar: " + listaDBCi.elimina("c"));
        System.out.println(listaDBCi.despAdelante());
        System.out.println(listaDBCi.desplegarEA());
        System.out.println("\n");

        System.out.println("Nodo a eliminar: " + listaDBCi.elimina("e"));
        System.out.println(listaDBCi.despAdelante());
        System.out.println(listaDBCi.desplegarEA());
        System.out.println("\n");

        System.out.println("Nodo a eliminar: " + listaDBCi.elimina("b"));
        System.out.println(listaDBCi.despAdelante());
        System.out.println(listaDBCi.desplegarEA());
        System.out.println("\n");

        System.out.println("Nodo a eliminar: " + listaDBCi.elimina("a"));
    }

}
