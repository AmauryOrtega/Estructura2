package colaPrioridad;

import java.io.Serializable;

public class Tarea implements Serializable{
    protected String dato;
    protected Tarea siguiente;

    public Tarea() {
        dato="";
        siguiente=null;
    }

    public Tarea(String dato, Tarea siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public Tarea(Tarea nuevo){
        this.dato=nuevo.dato;
        this.siguiente=nuevo.siguiente;
    }
    
    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Tarea getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Tarea siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return dato;
    }
}
