/**
 * Interfaz que define las operaciones básicas de una pila (Stack).
 *
 * @param <T> Tipo de dato almacenado en la pila.
 */
public interface Stack<T>
{
    /**
     * Agrega un elemento a la pila.
     *
     * @param elemento Elemento a agregar en la pila.
     */
    void push(T elemento);
    /**
     * Extrae y elimina el elemento en la cima de la pila.
     * 
     * @return El elemento extraído de la pila.
     */
    T pop();
    /**
     * Obtiene el número de elementos almacenados en la pila.
     * 
     * @return Cantidad de elementos en la pila.
     */
    int size();
    /**
     * Verifica si la pila está vacía.
     * 
     * @return true si la pila está vacía, false en caso contrario.
     */
    boolean isEmpty();
    /**
     * Duplica la capacidad de almacenamiento de la pila.
     */
    void AumentarCapacidad();
}