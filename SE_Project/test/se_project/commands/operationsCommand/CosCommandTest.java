/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project.commands.operationsCommand;

import java.util.LinkedList;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import se_project.ComplexNumber;
import se_project.Operations;
import se_project.commands.OperationCommand;
import se_project.exceptions.DivisionByZeroException;
import se_project.exceptions.InvalidNumberException;
import se_project.parser.ComplexNumberParser;
import se_project.parser.ParserString;

/**
 *
 * @author pionp
 */
public class CosCommandTest {
    
    public CosCommandTest() {

    }

    @Before
    public void setUp() {
        
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of sin method, of class Operations
     */
    @Test
    public void testCosCommand() throws InvalidNumberException, DivisionByZeroException {
        LinkedList<ComplexNumber> ret = new LinkedList();
        ComplexNumber result = new ComplexNumber(-5.7,-3.3);
        ComplexNumber expResult = new ComplexNumber(11.331,+7.455);
        ret.addLast(result);
        ret = Operations.cos(result);
        assertEquals(expResult, ret.getLast());
        ComplexNumber result_2 = new ComplexNumber(-5.7,3.3);
        ComplexNumber expResult_2 = new ComplexNumber(11.331,-7.455);
        ret.addLast(result);       
        ret = Operations.cos(result_2);
        assertEquals(expResult_2, ret.getLast());
        ComplexNumber result_3 = new ComplexNumber(9.6,2.5);
        ComplexNumber expResult_3 = new ComplexNumber(-6.038,1.055);
        ret.addLast(result);       
        ret = Operations.cos(result_3);
        assertEquals(expResult_3, ret.getLast());
        ComplexNumber result_4 = new ComplexNumber(9.6,-2.5);
        ComplexNumber expResult_4 = new ComplexNumber(-6.038,-1.055);
        ret.addLast(result);       
        ret = Operations.cos(result_4);
        assertEquals(expResult_4, ret.getLast());
        ComplexNumber result_5 = new ComplexNumber(-6.7,0);
        ComplexNumber expResult_5 = new ComplexNumber(0.914,0);
        ret.addLast(result);       
        ret = Operations.cos(result_5);
        assertEquals(expResult_5, ret.getLast());
        ComplexNumber result_6 = new ComplexNumber(0.0,8.8);
        ComplexNumber expResult_6 = new ComplexNumber(3317.122,0);
        ret.addLast(result);       
        ret = Operations.cos(result_6);
        assertEquals(expResult_6, ret.getLast());
        ComplexNumber result_7 = new ComplexNumber(0.0,-3.4);
        ComplexNumber expResult_7 = new ComplexNumber(14.999,0);
        ret.addLast(result);       
        ret = Operations.cos(result_7);
        assertEquals(expResult_7, ret.getLast());
        ComplexNumber result_8 = new ComplexNumber(0.8,0.0);
        ComplexNumber expResult_8 = new ComplexNumber(0.697,0.0);
        ret.addLast(result);       
        ret = Operations.cos(result_8);
        assertEquals(expResult_8, ret.getLast());
    }
}