package es.iessoterohernandez.daw.endes.CuentaTarjeta;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Date;
import java.util.stream.Stream;

public class CuentaMovimientoTest {

    @Test
    void testIngresar() throws Exception {
        Cuenta cuenta = new Cuenta("123456789", "Titular de prueba");
        cuenta.ingresar(100.0);
        assertEquals(100.0, cuenta.getSaldo());
    }

    @Test
    void testRetirar() throws Exception {
        Cuenta cuenta = new Cuenta("123456789", "Pepe");
        cuenta.ingresar(100.0);
        cuenta.retirar(50.0);
        assertEquals(50.0, cuenta.getSaldo());
    }

    @Test
    void testRetirarSaldoInsuficiente() {
        Cuenta cuenta = new Cuenta("123456789", "Pepe");
        assertThrows(Exception.class, () -> cuenta.retirar(100.0));
    }

    @Test
    void testSetAndGetConcepto() {
        Movimiento movimiento = new Movimiento();
        movimiento.setConcepto("Prueba de concepto");
        assertEquals("Prueba de concepto", movimiento.getConcepto());
    }

    @Test
    void testSetAndGetImporte() {
        Movimiento movimiento = new Movimiento();
        movimiento.setImporte(100.0);
        assertEquals(100.0, movimiento.getImporte());
    }

    @Test
    void testSetAndGetFecha() {
        Movimiento movimiento = new Movimiento();
        Date fecha = new Date();
        movimiento.setFecha(fecha);
        assertEquals(fecha, movimiento.getFecha());
    }

    @ParameterizedTest
    @MethodSource("provideIngresosConConcepto")
    void testIngresarConConcepto(double cantidad, String concepto) {
    	Cuenta cuenta = new Cuenta("123456789", "Pepe");
    	try {
			cuenta.ingresar(concepto, cantidad);
		} catch (Exception ex) {
			System.out.println(concepto + ": " + ex.getMessage());
		}
    }

    @ParameterizedTest
    @MethodSource("provideRetiradasConConcepto")
    void testRetirarConConcepto(double cantidad, String concepto) throws Exception {
        Cuenta cuenta = new Cuenta("123456789", "Pepe");
        try {
			cuenta.ingresar(80D);
			assertThat(cuenta.mMovimientos.size(), is(1));
			cuenta.retirar(concepto, cantidad);
			assertThat(cuenta.mMovimientos.size(), is(2));
			assertEquals(((Movimiento) cuenta.mMovimientos.get(1)).getConcepto(), concepto);
		} catch (Exception ex) {
			System.out.println(concepto + ": " + ex.getMessage());
		}
    }

    private static Stream<Arguments> provideIngresosConConcepto() {
        return Stream.of(
            Arguments.of(50D, "Ingreso nómina"),
            Arguments.of(100D, "Ingreso venta"),
            Arguments.of(0D, "Ingreso por error")
        );
    }

    private static Stream<Arguments> provideRetiradasConConcepto() {
        return Stream.of(
            Arguments.of(50D, "Retirada efectivo"),
            Arguments.of(100D, "Retirada compra"),
            Arguments.of(0D, "Retirada sin concepto")
        );
    }
}
