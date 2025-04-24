/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import modelo.*;
import vista.*;

/**
 *
 * @author otjos
 */
public class Manipula
{

    private static final String recImagen = "src/vista/imagenes/";
    private JLabel img;

    public static <T> void insertar(T obj, String nombre, String[] ruta)
    {
        try
        {
            NodoM<T> nodo = new NodoM(obj, nombre);
            Multilista m = Var.getM();
            m.setR(m.inserta(nodo, m.getR(), ruta, 0));
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error al insertar en la multilista", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static String formatoPalabras(String palabra)
    {
        palabra = palabra.toLowerCase().trim();
        String[] palabras = palabra.split("\\s+");
        StringBuilder resultado = new StringBuilder();
        for (String palabraAux : palabras)
        {
            if (!palabraAux.isEmpty())
            {
                resultado.append(Character.toUpperCase(palabraAux.charAt(0))).append(palabraAux.substring(1)).append(" ");
            }
        }
        return resultado.toString().trim();
    }

    public static boolean esEnteroValido(String texto)
    {
        try
        {
            Integer.parseInt(texto.trim());
            return true;
        } catch (NumberFormatException e)
        {
            return false;
        }
    }

    //---------------------------------TABLAS----------------------------------------
    public static DefaultTableModel actualizarTabla(NodoM r)
    {
        if (r != null)
        {
            NodoM aux = r.getSiguiente();
            Object obj = aux.getObj();
            DefaultTableModel modelo = null;
            if (obj instanceof Dependencia)
            {
                modelo = new DefaultTableModel(new String[]
                {
                    " ", "Clave", "Nombre", "Tipo"
                }, 0)
                {
                    @Override
                    public boolean isCellEditable(int row, int column)
                    {
                        return false; // Desactiva edición en toda la tabla
                    }

                    @Override
                    public Class<?> getColumnClass(int columnIndex)
                    {
                        // Asegura que la columna que contiene la imagen sea tratada correctamente
                        if (columnIndex == 0)
                        {
                            return ImageIcon.class;
                        }
                        return super.getColumnClass(columnIndex);
                    }
                };
                do
                {
                    Dependencia d = (Dependencia) aux.getObj();
                    URL url = Manipula.class.getClassLoader().getResource("vista/imagenes/dep_tab.png");

                    if (url != null)
                    {
                        // Si la URL no es nula, cargamos la imagen
                        ImageIcon iconDep = new ImageIcon(url);
                        Image img = iconDep.getImage();
                        Image scaledImg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH); // 30x30 píxeles
                        iconDep = new ImageIcon(scaledImg);
                        modelo.addRow(new Object[]
                        {
                            iconDep, d.getClave(), d.getNombre(), d.getTipo()
                        });
                    } else
                    {
                        System.out.println("Recurso no encontrado: vista/imagenes/dep_tab.png");
                        // Si no se encuentra el archivo, puedes optar por mostrar un icono por defecto
                        modelo.addRow(new Object[]
                        {
                            new ImageIcon(), d.getClave(), d.getNombre(), d.getTipo()
                        });
                    }

                    aux = aux.getSiguiente();
                } while (aux != r.getSiguiente());

            } else if (obj instanceof Hospital)
            {
                modelo = new DefaultTableModel(new String[]
                {
                    " ", "Clave", "Nombre", "Direccion", "Nivel"
                }, 0)
                {
                    @Override
                    public boolean isCellEditable(int row, int column)
                    {
                        return false; // Desactiva edición en toda la tabla
                    }

                    @Override
                    public Class<?> getColumnClass(int columnIndex)
                    {
                        // Asegura que la columna que contiene la imagen sea tratada correctamente
                        if (columnIndex == 0)
                        {
                            return ImageIcon.class;
                        }
                        return super.getColumnClass(columnIndex);
                    }
                };
                do
                {
                    Hospital h = (Hospital) aux.getObj();
                    URL url = Manipula.class.getClassLoader().getResource("vista/imagenes/hospital_tab.png");

                    if (url != null)
                    {
                        // Si la URL no es nula, cargamos la imagen
                        ImageIcon iconDep = new ImageIcon(url);
                        Image img = iconDep.getImage();
                        Image scaledImg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH); // 30x30 píxeles
                        iconDep = new ImageIcon(scaledImg);

                        modelo.addRow(new Object[]
                        {
                            iconDep, h.getClave(), h.getNombre(), h.getDireccion(), h.getNivel()
                        });
                    } else
                    {
                        System.out.println("Recurso no encontrado: vista/imagenes/dep_tab.png");
                        // Si no se encuentra el archivo, puedes optar por mostrar un icono por defecto
                        modelo.addRow(new Object[]
                        {
                            new ImageIcon(), h.getClave(), h.getNombre(), h.getDireccion(), h.getNivel()
                        });
                    }

                    aux = aux.getSiguiente();
                } while (aux != r.getSiguiente());

            } else if (obj instanceof Especialidad)
            {
                modelo = new DefaultTableModel(new String[]
                {
                    " ", "Clave", "Nombre", "Numero de camas", "Numero de medicos"
                }, 0)
                {
                    @Override
                    public boolean isCellEditable(int row, int column)
                    {
                        return false; // Desactiva edición en toda la tabla
                    }

                    @Override
                    public Class<?> getColumnClass(int columnIndex)
                    {
                        // Asegura que la columna que contiene la imagen sea tratada correctamente
                        if (columnIndex == 0)
                        {
                            return ImageIcon.class;
                        }
                        return super.getColumnClass(columnIndex);
                    }
                };
                do
                {
                    Especialidad e = (Especialidad) aux.getObj();
                    URL url = Manipula.class.getClassLoader().getResource("vista/imagenes/est_tab.png");

                    if (url != null)
                    {
                        // Si la URL no es nula, cargamos la imagen
                        ImageIcon iconDep = new ImageIcon(url);
                        Image img = iconDep.getImage();
                        Image scaledImg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH); // 30x30 píxeles
                        iconDep = new ImageIcon(scaledImg);
                        modelo.addRow(new Object[]
                        {
                            iconDep, e.getClave(), e.getNombre(), e.getNumeroCamas(), e.getNumeroMedicos()
                        });
                    } else
                    {
                        System.out.println("Recurso no encontrado: vista/imagenes/dep_tab.png");
                        // Si no se encuentra el archivo, puedes optar por mostrar un icono por defecto
                        modelo.addRow(new Object[]
                        {
                            new ImageIcon(), e.getClave(), e.getNombre(), e.getNumeroCamas(), e.getNumeroMedicos()
                        });
                    }

                    aux = aux.getSiguiente();
                } while (aux != r.getSiguiente());

            } else if (obj instanceof Paciente)
            {
                modelo = new DefaultTableModel(new String[]
                {
                    " ", "Clave", "Nombre", "Status", "Sexo", "Vigencia"
                }, 0)
                {
                    @Override
                    public boolean isCellEditable(int row, int column)
                    {
                        return false; // Desactiva edición en toda la tabla
                    }

                    @Override
                    public Class<?> getColumnClass(int columnIndex)
                    {
                        // Asegura que la columna que contiene la imagen sea tratada correctamente
                        if (columnIndex == 0)
                        {
                            return ImageIcon.class;
                        }
                        return super.getColumnClass(columnIndex);
                    }
                };
                
                DateTimeFormatter formatoFecha=DateTimeFormatter.ofPattern("dd/MM/yyyy");
                
                do
                {
                    Paciente p = (Paciente) aux.getObj();
                    URL url = Manipula.class.getClassLoader().getResource("vista/imagenes/paciente_tab.png");
                    
                    String vigencia=p.getVigencia().format(formatoFecha);

                    if (url != null)
                    {
                        // Si la URL no es nula, cargamos la imagen
                        ImageIcon iconDep = new ImageIcon(url);
                        Image img = iconDep.getImage();
                        Image scaledImg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH); // 30x30 píxeles
                        iconDep = new ImageIcon(scaledImg);
                        modelo.addRow(new Object[]
                        {
                            iconDep, p.getClave(), p.getNombre(), p.getStatus(), p.getSexo(), vigencia
                        });
                    } else
                    {
                        System.out.println("Recurso no encontrado: vista/imagenes/dep_tab.png");
                        // Si no se encuentra el archivo, puedes optar por mostrar un icono por defecto
                        modelo.addRow(new Object[]
                        {
                            new ImageIcon(), p.getClave(), p.getNombre(), p.getStatus(), p.getSexo(), vigencia
                        });
                    }

                    aux = aux.getSiguiente();
                } while (aux != r.getSiguiente());
            }
            return modelo;
        }
        return new DefaultTableModel();
    }

    public static String[] dividirCad(String nuevaRuta)
    {
// Dividir la ruta en base al delimitador "/"
        String[] dividirDir = nuevaRuta.split("/");

        // Crear una lista para almacenar los directorios no vacíos
        ArrayList<String> listaDirectorios = new ArrayList<>(Arrays.asList(dividirDir));
        listaDirectorios.removeIf(String::isEmpty);

        // Convertir la lista en un arreglo de String y devolverlo
        return listaDirectorios.toArray(new String[0]);
    }
}
