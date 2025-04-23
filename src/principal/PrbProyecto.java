/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;


import modelo.*;
import controlador.*;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Locale;
import javax.swing.JFrame;
import vista.*;

/**
 *
 * @author otjos
 */
public class PrbProyecto
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        final String ARCHIVO = "datos.dat";
        final String CONTADOR_ARCHIVO = "contador.dat";

        // Cargar datos al iniciar
        int contador = ManipulaArchivos.cargarContador(CONTADOR_ARCHIVO);  // Cargar el contador actual
        Object obj = ManipulaArchivos.cargar(ARCHIVO);
        if (obj instanceof Multilista x)
        { 
            Var.setM(x);
        } else
        {
            Var.setM(new Multilista());
        }

        EventQueue.invokeLater(() ->
        {
            try
            {

                VentanaPrincipal ventana = new VentanaPrincipal();
                ventana.setVisible(true);
                ventana.setMinimumSize(new Dimension(850, 400));
                ventana.setMaximumSize(new Dimension(1100, 600));
                ventana.setLocationRelativeTo(null);
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                /*int opcion;
                do
                {
                    opcion = ManipulaMenus.menuPrincipal();
                    switch (opcion)
                    {
                        case 1:
                            ManipulaMenus.menuUsoGeneral("crear");
                            break;
                        case 2:
                            ManipulaMenus.menuUsoGeneral("eliminar");
                            break;
                        case 3:
                            ManipulaMenus.menuUsoGeneral("modificar");
                            break;
                        case 4:
                            System.out.println(Var.getM().desplegar(Var.getM().getR(), ""));
                            break;
                        case 5:
                            // Guardar datos antes de salir
                            boolean guardado = ManipulaArchivos.guardar(Var.getM(), ARCHIVO);
                            if (guardado)
                            {
                                System.out.println("Datos guardados con exito.");
                            }
                            ManipulaArchivos.guardarContador(Datos.getContadorGeneral(), "contador.dat");
                            System.out.println("Saliendo del sistema...");
                            break;
                        default:
                            System.out.println("Opción no valida. Intenta de nuevo.");
                    }
                } while (opcion != 5);*/
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        });
    }

}
