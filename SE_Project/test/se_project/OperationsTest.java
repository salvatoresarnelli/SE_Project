/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import org.junit.*;
import org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import se_project.ComplexNumber;
import se_project.Operations;
import se_project.exceptions.InvalidNumberException;

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
       
    }   public void testDotOneNull() throws InvalidNumberException {
    //(null+null)
        
    }    
    
    public void testDotBothNull() throws InvalidNumberException {
    //(null+null)
       
    }   public void testDivisionOneNull() throws InvalidNumberException {
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
