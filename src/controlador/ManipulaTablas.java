package controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author otjos
 */
public class ManipulaTablas extends JTable
{

    // Método para personalizar las tablas
    public static void personalizarTabla(JTable tabla, String tipo)
    {
        tabla.setShowGrid(false);
        tabla.setIntercellSpacing(new Dimension(0, 0));

        tabla.setRowSelectionAllowed(true);
        tabla.setColumnSelectionAllowed(false);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.setRowHeight(30);

        JTableHeader header = tabla.getTableHeader();
        header.setBackground(new Color(34, 139, 34)); // Verde
        header.setForeground(new Color(255, 215, 0)); // Dorado
        header.setReorderingAllowed(false);
        header.setResizingAllowed(false);

        // Se ajusta el renderizado para evitar el borde de enfoque
        TableCellRenderer noFocusBorderRenderer = new NoFocusBorderTableCellRenderer();
        tabla.setDefaultRenderer(Object.class, noFocusBorderRenderer);
        if (tabla.getColumnCount() > 0)
        {
            // Si la primera columna es un ícono (suponiendo que la primera columna es de tipo " ")
            if (tabla.getColumnName(0).equals(" "))
            {
                tabla.getColumnModel().getColumn(0).setMinWidth(50);
                tabla.getColumnModel().getColumn(0).setMaxWidth(50);
            }

            // Configurar columnas dependiendo del tipo
            switch (tipo)
            {
                case "Dependencia":
                    setColumnWidths(tabla, new int[]
                    {
                        100, 250, 150
                    });
                    break;
                case "Hospital":
                    setColumnWidths(tabla, new int[]
                    {
                        150, 200, 250, 100
                    });
                    break;
                case "Especialidad":
                    setColumnWidths(tabla, new int[]
                    {
                        150, 200, 150, 150
                    });
                    break;
                case "Paciente":
                    setColumnWidths(tabla, new int[]
                    {
                        150, 200, 100, 100, 100
                    });
                    break;
            }
        }
    }

    // Método auxiliar para ajustar los anchos de las columnas
    private static void setColumnWidths(JTable tabla, int[] widths)
    {
        for (int i = 0; i < widths.length; i++)
        {
            int col = i + 1;  // Empezamos desde la columna 1 (la columna 0 es para íconos)
            if (col < tabla.getColumnCount())
            {
                tabla.getColumnModel().getColumn(col).setMinWidth(widths[i]);
                tabla.getColumnModel().getColumn(col).setPreferredWidth(widths[i]);
            }
        }
    }

    static class NoFocusBorderTableCellRenderer extends DefaultTableCellRenderer
    {

        private static final Border NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);
        private static final Color COLOR_A = new Color(220, 220, 220); // Color claro
        private static final Color COLOR_B = new Color(255, 255, 255); // Color blanco

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (isSelected)
            {
                component.setBackground(table.getSelectionBackground());
                component.setForeground(table.getSelectionForeground());
            } else
            {
                if (row % 2 == 0)
                {
                    component.setBackground(COLOR_A);
                } else
                {
                    component.setBackground(COLOR_B);
                }
                component.setForeground(table.getForeground());
            }

            if (hasFocus)
            {
                setBorder(NO_FOCUS_BORDER);
            }

            setHorizontalAlignment(SwingConstants.CENTER);

            setValue(value);
            return component;
        }
    }
}
