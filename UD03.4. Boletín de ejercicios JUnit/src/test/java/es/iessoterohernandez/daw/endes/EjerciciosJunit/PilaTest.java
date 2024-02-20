package es.iessoterohernandez.daw.endes.EjerciciosJunit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PilaTest {

	@Test
    public void testPushAndPop() {
        Pila pila = new Pila();
        pila.push(1);
        pila.push(2);
        pila.pop();
        assertTrue(pila.isEmpty());
    }


    @Test
    public void testIsEmpty() {
        Pila pila = new Pila();
        assertTrue(pila.isEmpty());
        pila.push(5);
        assertFalse(pila.isEmpty());
    }

    @Test
    public void testTop() {
        Pila pila = new Pila();
        pila.push(5);
        assertEquals(5, pila.top());
    }

    @Test
    public void testPopEmptyStack() {
        Pila pila = new Pila();
        assertNull(pila.pop());
    }
}
