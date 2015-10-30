/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colaPrioridad.Persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import colaPrioridad.ColaPrioridad;

public class ArchivoBinario {

    private static final String ruta_archivo = "src\\colaPrioridad.Persistencia\\datosApp.dat";
    //private static final String ruta_archivo = "datosAppFuera.dat";

    public static void escribir(ColaPrioridad app) {

        try {
            try (ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(ArchivoBinario.ruta_archivo))) {
                file.writeObject(app);
                file.close();

                //System.out.println("Guardado exitoso");
                JOptionPane.showMessageDialog(null, "Guardado exitoso", "Exito", 0);
            }
        } catch (IOException e) {
            System.out.println(e);
        } catch (Exception e) {

        }
    }

    public static ColaPrioridad leer() {
        ColaPrioridad aux = new ColaPrioridad();
        try {
            try (ObjectInputStream file = new ObjectInputStream(new FileInputStream(ArchivoBinario.ruta_archivo))) {

                aux = (ColaPrioridad) file.readObject();
                file.close();
                System.out.println("Lectura exitosa");

            }
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(ex);
        } catch (Exception e) {
        }
        return aux;
    }

}
