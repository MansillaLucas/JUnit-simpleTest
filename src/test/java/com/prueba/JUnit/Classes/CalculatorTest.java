package com.prueba.JUnit.Classes;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void sumaDeberiaSerCorrecta() throws Exception{

        Calculator calculadora = new Calculator();

        assertEquals(17, calculadora.calculate(8, 9, "+"));
        assertNotEquals(38, calculadora.calculate(8, 9, "+"));

    }

    @Test
    void multiplicacionDeberiaSerCorrecta() throws Exception{
        
        Calculator calculadora = new Calculator();

        assertEquals(4, calculadora.calculate(2, 2, "*"));
        assertEquals(9, calculadora.calculate(3, 3, "*"));
        assertEquals(0, calculadora.calculate(1, 0, "*"));
        assertNotEquals(1, calculadora.calculate(1, 0, "*"));

    }

    @Test
    void divisionDeberiaSerCorrecta() throws Exception{
        
        Calculator calculadora = new Calculator();

        assertEquals(5, calculadora.calculate(10, 2, "/"));
        assertNotEquals(1, calculadora.calculate(1, 2, "/"));
        //assertNotEquals(0, calculadora.calculate(32, 0, "/"));

    }

    @Test
    void signosDeberianSerCorrectos() {
        Calculator calculadora = new Calculator();

        assertThrows(IllegalArgumentException.class,() -> {
            calculadora.calculate(8, 9, "?");
        });

        assertDoesNotThrow(() -> {
            calculadora.calculate(8, 9, "+");
        }, "Símbolo suma correcto");

        assertDoesNotThrow(() -> {
            calculadora.calculate(8, 9, "-");
        }, "Símbolo resta correcto");

        assertDoesNotThrow(() -> {
            calculadora.calculate(8, 9, "*");
        }, "Símbolo multiplicación correcto");

        assertThrows(NumberFormatException.class,() -> {
            calculadora.calculate(8, 0, "/");
        });
        assertDoesNotThrow(() -> {
            calculadora.calculate(8, 9, "/");
        }, "Símbolo división correcto");

    }

}
