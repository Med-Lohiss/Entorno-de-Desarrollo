package es.iessoterohernandez.daw.endes.EjerciciosJunit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class OperadorAritmeticoTest {

    @Test
    public void testSuma() {
        assertEquals(5, OperadorAritmetico.suma(2, 3));
    }

    @Test
    public void testDivision() throws Exception {
        assertEquals(2, OperadorAritmetico.division(6, 3));
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(Exception.class, () -> {
            OperadorAritmetico.division(6, 0);
        });
    }
}