package es.iessoterohernandez.daw.endes.EjerciciosJunit;

import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

public class AccountTest {

    private Account acc;

    @BeforeEach
    public void setUp() {
        acc = new Account("Juan Perez", 123456789, 1000);
    }

    @Test
    public void testDeposit() {
        assertTrue(acc.deposit(500)); // Depositar una cantidad válida
        assertFalse(acc.deposit(-100)); // Depositar una cantidad negativa
        assertEquals(1500, acc.getBalance(), 0); // Verificar el balance después del depósito
    }

    @Test
    public void testWithdraw() {
        assertTrue(acc.withdraw(500, 0)); // Retirar una cantidad válida sin cargo
        assertFalse(acc.withdraw(-100, 0)); // Retirar una cantidad negativa
        assertFalse(acc.withdraw(2000, 0)); // Retirar más de lo que hay en la cuenta
        assertFalse(acc.withdraw(500, 100)); // Intentar retirar con un cargo mayor al balance
        assertEquals(500, acc.getBalance(), 0); // Verificar el balance después de retirar
    }

    @Test
    public void testAddInterest() {
        acc.addInterest();
        assertEquals(1045, acc.getBalance(), 0); // Verificar el balance después de aplicar el interés
    }

    @Test
    public void testToString() {
        assertEquals("123456789\tJuan Perez\t$1,000.00", acc.toString()); // Verificar el formato de la cadena toString()
    }

    @Test
    public void testGetBalance() {
        assertEquals(1000, acc.getBalance(), 0); // Verificar el balance inicial
    }

    @Test
    public void testGetAccountNumber() {
        assertEquals(123456789, acc.getAccountNumber()); // Verificar el número de cuenta
    }
    
    //El defecto sutil en la clase Account está relacionado con el uso de tipos de datos de punto flotante (float) 
    //para representar valores monetarios. Esto puede llevar a imprecisiones en los cálculos.
    //La siguiente prueba verifica si el balance de la cuenta es preciso después de realizar múltiples transacciones de depósito y retiro.
    //Si hay alguna imprecisión debido al uso de tipos de datos de punto flotante, esta prueba lo revelará.
    
    @Test
    public void testMultipleTransactions() {
        acc.deposit(0.1f); // depositar $0.10
        acc.withdraw(0.05f, 0); // retirar $0.05 sin cargo
        acc.deposit(0.1f); // depositar $0.10 nuevamente

        // Verificar que el balance sea preciso después de múltiples transacciones
        assertEquals(1000.15, acc.getBalance(), 0.001); // Se usa un delta pequeño debido a la naturaleza de los flotantes
    }
}
