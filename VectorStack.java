import java.util.Arrays;

/**
 * Clase que implementa un Stack genérico utilizando un array dinámico.
 * Expande automáticamente su capacidad cuando es necesario.
 *
 * @param <T> Tipo de dato almacenado en la pila.
 */

public class VectorStack<T> implements Stack<T>
{
    private T[] stack;
    private int capacidad;
    private int cantidad;

    /**
     * Constructor de la clase VectorStack.
     * Inicializa la pila con una capacidad predeterminada de 10.
     */

    @SuppressWarnings("unchecked")
    public VectorStack()
    {
        capacidad = 10;
        stack = (T[]) new Object[capacidad];
        cantidad = -1;
    }

    /**
     * Agrega un elemento a la pila.
     * Si la pila alcanza su capacidad máxima, esta se duplica.
     *
     * @param caracter Elemento a agregar en la pila.
     */

    @Override
    public void push(T caracter)
    {
        if (cantidad + 1 == capacidad)
        {
            AumentarCapacidad();
        }
        cantidad++;
        stack[cantidad] = caracter;
    }

    /**
     * Extrae y elimina el elemento en la cima de la pila.
     * 
     * @return El elemento extraído de la pila.
     * @throws IllegalStateException Si la pila está vacía.
     */

    @Override
    public T pop()
    {
        if (this.isEmpty())
        {
            throw new IllegalStateException("Stack vacío.");
        }
        T caracter = this.stack[cantidad];
        this.stack[cantidad] = null;
        cantidad--;
        return caracter;
    }

    /**
     * Verifica si la pila está vacía.
     * 
     * @return true si la pila está vacía, false en caso contrario.
     */

    @Override
    public boolean isEmpty()
    {
        if (this.size()==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Obtiene el número de elementos almacenados en la pila.
     * 
     * @return Cantidad de elementos en la pila.
     */

    @Override
    public int size()
    {
        return this.cantidad + 1;
    }

    /**
     * Duplica la capacidad del array que almacena los elementos de la pila.
     */
    @Override
    public void AumentarCapacidad()
    {
        this.capacidad = 2 * this.capacidad;
        this.stack = Arrays.copyOf(this.stack, this.capacidad);
    }
}