package es.iessoterohernandez.daw.endes.EjerciciosJunit;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class FridgeTest {

    private Fridge fridge;

    @BeforeEach
    void setUp() {
        fridge = new Fridge();
    }

    @ParameterizedTest
    @MethodSource("provideItems")
    void testPut(String item) {
        assertTrue(fridge.put(item));
    }

    @ParameterizedTest
    @MethodSource("provideItems")
    void testContains(String item) {
        fridge.put(item);
        assertTrue(fridge.contains(item));
    }

    @ParameterizedTest
    @MethodSource("provideItems")
    void testTake(String item) {
        fridge.put(item);
        assertTrue(fridge.contains(item));
        assertDoesNotThrow(() -> fridge.take(item));
        assertFalse(fridge.contains(item));
    }

    static Collection<String> provideItems() {
        return Arrays.asList("apple", "banana", "orange");
    }

    @ParameterizedTest
    @MethodSource("provideNonExistingItems")
    void testTakeNonExistingItem(String item) {
        NoSuchItemException exception = assertThrows(NoSuchItemException.class, () -> fridge.take(item));
        assertEquals(item + " not found in the fridge", exception.getMessage());
    }

    static Collection<String> provideNonExistingItems() {
        return Arrays.asList("milk", "cheese", "bread");
    }
}