import java.util.Arrays;
public class ColaCircular {
    private String datos[];
    private int tamano;
    private int frente=-1;
    private int fin=-1;
    public int getTamano(){
        return tamano;
    }
    public boolean estaVacia(){
        return (frente==-1)&&(fin==-1);
    }
    public boolean estaLlena(){
        if(frente==0&&fin==(tamano-1)) return true; 
        return fin==(frente-1); 
    }
    public void insertar(String dato){
        if(frente==-1&&fin==-1) frente = fin = 0; 
        else if(fin==(tamano-1)) fin = 0; 
        else fin = fin+1; 
        datos[fin] = dato;
    }
    public void remover(){
        datos[frente] = "null";
        if(fin==frente) fin = frente = -1;
        else if(frente==(tamano-1)) frente = 0;
        else frente=frente+1;
    }
    public String getElemento(){
        String x = datos[frente];
        remover();
        return x;
    }
    public void imprimir(){
		System.out.print("|");
        for (int i = 0; i < tamano; i++) {
            System.out.print(datos[i]+"|");
        }
        System.out.println();
		System.out.println("Frente = "+frente+", Fin = "+fin);
    }

    public ColaCircular(int tamano) {
        this.tamano = tamano;
        datos = new String[tamano];
        Arrays.fill(datos, "null");
    }
}
