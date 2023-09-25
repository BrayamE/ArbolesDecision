import java.util.Scanner;
class Nodo {
    int dato;
    Nodo izquierdo, derecho;

    public Nodo(int item) {
        dato = item;
        izquierdo = derecho = null;
    }
}
class ArbolBinario {
    Nodo raiz;

    ArbolBinario() {
        raiz = null;
    }

    void insertar(int dato) {
        raiz = insertarRec(raiz, dato);
    }
    Nodo insertarRec(Nodo raiz, int dato) {
        if (raiz == null) {
            raiz = new Nodo(dato);
            return raiz;
        }

        if (dato < raiz.dato)
            raiz.izquierdo = insertarRec(raiz.izquierdo, dato);
        else if (dato > raiz.dato)
            raiz.derecho = insertarRec(raiz.derecho, dato);

        return raiz;
    }
    void imprimirPreorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + " ");
            imprimirPreorden(nodo.izquierdo);
            imprimirPreorden(nodo.derecho);
        }
    }
    void imprimirInorden(Nodo nodo) {
        if (nodo != null) {
            imprimirInorden(nodo.izquierdo);
            System.out.print(nodo.dato + " ");
            imprimirInorden(nodo.derecho);
        }
    }
    void imprimirPostorden(Nodo nodo) {
        if (nodo != null) {
            imprimirPostorden(nodo.izquierdo);
            imprimirPostorden(nodo.derecho);
            System.out.print(nodo.dato + " ");
        }
    }

    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        Scanner scanner = new Scanner(System.in);
        int dato;
        System.out.println(" ==========================");
        System.out.println(" BRAYAM EDWIN QUISPE APAZA");
        System.out.print("Ingresa el número de elementos en el árbol: ");
        int n = scanner.nextInt();

        System.out.println("Ingresa los elementos del árbol:");
        for (int i = 0; i < n; i++) {
            dato = scanner.nextInt();
            arbol.insertar(dato);
        }
        System.out.println("Recorrido en preorden:");
        arbol.imprimirPreorden(arbol.raiz);

        System.out.println("\nRecorrido en inorden:");
        arbol.imprimirInorden(arbol.raiz);

        System.out.println("\nRecorrido en postorden:");
        arbol.imprimirPostorden(arbol.raiz);
    }
}
