package es.iesoterohernandez.daw.endes.Entregable;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SerieTest {
	Serie serie;

    @BeforeEach
    public void setUp() {
        // Inicializar una instancia de Serie antes de cada prueba
        serie = new Serie("Breaking Bad", 5, "Drama", "Vince Gilligan");
    }

    @Test
    public void testEntregar() {
        serie.entregar();
        assertTrue(serie.isEntregado());
    }

    @Test
    public void testDevolver() {
        serie.devolver();
        assertFalse(serie.isEntregado());
    }

    @Test
    public void testIsEntregado() {
        assertFalse(serie.isEntregado());
    }

    @Test
    public void testCompareTo() {
        // Mayor
        Serie mayor = new Serie("Stranger Things", 3, "Sci-Fi", "Duffer Brothers");
        assertEquals(Serie.MAYOR, serie.compareTo(mayor));

        // Igual
        Serie igual = new Serie("Better Call Saul", 5, "Drama", "Vince Gilligan");
        assertEquals(Serie.IGUAL, serie.compareTo(igual));

        // Menor
        Serie menor = new Serie("Juego de tronos", 9, "Fantasia", "David Benioff");
        assertEquals(Serie.MENOR, serie.compareTo(menor));
    }
    
    @Test
    public void testToString() {
        String esperado = "Informacion de la Serie: \n" +
                          "\tTitulo: Breaking Bad\n" +
                          "\tNumero de temporadas: 5\n" +
                          "\tGenero: Drama\n" +
                          "\tCreador: Vince Gilligan";
        assertEquals(esperado, serie.toString());
    }

    @Test
    public void testEquals() {
        Serie mismaSerie = new Serie("Breaking Bad", 5, "Drama", "Vince Gilligan");
        Serie diferenteSerie = new Serie("Game of Thrones", 8, "Fantasy", "David Benioff");

        assertTrue(serie.equals(mismaSerie));
        assertFalse(serie.equals(diferenteSerie));
    }
}
