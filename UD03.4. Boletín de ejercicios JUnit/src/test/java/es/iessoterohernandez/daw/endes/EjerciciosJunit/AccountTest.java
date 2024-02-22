package es.iessoterohernandez.daw.endes.EjerciciosJunit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account("John Doe", 123456, 1000);
    }

    @Test
    public void testDeposit() {
        assertTrue(account.deposit(500));
        assertEquals(1500, account.getBalance(), 0.01);
        assertFalse(account.deposit(-200));
        assertEquals(1500, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdraw() {
        assertTrue(account.withdraw(200, 5));
        assertEquals(795, account.getBalance(), 0.01);
        assertFalse(account.withdraw(1000, 0));
        assertEquals(795, account.getBalance(), 0.01);
        assertFalse(account.withdraw(-50, 0));
        assertEquals(795, account.getBalance(), 0.01);
        assertFalse(account.withdraw(50, -5));
        assertEquals(795, account.getBalance(), 0.01);
    }

    @Test
    public void testAddInterest() {
        account.addInterest();
        assertEquals(1045, account.getBalance(), 0.01);
    }

    @Test
    public void testInvalidWithdrawal() {
        assertFalse(account.withdraw(1500, 0));
        assertEquals(1000, account.getBalance(), 0.01);
    }
    
    //El defecto sutil en la clase Account está relacionado con el uso de tipos de datos de punto flotante (float) 
    //para representar valores monetarios. Esto puede llevar a imprecisiones en los cálculos.
    //La siguiente prueba verifica si el balance de la cuenta es preciso después de realizar múltiples transacciones de depósito y retiro.
    //Si hay alguna imprecisión debido al uso de tipos de datos de punto flotante, esta prueba lo revelará.
    
    @Test
    public void testMultipleTransactions() {
        account.deposit(0.1f); // depositar $0.10
        account.withdraw(0.05f, 0); // retirar $0.05 sin cargo
        account.deposit(0.1f); // depositar $0.10 nuevamente

        // Verificar que el balance sea preciso después de múltiples transacciones
        assertEquals(1000.15, account.getBalance(), 0.001); // Se usa un delta pequeño debido a la naturaleza de los flotantes
    }
}
