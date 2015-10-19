package Arbol;

public class Arbol {

    /*
    Casos para eliminar
    raiz{
        si solo tiene dos hojas, intercambia una de las dos por la raiz
        si tiene ramas, usar uno de los metodos de abajo para intercambiar
    }
    
    intermedio{
        usar uno de los metodos de abajo para intercambiar
    }
    
    hoja{
        volverlo null
    }
    
    Metodos que se usan para intercambiar un nodo intermedio por uno nuevo:
        Metoto para buscar el mayor de la rama izq (Una de las hojas)
        Metodo para buscar el menor de la rama derecha (Una de las hojas)
    */
    
    private Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public Arbol(int raiz) {
        this.raiz = new Nodo(raiz, null, null);
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public void insertar(int d) {
        if (d != raiz.getDato()) {
            Nodo aux = raiz;
            boolean band;
            while (aux != null) {
                if (d < aux.getDato()) {
                    band = true;
                } else {//Puede aclararse para que no sean ==
                    band = false;
                }

                if (band) {
                    //izquierda
                    if (aux.getIzquierda() != null) {
                        aux = aux.getIzquierda();
                    } else {
                        aux.setIzquierda(new Nodo(d, null, null));
                    }
                } else {
                    //derecha
                    if (aux.getDerecha() != null) {
                        aux = aux.getDerecha();
                    } else {
                        aux.setDerecha(new Nodo(d, null, null));
                    }
                }
            }
        } else {
            System.out.println("no se puede ese valor");
        }
    }

    public void insertarv2(int d) {
        Nodo nuevo = new Nodo(d);
        if (raiz == null) {
            //Caso que no hayan nodos
            raiz = nuevo;
        } else {
            Nodo aux = raiz;
            Nodo padre;
            while (true) {
                padre = aux;
                if (d < aux.getDato()) {
                    aux = aux.getIzquierda();
                    if (aux == null) {
                        padre.setIzquierda(nuevo);
                        return;
                    }
                } else {
                    aux = aux.getDerecha();
                    if (aux == null) {
                        padre.setDerecha(nuevo);
                        return;
                    }
                }
            }
        }
    }

    public Nodo buscar(int d) {
        Nodo aux = raiz;

        while (aux.getDato() != d) {

            if (d < aux.getDato()) {
                aux = aux.getIzquierda();
            } else {
                aux = aux.getDerecha();
            }

            if (aux == null) {
                return null;
            }
        }
        return aux;
    }
    
    public void imprimirInOrder(){
        auxImprimirInOrder(raiz);
    }
    
    public void auxImprimirInOrder(Nodo raiz) {
        if(raiz!=null){
            auxImprimirInOrder(raiz.getIzquierda());
            System.out.println(raiz.getDato()+" ");
            auxImprimirInOrder(raiz.getDerecha());
        }
    }

}
