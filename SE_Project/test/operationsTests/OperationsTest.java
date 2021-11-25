package operationsTests;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se_project.*;
import se_project.exceptions.InvalidNumberException;

/**
 *
 * @author aless
 */
public class OperationsTest {

    Operations op;
    ComplexNumber a, b, result;

    public OperationsTest() {
        op = new Operations();
        a = new ComplexNumber();
        b = new ComplexNumber();
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    private void testAdd(ComplexNumber a, ComplexNumber b, ComplexNumber result) {
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testPlus() {
        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(3);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(2);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(3);
        result.setImaginaryPart(2);
        a.setRealPart(1);
        a.setImaginaryPart(4);
        b.setRealPart(2);
        b.setImaginaryPart(-2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(0);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(5);
        result.setImaginaryPart(5);
        a.setRealPart(10);
        a.setImaginaryPart(10);
        b.setRealPart(-5);
        b.setImaginaryPart(-5);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
                result.setRealPart(5);
        result.setImaginaryPart(-1);
        a.setRealPart(2);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).
                result.setRealPart(7);
        result.setImaginaryPart(-5);
        a.setRealPart(4);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).

        result.setRealPart(1);
        result.setImaginaryPart(-1);
        a.setRealPart(1);
        a.setImaginaryPart(-2);
        b.setRealPart(-2);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).

        result.setRealPart(-1);
        result.setImaginaryPart(-6);
        a.setRealPart(1);
        a.setImaginaryPart(-3);
        b.setRealPart(-2);
        b.setImaginaryPart(-3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(2);
        result.setImaginaryPart(5);
        a.setRealPart(-3);
        a.setImaginaryPart(2);
        b.setRealPart(5);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(1);
        result.setImaginaryPart(6);
        a.setRealPart(-2);
        a.setImaginaryPart(3);
        b.setRealPart(-3);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(2);
        result.setImaginaryPart(-1);
        a.setRealPart(-1);
        a.setImaginaryPart(2);
        b.setRealPart(3);
        b.setImaginaryPart(-3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).

        result.setRealPart(-3);
        result.setImaginaryPart(5);
        a.setRealPart(-1);
        a.setImaginaryPart(3);
        b.setRealPart(-2);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-5);
        result.setImaginaryPart(2);
        a.setRealPart(-2);
        a.setImaginaryPart(3);
        b.setRealPart(-3);
        b.setImaginaryPart(-1);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(2);
        result.setImaginaryPart(0);
        a.setRealPart(-2);
        a.setImaginaryPart(-3);
        b.setRealPart(4);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).

        result.setRealPart(2);
        result.setImaginaryPart(-4);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(-2);
        result.setImaginaryPart(1);
        a.setRealPart(-1);
        a.setImaginaryPart(-1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-2);
        result.setImaginaryPart(-3);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(-1);
        b.setImaginaryPart(-1);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).

        result.setRealPart(1);
        result.setImaginaryPart(1);
        a.setRealPart(-2);
        a.setImaginaryPart(-2);
        b.setRealPart(3);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0,Im=0) + (Real Part>0,Im=0)
        result.setRealPart(2);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(1);
        b.setImaginaryPart(0);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part>0, Im=0) + (Real Part<0,Im=0) 
        result.setRealPart(-3);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(-4);
        b.setImaginaryPart(0);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }


        //(Real Part<0, Im =0) + (Real Part<0, Im=0)
        result.setRealPart(-3);
        result.setImaginaryPart(0);
        a.setRealPart(-1);
        a.setImaginaryPart(0);
        b.setRealPart(-2);
        b.setImaginaryPart(0);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        // (Real Part=0, Im>0) + (Real Part=0, Im>0)
        result.setRealPart(0);
        result.setImaginaryPart(2);
        a.setRealPart(0);
        a.setImaginaryPart(1);
        b.setRealPart(0);
        b.setImaginaryPart(1);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //(Real Part!=0,Im =0) + (Real Part=0, Im!=0)
                result.setRealPart(1);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }


        //(Real Part=0,Im =0) + (Real Part=0, Im=0)
                result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(0);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(0);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part=A,Im =B) + (Real Part=-A, Im=-B)
                result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(6);
        a.setImaginaryPart(7);
        b.setRealPart(-6);
        b.setImaginaryPart(-7);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }


        //(null+null)
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            Operations.addOperation(null, null);
        });
        String expectedMessage = "InvalidNumberException";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    /*Prodotto*/
    @Test
    public void testDot() {
        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(3);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(2);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(3);
        result.setImaginaryPart(2);
        a.setRealPart(1);
        a.setImaginaryPart(4);
        b.setRealPart(2);
        b.setImaginaryPart(-2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(0);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(5);
        result.setImaginaryPart(5);
        a.setRealPart(10);
        a.setImaginaryPart(10);
        b.setRealPart(-5);
        b.setImaginaryPart(-5);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
                result.setRealPart(5);
        result.setImaginaryPart(-1);
        a.setRealPart(2);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).
                result.setRealPart(7);
        result.setImaginaryPart(-5);
        a.setRealPart(4);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).

        result.setRealPart(1);
        result.setImaginaryPart(-1);
        a.setRealPart(1);
        a.setImaginaryPart(-2);
        b.setRealPart(-2);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).

        result.setRealPart(-1);
        result.setImaginaryPart(-6);
        a.setRealPart(1);
        a.setImaginaryPart(-3);
        b.setRealPart(-2);
        b.setImaginaryPart(-3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(2);
        result.setImaginaryPart(5);
        a.setRealPart(-3);
        a.setImaginaryPart(2);
        b.setRealPart(5);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(1);
        result.setImaginaryPart(6);
        a.setRealPart(-2);
        a.setImaginaryPart(3);
        b.setRealPart(-3);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(2);
        result.setImaginaryPart(-1);
        a.setRealPart(-1);
        a.setImaginaryPart(2);
        b.setRealPart(3);
        b.setImaginaryPart(-3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).

        result.setRealPart(-3);
        result.setImaginaryPart(5);
        a.setRealPart(-1);
        a.setImaginaryPart(3);
        b.setRealPart(-2);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-5);
        result.setImaginaryPart(2);
        a.setRealPart(-2);
        a.setImaginaryPart(3);
        b.setRealPart(-3);
        b.setImaginaryPart(-1);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(2);
        result.setImaginaryPart(0);
        a.setRealPart(-2);
        a.setImaginaryPart(-3);
        b.setRealPart(4);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).

        result.setRealPart(2);
        result.setImaginaryPart(-4);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(-2);
        result.setImaginaryPart(1);
        a.setRealPart(-1);
        a.setImaginaryPart(-1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-2);
        result.setImaginaryPart(-3);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(-1);
        b.setImaginaryPart(-1);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).

        result.setRealPart(1);
        result.setImaginaryPart(1);
        a.setRealPart(-2);
        a.setImaginaryPart(-2);
        b.setRealPart(3);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0,Im=0) + (Real Part>0,Im=0)
        result.setRealPart(2);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(1);
        b.setImaginaryPart(0);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part>0, Im=0) + (Real Part<0,Im=0) 
        result.setRealPart(-3);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(-4);
        b.setImaginaryPart(0);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }


        //(Real Part<0, Im =0) + (Real Part<0, Im=0)
        result.setRealPart(-3);
        result.setImaginaryPart(0);
        a.setRealPart(-1);
        a.setImaginaryPart(0);
        b.setRealPart(-2);
        b.setImaginaryPart(0);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        // (Real Part=0, Im>0) + (Real Part=0, Im>0)
        result.setRealPart(0);
        result.setImaginaryPart(2);
        a.setRealPart(0);
        a.setImaginaryPart(1);
        b.setRealPart(0);
        b.setImaginaryPart(1);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //(Real Part!=0,Im =0) + (Real Part=0, Im!=0)
                result.setRealPart(1);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }


        //(Real Part=0,Im =0) + (Real Part=0, Im=0)
                result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(0);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(0);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part=A,Im =B) + (Real Part=-A, Im=-B)
                result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(6);
        a.setImaginaryPart(7);
        b.setRealPart(-6);
        b.setImaginaryPart(-7);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }


        //(null+null)
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            Operations.addOperation(null, null);
        });
        String expectedMessage = "InvalidNumberException";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }
    

    @Test
    public void testDifference() {
        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(3);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(2);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(3);
        result.setImaginaryPart(2);
        a.setRealPart(1);
        a.setImaginaryPart(4);
        b.setRealPart(2);
        b.setImaginaryPart(-2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(0);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(5);
        result.setImaginaryPart(5);
        a.setRealPart(10);
        a.setImaginaryPart(10);
        b.setRealPart(-5);
        b.setImaginaryPart(-5);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
                result.setRealPart(5);
        result.setImaginaryPart(-1);
        a.setRealPart(2);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).
                result.setRealPart(7);
        result.setImaginaryPart(-5);
        a.setRealPart(4);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).

        result.setRealPart(1);
        result.setImaginaryPart(-1);
        a.setRealPart(1);
        a.setImaginaryPart(-2);
        b.setRealPart(-2);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).

        result.setRealPart(-1);
        result.setImaginaryPart(-6);
        a.setRealPart(1);
        a.setImaginaryPart(-3);
        b.setRealPart(-2);
        b.setImaginaryPart(-3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(2);
        result.setImaginaryPart(5);
        a.setRealPart(-3);
        a.setImaginaryPart(2);
        b.setRealPart(5);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(1);
        result.setImaginaryPart(6);
        a.setRealPart(-2);
        a.setImaginaryPart(3);
        b.setRealPart(-3);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(2);
        result.setImaginaryPart(-1);
        a.setRealPart(-1);
        a.setImaginaryPart(2);
        b.setRealPart(3);
        b.setImaginaryPart(-3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).

        result.setRealPart(-3);
        result.setImaginaryPart(5);
        a.setRealPart(-1);
        a.setImaginaryPart(3);
        b.setRealPart(-2);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-5);
        result.setImaginaryPart(2);
        a.setRealPart(-2);
        a.setImaginaryPart(3);
        b.setRealPart(-3);
        b.setImaginaryPart(-1);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(2);
        result.setImaginaryPart(0);
        a.setRealPart(-2);
        a.setImaginaryPart(-3);
        b.setRealPart(4);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).

        result.setRealPart(2);
        result.setImaginaryPart(-4);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(-2);
        result.setImaginaryPart(1);
        a.setRealPart(-1);
        a.setImaginaryPart(-1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-2);
        result.setImaginaryPart(-3);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(-1);
        b.setImaginaryPart(-1);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).

        result.setRealPart(1);
        result.setImaginaryPart(1);
        a.setRealPart(-2);
        a.setImaginaryPart(-2);
        b.setRealPart(3);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0,Im=0) + (Real Part>0,Im=0)
        result.setRealPart(2);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(1);
        b.setImaginaryPart(0);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part>0, Im=0) + (Real Part<0,Im=0) 
        result.setRealPart(-3);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(-4);
        b.setImaginaryPart(0);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }


        //(Real Part<0, Im =0) + (Real Part<0, Im=0)
        result.setRealPart(-3);
        result.setImaginaryPart(0);
        a.setRealPart(-1);
        a.setImaginaryPart(0);
        b.setRealPart(-2);
        b.setImaginaryPart(0);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        // (Real Part=0, Im>0) + (Real Part=0, Im>0)
        result.setRealPart(0);
        result.setImaginaryPart(2);
        a.setRealPart(0);
        a.setImaginaryPart(1);
        b.setRealPart(0);
        b.setImaginaryPart(1);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //(Real Part!=0,Im =0) + (Real Part=0, Im!=0)
                result.setRealPart(1);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }


        //(Real Part=0,Im =0) + (Real Part=0, Im=0)
                result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(0);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(0);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part=A,Im =B) + (Real Part=-A, Im=-B)
                result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(6);
        a.setImaginaryPart(7);
        b.setRealPart(-6);
        b.setImaginaryPart(-7);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }


        //(null+null)
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            Operations.addOperation(null, null);
        });
        String expectedMessage = "InvalidNumberException";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }
 

    @Test
    public void testDivision() {
        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(3);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(2);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(3);
        result.setImaginaryPart(2);
        a.setRealPart(1);
        a.setImaginaryPart(4);
        b.setRealPart(2);
        b.setImaginaryPart(-2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(0);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(5);
        result.setImaginaryPart(5);
        a.setRealPart(10);
        a.setImaginaryPart(10);
        b.setRealPart(-5);
        b.setImaginaryPart(-5);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
                result.setRealPart(5);
        result.setImaginaryPart(-1);
        a.setRealPart(2);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).
                result.setRealPart(7);
        result.setImaginaryPart(-5);
        a.setRealPart(4);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).

        result.setRealPart(1);
        result.setImaginaryPart(-1);
        a.setRealPart(1);
        a.setImaginaryPart(-2);
        b.setRealPart(-2);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).

        result.setRealPart(-1);
        result.setImaginaryPart(-6);
        a.setRealPart(1);
        a.setImaginaryPart(-3);
        b.setRealPart(-2);
        b.setImaginaryPart(-3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(2);
        result.setImaginaryPart(5);
        a.setRealPart(-3);
        a.setImaginaryPart(2);
        b.setRealPart(5);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(1);
        result.setImaginaryPart(6);
        a.setRealPart(-2);
        a.setImaginaryPart(3);
        b.setRealPart(-3);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(2);
        result.setImaginaryPart(-1);
        a.setRealPart(-1);
        a.setImaginaryPart(2);
        b.setRealPart(3);
        b.setImaginaryPart(-3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).

        result.setRealPart(-3);
        result.setImaginaryPart(5);
        a.setRealPart(-1);
        a.setImaginaryPart(3);
        b.setRealPart(-2);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-5);
        result.setImaginaryPart(2);
        a.setRealPart(-2);
        a.setImaginaryPart(3);
        b.setRealPart(-3);
        b.setImaginaryPart(-1);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(2);
        result.setImaginaryPart(0);
        a.setRealPart(-2);
        a.setImaginaryPart(-3);
        b.setRealPart(4);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).

        result.setRealPart(2);
        result.setImaginaryPart(-4);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(-2);
        result.setImaginaryPart(1);
        a.setRealPart(-1);
        a.setImaginaryPart(-1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-2);
        result.setImaginaryPart(-3);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(-1);
        b.setImaginaryPart(-1);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).

        result.setRealPart(1);
        result.setImaginaryPart(1);
        a.setRealPart(-2);
        a.setImaginaryPart(-2);
        b.setRealPart(3);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0,Im=0) + (Real Part>0,Im=0)
        result.setRealPart(2);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(1);
        b.setImaginaryPart(0);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part>0, Im=0) + (Real Part<0,Im=0) 
        result.setRealPart(-3);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(-4);
        b.setImaginaryPart(0);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }


        //(Real Part<0, Im =0) + (Real Part<0, Im=0)
        result.setRealPart(-3);
        result.setImaginaryPart(0);
        a.setRealPart(-1);
        a.setImaginaryPart(0);
        b.setRealPart(-2);
        b.setImaginaryPart(0);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        // (Real Part=0, Im>0) + (Real Part=0, Im>0)
        result.setRealPart(0);
        result.setImaginaryPart(2);
        a.setRealPart(0);
        a.setImaginaryPart(1);
        b.setRealPart(0);
        b.setImaginaryPart(1);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //(Real Part!=0,Im =0) + (Real Part=0, Im!=0)
                result.setRealPart(1);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }


        //(Real Part=0,Im =0) + (Real Part=0, Im=0)
                result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(0);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(0);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part=A,Im =B) + (Real Part=-A, Im=-B)
                result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(6);
        a.setImaginaryPart(7);
        b.setRealPart(-6);
        b.setImaginaryPart(-7);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }


        //(null+null)
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            Operations.addOperation(null, null);
        });
        String expectedMessage = "InvalidNumberException";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }
    
    @Test
    public void testSign() {
        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(3);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(2);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(3);
        result.setImaginaryPart(2);
        a.setRealPart(1);
        a.setImaginaryPart(4);
        b.setRealPart(2);
        b.setImaginaryPart(-2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(0);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(5);
        result.setImaginaryPart(5);
        a.setRealPart(10);
        a.setImaginaryPart(10);
        b.setRealPart(-5);
        b.setImaginaryPart(-5);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
                result.setRealPart(5);
        result.setImaginaryPart(-1);
        a.setRealPart(2);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).
                result.setRealPart(7);
        result.setImaginaryPart(-5);
        a.setRealPart(4);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).

        result.setRealPart(1);
        result.setImaginaryPart(-1);
        a.setRealPart(1);
        a.setImaginaryPart(-2);
        b.setRealPart(-2);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).

        result.setRealPart(-1);
        result.setImaginaryPart(-6);
        a.setRealPart(1);
        a.setImaginaryPart(-3);
        b.setRealPart(-2);
        b.setImaginaryPart(-3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(2);
        result.setImaginaryPart(5);
        a.setRealPart(-3);
        a.setImaginaryPart(2);
        b.setRealPart(5);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(1);
        result.setImaginaryPart(6);
        a.setRealPart(-2);
        a.setImaginaryPart(3);
        b.setRealPart(-3);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(2);
        result.setImaginaryPart(-1);
        a.setRealPart(-1);
        a.setImaginaryPart(2);
        b.setRealPart(3);
        b.setImaginaryPart(-3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).

        result.setRealPart(-3);
        result.setImaginaryPart(5);
        a.setRealPart(-1);
        a.setImaginaryPart(3);
        b.setRealPart(-2);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-5);
        result.setImaginaryPart(2);
        a.setRealPart(-2);
        a.setImaginaryPart(3);
        b.setRealPart(-3);
        b.setImaginaryPart(-1);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(2);
        result.setImaginaryPart(0);
        a.setRealPart(-2);
        a.setImaginaryPart(-3);
        b.setRealPart(4);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).

        result.setRealPart(2);
        result.setImaginaryPart(-4);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(-2);
        result.setImaginaryPart(1);
        a.setRealPart(-1);
        a.setImaginaryPart(-1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-2);
        result.setImaginaryPart(-3);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(-1);
        b.setImaginaryPart(-1);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).

        result.setRealPart(1);
        result.setImaginaryPart(1);
        a.setRealPart(-2);
        a.setImaginaryPart(-2);
        b.setRealPart(3);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part >0,Im=0) + (Real Part>0,Im=0)
        result.setRealPart(2);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(1);
        b.setImaginaryPart(0);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part>0, Im=0) + (Real Part<0,Im=0) 
        result.setRealPart(-3);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(-4);
        b.setImaginaryPart(0);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }


        //(Real Part<0, Im =0) + (Real Part<0, Im=0)
        result.setRealPart(-3);
        result.setImaginaryPart(0);
        a.setRealPart(-1);
        a.setImaginaryPart(0);
        b.setRealPart(-2);
        b.setImaginaryPart(0);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        // (Real Part=0, Im>0) + (Real Part=0, Im>0)
        result.setRealPart(0);
        result.setImaginaryPart(2);
        a.setRealPart(0);
        a.setImaginaryPart(1);
        b.setRealPart(0);
        b.setImaginaryPart(1);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //(Real Part!=0,Im =0) + (Real Part=0, Im!=0)
                result.setRealPart(1);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(3);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }


        //(Real Part=0,Im =0) + (Real Part=0, Im=0)
                result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(0);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(0);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //(Real Part=A,Im =B) + (Real Part=-A, Im=-B)
                result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(6);
        a.setImaginaryPart(7);
        b.setRealPart(-6);
        b.setImaginaryPart(-7);
        try {
            assertEquals(result, Operations.addOperation(a, b));
        } catch (InvalidNumberException ex) {
            Logger.getLogger(OperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }


        //(null+null)
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            Operations.addOperation(null, null);
        });
        String expectedMessage = "InvalidNumberException";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }


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
