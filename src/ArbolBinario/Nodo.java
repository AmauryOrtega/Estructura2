/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolBinario;

/**
 *
 * @author Amaury
 */
public class Nodo {
    private int dato;
    private Nodo derecha;
    private Nodo izquierda;

    public Nodo() {
        derecha=null;
        izquierda=null;
    }

    public Nodo(int dato, Nodo derecha, Nodo izquierda) {
        this.dato = dato;
        this.derecha = derecha;
        this.izquierda = izquierda;
    }

    public Nodo(int dato) {
        this.dato = dato;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + ", izquierda.dato=" + izquierda.getDato()+ ", derecha.dato=" + derecha.getDato() +'}';
    }
    
}
