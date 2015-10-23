package colaPrioridad;

import java.util.Calendar;

public class ColaPrioridad {

    private NodoPrioridad primero;

    public ColaPrioridad() {
        primero = null;
    }

    public ColaPrioridad(NodoPrioridad primero) {
        this.primero = primero;
    }

    public NodoPrioridad getPrimero() {
        return primero;
    }

    public void setPrimero(NodoPrioridad primero) {
        this.primero = primero;
    }

    public boolean isVacia() {
        return this.primero == null;
    }

    //--------------NODOS DE PRIORIDAD------------------
    public String imprimirListaFechas() {
        String lista = "";

        if (isVacia()) {
            lista += "Vacia";
        } else {
            int i = 0;
            NodoPrioridad aux = this.primero;
            while (aux != null) {
                lista += "NodoPrioridad(" + i + ")" + " " + aux.getFecha() + "\n";
                aux = aux.getSiguiente();
                i++;
            }
        }
        return lista;
    }
    
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

    public void insertarFecha123(Calendar f) {
        //Debe hacerse debido a que esta es la mas usada en BACK END
    }

    public NodoPrioridad buscarNodoPrioridad(Calendar f) {
        if (isVacia()) {
            return null;
        } else {
            NodoPrioridad aux = primero;
            while (aux != null) {
                if (aux.getFecha().compareTo(f)==0) {
                    //Metodo comparteTo retorna
                    // ==0-son iguales en milisegundos
                    // <0-aux.getFecha() es antes que la fecha del parametro 
                    // >0-aux.getFecha() es despues que la fecha del parametro 
                    return aux;
                }
                aux = aux.getSiguiente();
            }
            return aux; //Es como si retornara null porque ya llego al final de la lista
        }
    }

    public boolean borrarNodoPrioridad(Calendar f) {
        if (isVacia()) {
            return false;
        } else {
            NodoPrioridad borrar = buscarNodoPrioridad(f);
            if (borrar == primero) {
                //Primero
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
    //--------------FIN/ NODOS DE PRIORIDAD---------------
    
    //--------------TAREAS------------------    
    public String imprimirListaTareas(Calendar f) {
        String texto = "";
        return texto;
    }

    public void insertarTarea(Calendar f, String tarea) {

    }

    public Tarea buscarTarea(Calendar f, String tarea) {
        return new Tarea();
    }

    public boolean borrarTarea(Calendar f, String tarea) {
        return true;
    }
    
    public void mostrarTarea(Tarea tarea){
        
    }
    
    public Tarea leerTarea(){
        return new Tarea();
    }
    //--------------FIN/ TAREAS------------------    

    //--------------FUNCIONES FRONT END------------------    
    public void agregarTarea() { //PEDIDO (1)
        
    }

    public void consultarPrimerDato() {  //PEDIDO (2) - RETORNAR TAREA CON FECHA Y HORA MAS ANTIGUA

    }

    public void actualizarPrimerDato() { //PEDIDO (3) - EXTRAER PRIMER DATO Y VOLVERLO A PONER CON FECHA EXTENDIDA

    }

    public void extraerPrimerDato() {    //PEDIDO (4) - EXTRAER PRIMER DATO Y MOSTRAR SU INFO (NO VOLVER A METER EL DATO)

    }
}
