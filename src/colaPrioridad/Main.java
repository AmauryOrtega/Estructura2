package colaPrioridad;

import colaPrioridad.Persistencia.ArchivoBinario;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        ColaPrioridad colaP = new ColaPrioridad();
        /*
         DateFormat formato = new SimpleDateFormat("dd/MM/yyy HH:mm");
        
         try {
         colaP.insertarFechaPrincipio((Date) formato.parse("30/10/2015 15:30"));
         colaP.insertarFechaFinal((Date) formato.parse("31/10/2015 15:30"));
         colaP.insertarFechaFinal((Date) formato.parse("02/11/2015 15:30"));
         } catch (ParseException ex) {
         System.out.println("ex:" + ex);
         }
         */
        boolean salir = false;
        while (salir != true) {
            try {
                int op = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1.Agregar tarea\n"
                        + "2.Consultar el primer dato\n"
                        + "3.Extraer primer dato y aplazarlo antes de insertarlo\n"
                        + "4.Extraer primer dato sin insertarlo\n"
                        + "5.Atender tarea mas vieja\n"
                        + "6.Imprimir Tareas de todas las fechas\n"
                        + "7.Imprimir Tareas de una fecha en especifico\n"
                        + "8.Guardar Tareas\n"
                        + "9.Leer Tareas\n"
                        + "10.Salir\n", "Cola de prioridad v1.1", 3));
                switch (op) {
                    case 1:
                        try {
                            colaP.agregarTarea();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
                        }
                        break;
                    case 2:
                        colaP.consultarPrimerDato();
                        break;
                    case 3:
                        colaP.actualizarPrimerDato();
                        break;
                    case 4:
                        colaP.extraerPrimerDato();
                        break;
                    case 5:
                        colaP.atender();
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, colaP.imprimirListaTareas(), "Lista de todas las tareas", 1);
                        break;
                    case 7:
                        Date fechaAux = new Date();
                        DateFormat formato = new SimpleDateFormat("dd/MM/yyy HH:mm");
                        try {
                            fechaAux = (Date) formato.parse(JOptionPane.showInputDialog(null, "Ingrese la fecha", "Imprimir Lista de tareas de una fecha", 1));
                            JOptionPane.showMessageDialog(null, colaP.imprimirListaTareas(fechaAux), "Lista de todas las tareas", 1);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "\"Porfavor use el formato dado dd/MM/yyy HH:mm\\nEjemplo: 30/10/2015 15:30\"", "Error", 0);
                        }
                        break;
                    case 8:
                        ArchivoBinario.escribir(colaP);
                        break;
                    case 9:
                        colaP=ArchivoBinario.leer();
                        break;
                    case 10:
                        salir=true;
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
