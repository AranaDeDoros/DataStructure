import java.util.Scanner;

public class Main {
    private static String menu;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int resp=0,tam;
        System.out.print("Tamano de la pila: ");
        tam = in.nextInt();
        Pila pila = new Pila(tam);
        
            while(resp!=5){
	    System.out.println("\n--------------------- ");
            System.out.println("Elija una opcion: ");
            System.out.println("1.Insertar dato"
                            +"\n2.Eliminar dato"
                            +"\n3.Mostrar datos"
                            +"\n4.Buscar dato"
                            +"\n5.Salir del programa"
                            +"\n----------------------- ");
            resp=in.nextInt();
            switch(resp){
                case 1: 
                    if(pila.estaLlena()) System.out.println("Pila llena, elimine un dato si es necesario");
                    else{
                        System.out.print("Ingrese el dato a insertar:\t");
                        int dato = in.nextInt();
                        pila.insertarElemento(dato);
                        
                    }
                break;
                case 2: //Remover elemento
                    if(pila.estaVacia()) System.out.println("Pila vacia, agregue datos");
                    else{
                        pila.removerElemento();
                        
                    }
                    break;
                case 3:
					System.out.print(pila);
					
                    break;

                case 4: 
                    if(pila.estaVacia()) System.out.println("La pila está vacia!!.");
                    else{
                        System.out.println("Ingrese el elemento a buscar:\t");
                        int dato = in.nextInt();
                        pila.busquedaDeElemento(dato); 
                    }
                break;
                
                case 5:
                    System.out.println(" ");
                    break;
                
                
            }
        }
    }
}