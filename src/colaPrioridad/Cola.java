package colaPrioridad;

public class Cola {

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

    public boolean isVacia() {
        return nitem == 0;
    }

    public void insertar(String d) {
        if (isVacia()) {
            primero = new Tarea(d, null);
            ultimo = primero;
            nitem++;
        } else {
            ultimo.setSiguiente(new Tarea(d, null));
            ultimo=ultimo.getSiguiente();
            nitem++;
        }
    }

    public boolean quitar() {
        if (nitem == 0) {
            System.out.println("no queda nada");
            return false;
        } else {
            primero = primero.getSiguiente();
            nitem--;
            return true;
        }
    }

    public String imprimir() {
        String texto="";
        if(isVacia()){
            texto="Vacio";
        }else{
            Tarea aux = primero;
            while(aux!=null){
                texto+=aux.toString()+"\n";
                aux=aux.getSiguiente();
            };
        }
        
        return new StringBuilder(texto).reverse().toString();
    }

}
