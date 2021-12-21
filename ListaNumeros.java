/**
 * Un objeto de esta clase
 * guarda una lista de n�meros enteros
 * 
 * La clase incluye una serie de m�todos de instancia
 * para hacer operaciones sobre la lista
 * y dos  m�todos est�ticos para trabajar con
 * arrays de dos dimensiones
 *
 * @author -
 */


import java.util.Random;
import java.util.Arrays;

    public class ListaNumeros {
    public static final int DIMENSION = 10;
    public static final int ANCHO_FORMATO = 6;
    public static final char CAR_CABECERA = '-';

    private static final Random generador = new Random();
    //TODO
    public int[] lista;
    public int pos;
    
    
    
    

    /**
     * Constructor de la clase ListaNumeros
     * Crea e inicializa adecuadamente los
     * atributos
     *
     * @param n el tama�o m�ximo de la lista
     */
    public ListaNumeros(int n) {
        //TODO
        lista = new int[n];
        
    }

    /**
     * A�ade un valor al final de la lista 
     * siempre que no est� completa
     *
     * @param numero el valor que se a�ade.  
     * @return true si se ha podido a�adir, false en otro caso
     */
    public boolean addElemento() {
        //TODO
        if(estaCompleta()){
            return false;
        }else{
            return true;
        }
            


    }

    /**
     * @return true si la lista est� completa, false en otro caso
     * Hacer sin if
     */
    public boolean estaCompleta() {
        //TODO
        return pos == lista.length;

    }

    /**
     * @return true si la lista est� vac�a, false en otro caso.
     * Hacer sin if
     */
    public boolean estaVacia() {
       //TODO
        return pos == 0;
    }

    /**
     * @return el n� de elementos realmente guardados en la lista
     */
    public int  getTotalNumeros() {
        //TODO
        return pos;
    }

    /**
     * Vac�a la lista
     */
    public boolean vaciarLista() {
       //TODO
       return pos == 0;
    }

    /**
     * @return una cadena con representaci�n textual de la lista 
     * (leer enunciado)
     * 
     * Si la lista est� vac�a devuelve ""
     */
    public String toString() {
       //TODO
       String str = "";
       if(estaVacia()){
           for ( int i = 0; i <=ANCHO_FORMATO; i++){
               str += CAR_CABECERA;
           }
       }
       
       
       
       return "";
    }

     

    /**
     * Mostrar en pantalla la lista
     */
    public void escribirLista() {
        System.out.println(this.toString());
    }

    /**
     *  
     * @return el segundo valor m�ximo en la lista
     * Cuando no haya un segundo m�ximo el m�todo 
     * devolver� el valor Integer.MIN_VALUE
     * 
     * Si lista = {21, -5, 28, -7, 28, 77, 77, -17, 21, 15, 28, 28, 77} se devuelve 28
     * Si lista = {21, -5, 28, -7, 77} se devuelve 28
     * Si lista = {77, 21} se devuelve 21
     * Si lista = {21} se devuelve Integer.MIN_VALUE
     * Si lista = {21, 21, 21, 21} se devuelve Integer.MIN_VALUE
     * 
     * No se puede usar ning�n otro array auxiliar ni hay que ordenar previamente
     * la lista
     */
    public int segundoMaximo() {       
       //TODO
         
       if (lista.length ==1)
       return Integer.MIN_VALUE;
       int max = lista[0];
       int segundoMax = lista[0];
       
       for ( int i = 1; i<lista.length; i++){
           if(max < lista[i])
           max = lista[i];
       }
       for ( int i = 1; i<lista.length;i++){
           if(segundoMax<lista[i]&& max!= lista[i])
           segundoMax = lista[i];
       }
       if (max == segundoMax)
       return Integer.MIN_VALUE;
    
       return segundoMax;
    
    }

    /**
     * El m�todo coloca los valores que son segundos m�ximos al principio de
     * la lista respetando el orden de aparici�n del resto de elementos
     * 
     * No se puede usar ning�n otro array auxiliar ni hay que ordenar previamente
     * la lista
     * 
     * Si lista = {21, -5, 28, -7, 28, 77, 77, -17, 21, 15, 28, 28, 77} 
     * lista queda  {28, 28, 28, 28, 21, -5, -7, 77, 77, -17, 21, 15, 77} y se devuelve true
     * 
     * Si lista = {77, 21} lista queda {21, 77} y se devuelve true
     * Si lista = {21} lista queda igual y se devuelve false
     * Si lista = {21, 21, 21, 21} lista queda igual y se devuelve false
     * 
     * @return true si se han colocado los segundos m�ximos
     *          false si no se han colocado los segundos m�ximos porque no hab�a ninguno
     */
    public boolean segundosMaximosAlPrincipio() {
        //TODO
        
        int x = 0;
        if(lista.length <= 1){
            return false;
        }else
        
        {
            for( int i = 0; i < lista.length; i++) {
                if (lista[i] == segundoMaximo()){
                    for (int j = 0; j<0;j++){
                        lista[j] = lista[j +1];
                    }
                    lista[x] = segundoMaximo();
                    x++;
                }
            }
        }
        
        
        return true;
        

    }

    /**
     * @param numero b�squeda binaria de  numero en lista
     * @return devuelve -1 si no se encuentra o la posici�n en la que aparece
     *  
     * El array original lista no se modifica
     * Para ello crea  previamente una copia
     * de lista y trabaja  con la copia
     *  
     * Usa exclusivamente m�todos de la clase Arrays
     */
    public int buscarBinario(int num) {
         //TODO
         int[] listacopy = Arrays.copyOf(lista,lista.length);
         
         if(Arrays.binarySearch(listacopy,num)>-1){
             for (int i = 0;i<listacopy.length; i++){
                 if (listacopy [i] == num){
                     return i;
                 }
                 
                 
             }
         }
         
         return -1;

    }

    /**
     * 
     * @return devuelve un array bidimensional de enteros de tama�o DIMENSION
     * inicializado con valores aleatorios entre 0 y 10 inclusive
     * 
     * Estos valores van a representar el brillo de una zona del espacio
     * 
     */
    public static int [][] crearBrillos() {
       //TODO
       int i = 0;
       int[][]brillos = new int[DIMENSION][DIMENSION];
       for ( i = 0; i<brillos.length; i++){
           for (int j = 0; j<brillos[0].length; j++){
               brillos[i][j] = generador.nextInt(10)+1;
               
           }
       }
       return brillos;
       

    }

    /**
     * @param  un array bidimensional brillos 
     * @return un nuevo array bidimensional de valores booleanos
     *          de las mismas dimensiones que el array brillos con
     *          valores true en las posiciones donde hay estrellas
     * 
     * Una posici�n f,c del array brillos es una estrella 
     * si la suma del valor de los brillos de sus cuatro vecinos 
     * (arriba, abajo, derecha e izquierda) es mayor que 30
     * 
     * Nota -  No hay estrellas en los bordes del array brillos
     */
    public void detectarEstrellas() {
       //TODO
       int x = 0;
       
       
    }

}
