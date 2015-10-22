package ArbolBinario;

public class ArbolBinario {

    private class nodoArbol {

        private ArbolBinario hijoDerecho;
        private ArbolBinario hijoIzquierdo;
        private int dato;

        private void nodoArbol() {
            hijoDerecho = null;
            hijoIzquierdo = null;
            dato = 0;
        }
    }

    public nodoArbol raiz;

    public void abb() {
        nodoArbol raiz = new nodoArbol();
    }

    //--------Extras--------
    public boolean esVacio() {
        return (raiz == null);
    }
    
    public boolean esHoja() {
        boolean hoja = false;
        if ((raiz.hijoIzquierdo).esVacio() && (raiz.hijoDerecho).esVacio()) {
            hoja = true;
        }
        return hoja;
    }

    public boolean existe(int a) {
        if (!esVacio()) {
            if (a == raiz.dato) {
                return true;
            } else {
                if (a < raiz.dato) {
                    raiz.hijoIzquierdo.existe(a);
                } else {
                    raiz.hijoDerecho.existe(a);
                }
            }
        }
        return false;
    }

    public int cantidad() {
        if (esVacio()) {
            return 0;
        } else {
            return (1 + raiz.hijoDerecho.cantidad() + raiz.hijoIzquierdo.cantidad());
        }
    }

    public int altura() {
        if (esVacio()) {
            return 0;
        } else {
            return (1 + Math.max(((raiz.hijoIzquierdo).altura()), ((raiz.hijoDerecho).altura())));
        }
    }

    //--------Basicas--------
    public void insertar(int a) {
        if (esVacio()) {
            nodoArbol nuevo = new nodoArbol();
            nuevo.dato = a;
            nuevo.hijoDerecho = new ArbolBinario();
            nuevo.hijoIzquierdo = new ArbolBinario();
            raiz = nuevo;
        } else {
            if (a > raiz.dato) {
                (raiz.hijoDerecho).insertar(a);
            }
            if (a < raiz.dato) {
                (raiz.hijoIzquierdo).insertar(a);
            }
        }
    }
    
    public void eliminar(int a) {
        ArbolBinario paraEliminar = buscar(a);
        if (!paraEliminar.esVacio()) {
            if (paraEliminar.esHoja()) {
                paraEliminar.raiz = null;
            } else {
                if (!paraEliminar.raiz.hijoIzquierdo.esVacio() && !paraEliminar.raiz.hijoDerecho.esVacio()) {
                    paraEliminar.raiz.dato = paraEliminar.raiz.hijoDerecho.buscarMin();
                } else {
                    if (paraEliminar.raiz.hijoIzquierdo.esVacio()) {
                        paraEliminar.raiz = paraEliminar.raiz.hijoDerecho.raiz;
                    } else {
                        paraEliminar.raiz = paraEliminar.raiz.hijoIzquierdo.raiz;
                    }
                }
            }
        }
    }

    public ArbolBinario buscar(int a) {
        ArbolBinario arbolito = null;
        if (!esVacio()) {
            if (a == raiz.dato) {
                return this;
            } else {
                if (a < raiz.dato) {
                    arbolito = raiz.hijoIzquierdo.buscar(a);
                } else {
                    arbolito = raiz.hijoDerecho.buscar(a);
                }
            }
        }
        return arbolito;
    }

    public int buscarMin() {
        ArbolBinario arbolActual = this;
        while (!arbolActual.raiz.hijoIzquierdo.esVacio()) {
            arbolActual = arbolActual.raiz.hijoIzquierdo;
        }
        int devuelvo = arbolActual.raiz.dato;
        //arbolActual.raiz=null;
        return devuelvo;
    }

    public int buscarMan() {
        ArbolBinario arbolActual = this;
        while (!arbolActual.raiz.hijoDerecho.esVacio()) {
            arbolActual = arbolActual.raiz.hijoDerecho;
        }
        int devuelvo = arbolActual.raiz.dato;
        //arbolActual.raiz=null;
        return devuelvo;
    }

    //--------Impresion--------
    public void preOrder() {
        if (!esVacio()) {
            System.out.print(raiz.dato + ", ");
            raiz.hijoIzquierdo.preOrder();
            raiz.hijoDerecho.preOrder();
        }
    }

    public void inOrder() {
        if (!esVacio()) {
            raiz.hijoIzquierdo.inOrder();
            System.out.print(raiz.dato + ", ");
            raiz.hijoDerecho.inOrder();
        }
    }

    public void posOrder() {
        if (!esVacio()) {
            raiz.hijoDerecho.posOrder();
            raiz.hijoIzquierdo.posOrder();
            System.out.print(raiz.dato + ", ");

        }
    }
}
