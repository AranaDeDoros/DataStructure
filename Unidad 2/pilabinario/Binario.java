import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author Eduardo Daniel Romero Enriquez
 */
public class Binario {

    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner s=new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String resp;
	do{
        System.out.println("Ingrese un valor: ");
        int valor=s.nextInt();
       
        //System.out.println(Integer.toString(valor, 2));
        Pila p=new Pila(100);
        while(valor !=0){
            p.introducir(valor%2);
            valor/=2;
        }
         System.out.println("El valor convertido a binario es: ");
        while(p.tope>=0){
            System.out.print(p.sacar());
        }
		System.out.print("\nDesea convertir otro numero? (si/no):\t");
		resp = br.readLine().trim().toLowerCase();
		}while(resp.equals("si")); 
    }
    
}
