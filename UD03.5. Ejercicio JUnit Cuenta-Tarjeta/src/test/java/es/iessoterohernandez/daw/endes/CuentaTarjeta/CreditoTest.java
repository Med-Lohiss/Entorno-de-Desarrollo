package es.iessoterohernandez.daw.endes.CuentaTarjeta;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Date;
import java.util.stream.Stream;

public class CreditoTest {
    
    Credito credito;
    final String titular = "Juan", TIENDA = "Tienda";
    
    @BeforeEach
    void init() {
        credito = new Credito("456", titular, new Date(2024, 1, 1), 500D);
        credito.setCuenta(new Cuenta("987654321", titular));
    }
    
    @AfterEach
    void finish() {
        credito = null;
    }
    
    @ParameterizedTest(name = "Ingresar {0}€")
    @MethodSource("cantidades")
    void testIngresarCreditoConCuenta(double cantidad) {
        try {
            credito.ingresar(cantidad);
            assertEquals(credito.getSaldo(), credito.mCuentaAsociada.getSaldo());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @ParameterizedTest(name = "Ingresar {0}€")
    @MethodSource("cantidades")
    void testIngresarCreditoSinCuenta(double cantidad) {
        // NullPointerException
        credito.setCuenta(null);
        assertThrows(NullPointerException.class, () -> credito.ingresar(cantidad));
    }
    
    @ParameterizedTest(name = "Retirar {0}€")
    @MethodSource("cantidades")
    void testRetirarCreditoConCuenta(double cantidad) {
        try {
            credito.retirar(cantidad);
            assertNotEquals(credito.getSaldo(), credito.mCuentaAsociada.getSaldo());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @ParameterizedTest(name = "Retirar {0}€")
    @MethodSource("cantidades")
    void testRetirarCreditoSinCuenta(double cantidad) {
        assertDoesNotThrow(() -> credito.retirar(cantidad));
        assertTrue(credito.getSaldo() >= 0);
    }
    
    @ParameterizedTest(name = "Realizar pago de {0}€ en " + TIENDA)
    @MethodSource("cantidades")
    void testPagoEnEstablecimiento(double cantidad) {
        try {
            credito.pagoEnEstablecimiento(TIENDA, cantidad);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testSaldoTotal() {
        double saldoTotal = cantidades().mapToDouble(Double::doubleValue).sum();
        cantidades().forEach(cantidad -> {
            try {
                credito.ingresar(cantidad);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });
        assertEquals(saldoTotal, credito.getSaldo());
    }
    
    static Stream<Double> cantidades() {
        return Stream.of(0D, 50D, 100D, 200D, 500D);
    }
}
