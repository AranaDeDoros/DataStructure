
import java.util.Scanner;

class Cola{
    int cola[], frente, fin, max;
    public Cola(int n){
        max=n;
        cola=new int[n];
        frente=-1;
        fin=-1;
    }
    public boolean isEmpty(){
        if(frente==-1){
            return true;
        }
        return false;
    }
    public void invertir(){
        if(frente==-1)
            return;        
        int inicio, f=fin, aux;
        for(inicio=frente; inicio != f  && (Math.abs(inicio-fin) !=1) ;inicio=((inicio<(max-1)) ? inicio+1: 0)){
            aux=cola[inicio];
            cola[inicio]= cola[f];
            cola[f]=aux;
            f = (f>0)? f -1 : max-1;
        }
    }
    boolean inserta(int e){     
        if((fin==(max-1)&& frente==0) || ((fin+1)==frente )){
            System.out.println("Cola llena!!");
            return false;
        }
        if(fin==(max-1))fin=0;
        else fin++;
		
		if(frente==-1)
            frente=0;
	
        System.out.println("frente= "+frente);
        System.out.println("fin= "+fin);
        cola[fin]=e;
            
        return true;
    }
    int elimina(){
        if(frente==-1){
            System.out.println("No se puede eliminar, no hay nada");            
            return 0;
        }
        int elemento=cola[frente];
        if(frente==fin){
            frente=-1;
            fin=-1;                       
        }else {
            if(frente==(max-1)){
                frente=0;
            }else frente++;
        }
        System.out.println("frente= "+frente);
        System.out.println("fin= "+fin);
        return elemento;
    }
    public int busca(int x){   
        for(int c=frente; fin!=c; c=(c<(max-1)) ? c+1: 0){
            if(cola[c]==x){
                return c;
            }
        }
        if(fin!=-1 && fin!= max &&cola[fin]==x){
            return fin;
        }
        return -1;
    }
    public void imprimir(){
        for(int c=frente; fin!=c; c=(c<(max-1)) ? c+1: 0){
            System.out.print(cola[c]+" ");
        }
        if(fin!=-1 && fin!= max){
            System.out.println(cola[fin]);
        }
        System.out.println("frente= "+frente);
        System.out.println("fin= "+fin);
    }
    }

public class ColaNegativos{
    public static void eliminaNegativos(Cola c){
        Cola aux= new Cola(c.max);
        int n;
        while(!c.isEmpty()){
            n= c.elimina();
            if(n>=0){
                aux.inserta(n);
            }
        }
        while(!aux.isEmpty()){
            c.inserta(aux.elimina());
        }
    }
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.println("Escriba el tamano de la cola ");
        n= s.nextInt();
        Cola cola= new Cola(n);
        int resp=0;
        while(resp!=5){
	    System.out.println("\n--------------------- ");
            System.out.println("Elija una opcion: ");
            System.out.println("1.Insertar dato"
                            +"\n2.Eliminar dato"
                            +"\n3.Mostrar datos"
                            +"\n4.Eliminar negativos"
                            +"\n5.Salir del programa"
                            +"\n----------------------- ");
            resp=s.nextInt();
            switch(resp){
                case 1:
                    System.out.println("Dato: ");
                    n=s.nextInt();
                    cola.inserta(n);
                    break;
                case 2:
                    cola.elimina();
                    break;
                case 3:
                    cola.imprimir();
                    break;
                case 4:
                    eliminaNegativos(cola);
                    break;
                case 5:
                    System.out.println(" ");
                    break;
            }
        }
    }
}

