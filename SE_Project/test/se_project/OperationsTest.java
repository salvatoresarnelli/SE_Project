/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.util.LinkedList;
import org.junit.*;
import org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import se_project.ComplexNumber;
import se_project.Operations;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.UndefinedPhaseException;

/**
 *
 * @author aless
 */
public class OperationsTest {

    ComplexNumber a, b, result;

    public OperationsTest() {

    }

    @Before
    public void setUp() {
        a = new ComplexNumber();
        b = new ComplexNumber();
        result = new ComplexNumber();
    }

    @After
    public void tearDown() {
    }
    /*----------------------------SUM-----------------------------------------*/
    @Test
    public void testSumRPositiveIPositiveRPositiveIPositive() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(3);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(2);
        b.setImaginaryPart(2);
        assertEquals(result, Operations.addOperation(a, b));
    }

    @Test
    public void testSumRPositiveIPositiveRPositiveINegative() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(3);
        result.setImaginaryPart(2);
        a.setRealPart(1);
        a.setImaginaryPart(4);
        b.setRealPart(2);
        b.setImaginaryPart(-2);
        assertEquals(result, Operations.addOperation(a, b));

    }

    @Test
    public void testSumRPositiveIPositiveRNegativeIPositive() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(0);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        assertEquals(result, Operations.addOperation(a, b));
    }

    @Test
    public void testSumRPositiveIPositiveRNegativeINegative() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(5);
        result.setImaginaryPart(5);
        a.setRealPart(10);
        a.setImaginaryPart(10);
        b.setRealPart(-5);
        b.setImaginaryPart(-5);
        assertEquals(result, Operations.addOperation(a, b));
    }

    @Test
    public void testSumRPositiveINegativeRPositiveIPositive() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(5);
        result.setImaginaryPart(-1);
        a.setRealPart(2);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(2);
        assertEquals(result, Operations.addOperation(a, b));

    }
    
    @Test
    public void testSumRPositiveINegativeRPositiveINegative() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(7);
        result.setImaginaryPart(-5);
        a.setRealPart(4);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        assertEquals(result, Operations.addOperation(a, b));

    }
@Test
    public void testSumRPositiveINegativeRNegativeIPositive() throws InvalidNumberException {

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(1);
        result.setImaginaryPart(-1);
        a.setRealPart(1);
        a.setImaginaryPart(-2);
        b.setRealPart(-2);
        b.setImaginaryPart(3);
        assertEquals(result, Operations.addOperation(a, b));

    }
@Test
    public void testSumRPositiveINegativeRNegativeINegative() throws InvalidNumberException {

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-1);
        result.setImaginaryPart(-6);
        a.setRealPart(1);
        a.setImaginaryPart(-3);
        b.setRealPart(-2);
        b.setImaginaryPart(-3);
        assertEquals(result, Operations.addOperation(a, b));

    }
@Test
    public void testSumRNegativeIPositiveRPositiveIPositive() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(2);
        result.setImaginaryPart(5);
        a.setRealPart(-3);
        a.setImaginaryPart(2);
        b.setRealPart(5);
        b.setImaginaryPart(3);
        assertEquals(result, Operations.addOperation(a, b));
    }
@Test
    public void testSumRNegativeIPositiveRPositiveINegative() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(2);
        result.setImaginaryPart(-1);
        a.setRealPart(-1);
        a.setImaginaryPart(2);
        b.setRealPart(3);
        b.setImaginaryPart(-3);
        assertEquals(result, Operations.addOperation(a, b));

    }
@Test
    public void testSumRNegativeIPositiveRNegativeIPositive() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(-3);
        result.setImaginaryPart(5);
        a.setRealPart(-1);
        a.setImaginaryPart(3);
        b.setRealPart(-2);
        b.setImaginaryPart(2);

        assertEquals(result, Operations.addOperation(a, b));

    }
@Test
    public void testSumRNegativeIPositiveRNegativeINegative() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-5);
        result.setImaginaryPart(2);
        a.setRealPart(-2);
        a.setImaginaryPart(3);
        b.setRealPart(-3);
        b.setImaginaryPart(-1);
        assertEquals(result, Operations.addOperation(a, b));

    }
@Test
    public void testSumRNegativeINegativeRPositiveIPositive() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(2);
        result.setImaginaryPart(0);
        a.setRealPart(-2);
        a.setImaginaryPart(-3);
        b.setRealPart(4);
        b.setImaginaryPart(3);
        assertEquals(result, Operations.addOperation(a, b));
    }
@Test
    public void testSumRNegativeINegativeRPositiveINegative() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).

        result.setRealPart(2);
        result.setImaginaryPart(-4);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        assertEquals(result, Operations.addOperation(a, b));

    }
@Test
    public void testSumRNegativeINegativeRNegativeIPositve() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(-2);
        result.setImaginaryPart(1);
        a.setRealPart(-1);
        a.setImaginaryPart(-1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        assertEquals(result, Operations.addOperation(a, b));

    }
@Test
    public void testSumRNegativeINegativeRNegativeINegative() throws InvalidNumberException {

        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-2);
        result.setImaginaryPart(-3);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(-1);
        b.setImaginaryPart(-1);
        assertEquals(result, Operations.addOperation(a, b));

    }
@Test
    public void testSumRPositiveIZeroRPositiveIZero() throws InvalidNumberException {

        //(Real Part >0,Im=0) + (Real Part>0,Im=0)
        result.setRealPart(2);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(1);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.addOperation(a, b));
    }
@Test
    public void testSumRPositiveIZeroRNegativeIZero() throws InvalidNumberException {
        //(Real Part>0, Im=0) + (Real Part<0,Im=0) 
        result.setRealPart(-3);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(-4);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.addOperation(a, b));

    }
@Test
    public void testSumRNegativeIZeroRNegativeIZero() throws InvalidNumberException {
        //(Real Part<0, Im =0) + (Real Part<0, Im=0)
        result.setRealPart(-3);
        result.setImaginaryPart(0);
        a.setRealPart(-1);
        a.setImaginaryPart(0);
        b.setRealPart(-2);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.addOperation(a, b));

    }
@Test
    public void testSumRZeroIPositiveRZeroIPositive() throws InvalidNumberException {
        // (Real Part=0, Im>0) + (Real Part=0, Im>0)
        result.setRealPart(0);
        result.setImaginaryPart(2);
        a.setRealPart(0);
        a.setImaginaryPart(1);
        b.setRealPart(0);
        b.setImaginaryPart(1);
        assertEquals(result, Operations.addOperation(a, b));

    }
@Test
    public void testSumRZeroIZeroRZeroIZero() throws InvalidNumberException {
        //(Real Part=0,Im =0) + (Real Part=0, Im=0)
        result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(0);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.addOperation(a, b));

    }
@Test
    public void testSumRNonZeroIZeroRZeroINonZero() throws InvalidNumberException {
        //(Real Part!=0,Im =0) + (Real Part=0, Im!=0)
        result.setRealPart(1);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(3);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testSumOpposite() throws InvalidNumberException {
        //(Real Part=A,Im =B) + (Real Part=-A, Im=-B)
        result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(6);
        a.setImaginaryPart(7);
        b.setRealPart(-6);
        b.setImaginaryPart(-7);
        assertEquals(result, Operations.addOperation(a, b));

    }

    @Test
    public void testDifferenceRPositiveIPositiveRPositiveIPositive() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(3);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(2);
        b.setImaginaryPart(2);
        assertEquals(result, Operations.addOperation(a, b));
    }

    /*----------------------------DIFFERENCE--------------------------------*/
    @Test
    public void testDifferenceRPositiveIPositiveRPositiveINegative() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(3);
        result.setImaginaryPart(2);
        a.setRealPart(1);
        a.setImaginaryPart(4);
        b.setRealPart(2);
        b.setImaginaryPart(-2);
        assertEquals(result, Operations.addOperation(a, b));

    }

    @Test
    public void testDifferenceRPositiveIPositiveRNegativeIPositive() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(0);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        assertEquals(result, Operations.addOperation(a, b));
    }

    @Test
    public void testDifferenceRPositiveIPositiveRNegativeINegative() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(5);
        result.setImaginaryPart(5);
        a.setRealPart(10);
        a.setImaginaryPart(10);
        b.setRealPart(-5);
        b.setImaginaryPart(-5);
        assertEquals(result, Operations.addOperation(a, b));
    }

    @Test
    public void testDifferenceRPositiveINegativeRPositiveIPositive() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(5);
        result.setImaginaryPart(-1);
        a.setRealPart(2);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(2);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDifferenceRPositiveINegativeRPositiveINegative() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(7);
        result.setImaginaryPart(-5);
        a.setRealPart(4);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDifferenceRPositiveINegativeRNegativeIPositive() throws InvalidNumberException {

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(1);
        result.setImaginaryPart(-1);
        a.setRealPart(1);
        a.setImaginaryPart(-2);
        b.setRealPart(-2);
        b.setImaginaryPart(3);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDifferenceRPositiveINegativeRNegativeINegative() throws InvalidNumberException {

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-1);
        result.setImaginaryPart(-6);
        a.setRealPart(1);
        a.setImaginaryPart(-3);
        b.setRealPart(-2);
        b.setImaginaryPart(-3);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDifferenceRNegativeIPositiveRPositiveIPositive() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(2);
        result.setImaginaryPart(5);
        a.setRealPart(-3);
        a.setImaginaryPart(2);
        b.setRealPart(5);
        b.setImaginaryPart(3);
        assertEquals(result, Operations.addOperation(a, b));
    }

    public void testDifferenceRNegativeIPositiveRPositiveINegative() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(2);
        result.setImaginaryPart(-1);
        a.setRealPart(-1);
        a.setImaginaryPart(2);
        b.setRealPart(3);
        b.setImaginaryPart(-3);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDifferenceRNegativeIPositiveRNegativeIPositive() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(-3);
        result.setImaginaryPart(5);
        a.setRealPart(-1);
        a.setImaginaryPart(3);
        b.setRealPart(-2);
        b.setImaginaryPart(2);

        assertEquals(result, Operations.addOperation(a, b));

    }


    public void testDifferenceRNegativeIPositiveRNegativeINegative() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-5);
        result.setImaginaryPart(2);
        a.setRealPart(-2);
        a.setImaginaryPart(3);
        b.setRealPart(-3);
        b.setImaginaryPart(-1);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDifferenceRNegativeINegativeRPositiveIPositive() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(2);
        result.setImaginaryPart(0);
        a.setRealPart(-2);
        a.setImaginaryPart(-3);
        b.setRealPart(4);
        b.setImaginaryPart(3);
        assertEquals(result, Operations.addOperation(a, b));
    }

    public void testDifferenceRNegativeINegativeRPositiveINegative() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).

        result.setRealPart(2);
        result.setImaginaryPart(-4);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDifferenceRNegativeINegativeRNegativeIPositve() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(-2);
        result.setImaginaryPart(1);
        a.setRealPart(-1);
        a.setImaginaryPart(-1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDifferenceRNegativeINegativeRNegativeINegative() throws InvalidNumberException {

        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-2);
        result.setImaginaryPart(-3);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(-1);
        b.setImaginaryPart(-1);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDifferenceRPositiveIZeroRPositiveIZero() throws InvalidNumberException {

        //(Real Part >0,Im=0) + (Real Part>0,Im=0)
        result.setRealPart(2);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(1);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.addOperation(a, b));
    }

    
        public void testDifferenceRPositiveIZeroRNegativeIZero() throws InvalidNumberException {
        //(Real Part>0, Im=0) + (Real Part<0,Im=0) 
        result.setRealPart(-3);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(-4);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.addOperation(a, b));
        
    }

        
        public void testDifferenceRNegativeIZeroRNegativeIZero() throws InvalidNumberException {
       //(Real Part<0, Im =0) + (Real Part<0, Im=0)
        result.setRealPart(-3);
        result.setImaginaryPart(0);
        a.setRealPart(-1);
        a.setImaginaryPart(0);
        b.setRealPart(-2);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.addOperation(a, b));
        
    }    
        
      public void testDifferenceRZeroIPositiveRZeroIPositive() throws InvalidNumberException {
     // (Real Part=0, Im>0) + (Real Part=0, Im>0)
        result.setRealPart(0);
        result.setImaginaryPart(2);
        a.setRealPart(0);
        a.setImaginaryPart(1);
        b.setRealPart(0);
        b.setImaginaryPart(1);
        assertEquals(result, Operations.addOperation(a, b));
        
    }    
    
    public void testDifferenceRZeroIZeroRZeroIZero() throws InvalidNumberException {
      //(Real Part=0,Im =0) + (Real Part=0, Im=0)
                result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(0);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.addOperation(a, b));
        
        
    }
    
    public void testDifferenceRNonZeroIZeroRZeroINonZero() throws InvalidNumberException {
      //(Real Part!=0,Im =0) + (Real Part=0, Im!=0)
                result.setRealPart(1);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(3);
            assertEquals(result, Operations.addOperation(a, b));
       
    }    
    
    public void testDifferenceOpposite() throws InvalidNumberException {
    //(Real Part=A,Im =B) + (Real Part=-A, Im=-B)
                result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(6);
        a.setImaginaryPart(7);
        b.setRealPart(-6);
        b.setImaginaryPart(-7);
        assertEquals(result, Operations.addOperation(a, b));
        
    }   
     
     /*----------------------------PRODUCT----------------------------------------*/
       @Test
    public void testDotRPositiveIPositiveRPositiveINegative() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(3);
        result.setImaginaryPart(2);
        a.setRealPart(1);
        a.setImaginaryPart(4);
        b.setRealPart(2);
        b.setImaginaryPart(-2);
        assertEquals(result, Operations.addOperation(a, b));

    }

    @Test
    public void testDotRPositiveIPositiveRNegativeIPositive() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(0);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        assertEquals(result, Operations.addOperation(a, b));
    }

    @Test
    public void testDotRPositiveIPositiveRNegativeINegative() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(5);
        result.setImaginaryPart(5);
        a.setRealPart(10);
        a.setImaginaryPart(10);
        b.setRealPart(-5);
        b.setImaginaryPart(-5);
        assertEquals(result, Operations.addOperation(a, b));
    }

    @Test
    public void testDotRPositiveINegativeRPositiveIPositive() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(5);
        result.setImaginaryPart(-1);
        a.setRealPart(2);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(2);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDotRPositiveINegativeRPositiveINegative() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(7);
        result.setImaginaryPart(-5);
        a.setRealPart(4);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDotRPositiveINegativeRNegativeIPositive() throws InvalidNumberException {

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(1);
        result.setImaginaryPart(-1);
        a.setRealPart(1);
        a.setImaginaryPart(-2);
        b.setRealPart(-2);
        b.setImaginaryPart(3);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDotRPositiveINegativeRNegativeINegative() throws InvalidNumberException {

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-1);
        result.setImaginaryPart(-6);
        a.setRealPart(1);
        a.setImaginaryPart(-3);
        b.setRealPart(-2);
        b.setImaginaryPart(-3);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDotRNegativeIPositiveRPositiveIPositive() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(2);
        result.setImaginaryPart(5);
        a.setRealPart(-3);
        a.setImaginaryPart(2);
        b.setRealPart(5);
        b.setImaginaryPart(3);
        assertEquals(result, Operations.addOperation(a, b));
    }

    public void testDotRNegativeIPositiveRPositiveINegative() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(2);
        result.setImaginaryPart(-1);
        a.setRealPart(-1);
        a.setImaginaryPart(2);
        b.setRealPart(3);
        b.setImaginaryPart(-3);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDotRNegativeIPositiveRNegativeIPositive() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(-3);
        result.setImaginaryPart(5);
        a.setRealPart(-1);
        a.setImaginaryPart(3);
        b.setRealPart(-2);
        b.setImaginaryPart(2);

        assertEquals(result, Operations.addOperation(a, b));

    }


    public void testDotRNegativeIPositiveRNegativeINegative() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-5);
        result.setImaginaryPart(2);
        a.setRealPart(-2);
        a.setImaginaryPart(3);
        b.setRealPart(-3);
        b.setImaginaryPart(-1);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDotRNegativeINegativeRPositiveIPositive() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(2);
        result.setImaginaryPart(0);
        a.setRealPart(-2);
        a.setImaginaryPart(-3);
        b.setRealPart(4);
        b.setImaginaryPart(3);
        assertEquals(result, Operations.addOperation(a, b));
    }

    public void testDotRNegativeINegativeRPositiveINegative() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).

        result.setRealPart(2);
        result.setImaginaryPart(-4);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDotRNegativeINegativeRNegativeIPositve() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(-2);
        result.setImaginaryPart(1);
        a.setRealPart(-1);
        a.setImaginaryPart(-1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDotRNegativeINegativeRNegativeINegative() throws InvalidNumberException {

        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-2);
        result.setImaginaryPart(-3);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(-1);
        b.setImaginaryPart(-1);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDotRPositiveIZeroRPositiveIZero() throws InvalidNumberException {

        //(Real Part >0,Im=0) + (Real Part>0,Im=0)
        result.setRealPart(2);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(1);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.addOperation(a, b));
    }

    
        public void testDotRPositiveIZeroRNegativeIZero() throws InvalidNumberException {
        //(Real Part>0, Im=0) + (Real Part<0,Im=0) 
        result.setRealPart(-3);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(-4);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.addOperation(a, b));
        
    }

        
        public void testDotRNegativeIZeroRNegativeIZero() throws InvalidNumberException {
       //(Real Part<0, Im =0) + (Real Part<0, Im=0)
        result.setRealPart(-3);
        result.setImaginaryPart(0);
        a.setRealPart(-1);
        a.setImaginaryPart(0);
        b.setRealPart(-2);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.addOperation(a, b));
        
    }    
        
      public void testDotRZeroIPositiveRZeroIPositive() throws InvalidNumberException {
     // (Real Part=0, Im>0) + (Real Part=0, Im>0)
        result.setRealPart(0);
        result.setImaginaryPart(2);
        a.setRealPart(0);
        a.setImaginaryPart(1);
        b.setRealPart(0);
        b.setImaginaryPart(1);
        assertEquals(result, Operations.addOperation(a, b));
        
    }    
    
    public void testDotRZeroIZeroRZeroIZero() throws InvalidNumberException {
      //(Real Part=0,Im =0) + (Real Part=0, Im=0)
                result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(0);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.addOperation(a, b));
        
        
    }
    
    public void testDotRNonZeroIZeroRZeroINonZero() throws InvalidNumberException {
      //(Real Part!=0,Im =0) + (Real Part=0, Im!=0)
                result.setRealPart(1);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(3);
            assertEquals(result, Operations.addOperation(a, b));
       
    }    
    
    public void testDotOpposite() throws InvalidNumberException {
    //(Real Part=A,Im =B) + (Real Part=-A, Im=-B)
                result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(6);
        a.setImaginaryPart(7);
        b.setRealPart(-6);
        b.setImaginaryPart(-7);
        assertEquals(result, Operations.addOperation(a, b));
    }

    /*----------------------------DIVISION----------------------------------------*/
       @Test
    public void testDivisionRPositiveIPositiveRPositiveINegative() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(3);
        result.setImaginaryPart(2);
        a.setRealPart(1);
        a.setImaginaryPart(4);
        b.setRealPart(2);
        b.setImaginaryPart(-2);
        assertEquals(result, Operations.addOperation(a, b));

    }

    @Test
    public void testDivisionRPositiveIPositiveRNegativeIPositive() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(0);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        assertEquals(result, Operations.addOperation(a, b));
    }

    @Test
    public void testDivisionRPositiveIPositiveRNegativeINegative() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(5);
        result.setImaginaryPart(5);
        a.setRealPart(10);
        a.setImaginaryPart(10);
        b.setRealPart(-5);
        b.setImaginaryPart(-5);
        assertEquals(result, Operations.addOperation(a, b));
    }

    @Test
    public void testDivisionRPositiveINegativeRPositiveIPositive() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(5);
        result.setImaginaryPart(-1);
        a.setRealPart(2);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(2);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDivisionRPositiveINegativeRPositiveINegative() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(7);
        result.setImaginaryPart(-5);
        a.setRealPart(4);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDivisionRPositiveINegativeRNegativeIPositive() throws InvalidNumberException {

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(1);
        result.setImaginaryPart(-1);
        a.setRealPart(1);
        a.setImaginaryPart(-2);
        b.setRealPart(-2);
        b.setImaginaryPart(3);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDivisionRPositiveINegativeRNegativeINegative() throws InvalidNumberException {

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-1);
        result.setImaginaryPart(-6);
        a.setRealPart(1);
        a.setImaginaryPart(-3);
        b.setRealPart(-2);
        b.setImaginaryPart(-3);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDivisionRNegativeIPositiveRPositiveIPositive() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(2);
        result.setImaginaryPart(5);
        a.setRealPart(-3);
        a.setImaginaryPart(2);
        b.setRealPart(5);
        b.setImaginaryPart(3);
        assertEquals(result, Operations.addOperation(a, b));
    }

    public void testDivisionRNegativeIPositiveRPositiveINegative() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(2);
        result.setImaginaryPart(-1);
        a.setRealPart(-1);
        a.setImaginaryPart(2);
        b.setRealPart(3);
        b.setImaginaryPart(-3);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDivisionRNegativeIPositiveRNegativeIPositive() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(-3);
        result.setImaginaryPart(5);
        a.setRealPart(-1);
        a.setImaginaryPart(3);
        b.setRealPart(-2);
        b.setImaginaryPart(2);

        assertEquals(result, Operations.addOperation(a, b));

    }


    public void testDivisionRNegativeIPositiveRNegativeINegative() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-5);
        result.setImaginaryPart(2);
        a.setRealPart(-2);
        a.setImaginaryPart(3);
        b.setRealPart(-3);
        b.setImaginaryPart(-1);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDivisionRNegativeINegativeRPositiveIPositive() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(2);
        result.setImaginaryPart(0);
        a.setRealPart(-2);
        a.setImaginaryPart(-3);
        b.setRealPart(4);
        b.setImaginaryPart(3);
        assertEquals(result, Operations.addOperation(a, b));
    }

    public void testDivisionRNegativeINegativeRPositiveINegative() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).

        result.setRealPart(2);
        result.setImaginaryPart(-4);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDivisionRNegativeINegativeRNegativeIPositve() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(-2);
        result.setImaginaryPart(1);
        a.setRealPart(-1);
        a.setImaginaryPart(-1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDivisionRNegativeINegativeRNegativeINegative() throws InvalidNumberException {

        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-2);
        result.setImaginaryPart(-3);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(-1);
        b.setImaginaryPart(-1);
        assertEquals(result, Operations.addOperation(a, b));

    }

    public void testDivisionRPositiveIZeroRPositiveIZero() throws InvalidNumberException {

        //(Real Part >0,Im=0) + (Real Part>0,Im=0)
        result.setRealPart(2);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(1);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.addOperation(a, b));
    }

    
        public void testDivisionRPositiveIZeroRNegativeIZero() throws InvalidNumberException {
        //(Real Part>0, Im=0) + (Real Part<0,Im=0) 
        result.setRealPart(-3);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(-4);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.addOperation(a, b));
        
    }

        
        public void testDivisionRNegativeIZeroRNegativeIZero() throws InvalidNumberException {
       //(Real Part<0, Im =0) + (Real Part<0, Im=0)
        result.setRealPart(-3);
        result.setImaginaryPart(0);
        a.setRealPart(-1);
        a.setImaginaryPart(0);
        b.setRealPart(-2);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.addOperation(a, b));
        
    }    
        
      public void testDivisionRZeroIPositiveRZeroIPositive() throws InvalidNumberException {
     // (Real Part=0, Im>0) + (Real Part=0, Im>0)
        result.setRealPart(0);
        result.setImaginaryPart(2);
        a.setRealPart(0);
        a.setImaginaryPart(1);
        b.setRealPart(0);
        b.setImaginaryPart(1);
        assertEquals(result, Operations.addOperation(a, b));
        
    }    
    
    public void testDivisionRZeroIZeroRZeroIZero() throws InvalidNumberException {
      //(Real Part=0,Im =0) + (Real Part=0, Im=0)
                result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(0);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.addOperation(a, b));
        
        
    }
    
    public void testDivisionRNonZeroIZeroRZeroINonZero() throws InvalidNumberException {
      //(Real Part!=0,Im =0) + (Real Part=0, Im!=0)
                result.setRealPart(1);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(3);
            assertEquals(result, Operations.addOperation(a, b));
       
    }    
    
    public void testDivisionOpposite() throws InvalidNumberException {
    //(Real Part=A,Im =B) + (Real Part=-A, Im=-B)
                result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(6);
        a.setImaginaryPart(7);
        b.setRealPart(-6);
        b.setImaginaryPart(-7);
        assertEquals(result, Operations.addOperation(a, b));
    }
        
    /*----------------------------SIGN----------------------------------------*/

    /*----------------------------SQRT----------------------------------------*/
    public void testSqrtRNegativeIZero() throws UndefinedPhaseException {

        LinkedList<ComplexNumber> results = new LinkedList<>();
        results.add(new ComplexNumber(0, 2));
        results.add(new ComplexNumber(0, -2));
        a.setRealPart(0);
        a.setImaginaryPart(-4);
        LinkedList<ComplexNumber> obtained = Operations.squareRoot(a);
        results.forEach(number -> {
            assertTrue(obtained.contains(number));
        });
    }
    
    /*-------------------------NULL POINTER-----------------------------------*/
       public void testSumOneNull() throws InvalidNumberException {
        //(null+null)

    }

    public void testSumBothNull() throws InvalidNumberException {
        //(null+null)

    }

    public void testDifferenceOneNull() throws InvalidNumberException {
        //(null+null)

    }

    public void testDifferenceBothNull() throws InvalidNumberException {
        //(null+null)

    }

    public void testDotOneNull() throws InvalidNumberException {
        //(null+null)

    }

    public void testDotBothNull() throws InvalidNumberException {
        //(null+null)

    }

    public void testDivisionOneNull() throws InvalidNumberException {
        //(null+null)

    }

    public void testDivisionothNull() throws InvalidNumberException {
        //(null+null)

    }

    /*
      
     */
}

/*
    @Test //Mutiply
    public void testMultiply() {
        //re > 0 && im > 0
        complexA.setRe(1);
        complexA.setIm(1);
        complexB.setRe(2);
        complexB.setIm(1);
        assertEquals(new Complex(1, 3), complexA.multiply(complexB));
        assertEquals(new Complex(1, 3), complexB.multiply(complexA));
        //re < 0 && im > 0
        complexA.setRe(-1);
        complexA.setIm(1);
        complexB.setRe(-2);
        complexB.setIm(1);
        assertEquals(new Complex(1, -3), complexA.multiply(complexB));
        assertEquals(new Complex(1, -3), complexB.multiply(complexA));
        //re < 0 && im < 0
        complexA.setRe(-1);
        complexA.setIm(-1);
        complexB.setRe(-2);
        complexB.setIm(-1);
        assertEquals(new Complex(1, 3), complexA.multiply(complexB));
        assertEquals(new Complex(1, 3), complexB.multiply(complexA));
        //re > 0 && im < 0
        complexA.setRe(1);
        complexA.setIm(-1);
        complexB.setRe(2);
        complexB.setIm(-1);
        assertEquals(new Complex(1, -3), complexA.multiply(complexB));
        assertEquals(new Complex(1, -3), complexB.multiply(complexA));
        //A -> re=0, im != 0
        complexA.setRe(0);
        complexA.setIm(1);
        complexB.setRe(-2);
        complexB.setIm(1);
        assertEquals(new Complex(-1, -2), complexA.multiply(complexB));
        assertEquals(new Complex(-1, -2), complexB.multiply(complexA));
        //re!=0, im = 0
        complexA.setRe(1);
        complexA.setIm(0);
        complexB.setRe(-2);
        complexB.setIm(1);
        assertEquals(new Complex(-2, 1), complexA.multiply(complexB));
        assertEquals(new Complex(-2, 1), complexB.multiply(complexA));
        //A, B -> re!=0, A, B -> im = 0, return real number
        complexA.setRe(1);
        complexA.setIm(0);
 */
