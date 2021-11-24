/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se_project;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Test;
import static org.junit.Assert.*;
import se_project.exceptions.UndefinedPhaseException;


/**
 *
 * @author pionp
 */
public class ComplexNumberTest {
    
    public ComplexNumberTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getRealPart method, of class ComplexNumber.
     */
    @Test
    public void testGetRealPart() {
        System.out.println("getRealPart");
        ComplexNumber instance = new ComplexNumber(4,5);      
        double expResult = 4.0;
        Double result = instance.getRealPart();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getImaginaryPart method, of class ComplexNumber.
   */
    
    @Test
    public void testGetImaginaryPart() {
        System.out.println("getImaginaryPart");
        ComplexNumber instance = new ComplexNumber(4);
        double expResult = 0.0;
        double result = instance.getImaginaryPart();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getModule method, of class ComplexNumber.
     */
    
    @Test
    public void testGetModule() {
        System.out.println("getModule");
        ComplexNumber instance = new ComplexNumber(4,5);
        double expResult = Math.sqrt(41);
        double result = instance.getModule();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getPhase method, of class ComplexNumber.
     */
    
    @Test
    public void testGetPhase() throws Exception {
        System.out.println("getPhase");
        ComplexNumber instance = new ComplexNumber(4,5);
        double expResult = Math.atan(5.0/4.0);
        System.out.println(Math.atan(5.0/4.0));
        double result = instance.getPhase();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of fromTrigonometric method, of class ComplexNumber.
     */
    @Test
    public void testFromTrigonometric() throws UndefinedPhaseException {
        System.out.println("fromTrigonometric");
        ComplexNumber n = new ComplexNumber(1.3,1.2);
        double mod = n.getModule();
        double phase = n.getPhase();
        ComplexNumber expResult = new ComplexNumber(1.3,1.2);
        ComplexNumber result = ComplexNumber.fromTrigonometric(mod, phase);
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of conjugated method, of class ComplexNumber.
     */
    @Test
    public void testConjugated() {
        System.out.println("conjugated");
        ComplexNumber n = new ComplexNumber(4,-5);
        String result = n.conjugated(n).toString();
        System.out.println(result);
        String expResult = "4.0+5.0j";
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ComplexNumber.
     */
    
    @Test
    public void testToString() {
        System.out.println("toString");
        ComplexNumber instance = new ComplexNumber(4,-5);
        String expResult = "4.0-5.0j";
        String result = instance.toString();
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
}
