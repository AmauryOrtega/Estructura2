package colaPrioridad;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

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

    //--------IMPRESIONES------
    public String imprimirListaTareas() {
        String lista = "";
        if (isVacia()) {
            lista += "Vacia";
        } else {
            NodoPrioridad aux = this.primero;
            lista = "\n";
            while (aux != null) {
                lista += "Lista de tareas de la fecha: " + aux.getFecha().toLocaleString() + "\n" + imprimirListaTareas(aux.getFecha());
                aux = aux.getSiguiente();
            }
        }
        return lista;
    }

    public String imprimirListaTareas(Date f) {
        NodoPrioridad aux = primero;
        while (aux != null) {
            if (aux.getFecha().compareTo(f) == 0) {
                return aux.getCola().imprimir();
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    public String imprimirTarea(String tarea) {
        Date fechaTarea = buscarTarea(tarea);
        if (fechaTarea == null) {
            return "No se encontro la tarea";
        } else {
            return "Fecha: " + fechaTarea.toLocaleString() + ", Tarea: " + tarea;
        }
    }

    //--------INSERTAR--------
    public void insertarFechaPrincipio(Date f) {
        f.setSeconds(0);
        if (isVacia()) {
            primero = new NodoPrioridad(f, new Cola(), null);
        } else {
            NodoPrioridad nuevo = new NodoPrioridad(f, new Cola(), null);
            nuevo.setSiguiente(this.primero);
            primero = nuevo;
        }
    }

    public void insertarFechaFinal(Date f) {
        f.setSeconds(0);
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

    public NodoPrioridad insertarFecha123(Date f) {
        //Debe hacerse debido a que esta es la mas usada en BACK END
        if (isVacia()) {
            primero = new NodoPrioridad(f, new Cola(), null);
            System.out.println("INSERTAR123: Cola de prioridad vacia, agrego al inicio");
        } else {
            //Si ya existe esa fecha
            NodoPrioridad aux = primero;
            while (aux != null) {
                if (aux.getFecha().compareTo(f) == 0) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
            //Si no existe esa fecha
            if (aux == null) {
                NodoPrioridad derecha = primero;
                while (derecha != null) {
                    if (f.compareTo(derecha.getFecha()) > 0) {
                        derecha = derecha.getSiguiente();
                    } else {
                        break;
                    }
                }
                NodoPrioridad izquierda = primero;
                while (izquierda != null) {
                    if (izquierda.getSiguiente() == derecha) {
                        break;
                    }
                    izquierda = izquierda.getSiguiente();
                }
                try {
                    System.out.println("izq:" + izquierda.getFecha());
                    System.out.println("derecha:" + derecha.getFecha());
                } catch (Exception e) {
                    //Solo se captura para que no de error al ver la fecha de los nodoPrioridad izqueirda y derecha
                }
                if (izquierda == null) {
                    //Al inicio
                    primero = new NodoPrioridad(f, new Cola(), primero);
                    System.out.println("INSERTAR123: Cola de prioridad no vacia, agrego al inicio");
                    return primero;
                } else {
                    //Medio
                    if (derecha != null) {
                        izquierda.setSiguiente(new NodoPrioridad(f, new Cola(), derecha));
                        System.out.println("INSERTAR123: Cola de prioridad no vacia, agrego entre " + izquierda.getFecha() + " y " + derecha.getFecha());
                        return izquierda.getSiguiente();
                    } else {
                        //Final
                        izquierda.setSiguiente(new NodoPrioridad(f, new Cola(), null));
                        System.out.println("INSERTAR123: Cola de prioridad no vacia, agrego al final");
                        return izquierda.getSiguiente();
                    }
                }

            }
        }
        return null;
    }

    public void agregarTarea() throws Exception { //PEDIDO (1) - Lanzar la excepcion cuando la fecha y hora NO es posterior a la actual
        String dato;
        dato = JOptionPane.showInputDialog(null, "Escriba la nueva tarea", "Agregar Tarea", 1);

        DateFormat formato = new SimpleDateFormat("dd/MM/yyy HH:mm");
        Date fecha = new Date();

        try {
            fecha = (Date) formato.parse(JOptionPane.showInputDialog(null, "Escriba la fecha y hora de la nueva tarea\nEjemplo: 30/10/2015 15:30", "Agregar Tarea", 1));
        } catch (Exception e) {
            throw new Exception("Porfavor use el formato dado dd/MM/yyy HH:mm\nEjemplo: 30/10/2015 15:30");
        }

        if (dato.equals("")) {
            throw new Exception("La tarea no puede quedar vacia");
        } else {
            if (fecha.compareTo(Calendar.getInstance().getTime()) < 0) { //Si es del pasado
                throw new Exception("La Fecha/Hora no es correcta debido a que es anterior a la fecha actual");
            } else {
                this.insertarFecha123(fecha).getCola().insertarTarea(dato);
            }

        }
    }

    //--------BUSCAR--------    
    public NodoPrioridad buscarNodoPrioridad(Date f) {
        if (isVacia()) {
            return null;
        } else {
            NodoPrioridad aux = primero;
            while (aux != null) {
                if (aux.getFecha().compareTo(f) == 0) {
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

    public Date buscarTarea(String tarea) {
        NodoPrioridad aux = primero;
        while (aux != null) {
            if (aux.getCola().buscarTarea(tarea)) {
                return aux.getFecha();
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    //--------BORRAR-------- 
    public boolean borrarNodoPrioridad(Date f) {
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
    
    public void atender(){
        
    }

    //--------------FUNCIONES ADICIONALES------------------    
    public boolean despuesDe(Tarea uno, Tarea dos) {
        Date fechaUno, fechaDos;

        fechaUno = buscarTarea(uno.getDato());
        fechaDos = buscarTarea(dos.getDato());

        return fechaUno.after(fechaDos);//True fechaUno esta despues de fechaDos
    }

    public boolean antesDe(Tarea uno, Tarea dos) {
        Date fechaUno, fechaDos;

        fechaUno = buscarTarea(uno.getDato());
        fechaDos = buscarTarea(dos.getDato());

        return fechaUno.before(fechaDos);//True fechaUno esta antes de fechaDos
    }

    public boolean igual(Tarea uno, Tarea dos) {
        Date fechaUno, fechaDos;

        fechaUno = buscarTarea(uno.getDato());
        fechaDos = buscarTarea(dos.getDato());

        return fechaUno.equals(fechaDos);//True fechaUnoes igual a fechaDos
    }

    
    public void consultarPrimerDato() {  //PEDIDO (2) - RETORNAR TAREA CON FECHA Y HORA MAS ANTIGUA
        JOptionPane.showMessageDialog(null, imprimirTarea(this.getPrimero().getCola().getPrimero().getDato()), "Primera Tarea", 1);
    }

    public void actualizarPrimerDato() { //PEDIDO (3) - EXTRAER PRIMER DATO Y VOLVERLO A PONER CON FECHA EXTENDIDA

    }

    public void extraerPrimerDato() {    //PEDIDO (4) - EXTRAER PRIMER DATO Y MOSTRAR SU INFO (NO VOLVER A METER EL DATO)
        //Hacer uso de la funcion leerTarea y buscarNodoPrioridad(Usando la fecha actual)
    }
}
