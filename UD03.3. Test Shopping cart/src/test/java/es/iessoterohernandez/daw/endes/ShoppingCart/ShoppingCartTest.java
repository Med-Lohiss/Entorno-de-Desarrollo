package es.iessoterohernandez.daw.endes.ShoppingCart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

	private ShoppingCart cart;
    private Product product1;
    private Product product2;

    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
        product1 = new Product("Product 1", 10.0);
        product2 = new Product("Product 2", 20.0);
    }

    //Cuando se crea, el carro tiene 0 elementos.
    @Test
    public void testInitialItemCountIsZero() {
        assertEquals(0, cart.getItemCount());
    }
    
    //Cuando está vacío, el carro tiene 0 elementos.
    @Test
    public void testEmptyCartHasZeroElements() {
        assertTrue(cart.getItemCount() == 0);
    }
    
    //Cuando se añade un producto, el número de elementos debe incrementarse.
    @Test
    public void testAddingProductIncreasesItemCount() {
        cart.addItem(product1);
        assertEquals(1, cart.getItemCount());
    }

    //Cuando se añade un producto, el balance nuevo debe ser la suma del balance 
    //anterior y el precio del producto añadido.
    @Test
    public void testAddingProductIncreasesBalance() {
        cart.addItem(product1);
        assertEquals(10.0, cart.getBalance(), 0.01);
    }
    
    
    @Test
    public void testAddingMultipleProductsIncreasesItemCountAndBalance() {
        cart.addItem(product1);
        cart.addItem(product2);
        assertEquals(2, cart.getItemCount());
        assertEquals(30.0, cart.getBalance(), 0.01);
    }
    
    //Cuando se elimina un producto, el número de elementos debe decrementarse.
    @Test
    public void testRemovingProductDecreasesItemCount() throws ProductNotFoundException {
        cart.addItem(product1);
        cart.removeItem(product1);
        assertEquals(0, cart.getItemCount());
    }
    
    //Cuando se intenta eliminar un producto que no está en el carro, se debe lanzar una excepción
    //ProductNotFoundException. Pista: inserta la llamada en un bloque try y pon un método fail()
    //después de la llamada a removeItem().
    @Test
    public void testRemovingNonExistingProductDoesNotChangeItemCount() {
        assertThrows(ProductNotFoundException.class, () -> {
            cart.removeItem(product1);
        });
        assertEquals(0, cart.getItemCount());
    }
}


