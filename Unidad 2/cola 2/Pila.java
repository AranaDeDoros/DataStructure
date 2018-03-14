import java.util.Arrays;
public class Pila{ 
    private String datos[];
    private int tamano;
    private int fin=-1; 
    public void imprimir(){ 
		System.out.print("|");
        for (int i = 0; i < tamano; i++) {
            System.out.print(datos[i]+"|");
        }
		System.out.println();
		System.out.println("Fin = "+fin);
    }
    public int getTamano(){
        return tamano;
    }
    public int buscarElemento(String dato){ 
        int i=0;
        do{
            if(datos[i].equals(dato)) return i;
            else i=i+1;
        }while(i<=fin);
        return -1;
    }
    public void busquedaDeElemento(String dato){ 
        int posicion = buscarElemento(dato);
        if(posicion==-1){ 
            if(!estaLlena()){
                insertar(dato);
                System.out.println("No se encontro y se inserto");
            }
            else System.out.println("No se encontró y esta llena la pila");
        }
        else{ 
            remover(posicion);
            System.out.println("Se encontró el elemento en "+posicion+" y se elimino.");
        }
    }
    public boolean estaVacia(){ 
        return fin==-1;
    }
    public boolean estaLlena(){
        return (fin+1)==tamano;
    }
    public String getElemento(){ 
        String elemento = datos[fin];
        remover();
        return elemento;
    }
    public void remover(){ 
        datos[fin]="null";
		fin = fin-1;
    }
    public void remover(int indice){ 
        int tam = fin-indice;
        String auxiliar [] = new String[tam];
        for (int i = 0; i < tam; i++) {
            auxiliar[i] = getElemento(); 
        }
        remover(); 
        for (int i = tam-1; i >=0; i--) {
            insertar(auxiliar[i]); 
        }
    }
    public void insertar(String dato){
		fin = fin+1;
        datos[fin] = dato; 
    }
    public Pila(int tamano){
        this.tamano = tamano;
        datos = new String[tamano]; 
        Arrays.fill(datos, "null");
    }
}
