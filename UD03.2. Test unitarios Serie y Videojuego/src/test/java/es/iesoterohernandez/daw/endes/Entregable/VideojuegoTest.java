package es.iesoterohernandez.daw.endes.Entregable;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VideojuegoTest {
	
	Videojuego videojuego;

    @BeforeEach
    public void setUp() {
        // Inicializar una instancia de Videojuego antes de cada prueba
        videojuego = new Videojuego("The Last of Us", 50, "Aventura", "Naughty Dog");
    }

    @Test
    public void testEntregar() {
        videojuego.entregar();
        assertTrue(videojuego.isEntregado());
    }

    @Test
    public void testDevolver() {
        videojuego.devolver();
        assertFalse(videojuego.isEntregado());
    }

    @Test
    public void testIsEntregado() {
        assertFalse(videojuego.isEntregado());
    }

    @Test
    public void testCompareTo() {
        // Mayor
        Videojuego mayor = new Videojuego("GTA V", 20, "Acción", "Rockstar Games");
        assertEquals(Videojuego.MAYOR, videojuego.compareTo(mayor));

        // Igual
        Videojuego igual = new Videojuego("FIFA 22", 50, "Deportes", "EA Sports");
        assertEquals(Videojuego.IGUAL, videojuego.compareTo(igual));

        // Menor
        Videojuego menor = new Videojuego("Minecraft", 500, "Aventura", "Mojang Studios");
        assertEquals(Videojuego.MENOR, videojuego.compareTo(menor));
    }
    
    @Test
    public void testToString() {
        String esperado = "Informacion del videojuego: \n" +
                          "\tTitulo: The Last of Us\n" +
                          "\tHoras estimadas: 50\n" +
                          "\tGenero: Aventura\n" +
                          "\tcompañia: Naughty Dog";
        assertEquals(esperado, videojuego.toString());
    }

    @Test
    public void testEquals() {
        Videojuego mismoVideojuego = new Videojuego("The Last of Us", 50, "Aventura", "Naughty Dog");
        Videojuego diferenteVideojuego = new Videojuego("GTA V", 200, "Acción", "Rockstar Games");

        assertTrue(videojuego.equals(mismoVideojuego));
        assertFalse(videojuego.equals(diferenteVideojuego));
    }
}
