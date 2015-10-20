package ArbolBinario;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        boolean init = true;
        if(init){
            arbol.insertarv2(27);
            arbol.insertarv2(14);
            arbol.insertarv2(7);
            arbol.insertarv2(11);
            arbol.insertarv2(47);
            arbol.insertarv2(32);
            arbol.insertarv2(59);
            arbol.insertarv2(50);
            arbol.insertarv2(77);
        }
        boolean salir = false;
        while (salir != true) {
            try {
                int op = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1.Insertar dato\n"
                        + "2.Buscar dato\n"
                        + "3.Imprimir InOrden\n"
                        + "4.Eliminar dato\n"
                        + "5.Salir"
                        , "Arbol Binario", 3));
                switch (op) {
                    case 1:
                        arbol.insertarv2(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato del nuevo nodo", "Insertar", 1)));
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        arbol.imprimirInOrder();
                        break;
                    case 4:
                        arbol.borrar(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato del nodo a borrar", "Borrar", 1)));
                        break;
                    case 5:
                        salir = true;
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
