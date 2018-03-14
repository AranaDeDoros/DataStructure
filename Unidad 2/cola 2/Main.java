import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Tamano de la cola:\t");
        int tamano = in.nextInt();
		int opcion;
        String dato;
        ColaCircular cola = new ColaCircular(tamano);
        
        do{
            imprimirMenu();
            opcion = in.nextInt();
            switch(opcion){
                case 1: //Insertar elemento
                    if(cola.estaLlena())  System.out.println("Cola llena!! ");
                    else{
                        System.out.print("Introduzca el elemento a insertar:\t");
                        dato = in.next();
                        cola.insertar(dato);
                        System.out.println("Elemento insertado, la cola quedo de la siguiente forma:");
                        cola.imprimir();
                    }
                    break;
                case 2: //Remover elemento
                    if(cola.estaVacia()) System.out.println("Cola vacia!! ");
                    else{
                        cola.remover();
                        System.out.println("Elemento removido, la cola quedo de la siguiente forma:");
                        cola.imprimir();
                    }
                    break;
                case 3: //Invertir cola circular
                    if(cola.estaVacia()) System.out.println("Cola vacia!! ");
                    else{
                        cola = invertir(cola);
                        System.out.println("Cola invertida: ");
                        cola.imprimir();
                    }
                    break;
                case 4:
                    cola.imprimir();
                    break;
                case 5:
			System.out.println("Goodbye! ");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
            
        }while(opcion!=6);
    }
	public static void imprimirMenu(){
		System.out.println("\n--------------------- ");
		System.out.println("Elija una opcion: ");
		System.out.println("1. Insertar elemento");
		System.out.println("2. Eliminar elemento");
		System.out.println("3. Invertir elementos");
		System.out.println("4. Mostrar cola");
		System.out.println("5. Salir");
		System.out.println("\n--------------------- ");
	}
    private static ColaCircular invertir(ColaCircular cola){
        Pila pilaAux = new Pila(cola.getTamano());
        while(!cola.estaVacia()){
            pilaAux.insertar(cola.getElemento());
        }
        while(!pilaAux.estaVacia()){
            cola.insertar(pilaAux.getElemento());
        }
        return cola;
    }
}
