import java.util.Arrays;

class Entero{
    public static int longEntero(int x){
        if(x<0) x=-x;
        else if(x==0) return 1;
        int longitud = 0;
        while(x>0){
            x/=10;
            longitud++;
        }
        return longitud;
    }
}
public class Pila{ 
    private int datos[];
    private int capacidad;
    private int fin=-1; 
	
   
    
    public int buscarElemento(int dato){ 
        int i=0;
        do{
            if(datos[i]==dato) return i;
            else i++;
        }while(i<=fin);
        return -1;
    }
    public void busquedaDeElemento(int dato){ 
        int posicion = buscarElemento(dato);
        if(posicion==-1){ //Si no está
            if(!estaLlena()){
                insertarElemento(dato);
                System.out.println("Dato no encontrado, se agrego a la pila");
            }
            else System.out.println("La pila esta llena, no se pudo agregar dato.");
        }
        else{ //Si está
            removerElemento(posicion);
            System.out.println("Dato encontrado y eliminado de la pila ");
		System.out.println("tope :"+fin);
        }
    }
	
	@Override
public String toString(){ 
        if(estaVacia()) return "La pila esta vacia!!\n";
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int numSpaces=0;
        sb2.append("|");
        for (int i = 0; i < capacidad; i++) {
            int tam = Entero.longEntero(datos[i]);
            sb2 = sb2.append(datos[i]).append("|");
            if(i==fin) numSpaces = sb2.length()-2-(tam>>1);
        }
        char [] lineas = new char[sb2.length()];
        char [] espacios = new char[numSpaces];
        Arrays.fill(lineas,'-');
        Arrays.fill(espacios,' ');
        sb = sb.append(lineas).append("\n").append(sb2).append("\n").append(lineas).append("\n").append(espacios).append("^\n");//.append(espacios).append("|\n");
        return sb.toString();
	
    }
	
    public boolean estaVacia(){
		System.out.println("tope :"+fin);
        return fin==-1;
		
    }
    public boolean estaLlena(){
        return (fin+1)==capacidad;
    }
    public int verElemento(){ 
        return datos[fin];
    }
    public int getElemento(){
        int x = datos[fin];
        removerElemento();
        return x;
    }
    public void removerElemento(){
        datos[fin--]=0;
	System.out.println("tope :"+fin);
    }
    public void removerElemento(int indice){
        for (int i = indice; i < fin; i++) {
            datos[i] = datos[i+1]; 
        }
        datos[fin--] = 0;
	
    }
    public void insertarElemento(int dato){
        datos[++fin] = dato;
	System.out.println("tope :"+fin);
    }
    public Pila(int capacidad){
        this.capacidad = capacidad;
        datos = new int[capacidad]; 
    }
}
