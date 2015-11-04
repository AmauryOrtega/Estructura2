package colaPrioridad;

import java.io.Serializable;

public class Cola implements Serializable{

    private Tarea primero;
    private Tarea ultimo;
    private int nitem;

    public Cola() {
        primero = ultimo = null;
        nitem = 0;
    }

    public Cola(String d) {
        primero = new Tarea(d, null);
        ultimo = primero;
        nitem = 1;
    }

    public Tarea getPrimero() {
        return primero;
    }

    public void setPrimero(Tarea primero) {
        this.primero = primero;
    }

    public Tarea getUltimo() {
        return ultimo;
    }

    public void setUltimo(Tarea ultimo) {
        this.ultimo = ultimo;
    }

    public int getNitem() {
        return nitem;
    }

    public void setNitem(int nitem) {
        this.nitem = nitem;
    }
    
    public boolean isVacia() {
        return nitem == 0;
    }

    public void insertarTarea(String d) {
        if (isVacia()) {
            primero = new Tarea(d, null);
            ultimo = primero;
            nitem++;
        } else {
            ultimo.setSiguiente(new Tarea(d, null));
            ultimo = ultimo.getSiguiente();
            nitem++;
        }
    }

    public boolean quitar() {
        if (nitem == 0) {
            return false;
        } else {
            primero = primero.getSiguiente();
            nitem--;
            return true;
        }
    }

    public String imprimir() {
        String texto = "";
        if (isVacia()) {
            texto = "Vacio\n";
        } else {
            Tarea aux = primero;
            while (aux != null) {
                texto += aux.toString() + "\n";
                aux = aux.getSiguiente();
            }
        }

        return texto;
    }

    public boolean buscarTarea(String tarea) {
        Tarea aux = primero;
        while (aux != null) {
            if (aux.getDato().equals(tarea)) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

}
