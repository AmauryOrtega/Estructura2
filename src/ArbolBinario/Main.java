package ArbolBinario;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        boolean init = true;
        if(init){
            arbol.insertar(27);
            arbol.insertar(14);
            arbol.insertar(7);
            arbol.insertar(11);
            arbol.insertar(47);
            arbol.insertar(32);
            arbol.insertar(59);
            arbol.insertar(50);
            arbol.insertar(77);
        }
        boolean salir = false;
        while (salir != true) {
            try {
                int op = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1.Insertar dato\n"
                        + "2.Buscar dato\n"
                        + "3.Eliminar dato\n"
                        + "4.Imprimir InOrden\n"
                        + "5.Imprimir PosOrden\n"
                        + "6.Imprimir resumen extra\n"
                        + "7.Salir"
                        , "Arbol Binario", 3));
                switch (op) {
                    case 1:
                        arbol.insertar(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato del nuevo nodo", "Insertar", 1)));
                        break;
                    case 2:
                        if(arbol.existe(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a buscar", "Buscar", 1)))){
                            JOptionPane.showMessageDialog(null, "El nodo si existe", "Buscar", 2);
                        }else{
                            JOptionPane.showMessageDialog(null, "El nodo no existe", "Buscar", 0);
                        }
                        break;
                    case 3:
                        arbol.eliminar(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato del nodo a borrar", "Borrar", 1)));
                        break;
                    case 4:
                        arbol.inOrder();
                        break;
                    case 5:
                        arbol.posOrder();
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "El arbol tiene\n"
                                + "Altura: "+arbol.altura()+"\n"
                                + "Cantidad de nodos: "+arbol.cantidad()+"\n"
                                + "Nodo max: "+arbol.max()+"\n"
                                + "Nodo min: "+arbol.min()+"\n"
                                , "Resumen", 2);
                        break;
                    case 7:
                        salir=true;
                        break;
                    default:
                        break;
                }
            } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Solo numeros enteros", "Error", 0);
            }
        }
    }
}
