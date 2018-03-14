
import java.util.Scanner;

/**
 *
 * @author Eduardo Daniel Romero Enriquez
 */
class Pila{
    int a[];
    int tope;
    public Pila (int size){
        a=new int [size];
        tope=-1;
    }
    public void introducir(int x){        
        if(tope<(a.length-1)){
            tope++;
            a[tope]=x;
            System.out.println("Elemento agregado");
		System.out.println("Tope: "+tope);
        }
        else System.out.println("Pila llena");
    }
    public int busca(int x){
        for (int i = 0; i <= tope; i++) {
            if(x==a[i])
                return i;
        }
        return -1;
    }
    public void actualizar(int x){
        int i=busca(x);
        if(i>=0){
            tope--;
            for (int j = i; j < tope; j++) {
                a[j]=a[j+1];
            } 
            System.out.println("Elemento borrado");
        }
        else{ introducir(x);
            
        }
    }
    public int sacar(){
        if(tope>=0){
            int aux=a[tope];
            tope--;
            return aux;
        }
        return -1;
    }
}
public class Pila1 {
    public static void main(String args[]){
        Pila p=new Pila(10);
        Scanner s=new Scanner(System.in);
        while(true){
            System.out.println("Ingrese valor: ");
            int dato=s.nextInt();
            p.actualizar(dato);
        }
    }
}
