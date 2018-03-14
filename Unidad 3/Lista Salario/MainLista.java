import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainLista{
    public static void main(String[] args) throws IOException {
        Lista ls = new Lista();
        
        int opcion;
        String opcion2;
        String dato, dato1;
        Scanner Leer = new Scanner (System.in);
        Scanner s = new Scanner(System.in);
        do {
                    
            System.out.print("\nMENU TRABAJADORES\n"
                    + "\n\t[1].INSERTAR AL PRINCIPO DE LA LISTA"
                    + "\n\t[2].INSERTAR EN LA LISTA DESPUES DE UNA REFERENCIA(NOMBRE)"
                    + "\n\t[3].INSERTAR AL FINAL(INSERTAR EN ORDEN)"
                    + "\n\t[4].INSERTAR ANTES DE UNA REFERENCIA(NOMBRE)"
                    
                    + "\n\t[5].ELIMINAR AL PRINCIPIO"
                    + "\n\t[6].ELIMINAR EN LA LISTA DESPUES DE UNA REFERENCIA(NOMBRE)"
                    + "\n\t[7].ELIMINAR TRABAJADOR (MISMA REFERENCIA)"
                    + "\n\t[8].ELIMINAR DE LA LISTA ANTES DE UNA REFERENCIA(NOMBRE)"
                    + "\n\t[9].RETIRAR AL FINAL "
          
                    + "\n\t[10].MUESTRA LISTA"
                    + "\n\t[11].BUSCAR"
                    + "\n\t[12].SALIR"
                    + "\nIngrese una opcion: \t");
            opcion = s.nextInt();

            switch (opcion) {
                case 1: {
                    System.out.print("Ingrese el nombre:\t");
                    dato = Leer.nextLine();
                    ls.InsertarPrincipio(dato);
                    break;
                }
                case 2: {
                   if (!ls.LSLVacia()) {
                         System.out.print("\n Inserte el Nombre como referencia\t");
                    dato1 = Leer.nextLine();
                    ls.InsertarDespuesDe(dato1);                 
                    } else {
                        System.out.println("Lista sin nodos");
                    }                  
                    break;
                }
                 case 3:{
                    System.out.print("Ingrese el nombre:\t");
                    dato = Leer.nextLine();
                    ls.insertarEnOrden(dato);
                    break;
                }
                case 4: {
                  if (!ls.LSLVacia()) {
                        System.out.print("\n Inserte el Nombre como referencia\t");
                        dato1 = Leer.nextLine();
                        ls.InsertarAntesDe(dato1);
                    } else {
                        System.out.println("Lista sin nodos");
                    }  
                    break;
                }
                case 5: {
                    if (!ls.LSLVacia()) {
                                ls.retiraAlPrincipio();                       
                    } else {
                        System.out.println("Lista sin nodos");
                    }
                    break;
                }                   
                case 6: {
                    if (!ls.LSLVacia()) {
                        System.out.println("Ingrese la referencia, el Nombre despues de esta se eliminara: ");
                        dato = Leer.nextLine();
                        ls.eliminarDespuesDe(dato);
                    } else {
                        System.out.println("Lista sin nodos");
                    }
                    break;
                }
                case 7: {
                    if (!ls.LSLVacia()) {
                        System.out.println("Ingrese el Nombre de referencia a eliminar:\t");
                        dato = Leer.nextLine();
                        ls.retirar(dato);
                    } else {
                        System.out.println("Lista sin nodos");
                    }
                    break;
                }
                case 8:{
                    if (!ls.LSLVacia()) {
                        System.out.print("\n Inserte el Nombre como referencia\t");
                    dato1 = Leer.nextLine();
                    ls.eliminarAntesDe(dato1);
                    } else {
                        System.out.println("Lista sin nodos");
                    }
                    break;
                }
                 case 9:{
                    if (!ls.LSLVacia()) {
                                ls.retiraAlFinal();
                    } else {
                        System.out.println("Lista sin nodos");
                    }
                    break;
                }
                  
                case 10: {
                    System.out.println("\nLista:\n");
                    ls.recorrer();
                    break;
                }
                case 11: {
                    if (!ls.LSLVacia()) {
                          System.out.print("\n Inserte el Nombre como referencia a buscar\t");
                    dato1 = Leer.nextLine();
                    ls.buscar(dato1);
                    } else {
                        System.out.println("Lista sin nodos");
                    }
                    break;
                } 
                case 12:{
                System.exit(0);
                }
            }
        } while (opcion != 0);
    }
}