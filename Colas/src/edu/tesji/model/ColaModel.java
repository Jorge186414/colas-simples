package edu.tesji.model;

import javax.swing.JOptionPane;

public class ColaModel {

    // Encapsulamiento de 2 variables de tipo NodoModel que funcionaran como punteros
    // inicioCola nos mostrara el primer valor en la cola, y finalCola que nos mostrara 
    // cual es el ultimo en la cola.
    private NodoModel inicioCola, finalCola;

    //Variable que nos ayudara a saber cual es el contenido de la cola.
    String Cola = "";

    //Contructor con el mismo nombre que la clase.
    public ColaModel() {

        //Nuestra variable inicioCola va a apuntar a null por que al inicio de la ejecucion
        //de nuestro programa no va a haber ningun valor en cola, los mismo va a pasar con 
        //la variable finalCola.
        inicioCola = null;
        finalCola = null;
    }

    // Método para saber si la cola esta vacia.
    public boolean ColaVacia() {

        //Declaracion de un condicional if en donde si la variable inicioCola es igual a un 
        //valor null o que la cola este vacia nos retorna un valor verdadero o true.
        if (inicioCola == null) {
            return true;
        } else {

            //En caso contrario nos retornara un valor falso o false.
            return false;
        }
    }

    // Método para insertar datos o valores a la cola, como este metodo va a ingresar 
    // datos a la cola va a ser necesario que reciba un valor de tipo int por que la 
    // cola va a recibir numeros enteros.
    public void Insertar(int informacion) {

        //Creacion de objeto para conectar con la clase NodoModel.
        NodoModel nodos = new NodoModel();

        // Con esto le damos a la variable informacion de la clase NodoModel el valor 
        // que recibe el metodo como parametro en este caso informacion.
        nodos.informacion = informacion;

        // Ahora le damos un valor null a la variable siguiente de la clase NodoModel
        // ya que al ser el ultimo valor en la lista no tiene hacia donde apuntar.
        nodos.siguiente = null;

        // Realizamos un condicional if en el que se manda a llamar al metodo ColaVacia,
        // si la cola esta vacia el valor de la variable inicioCola va a ser igual al 
        // valor nuevo que estamos añadiendo, y el elemento que esta al final de la cola
        // va a ser el mismo.
        if (ColaVacia()) {
            inicioCola = nodos;
            finalCola = nodos;
        } else {

            // En caso contrario el valor de finalCola en su campo siguiente va a ser 
            // el valor al que va a apuntar, es decir, va a apuntar el valor nuevo agregado.
            finalCola.siguiente = nodos;

            // El valor de finalCola va a ser igual al valor nuevo agregado a la cola.
            finalCola = nodos;
        }
    }

    // Método para extraer de la cola.
    public int Extraer() {

        // Creamos un condicional en el que se el valor de la cola sea completamente 
        // diferente de vacia.
        if (!ColaVacia()) {

            // Si la condicion se cumple a la variable informacion se le asignara el valor
            // que este al inicio de la cola en el campo informacion.
            int informacion;
            informacion = inicioCola.informacion;

            // Creamos otro condicional para verificar que el valor que esta al inicio 
            // de la cola sea igual al valor que esta al final de la cola, si esta condicion
            // se cumple quiere decir que el elemento que estamos viendo es el ultimo
            // valor en estar dentro de la cola.
            if (inicioCola == finalCola) {

                // Como la condicion se cumplio nuestro punteros no pueden apuntar hacia
                // un nuevo valor por lo que les asignamos un valor nulo.
                inicioCola = null;
                finalCola = null;
            } else {

                // En caso de que no sea el ultimo valor dentro de la cola el valor de la
                // variable inicioCola va a ser igual al valor de inicioCola en su campo siguiente.
                inicioCola = inicioCola.siguiente;
            }

            //Nos va a retornar el valor que se extrajo de nuestra cola.
            return informacion;
        } else {
            return Integer.MAX_VALUE;//Podemos colocar un 0, pero por buenas practicas no lo hacemos
        }
    }

    // Método para mostrar el contenido de la cola.
    public String MostrarContenido() {

        // Creacion de una varibale del tipo NodoModel a la que le damos el valor de inicioCola, lo 
        // cual nos sirve para indicar que debe apuntar al inicio de nuestra cola.
        NodoModel recorrido = inicioCola;

        // Variable de tipo String en la que guardaremos el valor de la cola invertida.
        String ColaInvertida = "";

        // Ciclo while en el que se evalua que mientras el valor de la variable o puntero 
        // recorrido sea completamente diferente de un valor nulo lo que quiere decir que debe seguir
        // ejecutandose.
        while (recorrido != null) {
            // A la variable Cola creada al principio le vamos a dar un acumulador, con el apuntador
            // recorrido en el campo de informacion va a ir viendo todos los valores de la cola.
            Cola += recorrido.informacion + " ";

            // Ahora al apuntador recorrido le daremos el valor que hay en siguiente con la intencion 
            // de ver cuales son los valores siguientes en la cola.
            recorrido = recorrido.siguiente;
        }

        // Creamos un arreglo unidimensional, el cual va a ser igual a los valores que hay guardados 
        // en la variable cola, haremos uso del metodo split con el que invertiremos nuestra cadena
        // de caractares guardados en la variable Cola, en los parentesis del metodo split agregamos
        // " ", para que al momento de ir invirtiendo la cadena de caracteres valla agregando un 
        // espacio entre los numeros que hay en la cola.
        String cadena[] = Cola.split(" ");

        // Creamos un ciclo for en donde comenzaremos dandole un valor a i el cual sera el ancho que 
        // se guardo en el arreglo unidimensional cadena al cual le agregamos un -1 para evitar un 
        // error de desbordamiento de memoria, es decir, un NullPointerExeption.
        // Seguido de esto declaramos hasta donde queremos que se detenga nuestro ciclo, colocaremos
        // que se detendra cuando el valor de i sea igual o mayor a 0 ya que estamos recorriendo de
        // adelante hacia atras nuestro arreglo cadena.
        // Por ultimo el ciclo va a ir en decremento de uno en uno desde el ancho del arreglo cadena 
        // hasta que i sea mayor o igual a 0.
        for (int i = cadena.length - 1; i >= 0; i--) {

            // Ahora ala variable ColaInvertida le asignaremos un acumulador, las comillas con el 
            // espacio las agregamos para que nos valla generando un espacio entre los valores que
            // se guardaron el el arreglo cadena, y a este le concatenaremos el valor que se guardo
            // en el arreglo en la posicion de i que va a ir cambiando hasta que se termine el 
            // ciclo for.
            ColaInvertida += " " + cadena[i];
        }

        // Como los valores de la variable Cola se invirtieron y durante el proceso del metodo 
        // MostrarContenido se guardaron en la variable ColaInvertida tendremos que limpiar esta
        // variable.
        Cola = "";
        // Como con este metodo queremos que nos muestre los valores de la cola en un TextAre en 
        // nuestra interfaz el valor que regresara el metodo sera lo que hay en la variable 
        // ColaInvertdia cuyos valores cambiaron en la ejecucion del ciclo for.
        return ColaInvertida;
    }
}
