package es.iessoterohernandez.daw.endes.EjerciciosJunit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SubscripcionTest {
    private Subscripcion subscripcion;

    @BeforeEach
    public void setUp() {
        subscripcion = new Subscripcion(120, 12);
    }

    @Test
    public void testPrecioPorMesPositive() {
        assertEquals(10.0, subscripcion.precioPorMes());
    }

    @Test
    public void testPrecioPorMesZeroPeriod() {
        subscripcion = new Subscripcion(120, 0);
        assertEquals(0.0, subscripcion.precioPorMes());
    }

    @Test
    public void testPrecioPorMesZeroPrice() {
        subscripcion = new Subscripcion(0, 12);
        assertEquals(0.0, subscripcion.precioPorMes());
    }

    @Test
    public void testPrecioPorMesZeroPriceAndPeriod() {
        subscripcion = new Subscripcion(0, 0);
        assertEquals(0.0, subscripcion.precioPorMes());
    }

    @Test
    public void testPrecioPorMesNegativePrice() {
        subscripcion = new Subscripcion(-120, 12);
        assertEquals(0.0, subscripcion.precioPorMes());
    }

    @Test
    public void testPrecioPorMesNegativePeriod() {
        subscripcion = new Subscripcion(120, -12);
        assertEquals(0.0, subscripcion.precioPorMes());
    }

    @Test
    public void testPrecioPorMesNegativePriceAndPeriod() {
        subscripcion = new Subscripcion(-120, -12);
        assertEquals(0.0, subscripcion.precioPorMes());
    }
    
    //Para probar el método cancel() y asegurarse de que establece periodo en 0, 
    //se puede hacer indirectamente a través del método precioPorMes(), que depende del valor de periodo. 

    @Test
    public void testCancel() {
        subscripcion.cancel();
        assertEquals(0, subscripcion.precioPorMes());
    }
}