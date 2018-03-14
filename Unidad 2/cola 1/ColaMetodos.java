

import java.util.Scanner;

class ColaMetodos {
Scanner in= new Scanner(System.in);
        static int max = 0; 
        static int al=0;
        static int colacirc[]; 
        static int frente, fin,t=0; 
        static int[] arreglo; 
        static int horas,salario, salariofin;
        public ColaMetodos() { 
            frente = -1;
            fin = -1;
            System.out.println(" Cola circular");
            System.out.println("ingrese tamaño de la cola: ");
            do{
            max=in.nextInt();
            if(max<=0){
                System.out.println("ERROR!!! :( , DEBE SER NUMERO POSITIVO");
            }
            else{
                al=max;
                }
            }while(max<=0);
            max=al;
            colacirc =new int [max];
            arreglo=new int [max];
        }
        
        public static void Insertar(int dato) {
            int cont=0;
            for(int i=0;i<max;i++){
               if(dato==arreglo[i]){
                   cont++;
               }
            }
               if(cont==0){
               if ((fin == max - 1 && frente == 0) || (fin + 1 == frente)) {
                System.out.println("\nCola Circular Llena!, desea eliminar el ultimo dato, elija la opcion 2");
                return;
                 }
            if (fin == max - 1 && frente != 0) {
                fin= 0;
                t= fin;;
            } else {
                fin++;
                t=fin;;
            }
            arreglo[t]=dato;
            colacirc[fin]= arreglo[t];
            if (frente == -1) {
                frente = 0;
            }  
            }else{
               System.out.println("\n¡¡¡Este salario ya existe , agregue uno nuevo");     
            }
              }
        
        public static void Imprimir() {
            int i = 0;
            System.out.println("\n\nCOLA de salarios");
            if (frente == -1) {
                System.out.println("\nCola esta vacia");
            } else {
                i = frente; 
                do {
                     if (i == max && frente > fin) {
                        i = 0; // Reiniciar en cero (dar la vuelta)
                    }else{
                    System.out.println("x[" + i + "]=" + colacirc[i]);
                    i++;
                     }
                } while (i != fin + 1);
            }
            System.out.println(" frente= " + frente);
            System.out.println(" fin= " + fin);
            System.out.println(" max=" + max);
        }

        public static void Eliminar() {
            System.out.println("\n\n eliminar");
            if (frente == -1) {
                System.out.println("lo siento:/");
                System.out.println("Cola Circular Vacia!");
                return;
            }
            System.out.println("El salario eliminado es: " + colacirc[frente]);//elimina en el vector
            if (frente == fin) {                                    //el primer frente
                frente = -1;
                fin = -1;
                return;
            }
            if (frente == max) {
                frente = 0;
            } else {
                frente++;
            }
        }
}    