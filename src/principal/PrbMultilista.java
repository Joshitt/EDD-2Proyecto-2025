package principal;
import modelo.Multilista;
import modelo.NodoM;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author otjos
 */
public class PrbMultilista
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        NodoM n1 = new NodoM("UNAM", "UNAM");
        NodoM n2 = new NodoM("UDG", "UDG");
        NodoM n3 = new NodoM("UAEM", "UAEM");

        NodoM n4 = new NodoM("DER", "DER");
        NodoM n5 = new NodoM("MED", "MED");
        NodoM n6 = new NodoM("FIL", "FIL");

        NodoM n7 = new NodoM("CON", "CON");
        NodoM n8 = new NodoM("CHE", "CHE");
        NodoM n9 = new NodoM("ODO", "ODO");

        NodoM n10 = new NodoM("ISW", "ISW");
        NodoM n11 = new NodoM("IPI", "IPI");
        NodoM n12 = new NodoM("IPL", "IPL");

        NodoM n13 = new NodoM("EDD", "EDD");
        NodoM n14 = new NodoM("PRG", "PRG");
        Multilista m = new Multilista();

        String s[] =
        {
            "UNAM"
        };
        m.setR(m.inserta(n1, m.getR(), s, 0));
        m.setR(m.inserta(n2, m.getR(), s, 0));
        m.setR(m.inserta(n3, m.getR(), s, 0));

        s = new String[2];
        s[0] = "UNAM";
        m.setR(m.inserta(n4, m.getR(), s, 0));
        m.setR(m.inserta(n5, m.getR(), s, 0));
        m.setR(m.inserta(n6, m.getR(), s, 0));
        s[0] = "UDG";
        m.setR(m.inserta(n7, m.getR(), s, 0));
        m.setR(m.inserta(n8, m.getR(), s, 0));
        m.setR(m.inserta(n9, m.getR(), s, 0));
        s[0] = "UAEM";
        m.setR(m.inserta(n10, m.getR(), s, 0));
        m.setR(m.inserta(n11, m.getR(), s, 0));
        m.setR(m.inserta(n12, m.getR(), s, 0));

        s = new String[3];
        s[0] = "UAEM";
        s[1] = "ISW";
        m.setR(m.inserta(n13, m.getR(), s, 0));
        m.setR(m.inserta(n14, m.getR(), s, 0));

        //System.out.println(m.desp(m.getR(), ""));
        System.out.println(m.desplegar(m.getR(), ""));
        
        /*
        String s4[] =
        {
            "UAEM", "ISW","PRG"
        };
        NodoM arr[] = new NodoM[2];
        m.elimina(m.getR(), arr, s4, 0);
        if (arr[0] != null)
        {
            System.out.println("Dato eliminado:" + arr[0].getEt());
        }
        m.setR(arr[1]);
        */
        String s4[]={"UAEM","ISW","EDD"};
        m.eliminarRuta(s4);
        System.out.println(m.desplegar(m.getR(), ""));
        
        String s5[]={"UAEM","ISW","EDD"};
        m.eliminarRuta(s5);
        System.out.println(m.desplegar(m.getR(), ""));
        
        String s6[]={"UAEM","ISW"};
        m.eliminarRuta(s6);
        System.out.println(m.desplegar(m.getR(), ""));
        
        String s7[]={"UNAM"};
        m.eliminarRuta(s7);
        System.out.println(m.desplegar(m.getR(), ""));

    }

}
