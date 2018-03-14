
import java.util.Scanner;

class Cola1 {
    static ColaMetodos ColaCircular = new ColaMetodos();

    public static void main(String args[])  {
       Scanner in= new Scanner(System.in);
         int op = 0;
        do {
            System.out.println("\n\n\tCOLA CIRCULAR SALARIAL: ");
            System.out.println(" 1.- Insertar");
            System.out.println(" 2.- Eliminar");
            System.out.println(" 3.- Mostrar");
            System.out.println(" 0.- Salir  ");
            System.out.print("Opcion: ");
            op =in.nextInt();
            switch (op) {
                case 1:
                    Altas();
                    break;
                case 2:
                    ColaCircular.Eliminar();
                    break;
                case 3:
                    ColaCircular.Imprimir();
                    break;
                    
           }
        } while (op != 0);
    }

    public static void Altas() {
        Scanner in= new Scanner(System.in);
        int dato, horas=0, salario=0, salariofin=0;
do{       
        System.out.print("¿Cuantas horas trabajo?");
        dato =in.nextInt();
        if(dato<=12 && dato>0){
        horas=dato;
        }else{
       System.out.println("dato invalido, ingrese nuevo dato!!!!!!");     
        }
}while((dato>12)||(dato<=0)); 
        
        do{
        System.out.print("¿Cual es su pago por hora?");
        dato =in.nextInt();
        if(dato<=15000 && dato>0){
         salario=dato;
        }else{
         System.out.println("dato invalido, ingrese nuevo dato!!!!!!");   
        }
        }while((dato>15000)||(dato<=0));
         
        salariofin=horas*salario;
        dato=salariofin;
          System.out.println("Su Salario Total es de $"+salariofin);
        ColaCircular.Insertar(dato);
      
    }            
   }
    
