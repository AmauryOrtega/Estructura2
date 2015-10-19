package colaPrioridad;

import java.util.Calendar;

public class NodoPrioridad {
    protected Calendar fecha;
    protected Cola cola;
    protected NodoPrioridad siguiente;

    public NodoPrioridad() {
        fecha= null;
        cola = new Cola();
        siguiente=null;
    }

    public NodoPrioridad(Calendar fecha, Cola cola, NodoPrioridad siguiente) {
        this.fecha = fecha;
        this.cola = cola;
        this.siguiente = siguiente;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Cola getCola() {
        return cola;
    }

    public void setCola(Cola cola) {
        this.cola = cola;
    }

    public NodoPrioridad getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPrioridad siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "NodoPrioridad{" + "fecha=" + fecha + ", cola=" + cola + '}';
    }
}
