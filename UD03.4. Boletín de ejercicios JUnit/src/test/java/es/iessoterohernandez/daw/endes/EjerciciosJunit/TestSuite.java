package es.iessoterohernandez.daw.endes.EjerciciosJunit;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({SubscripcionTest.class, OperadorAritmeticoTest.class, PilaTest.class, BoaTest.class, FridgeTest.class})
public class TestSuite {
    // Esta clase puede permanecer vacía
}
