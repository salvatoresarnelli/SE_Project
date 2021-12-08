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
public class SinCommandTest {
    
    public SinCommandTest() {

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
    public void testSinCommand() throws InvalidNumberException, DivisionByZeroException {
        LinkedList<ComplexNumber> ret = new LinkedList();
        ComplexNumber result = new ComplexNumber(-5.7,-3.3);
        ComplexNumber expResult = new ComplexNumber(7.475,-11.3);
        ret.addLast(result);
        ret = Operations.sin(result);
        //System.out.println(ret.getLast());
        assertEquals(expResult, ret.getLast());
        ComplexNumber result_2 = new ComplexNumber(-5.7,3.3);
        ComplexNumber expResult_2 = new ComplexNumber(+7.475,+11.3);
        ret.addLast(result);       
        ret = Operations.sin(result_2);
        //System.out.println(ret.getLast());
        assertEquals(expResult_2, ret.getLast());
        ComplexNumber result_3 = new ComplexNumber(9.6,2.5);
        ComplexNumber expResult_3 = new ComplexNumber(-1.069,-5.958);
        ret.addLast(result);       
        ret = Operations.sin(result_3);
        //System.out.println(ret.getLast());
        assertEquals(expResult_3, ret.getLast());
        ComplexNumber result_4 = new ComplexNumber(9.6,-2.5);
        ComplexNumber expResult_4 = new ComplexNumber(-1.069,5.958);
        ret.addLast(result);       
        ret = Operations.sin(result_4);
        //System.out.println(ret.getLast());
        assertEquals(expResult_4, ret.getLast());
        ComplexNumber result_5 = new ComplexNumber(-6.7,0);
        ComplexNumber expResult_5 = new ComplexNumber(-0.405,0);
        ret.addLast(result);       
        ret = Operations.sin(result_5);
        //System.out.println(ret.getLast());
        assertEquals(expResult_5, ret.getLast());
        ComplexNumber result_6 = new ComplexNumber(0.0,8.8);
        ComplexNumber expResult_6 = new ComplexNumber(0,3317.122);
        ret.addLast(result);       
        ret = Operations.sin(result_6);
        //System.out.println(ret.getLast());
        assertEquals(expResult_6, ret.getLast());
        ComplexNumber result_7 = new ComplexNumber(0.0,-3.4);
        ComplexNumber expResult_7 = new ComplexNumber(0,-14.965);
        ret.addLast(result);       
        ret = Operations.sin(result_7);
        //System.out.println(ret.getLast());
        assertEquals(expResult_7, ret.getLast());
        ComplexNumber result_8 = new ComplexNumber(0.8,0.0);
        ComplexNumber expResult_8 = new ComplexNumber(0.717,0.0);
        ret.addLast(result);       
        ret = Operations.sin(result_8);
        //System.out.println(ret.getLast());
        assertEquals(expResult_8, ret.getLast());
        
        
        
        
    }
    
}
