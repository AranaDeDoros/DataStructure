

import java.util.Scanner;

public class Lista{
    
Scanner miEntrada= new Scanner(System.in);

    int datoEdad;
    String datoPuesto;
    String datoSexo;
    int datoHrsTota;
    double datoSueldo=0;  
      
        int datohrsnormales;
        int datohrsextras;
        double datosaldoneto;
       // int salario=100;
        
    NodoLista inicio, fin;
  

    public void Lista() {
        inicio = null;
        fin = null;
    }

    public void InsertarPrincipio(String dd) {
        NodoLista p = new NodoLista();
        p.nombre = dd;
        pedirDatos();
        p.edad=datoEdad;
        p.puesto=datoPuesto;
        p.sexo=datoSexo;
        p.HrsTota=datoHrsTota;
        p.sueldo=datoSueldo;
        calculo();
        p.hrsnormales=datohrsnormales;
        p.hrsextras=datohrsextras;
        p.saldoneto=datosaldoneto;
        
        if (LSLVacia()) {      
//        p.sexo=datoSexo;
//        p.HrsTota=datoHrsTota;
//        calculo();
//        p.hrsnormales=datohrsnormales;
//        p.hrsextras=datohrsextras;
            inicio = fin = p;
        } else {
            p.next = inicio;
            inicio = p;
        }
    }

    public void InsertarDespuesDe(String dd) {
        NodoLista anterior = inicio;
        boolean encontrado = false;
        
        

        while (anterior != null) {
            if (dd.equals(anterior.nombre)) {
                encontrado = true;
                break;
            }
            anterior = anterior.next;
        }

        if (encontrado) {
            System.out.println("Ingresa el nombre:\t"); 
            String dd2= miEntrada.next();
            pedirDatos();
            NodoLista aux = new NodoLista();
            
            aux.nombre = dd2;
            aux.edad = datoEdad;
            aux.puesto = datoPuesto;
            aux.sexo = datoSexo;
            aux.sueldo = datoSueldo;
            calculo();
            aux.HrsTota = datoHrsTota;
            aux.hrsnormales = datohrsnormales;
            aux.hrsextras = datohrsextras;
            aux.saldoneto = datosaldoneto;
            
            aux.next = anterior.next;
            anterior.next = aux;

            if (aux.next == null) {
                fin = aux;
            } else {
            }
        } else {
            System.out.println("No existe referencia " + dd + " en la lista");
        }
    }
    
    public void InsertarAntesDe(String dd){
    
    NodoLista anterior = inicio;
    NodoLista anterior2 = inicio;
        
        boolean encontrado = false;
        boolean band=true;
        int cont = 0;
        
            while (anterior != null&&band) {
                if (dd.equals(anterior.nombre)) {
                    encontrado = true;
                    //band =false;
              
                    if(cont==0){
                   System.out.println("Su Trabajador de referencia se encuentra en el primer lugar, es recomendable Usar la Opcion [1]");
                   band = false;
                    }
                    
                    break;
                }
                anterior = anterior.next;
               if(cont>0){
               anterior2=anterior2.next;
               } 
                
                cont++;
            }
            
        
if(band){
        if (encontrado) {
            System.out.println("Ingresa el nombre:\t"); 
            String dd2= miEntrada.next();
            pedirDatos();
            NodoLista aux = new NodoLista();
            
            aux.nombre = dd2;
            aux.edad = datoEdad;
            aux.puesto = datoPuesto;
            aux.sexo = datoSexo;
            aux.sueldo = datoSueldo;
            calculo();
            aux.HrsTota = datoHrsTota;
            aux.hrsnormales = datohrsnormales;
            aux.hrsextras = datohrsextras;
            aux.saldoneto = datosaldoneto;
            
            aux.next = anterior2.next;
            anterior2.next = aux;

            if (aux.next == null) {
                fin = aux;}
        }else {
            System.out.println("No existe referencia" + dd + "en la lista");
        }
}
    }

    public void eliminarDespuesDe(String dd) {
        NodoLista anterior = inicio;
        
        boolean encontrado = false;

        while (anterior != null) {
            if (dd.equals(anterior.nombre)) {
                encontrado = true;
                break;
            }
            anterior = anterior.next;
        }

        if (encontrado) {
            anterior = anterior.next;
            if (anterior != null) {
                this.retirar(anterior.nombre);
            } else {
                System.out.println("No hay datos");
            }
        } else {
            System.out.println("No existe referencia" + dd + "en la lista");
        }
    }
    
    public void eliminarAntesDe(String dd){
    NodoLista anterior = inicio;
    NodoLista anterior2 = inicio;
      
    
    boolean encontrado = false;
        boolean band =true ;
        int cont=0;
        
       
         while (anterior != null&&band) {
                if (dd.equals(anterior.nombre)) {
                    encontrado = true;
              
                    if(cont==0){
                   System.out.println("Su Trabajador de referencia se encuentra en el primer lugar, no es posible Eliminar]");
                   band = false;
                    }
                    break;
                }
                
                anterior = anterior.next;
               
                if(cont>0){
               anterior2=anterior2.next;
               } 
                
                cont=cont+1;
            }
        
        
        if(band){
        if (encontrado) {
            //anterior2 = anterior2.next;
            if (anterior2 != null) {
                this.retirar(anterior2.nombre);
            } else {
                System.out.println("No hay datos");
            }
        } else {
            System.out.println("No existe referencia" + dd + "en la lista");
        }
        }
    
    }

    public void insertarEnOrden(String dd) {
        NodoLista aux = new NodoLista();
        pedirDatos();
        aux.nombre = dd;
        aux.edad=datoEdad;
        aux.puesto=datoPuesto;
        aux.sexo=datoSexo;
        aux.HrsTota=datoHrsTota;
        aux.sueldo = datoSueldo;
        calculo();
        aux.hrsnormales=datohrsnormales;
        aux.hrsextras=datohrsextras;
        aux.saldoneto=datosaldoneto;

        if (LSLVacia()) {
            inicio = fin = aux;
        } else {
            NodoLista ant = null;
            NodoLista act = inicio;
            boolean encontrado = false;

            while (act != null) {
                if (dd != (act.nombre)) {
                } else {
                    encontrado = true;
                    break;
                }
                ant = act;
                act = act.next;
            }
            if (encontrado) {
                if (act == inicio) {
                    aux.next = inicio;
                    inicio = aux;
                } else {
                    aux.next = ant.next;
                    ant.next = aux;
                }
            } else {
                aux.next = null;
                ant.next = aux;
                fin = aux;
            }
        }
    }

    public void insertarAlFinal(String dd) {
        NodoLista aux = new NodoLista();
        aux.nombre = dd;

        if (LSLVacia()) {
            inicio = fin = aux;
        } else {
            fin.next = aux;
            fin = aux;
        }
    }
    
    public String retiraAlPrincipio() {
        String dd = null;
        if (!LSLVacia()) {
            System.out.println("\nEl trabajador "+inicio.nombre+ " fue Eliminado");
            dd = inicio.nombre;
            inicio = inicio.next;

            if (inicio == null) {
                fin = null;
            }
        } else {
            System.out.println("Nomina sin trabajadores para eliminar");
        }
        return dd;
    }

    public String retiraAlFinal() {
        String dd = null;

        if (!LSLVacia()) {
            System.out.println("\nEl trabajador "+fin.nombre+" fue Eliminado");
            dd = fin.nombre;
            if (inicio == fin) {
                inicio = fin = null;
                return dd;
            }

            NodoLista ant = inicio;
            NodoLista act = inicio.next;

            while (act != fin) {
                ant = act;
                act = act.next;
            }
            ant.next = null;
            fin = ant;
            act = null;
        } else {
            System.out.println("Nomina Sin trabajadores para eliminar");
        }
        return dd;
    }

    public void retirar(String dd) {
        if (!LSLVacia()) {
            NodoLista ant = null;
            NodoLista act = inicio;
            boolean encontrado = false;

            while (act != null) {
                if (dd.equals(act.nombre)) {
                    encontrado = true;
                    break;
                } else {
                    ant = act;
                    act = act.next;
                }
            }

            if (!encontrado) {
                System.out.println("no existe la referencia");
            } else {
                if (inicio == fin) {
                    inicio = fin = act = null;
                } else if (act == inicio) {
                    inicio = inicio.next;
                    act = null;
                } else if (act == fin) {
                    ant.next = null;
                    fin = ant;
                    act = null;
                } else {
                    ant.next = act.next;
                    act = null;
                }
                System.out.println("Dato " + dd + " fue eliminado");
            }
        } else {
           System.out.println("Nomina Sin trabajadores para mostrar");
        }
    }

    public void recorrer() {
        String imprime = "";
        if (LSLVacia()) {
            System.out.println("Tu la Nomina aun no Existen trabajadores");
        } else {
            NodoLista aux = inicio;
            while (aux != null) {
                imprime = imprime +"\t:Nombre\t\t Edad\t\t Puesto\t\t  Salario:\n\t"+ aux.nombre + "\t\t"+aux.edad+"\t\t"+aux.puesto+"\t\t\t"+aux.sueldo+":\n\t||HrsTotales\tHrsNormales\tHrsExtras\tSaldoNeto||:\n\t||  "+aux.HrsTota+"\t\t  "+aux.hrsnormales+"\t\t   "+aux.hrsextras+"\t\t  "+aux.saldoneto+""+"||\n";
                aux = aux.next;
            }
            System.out.println(imprime);
        }
    }
    public void buscar(String dd){
    NodoLista buscador = inicio;
    boolean encontrado=false;
        while (buscador != null) {
            if (dd.equals(buscador.nombre)) {
                encontrado = true;
                break;
            }
            buscador = buscador.next;
        }

        if (encontrado) {
        String imprime;
        imprime="\n Nombre: "+ buscador.nombre+"\n Edad: "+buscador.edad+"\n Puesto: "+buscador.puesto+"\n Sexo: "+buscador.sexo+"\n Hrs Totales"+buscador.HrsTota+"\n Hrs.Normales: "+buscador.hrsnormales+"\n HrsExtras: "+buscador.hrsextras+"\n Sueldo: "+buscador.sueldo+"\n SaldoNeto: "+buscador.saldoneto;
            System.out.println("\n-----Datos Trabajador Encontrado------\n"+imprime);
        }else{
            System.out.println("\n\tTrabajador no encontrado\n");
        }
    }

    public boolean LSLVacia() {
        return (inicio == null);
    }
public void pedirDatos(){
    boolean band=true;
    boolean band2=true;
    datoSueldo=0;
    
     do{
    System.out.print("Ingrese la Edad   \t");
    datoEdad=miEntrada.nextInt();
    if(datoEdad>17&&datoEdad<81){
    band=false;
    }else {
        if(datoEdad<18&&datoEdad>0){
        System.out.println("Requiero Mayoria de edad, Intentalo de nuevo");
        band=true;}
        if(datoEdad<=0){
            System.out.println("Requiero Dato Positivo o Diferente de Cero");
        }
        if(datoEdad>=81){
            System.out.println("La Edad Debe de ser menor a 80 años");
        band = true;
        }
    }
    
    }while(band);
    
    
    System.out.print("Ingrese el puesto\t");
    datoPuesto =miEntrada.next();
    System.out.print("Ingrese el sexo   \t");
    datoSexo = miEntrada.next();
    do{
    System.out.print("Ingrese el sueldo del trabajador\t");
    datoSueldo = miEntrada.nextDouble();
    if (datoSueldo<0){
        System.out.println("El sueldo debe ser mayor que Cero");
        band2=true;
    }
    else{
    band2=false;
    }
    }while(band2);
    
    do{
    System.out.print("Ingrese la hrs totales de trabajo\t");
    datoHrsTota = miEntrada.nextInt();
    if(datoHrsTota>50||datoHrsTota<0){
    System.out.println("El Numero de HRs que ingreso no es permitida, Intentelo de Nuevo");
        band=true;
    }else {
        
        band=false;}
    }while(band);
}
        
    public void calculo(){
    int aux1;
        datohrsnormales=0;
        datohrsextras=0;
    
    if(datoHrsTota>40){
            datohrsnormales=40;
            datohrsextras= datoHrsTota-datohrsnormales;
            aux1= (int) (datohrsextras *(datoSueldo*2));
            datosaldoneto=(datohrsnormales*datoSueldo)+aux1;
        }else{
       datohrsnormales=datoHrsTota;
        datosaldoneto=datoHrsTota*datoSueldo;  
        }
    }
   
}