/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import other.Utilities;
import se_project.ComplexNumber;
import se_project.Operations;
import se_project.exceptions.InvalidNumberException;

/**
 *
 * @author aless
 */
public class UtilitiesTest {

    double a, result;

    public UtilitiesTest() {

    }

    @Before
    public void setUp() {
        a = 0;
        result = 0;
    }

    @Test
    public void roundZero() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result = 0;
        a = 0;
        assertEquals(Double.valueOf(result), Double.valueOf(Utilities.round(a, 4)));
    }

    @Test
    public void roundIntegerGreaterThenZero() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result = 1;
        a = 1.0000;
        assertEquals(Double.valueOf(result), Double.valueOf(Utilities.round(a, 4)));
    }

    @Test
    public void roundIntegerLessThenZero() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result = -1;
        a = -1.0000;
        assertEquals(Double.valueOf(result), Double.valueOf(Utilities.round(a, 4)));
    }

    @Test
    public void roundDoubleLessThenZero() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result = -1;
        a = -1.00004;
        assertEquals(Double.valueOf(result), Double.valueOf(Utilities.round(a, 4)));
    }

    @Test
    public void roundDoubleGreaterThenZero() throws InvalidNumberException {
        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result = 1;
        a = 1.00004;
        assertEquals(Double.valueOf(result), Double.valueOf(Utilities.round(a, 4)));
    }

}
