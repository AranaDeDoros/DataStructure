import java.util.Scanner;
public class Metodo_Shell{
/**
 *
 * @author Eduardo Daniel Romero Enríquez
 */
 public static void main(String[]args){
 Scanner valor=new Scanner(System.in);

System.out.println("\n--METODO SHELL SORT--");
System.out.println("\n\nIngrese El Numero De Elementos:");
   int p=valor.nextInt();
   int [] a=new int [p];

System.out.println("\n\nIngrese Los Valores Del Arreglo:");
   for(int i=0;i<p;i++){
   a[i]=valor.nextInt();
}
System.out.println("\n\n.....SALIDA DE DATOS.....");
   shellSort(a);   
   for(int i=0;i<p;i++){
System.out.println(+a[i]);
}
  }
public static void shellSort(int []matrix){
   for(int increment=matrix.length/2; increment>0; increment=(increment==2)?1: (int) Math.round(increment/2.2)){
   for(int i=increment;i<matrix.length;i++){
   for(int j=i;j>=increment&&matrix[j-increment]>matrix[j];j-=increment){
   int temp=matrix[j];
   matrix[j]=matrix[j-increment];
matrix[j-increment]=temp;
   }
  }
 }
}
}
