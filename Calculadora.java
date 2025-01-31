import java.util.Arrays;
import java.util.List;

/**
 * Clase que representa una Calculadora basada en un Stack.
 * Permite evaluar expresiones matemáticas utilizando notación polaca inversa.
 */

public class Calculadora
{
    private Stack<Integer> vector;
    private List<Character> operaciones;

/**
     * Constructor de la clase Calculadora.
     * Inicializa la pila y define los operadores soportados.
     */
    public Calculadora()
    {
        this.vector = new VectorStack<>();
        this.operaciones = Arrays.asList('+', '-', '*', '/', '%');
    }

/**
     * Método que verifica el tipo de carácter proporcionado.
     * 
     * @param caracter Carácter a evaluar.
     * @return 0 si es un espacio en blanco, 
     *         1 si es una operación válida (+, -, *, /, %),
     *         2 si es un número,
     *         3 si es un carácter inválido.
     */

    public int CorroboraTexto(char caracter)
    {
        if (caracter == ' ')
        {
            return 0;
        }
        else if (operaciones.contains(caracter))
        {
            return 1;
        }
        else
        {
            try
            {
                int numero = caracter - '0';
                return 2;    
            } 
            catch (NumberFormatException e)
            {
                return 3;
            }
        }
    }

    /**
     * Método que realiza una operación matemática utilizando los valores guardados en la pila.
     * 
     * @param caracter Operador matemático a aplicar (+, -, *, /, %).
     * @return true si la operación fue exitosa, false si la operación no pudo realizarse.
     */

    public boolean Operar(char caracter)
    {
        if(this.vector.size()>=2)
        {
            int a = (int) this.vector.pop();
            int b = (int) this.vector.pop();

            if(caracter == '+')
            {
                this.vector.push(a+b);
            }
            else if(caracter == '-')
            {
                this.vector.push(b-a);
            }
            else if(caracter == '*')
            {
                this.vector.push(a*b);
            }
            else if(caracter == '/')
            {
                this.vector.push(b/a);
            }
            else if(caracter == '%')
            {
                this.vector.push(a%b);
            }
            else
            {
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * Método que evalúa una expresión matemática en formato de cadena y devuelve el resultado.
     * La expresión debe estar en notación polaca inversa.
     * 
     * @param linea Expresión matemática a evaluar.
     * @return El resultado de la operación si es válida, -1 si la operación es inválida.
     */
    
    public int Resultado(String linea)
    {
        String numero_str = "";
        boolean flag_blanco = true;
        boolean flag_numero = false;
        boolean flag_op = false;
        int conteo = 0;
            
        while (conteo <= linea.length() - 1 && flag_blanco)
        {
            char car = linea.charAt(conteo);
            int opcion = this.CorroboraTexto(car);

            if(conteo == linea.length()-1 && opcion == 2)
            {
                flag_blanco = false;
            }
            else if (opcion == 0)
            {
                if(!flag_numero && !flag_op && conteo < linea.length()-1)
                {
                    flag_blanco = false;
                }
                if (flag_numero)
                {
                    int numero = Integer.parseInt(numero_str);
                    this.vector.push(numero);
                    numero_str = "";
                    flag_numero = false;
                }
                if (flag_op)
                {
                    flag_op = false;
                }
            }
            else if (flag_op)
            {
                flag_blanco = false;
            }
            else if (opcion == 1)
            {
                if(this.Operar(car))
                {
                    flag_op = true;
                }
                else
                {
                    flag_blanco = false;
                }
            }
            else if (opcion == 2)
            {
                numero_str = numero_str + car;
                flag_numero = true;
            }
            else if (opcion == 3)
            {
                flag_blanco = false;
            }
            conteo += 1;
        }

        if (flag_blanco)
        {
            return this.vector.pop();
        }
        return -1;
    }
}

