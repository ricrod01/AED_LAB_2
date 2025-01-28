import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Main
{
    public static void main(String[] args)
    {
        String ruta = "Ecuacion.txt";
        String linea = null;

        try (BufferedReader lector = new BufferedReader(new FileReader(ruta)))
        {
            linea = lector.readLine();
        }
        catch (IOException e)
        {
            System.err.println("No se pudo leer el archivo. " + e.getMessage());
        }

        if(linea != null)
        {
            Calculadora calculadora = new Calculadora();
            System.out.println(calculadora.Resultado(linea));
            
        }
        else
        {
            System.out.println("Archivo vacío.");
        }
    }
}