//4)(25%) Diseñe un programa que deje en una cola circular los datos negativos 
//en primer orden y el segundo los datos positivos
//[+][-][+][+][-]
//[-][-][-][+][+][+]

import java.io.IOException;
import java.util.Scanner;

public class Orden {
    Scanner leer = new Scanner(System.in);
    int max=0;
    int ArregloCola[];
    int frente, fin;
    int ArregloAux[];
    
    
    Orden(){
        frente = -1;
        fin = -1;
        System.out.println("Ingrese el tamaño de la cola");
        max=leer.nextInt();
        ArregloCola= new int [max];  //damos el tamaño del arreglo
        ArregloAux= new int [max];
        //System.out.println("La Cola esta vacia y es de tamaño  " + tamaño + "\nEl Frente y final aun no estan dentro de la cola");
    }
    
    public void Insertar(int dato){
     if ((fin == max - 1 && frente == 0) || (fin + 1 == frente)) {
                System.out.println("\nCola Circular Llena..!");
                return;
            }
            if (fin == max - 1 && frente != 0) {
                fin = 0;
            } else {
                fin++;
            }
            ArregloCola[fin] = dato;
            if (frente == -1) {
                frente = 0;
            }
        }
    
    public void Eliminar(){
      System.out.println("\n\n\t ELIMINAR DATO");
            if (frente == -1) {
                System.out.println("Cola Circular vacia !!!");
                return;
            }
            System.out.println("Dato eliminado = " + ArregloCola[frente]);//elimina en el vector
            if (frente == fin) {                                    //el primer fuente
                frente = -1;
                fin = -1; //si frente igual a fin vacios mostrar -1
                return;
            }
            if (frente == max) {
                frente = 0;
            } else {
                frente++;
            }
        }
    
    public void Mostrar(){
    int i = 0;
            System.out.println("\n\n\t MOSTRAR COLA CIRCULAR ");
            if (frente == -1) {
                System.out.println("\nCola Circular vacia.. .");
            } else {
                i = frente;
                do {
                    System.out.println("x [" + i + "]=" + ArregloCola[i]);
                    i++;
                    if (i == max && frente > fin) {
                        i = 0; // Reiniciar en cero (dar la vuelta)
                    }
                } while (i != fin + 1);
            }

            System.out.println(" frente= " + frente);
            System.out.println(" fin= " + fin);
            System.out.println("max=" + max);
        }
    
    public void Ordenar(){
         System.out.println("\n\n\tCOLA CIRCULAR ORDENADA: ");
         int m=0;
         int aux;
         for(m=1; m<ArregloCola.length; m++){
            aux=ArregloCola[m];
            int j;
           
            for(j=m-1; j>=0 && ArregloCola[j]>aux;j--)
                ArregloCola[j+1]=ArregloCola[j];
                ArregloCola[j+1]= aux;  
        }
        for (int i =0;i<ArregloCola.length; i++){
            System.out.println("x["+i+"]= "+ArregloCola[i]+"\t");
        }
        
        System.out.println(" Frente: " + frente);
        System.out.println(" Fin: " + fin);
        System.out.println(" Max: " + max);

    }
    
    
    static Orden ColaCircular = new Orden();

    public static void main (String [] args) throws IOException{
        Scanner leer = new Scanner(System.in);
        int opc =0;
        do{
        System.out.println("\nSeleccione: ");
        System.out.println("1.-Insertar\t2.-Eliminar\n3.-Mostrar\t4.-Ordenar\n0.-Salir");
        opc = leer.nextInt();
        switch (opc) {
                case 1:
                    Inserte();
                    break;
                case 2:
                    ColaCircular.Eliminar();
                    break;
                case 3:
                    ColaCircular.Mostrar();
                    break;
                case 4:
                    ColaCircular.Ordenar();
                    break;
               
            }
        } while (opc != 0);
    }
    
    public static void Inserte() throws IOException {
        Scanner leer = new Scanner(System.in);
        int dato;
        System.out.print("Introduzca el dato: ");
        dato = leer.nextInt();
        ColaCircular.Insertar(dato); //Invocar el metodo Insertar del objeto ColaCircular
    }
} //Llave final
