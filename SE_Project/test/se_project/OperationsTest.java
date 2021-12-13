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
import se_project.exceptions.DivisionByZeroException;
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
        result.setRealPart(-1);
        result.setImaginaryPart(1);
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

    @Test
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
        result.setRealPart(-1);
        result.setImaginaryPart(-1);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(2);
        b.setImaginaryPart(2);
        assertEquals(result, Operations.differenceOperation(a, b));
    }

    /*----------------------------DIFFERENCE--------------------------------*/
    @Test
    public void testDifferenceRPositiveIPositiveRPositiveINegative() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(-1);
        result.setImaginaryPart(6);
        a.setRealPart(1);
        a.setImaginaryPart(4);
        b.setRealPart(2);
        b.setImaginaryPart(-2);
        assertEquals(result, Operations.differenceOperation(a, b));

    }

    @Test
    public void testDifferenceRPositiveIPositiveRNegativeIPositive() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(2);
        result.setImaginaryPart(-1);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        assertEquals(result, Operations.differenceOperation(a, b));
    }

    @Test
    public void testDifferenceRPositiveIPositiveRNegativeINegative() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(15);
        result.setImaginaryPart(15);
        a.setRealPart(10);
        a.setImaginaryPart(10);
        b.setRealPart(-5);
        b.setImaginaryPart(-5);
        assertEquals(result, Operations.differenceOperation(a, b));
    }

    @Test
    public void testDifferenceRPositiveINegativeRPositiveIPositive() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(-1);
        result.setImaginaryPart(-5);
        a.setRealPart(2);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(2);
        assertEquals(result, Operations.differenceOperation(a, b));

    }

    @Test
    public void testDifferenceRPositiveINegativeRPositiveINegative() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(1);
        result.setImaginaryPart(-1);
        a.setRealPart(4);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        assertEquals(result, Operations.differenceOperation(a, b));

    }

    @Test

    public void testDifferenceRPositiveINegativeRNegativeIPositive() throws InvalidNumberException {

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(3);
        result.setImaginaryPart(-5);
        a.setRealPart(1);
        a.setImaginaryPart(-2);
        b.setRealPart(-2);
        b.setImaginaryPart(3);
        assertEquals(result, Operations.differenceOperation(a, b));

    }

    @Test

    public void testDifferenceRPositiveINegativeRNegativeINegative() throws InvalidNumberException {

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(3);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(-3);
        b.setRealPart(-2);
        b.setImaginaryPart(-3);
        assertEquals(result, Operations.differenceOperation(a, b));

    }

    @Test

    public void testDifferenceRNegativeIPositiveRPositiveIPositive() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(-8);
        result.setImaginaryPart(-1);
        a.setRealPart(-3);
        a.setImaginaryPart(2);
        b.setRealPart(5);
        b.setImaginaryPart(3);
        assertEquals(result, Operations.differenceOperation(a, b));
    }

    @Test

    public void testDifferenceRNegativeIPositiveRPositiveINegative() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(-4);
        result.setImaginaryPart(5);
        a.setRealPart(-1);
        a.setImaginaryPart(2);
        b.setRealPart(3);
        b.setImaginaryPart(-3);
        assertEquals(result, Operations.differenceOperation(a, b));

    }

    @Test

    public void testDifferenceRNegativeIPositiveRNegativeIPositive() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(1);
        result.setImaginaryPart(1);
        a.setRealPart(-1);
        a.setImaginaryPart(3);
        b.setRealPart(-2);
        b.setImaginaryPart(2);

        assertEquals(result, Operations.differenceOperation(a, b));

    }

    @Test

    public void testDifferenceRNegativeIPositiveRNegativeINegative() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(1);
        result.setImaginaryPart(4);
        a.setRealPart(-2);
        a.setImaginaryPart(3);
        b.setRealPart(-3);
        b.setImaginaryPart(-1);
        assertEquals(result, Operations.differenceOperation(a, b));

    }

    @Test

    public void testDifferenceRNegativeINegativeRPositiveIPositive() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(-6);
        result.setImaginaryPart(-6);
        a.setRealPart(-2);
        a.setImaginaryPart(-3);
        b.setRealPart(4);
        b.setImaginaryPart(3);
        assertEquals(result, Operations.differenceOperation(a, b));
    }

    @Test

    public void testDifferenceRNegativeINegativeRPositiveINegative() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).

        result.setRealPart(-4);
        result.setImaginaryPart(0);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        assertEquals(result, Operations.differenceOperation(a, b));

    }

    @Test

    public void testDifferenceRNegativeINegativeRNegativeIPositve() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(0);
        result.setImaginaryPart(-3);
        a.setRealPart(-1);
        a.setImaginaryPart(-1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        assertEquals(result, Operations.differenceOperation(a, b));

    }

    @Test
    public void testDifferenceRNegativeINegativeRNegativeINegative() throws InvalidNumberException {

        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(0);
        result.setImaginaryPart(-1);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(-1);
        b.setImaginaryPart(-1);
        assertEquals(result, Operations.differenceOperation(a, b));

    }

    @Test

    public void testDifferenceRPositiveIZeroRPositiveIZero() throws InvalidNumberException {

        //(Real Part >0,Im=0) + (Real Part>0,Im=0)
        result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(1);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.differenceOperation(a, b));
    }

    @Test
    public void testDifferenceRPositiveIZeroRNegativeIZero() throws InvalidNumberException {
        //(Real Part>0, Im=0) + (Real Part<0,Im=0) 
        result.setRealPart(5);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(-4);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.differenceOperation(a, b));

    }

    @Test

    public void testDifferenceRNegativeIZeroRNegativeIZero() throws InvalidNumberException {
        //(Real Part<0, Im =0) + (Real Part<0, Im=0)
        result.setRealPart(1);
        result.setImaginaryPart(0);
        a.setRealPart(-1);
        a.setImaginaryPart(0);
        b.setRealPart(-2);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.differenceOperation(a, b));

    }

    @Test

    public void testDifferenceRZeroIPositiveRZeroIPositive() throws InvalidNumberException {
        // (Real Part=0, Im>0) + (Real Part=0, Im>0)
        result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(0);
        a.setImaginaryPart(1);
        b.setRealPart(0);
        b.setImaginaryPart(1);
        assertEquals(result, Operations.differenceOperation(a, b));

    }

    @Test

    public void testDifferenceRZeroIZeroRZeroIZero() throws InvalidNumberException {
        //(Real Part=0,Im =0) + (Real Part=0, Im=0)
        result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(0);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.differenceOperation(a, b));

    }

    @Test

    public void testDifferenceRNonZeroIZeroRZeroINonZero() throws InvalidNumberException {
        //(Real Part!=0,Im =0) + (Real Part=0, Im!=0)
        result.setRealPart(1);
        result.setImaginaryPart(-3);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(3);
        assertEquals(result, Operations.differenceOperation(a, b));

    }

    @Test

    public void testDifferenceOpposite() throws InvalidNumberException {
        //(Real Part=A,Im =B) + (Real Part=-A, Im=-B)
        result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(6);
        a.setImaginaryPart(7);
        b.setRealPart(6);
        b.setImaginaryPart(7);
        assertEquals(result, Operations.differenceOperation(a, b));

    }

    /*----------------------------PRODUCT----------------------------------------*/
    @Test
    public void testDotRPositiveIPositiveRPositiveINegative() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(10);
        result.setImaginaryPart(6);
        a.setRealPart(1);
        a.setImaginaryPart(4);
        b.setRealPart(2);
        b.setImaginaryPart(-2);
        assertEquals(result, Operations.dotOperation(a, b));

    }

    @Test
    public void testDotRPositiveIPositiveRNegativeIPositive() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(0);
        result.setImaginaryPart(6);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(3);
        b.setImaginaryPart(3);
        assertEquals(result, Operations.dotOperation(a, b));
    }

    @Test
    public void testDotRPositiveIPositiveRNegativeINegative() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(0);
        result.setImaginaryPart(-100);
        a.setRealPart(10);
        a.setImaginaryPart(10);
        b.setRealPart(-5);
        b.setImaginaryPart(-5);
        assertEquals(result, Operations.dotOperation(a, b));
    }

    @Test
    public void testDotRPositiveINegativeRPositiveIPositive() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(12);
        result.setImaginaryPart(-5);
        a.setRealPart(2);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(2);
        assertEquals(result, Operations.dotOperation(a, b));

    }

    @Test
    public void testDotRPositiveINegativeRPositiveINegative() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(6);
        result.setImaginaryPart(-17);
        a.setRealPart(4);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        assertEquals(result, Operations.dotOperation(a, b));

    }

    @Test
    public void testDotRPositiveINegativeRNegativeIPositive() throws InvalidNumberException {

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(4);
        result.setImaginaryPart(7);
        a.setRealPart(1);
        a.setImaginaryPart(-2);
        b.setRealPart(-2);
        b.setImaginaryPart(3);
        assertEquals(result, Operations.dotOperation(a, b));

    }

    @Test
    public void testDotRPositiveINegativeRNegativeINegative() throws InvalidNumberException {

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-11);
        result.setImaginaryPart(+3);
        a.setRealPart(1);
        a.setImaginaryPart(-3);
        b.setRealPart(-2);
        b.setImaginaryPart(-3);
        assertEquals(result, Operations.dotOperation(a, b));

    }

    @Test
    public void testDotRNegativeIPositiveRPositiveIPositive() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(-21);
        result.setImaginaryPart(1);
        a.setRealPart(-3);
        a.setImaginaryPart(2);
        b.setRealPart(5);
        b.setImaginaryPart(3);
        assertEquals(result, Operations.dotOperation(a, b));
    }

    @Test
    public void testDotRNegativeIPositiveRPositiveINegative() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(3);
        result.setImaginaryPart(9);
        a.setRealPart(-1);
        a.setImaginaryPart(2);
        b.setRealPart(3);
        b.setImaginaryPart(-3);
        assertEquals(result, Operations.dotOperation(a, b));

    }

    @Test
    public void testDotRNegativeIPositiveRNegativeIPositive() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(-4);
        result.setImaginaryPart(-8);
        a.setRealPart(-1);
        a.setImaginaryPart(3);
        b.setRealPart(-2);
        b.setImaginaryPart(2);

        assertEquals(result, Operations.dotOperation(a, b));

    }

    @Test
    public void testDotRNegativeIPositiveRNegativeINegative() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(9);
        result.setImaginaryPart(-7);
        a.setRealPart(-2);
        a.setImaginaryPart(3);
        b.setRealPart(-3);
        b.setImaginaryPart(-1);
        assertEquals(result, Operations.dotOperation(a, b));

    }

    @Test
    public void testDotRNegativeINegativeRPositiveIPositive() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(1);
        result.setImaginaryPart(-18);
        a.setRealPart(-2);
        a.setImaginaryPart(-3);
        b.setRealPart(4);
        b.setImaginaryPart(3);
        assertEquals(result, Operations.dotOperation(a, b));
    }

    @Test
    public void testDotRNegativeINegativeRPositiveINegative() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).

        result.setRealPart(-7);
        result.setImaginaryPart(-4);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        assertEquals(result, Operations.dotOperation(a, b));

    }

    @Test
    public void testDotRNegativeINegativeRNegativeIPositve() throws InvalidNumberException {
        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(3);
        result.setImaginaryPart(-1);
        a.setRealPart(-1);
        a.setImaginaryPart(-1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        assertEquals(result, Operations.dotOperation(a, b));

    }

    @Test
    public void testDotRNegativeINegativeRNegativeINegative() throws InvalidNumberException {

        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-1);
        result.setImaginaryPart(3);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(-1);
        b.setImaginaryPart(-1);
        assertEquals(result, Operations.dotOperation(a, b));

    }

    @Test
    public void testDotRPositiveIZeroRPositiveIZero() throws InvalidNumberException {

        //(Real Part >0,Im=0) + (Real Part>0,Im=0)
        result.setRealPart(1);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(1);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.dotOperation(a, b));
    }

    @Test
    public void testDotRPositiveIZeroRNegativeIZero() throws InvalidNumberException {
        //(Real Part>0, Im=0) + (Real Part<0,Im=0) 
        result.setRealPart(-4);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(-4);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.dotOperation(a, b));

    }

    @Test
    public void testDotRNegativeIZeroRNegativeIZero() throws InvalidNumberException {
        //(Real Part<0, Im =0) + (Real Part<0, Im=0)
        result.setRealPart(2);
        result.setImaginaryPart(0);
        a.setRealPart(-1);
        a.setImaginaryPart(0);
        b.setRealPart(-2);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.dotOperation(a, b));

    }

    @Test
    public void testDotRZeroIPositiveRZeroIPositive() throws InvalidNumberException {
        // (Real Part=0, Im>0) + (Real Part=0, Im>0)
        result.setRealPart(-1);
        result.setImaginaryPart(0);
        a.setRealPart(0);
        a.setImaginaryPart(1);
        b.setRealPart(0);
        b.setImaginaryPart(1);
        assertEquals(result, Operations.dotOperation(a, b));

    }

    @Test
    public void testDotRZeroIZeroRZeroIZero() throws InvalidNumberException {
        //(Real Part=0,Im =0) + (Real Part=0, Im=0)
        result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(0);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.dotOperation(a, b));

    }

    @Test
    public void testDotRNonZeroIZeroRZeroINonZero() throws InvalidNumberException {
        //(Real Part!=0,Im =0) + (Real Part=0, Im!=0)
        result.setRealPart(0);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(3);
        assertEquals(result, Operations.dotOperation(a, b));

    }

    @Test
    public void testDotOpposite() throws InvalidNumberException {
        //(Real Part=A,Im =B) + (Real Part=A, Im=B)
        result.setRealPart(1);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(2);
        b.setRealPart(0.2);
        b.setImaginaryPart(-0.4);
        assertEquals(result, Operations.dotOperation(a, b));
    }

    /*----------------------------DIVISION----------------------------------------*/
    @Test
    public void testDivisionRPositiveIPositiveRPositiveINegative() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException {
        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(-0.7500);
        result.setImaginaryPart(1.2500);
        a.setRealPart(1);
        a.setImaginaryPart(4);
        b.setRealPart(2);
        b.setImaginaryPart(-2);
        assertEquals(result.getRealPart(), Operations.divisionOperation(a, b).getRealPart(), 0.3);
        assertEquals(result.getImaginaryPart(), Operations.divisionOperation(a, b).getImaginaryPart(), 0.3);

    }

    @Test
    public void testDivisionRPositiveIPositiveRNegativeIPositive() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException {
        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(0.2);
        result.setImaginaryPart(-0.6);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        assertEquals(result.getRealPart(), Operations.divisionOperation(a, b).getRealPart(), 0.3);
        assertEquals(result.getImaginaryPart(), Operations.divisionOperation(a, b).getImaginaryPart(), 0.3);

    }

    @Test
    public void testDivisionRPositiveIPositiveRNegativeINegative() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException {
        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-2);
        result.setImaginaryPart(0);
        a.setRealPart(10);
        a.setImaginaryPart(10);
        b.setRealPart(-5);
        b.setImaginaryPart(-5);
        assertEquals(result.getRealPart(), Operations.divisionOperation(a, b).getRealPart(), 0.3);
        assertEquals(result.getImaginaryPart(), Operations.divisionOperation(a, b).getImaginaryPart(), 0.3);

    }

    @Test
    public void testDivisionRPositiveINegativeRPositiveIPositive() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException {
        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(0);
        result.setImaginaryPart(-1);
        a.setRealPart(2);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(2);
        assertEquals(result, Operations.divisionOperation(a, b));

    }

    @Test

    public void testDivisionRPositiveINegativeRPositiveINegative() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException {
        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(1.3846);
        result.setImaginaryPart(-0.0769);
        a.setRealPart(4);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        assertEquals(result.getRealPart(), Operations.divisionOperation(a, b).getRealPart(), 0.3);
        assertEquals(result.getImaginaryPart(), Operations.divisionOperation(a, b).getImaginaryPart(), 0.3);

    }

    @Test

    public void testDivisionRPositiveINegativeRNegativeIPositive() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException {

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(-0.6154);
        result.setImaginaryPart(0.077);
        a.setRealPart(1);
        a.setImaginaryPart(-2);
        b.setRealPart(-2);
        b.setImaginaryPart(3);
        assertEquals(result.getRealPart(), Operations.divisionOperation(a, b).getRealPart(), 0.3);
        assertEquals(result.getImaginaryPart(), Operations.divisionOperation(a, b).getImaginaryPart(), 0.3);

    }

    @Test

    public void testDivisionRPositiveINegativeRNegativeINegative() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException {

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(0.5385);
        result.setImaginaryPart(0.6923);
        a.setRealPart(1);
        a.setImaginaryPart(-3);
        b.setRealPart(-2);
        b.setImaginaryPart(-3);
        assertEquals(result.getRealPart(), Operations.divisionOperation(a, b).getRealPart(), 0.3);
        assertEquals(result.getImaginaryPart(), Operations.divisionOperation(a, b).getImaginaryPart(), 0.3);

    }

    @Test

    public void testDivisionRNegativeIPositiveRPositiveIPositive() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException {
        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(-0.2647);

        result.setImaginaryPart(0.5588);
        a.setRealPart(-3);
        a.setImaginaryPart(2);
        b.setRealPart(5);
        b.setImaginaryPart(3);
        assertEquals(result.getRealPart(), Operations.divisionOperation(a, b).getRealPart(), 0.3);
        assertEquals(result.getImaginaryPart(), Operations.divisionOperation(a, b).getImaginaryPart(), 0.3);

    }

    @Test

    public void testDivisionRNegativeIPositiveRPositiveINegative() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException {
        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(-0.5000);
        result.setImaginaryPart(0.1667);
        a.setRealPart(-1);
        a.setImaginaryPart(2);
        b.setRealPart(3);
        b.setImaginaryPart(-3);
        assertEquals(result.getRealPart(), Operations.divisionOperation(a, b).getRealPart(), 0.3);
        assertEquals(result.getImaginaryPart(), Operations.divisionOperation(a, b).getImaginaryPart(), 0.3);

    }

    @Test

    public void testDivisionRNegativeIPositiveRNegativeIPositive() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException {
        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(1.0000);
        result.setImaginaryPart(-0.5);
        a.setRealPart(-1);
        a.setImaginaryPart(3);
        b.setRealPart(-2);
        b.setImaginaryPart(2);

        assertEquals(result.getRealPart(), Operations.divisionOperation(a, b).getRealPart(), 0.3);
        assertEquals(result.getImaginaryPart(), Operations.divisionOperation(a, b).getImaginaryPart(), 0.3);

    }

    @Test

    public void testDivisionRNegativeIPositiveRNegativeINegative() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException {
        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(0.3000);
        result.setImaginaryPart(-1.1000);
        a.setRealPart(-2);
        a.setImaginaryPart(3);
        b.setRealPart(-3);
        b.setImaginaryPart(-1);
        assertEquals(result, Operations.divisionOperation(a, b));

    }

    @Test

    public void testDivisionRNegativeINegativeRPositiveIPositive() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException {
        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(-0.6800);
        result.setImaginaryPart(-0.2400);
        a.setRealPart(-2);
        a.setImaginaryPart(-3);
        b.setRealPart(4);
        b.setImaginaryPart(3);
        assertEquals(result.getRealPart(), Operations.divisionOperation(a, b).getRealPart(), 0.3);
        assertEquals(result.getImaginaryPart(), Operations.divisionOperation(a, b).getImaginaryPart(), 0.3);

    }

    @Test

    public void testDivisionRNegativeINegativeRPositiveINegative() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException {
        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).

        result.setRealPart(0.0769);
        result.setImaginaryPart(-0.6154);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        assertEquals(result.getRealPart(), Operations.divisionOperation(a, b).getRealPart(), 0.3);
        assertEquals(result.getImaginaryPart(), Operations.divisionOperation(a, b).getImaginaryPart(), 0.3);

    }

    @Test
    public void testDivisionRNegativeINegativeRNegativeIPositve() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException {
        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(-0.2000);
        result.setImaginaryPart(0.6000);
        a.setRealPart(-1);
        a.setImaginaryPart(-1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        assertEquals(result.getRealPart(), Operations.divisionOperation(a, b).getRealPart(), 0.3);
        assertEquals(result.getImaginaryPart(), Operations.divisionOperation(a, b).getImaginaryPart(), 0.3);

    }

    @Test

    public void testDivisionRNegativeINegativeRNegativeINegative() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException {

        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(1.5000);
        result.setImaginaryPart(0.5000);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(-1);
        b.setImaginaryPart(-1);
        assertEquals(result, Operations.divisionOperation(a, b));

    }

    @Test

    public void testDivisionRPositiveIZeroRPositiveIZero() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException {

        //(Real Part >0,Im=0) + (Real Part>0,Im=0)
        result.setRealPart(1);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(1);
        b.setImaginaryPart(0);
        assertEquals(result, Operations.divisionOperation(a, b));
    }

    @Test
    public void testDivisionRPositiveIZeroRNegativeIZero() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException {
        //(Real Part>0, Im=0) + (Real Part<0,Im=0) 
        result.setRealPart(-0.25);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(-4);
        b.setImaginaryPart(0);
        assertEquals(result.getRealPart(), Operations.divisionOperation(a, b).getRealPart(), 0.3);
        assertEquals(result.getImaginaryPart(), Operations.divisionOperation(a, b).getImaginaryPart(), 0.3);

    }

    @Test

    public void testDivisionRNegativeIZeroRNegativeIZero() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException {
        //(Real Part<0, Im =0) + (Real Part<0, Im=0)
        result.setRealPart(0.5);
        result.setImaginaryPart(0);
        a.setRealPart(-1);
        a.setImaginaryPart(0);
        b.setRealPart(-2);
        b.setImaginaryPart(0);
        assertEquals(result.getRealPart(), Operations.divisionOperation(a, b).getRealPart(), 0.3);
        assertEquals(result.getImaginaryPart(), Operations.divisionOperation(a, b).getImaginaryPart(), 0.3);

    }

    @Test

    public void testDivisionRZeroIPositiveRZeroIPositive() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException {
        // (Real Part=0, Im>0) + (Real Part=0, Im>0)
        result.setRealPart(1);
        result.setImaginaryPart(0);
        a.setRealPart(0);
        a.setImaginaryPart(1);
        b.setRealPart(0);
        b.setImaginaryPart(1);
        assertEquals(result.getRealPart(), Operations.divisionOperation(a, b).getRealPart(), 0.3);
        assertEquals(result.getImaginaryPart(), Operations.divisionOperation(a, b).getImaginaryPart(), 0.3);

    }

    @Test(expected = DivisionByZeroException.class)

    public void testDivisionRZeroIZeroRZeroIZero() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException {
        //(Real Part=0,Im =0) + (Real Part=0, Im=0)
        a.setRealPart(0);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(0);
        Operations.divisionOperation(a, b);

    }

    @Test

    public void testDivisionRNonZeroIZeroRZeroINonZero() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException {
        //(Real Part!=0,Im =0) + (Real Part=0, Im!=0)
        result.setRealPart(0);
        result.setImaginaryPart(-0.3333);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(3);
        assertEquals(result.getRealPart(), Operations.divisionOperation(a, b).getRealPart(), 0.3);
        assertEquals(result.getImaginaryPart(), Operations.divisionOperation(a, b).getImaginaryPart(), 0.3);

    }

    @Test

    public void testDivisionOpposite() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException {
        //(Real Part=A,Im =B) + (Real Part=-A, Im=-B)
        result.setRealPart(1);
        result.setImaginaryPart(0);
        a.setRealPart(6);
        a.setImaginaryPart(7);
        b.setRealPart(6);
        b.setImaginaryPart(7);
        assertEquals(result.getRealPart(), Operations.divisionOperation(a, b).getRealPart(), 0.3);
        assertEquals(result.getImaginaryPart(), Operations.divisionOperation(a, b).getImaginaryPart(), 0.3);

    }

    /*----------------------------SIGN----------------------------------------*/
    @Test
    public void testSignZeros() throws InvalidNumberException {
        a.setRealPart(0);
        a.setImaginaryPart(0);
        result.setImaginaryPart(0);
        result.setRealPart(0);
        assertEquals(result, Operations.signOperation(a));
    }

    @Test
    public void testSignImaginaryOnly() throws InvalidNumberException {
        a.setRealPart(0);
        a.setImaginaryPart(1);
        result.setImaginaryPart(-1);
        result.setRealPart(0);
        assertEquals(result, Operations.signOperation(a));
    }

    @Test
    public void testSignComplexWithBothParts() throws InvalidNumberException {
        a.setRealPart(1);
        a.setImaginaryPart(1);
        result.setImaginaryPart(-1);
        result.setRealPart(-1);
        assertEquals(result, Operations.signOperation(a));

    }

    /*----------------------------SQRT----------------------------------------*/
    @Test
    public void testSqrtRNegativeIZero() throws InvalidNumberException {

        LinkedList<ComplexNumber> results = new LinkedList<>();
        results.add(new ComplexNumber(0, 2));
        results.add(new ComplexNumber(0, -2));
        a.setRealPart(-4);
        a.setImaginaryPart(0);
        LinkedList<ComplexNumber> obtained = Operations.squareRoot(a);
        results.forEach(number -> {
            assertTrue(obtained.contains(number));
        });
    }

    @Test
    public void testSqrtRPositiveIZero() throws InvalidNumberException {

        LinkedList<ComplexNumber> results = new LinkedList<>();
        results.add(new ComplexNumber(2, 0));
        results.add(new ComplexNumber(-2, 0));
        a.setRealPart(4);
        a.setImaginaryPart(0);
        LinkedList<ComplexNumber> obtained = Operations.squareRoot(a);
        results.forEach(number -> {
            assertTrue(obtained.contains(number));
        });
    }

    @Test
    public void testSqrtRZeroIPositive() throws InvalidNumberException {

        LinkedList<ComplexNumber> results = new LinkedList<>();
        results.add(new ComplexNumber(1.4142, 1.4142));
        results.add(new ComplexNumber(-1.4142, -1.4142));
        a.setRealPart(0);
        a.setImaginaryPart(4);
        LinkedList<ComplexNumber> obtained = Operations.squareRoot(a);
        results.forEach(number -> {
            assertTrue(obtained.contains(number));
        });
    }

    @Test
    public void testSqrtRZeroINegative() throws InvalidNumberException {

        LinkedList<ComplexNumber> results = new LinkedList<>();
        results.add(new ComplexNumber(1.4142, -1.4142));
        results.add(new ComplexNumber(-1.4142, 1.4142));
        a.setRealPart(0);
        a.setImaginaryPart(-4);
        LinkedList<ComplexNumber> obtained = Operations.squareRoot(a);
        results.forEach(number -> {
            assertTrue(obtained.contains(number));
        });
    }

    @Test
    public void testSqrtRPositiveIPositive() throws InvalidNumberException {
        LinkedList<ComplexNumber> results = new LinkedList<>();
        results.add(new ComplexNumber(1.5538, 0.6436));
        results.add(new ComplexNumber(-1.5538, -0.6436));
        a.setRealPart(2);
        a.setImaginaryPart(2);
        LinkedList<ComplexNumber> obtained = Operations.squareRoot(a);
        results.forEach(number -> {
            assertTrue(obtained.contains(number));
        });
    }

    @Test
    public void testSqrtRNegativeIPositive() throws InvalidNumberException {
        LinkedList<ComplexNumber> results = new LinkedList<>();
        results.add(new ComplexNumber(0.6436, 1.5538));
        results.add(new ComplexNumber(-0.6436, -1.5538));
        a.setRealPart(-2);
        a.setImaginaryPart(2);
        LinkedList<ComplexNumber> obtained = Operations.squareRoot(a);
        results.forEach(number -> {
            assertTrue(obtained.contains(number));
        });
    }

    @Test
    public void testSqrtPhaseUndefined() throws InvalidNumberException {
        LinkedList<ComplexNumber> results = new LinkedList<>();
        results.add(new ComplexNumber(0, 0));
        a.setRealPart(0);
        a.setImaginaryPart(0);
        LinkedList<ComplexNumber> obtained = Operations.squareRoot(a);
        results.forEach(number -> {
            assertTrue(obtained.contains(number));
        });
    }

    @Test
    public void testSqrtRNegativeINegative() throws InvalidNumberException {
        LinkedList<ComplexNumber> results = new LinkedList<>();

        results.add(new ComplexNumber(0.6436, -1.5538));
        results.add(new ComplexNumber(-0.6436, +1.5538));
        a.setRealPart(-2);
        a.setImaginaryPart(-2);
        LinkedList<ComplexNumber> obtained = Operations.squareRoot(a);
        results.forEach(number -> {
            assertTrue(obtained.contains(number));
        });
    }

    /*-------------------------NULL POINTER-----------------------------------*/
    @Test(expected = InvalidNumberException.class)
    public void testSumOneNull() throws InvalidNumberException {
        ComplexNumber x = null;
        a.setRealPart(1);
        a.setImaginaryPart(0);
        Operations.addOperation(x, a);

    }

    @Test(expected = InvalidNumberException.class)
    public void testSumBothNull() throws InvalidNumberException {
        ComplexNumber x = null;
        ComplexNumber y = null;
        Operations.addOperation(x, y);
    }

    @Test(expected = InvalidNumberException.class)
    public void testDifferenceOneNull() throws InvalidNumberException {
        ComplexNumber x = null;
        a.setRealPart(1);
        a.setImaginaryPart(0);
        Operations.differenceOperation(x, a);

    }

    @Test(expected = InvalidNumberException.class)
    public void testDifferenceBothNull() throws InvalidNumberException {
        //(null-null)
        ComplexNumber x = null;
        ComplexNumber y = null;
        Operations.differenceOperation(x, y);
    }

    @Test(expected = InvalidNumberException.class)
    public void testDotOneNull() throws InvalidNumberException {
        //(null+null)
        ComplexNumber x = null;
        a.setRealPart(1);
        a.setImaginaryPart(0);
        Operations.dotOperation(x, a);

    }

    @Test(expected = InvalidNumberException.class)
    public void testDotBothNull() throws InvalidNumberException {
        //(null*null)
        ComplexNumber x = null;
        ComplexNumber y = null;
        Operations.dotOperation(x, y);

    }

    @Test(expected = InvalidNumberException.class)
    public void testDivisionOneNull() throws InvalidNumberException, DivisionByZeroException {
        //(null+null)
        ComplexNumber x = null;
        a.setRealPart(1);
        a.setImaginaryPart(0);
        Operations.divisionOperation(x, a);

    }

    @Test(expected = InvalidNumberException.class)
    public void testDivisionothNull() throws InvalidNumberException, DivisionByZeroException {
        //(null+null)
        ComplexNumber x = null;
        ComplexNumber y = null;
        Operations.divisionOperation(x, y);

    }

    @Test(expected = InvalidNumberException.class)
    public void testSignNull() throws InvalidNumberException {
        ComplexNumber x = null;
        Operations.signOperation(x);
    }

    @Test(expected = InvalidNumberException.class)
    public void testSqrtNull() throws InvalidNumberException {
        ComplexNumber x = null;
        Operations.squareRoot(x);
    }
    
    /*-------------------------COS-----------------------------------*/
    
    @Test
    public void testCos_1() throws InvalidNumberException, DivisionByZeroException{
        //cos(Real Part <0, Imaginary Part <0).
        result.setRealPart(11.331026594588057);
        result.setImaginaryPart(7.45511362411162);
        a.setRealPart(-5.7);
        a.setImaginaryPart(-3.3);
        assertEquals(result,Operations.cos(a).getLast());
    }
    
    @Test
    public void testCos_2() throws InvalidNumberException, DivisionByZeroException{
        //cos(Real Part >0, Imaginary Part >0).
        result.setRealPart(-6.038390978838917);
        result.setImaginaryPart(+1.0547126729205143);
        a.setRealPart(9.6);
        a.setImaginaryPart(2.5);
        assertEquals(result,Operations.cos(a).getLast());
    }
    
    @Test
    public void testCos_3() throws InvalidNumberException, DivisionByZeroException{
        //cos(Real Part >0, Imaginary Part <0).
        result.setRealPart(-6.038390978838917);
        result.setImaginaryPart(-1.0547126729205143);
        a.setRealPart(9.6);
        a.setImaginaryPart(-2.5);
        assertEquals(result,Operations.cos(a).getLast());
    }
    
    @Test
    public void testCos_4() throws InvalidNumberException, DivisionByZeroException{
        //cos(Real Part <0, Imaginary Part >0).
        result.setRealPart(11.331026594588057);
        result.setImaginaryPart(-7.45511362411162);
        a.setRealPart(-5.7);
        a.setImaginaryPart(3.3);        
        assertEquals(result,Operations.cos(a).getLast());
    }
    
    @Test
    public void testCos_5() throws InvalidNumberException, DivisionByZeroException{
        //cos(Real Part <0, Imaginary Part =0).         
        a.setRealPart(-6.7);
        result.setRealPart(0.9143831482353194);
        assertEquals(result,Operations.cos(a).getLast());
    }
    
    @Test
    public void testCos_6() throws InvalidNumberException, DivisionByZeroException{
        //cos(Real Part =0, Imaginary Part >0).         
        a.setImaginaryPart(8.8);
        result.setRealPart(3317.1220785054825);
        assertEquals(result,Operations.cos(a).getLast());
    }
    
    @Test
    public void testCos_7() throws InvalidNumberException, DivisionByZeroException{
        //cos(Real Part =0, Imaginary Part <0).         
        a.setImaginaryPart(-3.4);
        result.setRealPart(14.998736658678668);
        assertEquals(result,Operations.cos(a).getLast());
    }
    
    @Test
    public void testCos_8() throws InvalidNumberException, DivisionByZeroException{
        //cos(Real Part >0, Imaginary Part =0).         
        a.setRealPart(0.8);
        result.setRealPart(0.6967067093471654);
        assertEquals(result,Operations.cos(a).getLast());
    }
    
    /*-------------------------SIN-----------------------------------*/
    
    @Test
    public void testSin_1() throws InvalidNumberException, DivisionByZeroException{
        //sin(Real Part <0, Imaginary Part <0).
        result.setRealPart(7.475424651164692);
        result.setImaginaryPart(-11.300239743212877);
        a.setRealPart(-5.7);
        a.setImaginaryPart(-3.3);
        assertEquals(result,Operations.sin(a).getLast());
    }
    
    @Test
    public void testSin_2() throws InvalidNumberException, DivisionByZeroException{
        //sin(Real Part >0, Imaginary Part >0).
        result.setRealPart(-1.0690222865173111);
        result.setImaginaryPart(-5.957562877551087);
        a.setRealPart(9.6);
        a.setImaginaryPart(2.5);
        assertEquals(result,Operations.sin(a).getLast());
    }
    
    @Test
    public void testSin_3() throws InvalidNumberException, DivisionByZeroException{
        //sin(Real Part >0, Imaginary Part <0).
        result.setRealPart(-1.0690222865173111);
        result.setImaginaryPart(5.957562877551087);
        a.setRealPart(9.6);
        a.setImaginaryPart(-2.5);
        assertEquals(result,Operations.sin(a).getLast());
    }
    
    @Test
    public void testSin_4() throws InvalidNumberException, DivisionByZeroException{
       //sin(Real Part <0, Imaginary Part >0).
        result.setRealPart(7.475424651164692);
        result.setImaginaryPart(11.300239743212877);
        a.setRealPart(-5.7);
        a.setImaginaryPart(3.3);
        assertEquals(result,Operations.sin(a).getLast());
    }
    
    @Test
    public void testSin_5() throws InvalidNumberException, DivisionByZeroException{
        //sin(Real Part <0, Imaginary Part =0).         
        a.setRealPart(-6.7);
        result.setRealPart(-0.4048499206165983);
        assertEquals(result,Operations.sin(a).getLast());
    }
    
    @Test
    public void testSin_6() throws InvalidNumberException, DivisionByZeroException{
        //sin(Real Part =0, Imaginary Part >0).
        a.setImaginaryPart(8.8);
        result.setImaginaryPart(3317.121927772407);
        assertEquals(result,Operations.sin(a).getLast());
    }
    
    @Test
    public void testSin_7() throws InvalidNumberException, DivisionByZeroException{
        //sin(Real Part =0, Imaginary Part <0).
        a.setImaginaryPart(-3.4);
        result.setImaginaryPart(-14.965363388718343);
        assertEquals(result,Operations.sin(a).getLast());
    }
    
    @Test
    public void testSin_8() throws InvalidNumberException, DivisionByZeroException{
        //sin(Real Part >0, Imaginary Part =0).         
        a.setRealPart(0.8);
        result.setRealPart(0.7173560908995228);
        assertEquals(result,Operations.sin(a).getLast());
    }
    
    /*-------------------------TAN-----------------------------------*/
    
    @Test
    public void testTan_1() throws InvalidNumberException, DivisionByZeroException{
        //tan(Real Part <0, Imaginary Part <0).
        result.setRealPart(0.0024985707289502767);
        result.setImaginaryPart(-0.9989268648704096);
        a.setRealPart(-5.7);
        a.setImaginaryPart(-3.3);
        assertEquals(result,Operations.tan(a).getLast());
    }
    
    @Test
    public void testTan_2() throws InvalidNumberException, DivisionByZeroException{
        //tan(Real Part >0, Imaginary Part >0).
        result.setRealPart(0.004568446118239934);
        result.setImaginaryPart(+0.9874122587394989);
        a.setRealPart(9.6);
        a.setImaginaryPart(2.5);
        assertEquals(result,Operations.tan(a).getLast());
    }
    
    @Test
    public void testTan_3() throws InvalidNumberException, DivisionByZeroException{
        //tan(Real Part >0, Imaginary Part <0).
        result.setRealPart(0.004568446118239934);
        result.setImaginaryPart(-0.9874122587394989);
        a.setRealPart(9.6);
        a.setImaginaryPart(-2.5);
        assertEquals(result,Operations.tan(a).getLast());
    }
    
    @Test
    public void testTan_4() throws InvalidNumberException, DivisionByZeroException{
       //tan(Real Part <0, Imaginary Part >0).
        result.setRealPart(0.0024985707289502767);
        result.setImaginaryPart(0.9989268648704096);
        a.setRealPart(-5.7);
        a.setImaginaryPart(3.3);
        assertEquals(result,Operations.tan(a).getLast());
    }
    
    @Test
    public void testTan_5() throws InvalidNumberException, DivisionByZeroException{
        //tan(Real Part <0, Imaginary Part =0).         
        a.setRealPart(-6.7);
        result.setRealPart(-0.4427574167327162);
        assertEquals(result,Operations.tan(a).getLast());
    }
    
    @Test
    public void testTan_6() throws InvalidNumberException, DivisionByZeroException{
        //tan(Real Part =0, Imaginary Part >0).
        a.setImaginaryPart(8.8);
        result.setImaginaryPart(0.999999954559081);
        assertEquals(result,Operations.tan(a).getLast());
    }
    
    @Test
    public void testTan_7() throws InvalidNumberException, DivisionByZeroException{
        //tan(Real Part =0, Imaginary Part <0).
        a.setImaginaryPart(-3.4);
        result.setImaginaryPart(-0.9977749279342795);
        assertEquals(result,Operations.tan(a).getLast());
    }
    
    @Test
    public void testTan_8() throws InvalidNumberException, DivisionByZeroException{
        //tan(Real Part >0, Imaginary Part =0).         
        a.setRealPart(0.8);
        result.setRealPart(1.0296385570503641);
        assertEquals(result,Operations.tan(a).getLast());
    }
}
