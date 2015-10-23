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

        public ArbolBinario getHijoDerecho() {
            return hijoDerecho;
        }

        public void setHijoDerecho(ArbolBinario hijoDerecho) {
            this.hijoDerecho = hijoDerecho;
        }

        public ArbolBinario getHijoIzquierdo() {
            return hijoIzquierdo;
        }

        public void setHijoIzquierdo(ArbolBinario hijoIzquierdo) {
            this.hijoIzquierdo = hijoIzquierdo;
        }

        public int getDato() {
            return dato;
        }

        public void setDato(int dato) {
            this.dato = dato;
        }
    }

    private nodoArbol raiz;

    public ArbolBinario() {
        raiz = new nodoArbol();
    }

    //--------Extras--------
    public boolean esVacio() {
        return (raiz == null);
    }

    public boolean esHoja() {
        return (raiz.getHijoIzquierdo()).esVacio() && (raiz.getHijoDerecho()).esVacio();
    }

    public boolean existe(int a) {
        if (!esVacio()) {
            if (a == raiz.getDato()) {
                return true;
            } else {
                if (a < raiz.getDato()) {
                    raiz.getHijoIzquierdo().existe(a);
                } else {
                    raiz.getHijoDerecho().existe(a);
                }
            }
        }
        return false;
    }

    public int cantidad() {
        if (esVacio()) {
            return 0;
        } else {
            return (1 + raiz.getHijoDerecho().cantidad() + raiz.getHijoIzquierdo().cantidad());
        }
    }

    public int altura() {
        if (esVacio()) {
            return 0;
        } else {
            return (1 + Math.max(((raiz.getHijoIzquierdo()).altura()), ((raiz.getHijoDerecho()).altura())));
        }
    }

    //--------Basicas--------
    public void insertar(int a) {
        if (esVacio()) {
            nodoArbol nuevo = new nodoArbol();
            nuevo.setDato(a);
            nuevo.setHijoDerecho(new ArbolBinario());
            nuevo.setHijoIzquierdo(new ArbolBinario());
            raiz = nuevo;
        } else {
            if (a > raiz.getDato()) {
                (raiz.getHijoDerecho()).insertar(a);
            }
            if (a < raiz.getDato()) {
                (raiz.getHijoIzquierdo()).insertar(a);
            }
        }
    }

    public void eliminar(int a) {
        ArbolBinario paraEliminar = buscar(a);
        if (!paraEliminar.esVacio()) {
            if (paraEliminar.esHoja()) {
                paraEliminar.setRaiz(null);
            } else {
                if (!paraEliminar.getRaiz().getHijoIzquierdo().esVacio() && !paraEliminar.getRaiz().getHijoDerecho().esVacio()) {
                    paraEliminar.getRaiz().setDato(paraEliminar.getRaiz().getHijoDerecho().buscarMin());
                } else {
                    if (paraEliminar.getRaiz().getHijoIzquierdo().esVacio()) {
                        paraEliminar.setRaiz(paraEliminar.getRaiz().getHijoDerecho().getRaiz());
                    } else {
                        paraEliminar.setRaiz(paraEliminar.getRaiz().getHijoIzquierdo().getRaiz());
                    }
                }
            }
        }
    }

    public ArbolBinario buscar(int a) {
        ArbolBinario arbolAux = null;
        if (!esVacio()) {
            if (a == raiz.getDato()) {
                return this;
            } else {
                if (a < raiz.getDato()) {
                    arbolAux = raiz.getHijoIzquierdo().buscar(a);
                } else {
                    arbolAux = raiz.getHijoDerecho().buscar(a);
                }
            }
        }
        return arbolAux;
    }

    public int buscarMin() {
        ArbolBinario arbolActual = this;
        while (!arbolActual.getRaiz().getHijoIzquierdo().esVacio()) {
            arbolActual = arbolActual.getRaiz().getHijoIzquierdo();
        }
        int retorno = arbolActual.getRaiz().getDato();
        arbolActual.setRaiz(null);
        return retorno;
    }

    public int buscarMax() {
        ArbolBinario arbolActual = this;
        while (!arbolActual.getRaiz().getHijoDerecho().esVacio()) {
            arbolActual = arbolActual.getRaiz().getHijoDerecho();
        }
        int retorno = arbolActual.getRaiz().getDato();
        arbolActual.setRaiz(null);
        return retorno;
    }

    //--------Impresion--------
    public void preOrder() {
        if (!esVacio()) {
            System.out.print(raiz.dato + ", ");
            raiz.getHijoIzquierdo().preOrder();
            raiz.getHijoDerecho().preOrder();
        }
    }

    public void inOrder() {
        if (!esVacio()) {
            raiz.getHijoIzquierdo().inOrder();
            System.out.print(raiz.dato + ", ");
            raiz.getHijoDerecho().inOrder();
        }
    }

    public void posOrder() {
        if (!esVacio()) {
            raiz.getHijoDerecho().posOrder();
            raiz.getHijoIzquierdo().posOrder();
            System.out.print(raiz.dato + ", ");
        }
    }

    public int min() {
        ArbolBinario arbolActual = this;
        while (!arbolActual.getRaiz().getHijoIzquierdo().esVacio()) {
            arbolActual = arbolActual.getRaiz().getHijoIzquierdo();
        }
        return arbolActual.getRaiz().getDato();
    }

    public int max() {
        ArbolBinario arbolActual = this;
        while (!arbolActual.getRaiz().getHijoDerecho().esVacio()) {
            arbolActual = arbolActual.getRaiz().getHijoDerecho();
        }
        return arbolActual.getRaiz().getDato();
    }

    //--------Get/Set--------
    public nodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(nodoArbol raiz) {
        this.raiz = raiz;
    }

}
