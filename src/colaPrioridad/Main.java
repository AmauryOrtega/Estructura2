package colaPrioridad;

import java.util.Calendar;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        ColaPrioridad colaP = new ColaPrioridad();
        boolean salir = false;
        while (salir != true) {
            try {
                int op = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1.Agregar tarea\n"
                        + "2.Consultar el primer dato\n"
                        + "3.Extraer primer dato y aplazarlo antes de insertarlo\n"
                        + "4.Guardar\n"
                        + "5.Leer\n\n"
                        + "6.Imprimir fechas\n"
                        + "7.Imprimir Tareas de una fecha en especifico\n"
                        + "\n"
                        , "Cola de prioridad v1.1", 3));
                switch (op) {
                    case 1:
                        try{
                            colaP.agregarTarea();
                        }catch(Exception e){
                            //Capturar la excepcion cuando la fecha y hora NO es posterior a la actual
                        }
                        break;
                    case 2:
                        colaP.consultarPrimerDato();
                        break;
                    case 3:
                        colaP.actualizarPrimerDato();
                        break;
                    case 4:
                        
                        break;
                    case 5:
                        
                        break;
                    case 6:
                        colaP.imprimirListaFechas();
                        break;
                    case 7:
                        colaP.imprimirListaTareas(null);
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
