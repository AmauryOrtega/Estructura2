package colaPrioridad;

import java.util.Calendar;

public class Lista {

    protected NodoPrioridad primero;

    public Lista() {
        primero = null;
    }

    public Lista(NodoPrioridad primero) {
        this.primero = primero;
    }

    public NodoPrioridad getPrimero() {
        return primero;
    }

    public void setPrimero(NodoPrioridad primero) {
        this.primero = primero;
    }
    
    public boolean isVacia() {
        if (this.primero == null) {
            return true;
        }
        return false;
    }

    //--------------FECHAS------------------
    public String imprimirListaFechas() {
        String lista = "";

        if (isVacia()) {
            lista += "Vacia";
        } else {
            int i = 0;
            NodoPrioridad aux = this.primero;
            while (aux != null) {
                lista += "NodoPrioridad(" + i + ")" + " " + aux.getFecha()+ "\n";
                aux = aux.getSiguiente();
                i++;
            }
        }

        return lista;
    }

    //--------------Insertar------------------
    public void instertarFechaPrincipio(Calendar f) {
        if (isVacia()) {
            primero = new NodoPrioridad(f, new Cola(), null);
        } else {
            NodoPrioridad nuevo = new NodoPrioridad(f, new Cola(), null);
            nuevo.setSiguiente(this.primero);
            primero = nuevo;
        }
    }

    public void insertarFechaFinal(Calendar f) {
        if (isVacia()) {
            primero = new NodoPrioridad(f, new Cola(), null);
        } else {
            NodoPrioridad nuevo = new NodoPrioridad(f, new Cola(), null);

            NodoPrioridad aux = primero;
            while (aux.siguiente != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);

        }
    }
    
    public void insertarFecha123(Calendar f){
        
    }

    public NodoPrioridad buscarPorFecha(Calendar f) {
        if (isVacia()) {
            return null;
        } else {
            NodoPrioridad aux = primero;
            while (aux != null) {
                if (aux.getFecha().equals(f)) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
            return aux; //Es como si retornara null porque ya llego al final de la lista
        }
    }

    public boolean borrarPorFecha(Calendar f) {
        if (isVacia()) {
            return false;
        } else {
            NodoPrioridad borrar = buscarPorFecha(f);
            if (borrar == primero) {
                primero = borrar.siguiente;
                return true;
            } else {
                //Medio
                NodoPrioridad auxAntes = primero;
                NodoPrioridad auxDespues = primero;

                while (auxAntes != null) {
                    if (auxAntes.getSiguiente() == borrar) {
                        break;
                    }
                    auxAntes = auxAntes.getSiguiente();
                }
                while (auxDespues != null) {
                    if (auxDespues == borrar) {
                        auxDespues = borrar.getSiguiente();
                        break;
                    }
                    auxDespues = auxDespues.getSiguiente();
                }
                if (auxDespues != null) {
                    auxAntes.setSiguiente(auxDespues);
                    return true;
                } else {
                    auxAntes.setSiguiente(null);
                    return true;
                }
            }
        }
    }
    
    //--------------TAREAS------------------    
    
    public String imprimirListaTareas(Calendar f){
        String texto="";
        return texto;
    }
    
    public void insertarTarea(Calendar f){
    
    }
    
    public Tarea buscarTarea(Calendar f, String tarea){
        return new Tarea();
    }
    
    public boolean borrarTarea(Calendar f, String tarea){
        return true;
    }
    
    //--------------COMBINADAS------------------    
        
    public void agregarTarea(){ //PEDIDO (1)
    
    }
    
    public void consultarPrimerDato(){  //PEDIDO (2) - TAREA CON FECHA Y HORA MAS ANTIGUA
        
    }
    
    public void actualizarPrimerDato(){ //PEDIDO (3) - EXTRAER(4) PRIMERDATO Y VOLVERLO A PONER CON NEW (FECHA+?) DONDE ? ES UN PARAMETRO
    
    }
    
    public void extraerPrimerDato(){    //PEDIDO (4) - EXTRAER PRIMER DATO Y MOSTRAR SU INFO
    
    }
    
    //PEDIDOS
    /*
    HACER FUNCIONES COMPARATIVAS PARA FECHAS
    METODO LEER QUE TOME TODOS LOS DATOS DE UNA TAREA
    METODO MOSTRAR QUE MUESTRE TODOS LOS DATOS DE UNA TAREA
    METODO APLAZAR TAREA POR UN TIEMPO ? QUE PASARA POR PARAMETRO
    ARCHIVOS
    */
    
}
