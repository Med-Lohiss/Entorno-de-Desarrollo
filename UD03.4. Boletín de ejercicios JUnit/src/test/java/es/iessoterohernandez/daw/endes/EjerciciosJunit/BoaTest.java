package es.iessoterohernandez.daw.endes.EjerciciosJunit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BoaTest {

    // Test parametrizado para el método isHealthy()
    @ParameterizedTest
    @MethodSource("provideIsHealthyTestData")
    public void testIsHealthy(String name, int length, String favoriteFood, boolean expected) {
        Boa boa = new Boa(name, length, favoriteFood);
        assertEquals(expected, boa.isHealthy());
    }

    // Método que proporciona los argumentos para los casos de prueba de isHealthy()
    static Stream<Arguments> provideIsHealthyTestData() {
        return Stream.of(
                Arguments.of("Healthy Boa", 5, "granola bars", true),
                Arguments.of("Unhealthy Boa", 6, "mice", false),  // No es su comida favorita
                Arguments.of("Large Boa", 10, "granola bars", true),
                Arguments.of("Small Boa", 3, "granola bars", true)
        );
    }

    // Test parametrizado para el método fitsInCage()
    @ParameterizedTest
    @MethodSource("provideFitsInCageTestData")
    public void testFitsInCage(String name, int length, String favoriteFood, boolean expected) {
        Boa boa = new Boa(name, length, favoriteFood);
        assertEquals(expected, boa.fitsInCage(6)); // Se prueba con una longitud de jaula de 6 metros
    }

    // Método que proporciona los argumentos para los casos de prueba de fitsInCage()
    static Stream<Arguments> provideFitsInCageTestData() {
        return Stream.of(
                Arguments.of("Healthy Boa", 5, "granola bars", true),
                Arguments.of("Unhealthy Boa", 6, "mice", false),	
                Arguments.of("Large Boa", 10, "granola bars", false), // Excede la longitud de la jaula
                Arguments.of("Small Boa", 3, "granola bars", true)
        );
    }
}


