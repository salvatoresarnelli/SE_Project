/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se_project;

import org.junit.Test;
import static org.junit.Assert.*;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.UndefinedPhaseException;

/**
 *
 * @author pionp
 */
public class ComplexNumberTest {

    public ComplexNumberTest() {
    }

    /**
     * Test of getRealPart method, of class ComplexNumber.
     */
    @Test
    public void testGetRealPart() {
        System.out.println("getRealPart");
        ComplexNumber instance = new ComplexNumber(4, 5);
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
        ComplexNumber instance = new ComplexNumber(4, 0);
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
        ComplexNumber instance = new ComplexNumber(4, 5);
        double expResult = Math.sqrt(41);
        double result = instance.getModule();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getPhase method, of class ComplexNumber.
     */
    @Test
    public void testGetPhase() throws Exception {
        double result;
        double phase;
        System.out.println("getPhase");
        //CASO 1: A=0, B=0.

        ComplexNumber instance = new ComplexNumber(0, 0);
        //ECCEZIONE.
        //CASO 2: A<0 B<0
        instance.setRealPart(-1);
        instance.setImaginaryPart(-2);
        result = -2.0344;
        phase = instance.getPhase();
        assertEquals(result, phase, 0.2);

        //CASO 3: A<0 B>=0
        instance.setRealPart(-1);
        instance.setImaginaryPart(0);
        phase = instance.getPhase();
        result = Math.PI;
        assertEquals(result, phase, 0.2);

        //CASO 4: A>0
        instance.setRealPart(1);
        instance.setImaginaryPart(0);
        phase = instance.getPhase();
        result = 0;
        assertEquals(result, phase, 0.2);

        //CASO 5: A==0 B<0
        instance.setRealPart(0);
        instance.setImaginaryPart(-1);
        phase = instance.getPhase();
        result = -1.5708;
        assertEquals(result, phase, 0.2);

        //CASO 6: A==0 B>0
        instance.setRealPart(0);
        instance.setImaginaryPart(1);
        phase = instance.getPhase();
        result = 1.5708;
        assertEquals(result, phase, 0.2);

    }

    /**
     * Test of fromTrigonometric method, of class ComplexNumber.
     */
    @Test
    public void testFromTrigonometric() throws UndefinedPhaseException {
        System.out.println("fromTrigonometric");
        ComplexNumber n = new ComplexNumber(1.3, 1.2);
        double mod = n.getModule();
        double phase = n.getPhase();
        ComplexNumber expResult = new ComplexNumber(1.3, 1.2);
        ComplexNumber result = ComplexNumber.fromTrigonometric(mod, phase);
        assertEquals(expResult, result);
    }

    /**
     * Test of conjugated method, of class ComplexNumber.
     */
    @Test
    public void testConjugated() throws InvalidNumberException{
        System.out.println("conjugated");
        ComplexNumber n = new ComplexNumber(4, -5);
        String result = n.conjugated(n).toString();
        System.out.println(result);
        String expResult = "4+5j";
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ComplexNumber.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ComplexNumber instance = new ComplexNumber(4.0, -5.0);
        String expResult = "4-5j";
        String result = instance.toString();
        System.out.println(result);
        assertEquals(expResult, result);
    }

}
