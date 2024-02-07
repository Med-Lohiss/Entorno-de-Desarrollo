package es.iessoterohernandez.daw.endes.Persona;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class TestPersona {
	@Test
    public void testConstructorPorDefecto() {
        Persona persona = new Persona();
        assertNotNull(persona);
    }

    @Test
    public void testConstructorConTresParametros() {
        Persona persona = new Persona("Ana", 20, 'M');
        assertNotNull(persona);
        assertTrue(persona.toString().contains("Nombre: Ana"));
        assertTrue(persona.toString().contains("Sexo: 'M'"));
        assertTrue(persona.toString().contains("Edad: 20 años"));
    }

    @Test
    public void testConstructorConCincoParametros() {
        Persona persona = new Persona("Juan", 25, 'H', 70, 1.75);
        assertNotNull(persona);
        assertTrue(persona.toString().contains("Nombre: Juan"));
        assertTrue(persona.toString().contains("Edad: 25 años"));
        assertTrue(persona.toString().contains("Sexo: 'H'"));
        assertTrue(persona.toString().contains("Peso: 70.0 kg"));
        assertTrue(persona.toString().contains("Altura: 1.75 metros"));
    }

    @Test
    public void testSetNombre() {
        Persona persona = new Persona();
        persona.setNombre("Juan");
        assertTrue(persona.toString().contains("Nombre: Juan"));
    }

    @Test
    public void testSetEdad() {
        Persona persona = new Persona();
        persona.setEdad(25);
        assertTrue(persona.toString().contains("Edad: 25 años"));
    }

    @Test
    public void testSetSexo() {
        Persona persona = new Persona();
        persona.setSexo('M');
        assertTrue(persona.toString().contains("Sexo: mujer"));
    }

    @Test
    public void testSetPeso() {
        Persona persona = new Persona();
        persona.setPeso(65);
        assertTrue(persona.toString().contains("Peso: 65.0 kg"));
    }

    @Test
    public void testSetAltura() {
        Persona persona = new Persona();
        persona.setAltura(1.75);
        assertTrue(persona.toString().contains("Altura: 1.75 metros"));
    }

    @Test
    public void testCalcularIMC() {
        Persona persona1 = new Persona("Juan", 20, 'H', 60, 1.75);
        assertEquals(Persona.INFRAPESO, persona1.calcularIMC());

        Persona persona2 = new Persona("Ana", 30, 'M', 70, 1.65);
        assertEquals(Persona.SOBREPESO, persona2.calcularIMC());

        Persona persona3 = new Persona("Pedro", 25, 'H', 75, 1.80);
        assertEquals(Persona.PESO_IDEAL, persona3.calcularIMC());
    }

    @Test
    public void testEsMayorDeEdad() {
        Persona persona = new Persona();
        persona.setEdad(17);
        persona.setEdad(18);
        assertTrue(persona.toString().contains("Edad: 18 años"));
    }

    @Test
    public void testToString() {
        Persona persona = new Persona("Juan", 25, 'H', 70, 1.75);
        String expectedToString = "Informacion de la persona:\n"
                + "Nombre: Juan\n"
                + "Sexo: hombre\n"
                + "Edad: 25 años\n"
                + "DNI: ";
        assertTrue(persona.toString().startsWith(expectedToString));
    }

}
