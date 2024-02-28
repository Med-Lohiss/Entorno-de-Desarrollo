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
import java.util.Vector;
import java.util.stream.Stream;

public class DebitoTest {
    
    Debito debito;
    final String titular = "María", SUPERMARKET = "Supermarket";
    
    @BeforeEach
    void init() {
        debito = new Debito("123", titular, new Date(2024, 1, 1));
        debito.setCuenta(new Cuenta("987654321", titular));
    }
    
    @AfterEach
    void finish() {
        debito = null;
    }
    
    @ParameterizedTest(name = "Ingresar {0}€")
    @MethodSource("cantidades")
    void testIngresarDebitoConCuenta(double cantidad) {
        try {
            debito.ingresar(cantidad);
            assertEquals(debito.getSaldo(), debito.mCuentaAsociada.getSaldo());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @ParameterizedTest(name = "Ingresar {0}€")
    @MethodSource("cantidades")
    void testIngresarDebitoSinCuenta(double cantidad) {
        // NullPointerException
        debito.setCuenta(null);
        assertThrows(NullPointerException.class, () -> debito.ingresar(cantidad));
    }
    
    @ParameterizedTest(name = "Retirar {0}€")
    @MethodSource("cantidades")
    void testRetirarDebitoConCuenta(double cantidad) {
        try {
            debito.retirar(cantidad);
            assertNotEquals(debito.getSaldo(), debito.mCuentaAsociada.getSaldo());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @ParameterizedTest(name = "Retirar {0}€")
    @MethodSource("cantidades")
    void testRetirarDebitoSinCuenta(double cantidad) {
        assertTrue(debito.getSaldo() >= 0);
    }
    
    @ParameterizedTest(name = "Pagar {0}€ en " + SUPERMARKET)
    @MethodSource("cantidades")
    void testPagoEnEstablecimiento(double cantidad) {
        try {
            double saldoAnterior = debito.mCuentaAsociada.getSaldo();
            debito.pagoEnEstablecimiento(SUPERMARKET, cantidad);
            assertEquals(saldoAnterior - cantidad, debito.mCuentaAsociada.getSaldo());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testSaldoTotal() {
        double saldoTotal = cantidades().mapToDouble(Double::doubleValue).sum();
        cantidades().forEach(cantidad -> {
            try {
                debito.ingresar(cantidad);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });
    }
    
    static Stream<Double> cantidades() {
        return Stream.of(0D, 50D, 100D, 200D, 500D);
    }
}



