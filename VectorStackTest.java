import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Clase de pruebas unitarias para la clase VectorStack.
 */
class VectorStackTest {

    private VectorStack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new VectorStack<>();
    }

    @Test
    void testPush() {
        stack.push(10);
        stack.push(20);
        assertEquals(2, stack.size(), "La pila debe tener 2 elementos después de realizar dos push");
        assertEquals(20, stack.pop(), "El último elemento agregado debe ser 20");
    }

    @Test
    void testPop() {
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.pop(), "El primer pop debe retornar 20");
        assertEquals(10, stack.pop(), "El segundo pop debe retornar 10");
        assertThrows(IllegalStateException.class, stack::pop, "La pila vacía debe lanzar una excepción al hacer pop");
    }

    @Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty(), "La pila debe estar vacía al inicio");
        stack.push(10);
        assertFalse(stack.isEmpty(), "La pila no debe estar vacía después de hacer un push");
        stack.pop();
        assertTrue(stack.isEmpty(), "La pila debe estar vacía después de hacer un pop de su único elemento");
    }

    @Test
    void testSize() {
        assertEquals(0, stack.size(), "El tamaño inicial de la pila debe ser 0");
        stack.push(10);
        stack.push(20);
        assertEquals(2, stack.size(), "El tamaño de la pila debe ser 2 después de dos push");
        stack.pop();
        assertEquals(1, stack.size(), "El tamaño de la pila debe ser 1 después de un pop");
    }

    @Test
    void testAumentarCapacidad() {
        for (int i = 1; i <= 11; i++) {
            stack.push(i);
        }
        assertEquals(11, stack.size(), "La pila debe tener 11 elementos después de 11 push");
        assertDoesNotThrow(() -> stack.push(12), "El push adicional no debe lanzar una excepción");
        assertEquals(12, stack.size(), "El tamaño de la pila debe ser 12 después de otro push");
    }
}
