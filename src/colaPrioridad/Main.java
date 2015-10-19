package colaPrioridad;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Tareas colaP = new Tareas();
        boolean salir = false;
        while (salir != true) {
            try {
                int op = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1.Insertar tarea\n"
                        + "2.Buscar por fecha\n"
                        + "3.Buscar por tarea\n"
                        + "4.Imprimir fechas\n"
                        + "5.Imprimir tareas de una fecha\n"
                        + "6.Salir"
                        , "Cola de prioridad v1.0", 3));
                switch (op) {
                    case 1:
                        
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        
                        break;
                    case 5:
                        
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        break;
                }
            } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Solo numeros enteros", "Error", 0);
            }
        }
    }
}
