import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Stack;

/**
 * Clase de pruebas unitarias para la clase Calculadora.
 */
class CalculadoraTest {

    private Calculadora calc;

    @BeforeEach
    void setUp() {
        calc = new Calculadora();
    }

    @Test
    void testCorroboraTexto() {
        assertEquals(0, calc.CorroboraTexto(' '), "Debe retornar 0 para espacios");
        assertEquals(1, calc.CorroboraTexto('+'), "Debe retornar 1 para operadores válidos");
        assertEquals(2, calc.CorroboraTexto('5'), "Debe retornar 2 para números");
        assertEquals(3, calc.CorroboraTexto('&'), "Debe retornar 3 para caracteres inválidos");
    }

    @Test
    void testOperar() {
        calc.getVector().push(10);
        calc.getVector().push(5);

        assertTrue(calc.Operar('+'), "La suma debería ser exitosa");
        assertEquals(15, (int) calc.getVector().pop(), "El resultado debería ser 15");

        calc.getVector().push(10);
        calc.getVector().push(5);
        assertTrue(calc.Operar('/'), "La división debería ser exitosa");
        assertEquals(2, (int) calc.getVector().pop(), "El resultado debería ser 2");
    }

    @Test
    void testResultadoExpresionValida() {
        String expresion = "10 5 + 3 *"; // (10 + 5) * 3 = 45
        assertEquals(45, calc.Resultado(expresion), "El resultado de la expresión debe ser 45");
    }

    @Test
    void testResultadoExpresionInvalida() {
        String expresion = "10 5 &"; // Expresión inválida por carácter no permitido
        assertEquals(-1, calc.Resultado(expresion), "Debe retornar -1 para expresiones inválidas");
    }

    @Test
    void testOperarStackInsuficiente() {
        calc.getVector().push(10);
        assertFalse(calc.Operar('+'), "La operación debería fallar con un solo elemento en el stack");
    }
}
