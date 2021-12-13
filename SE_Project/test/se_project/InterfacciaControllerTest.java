/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se_project.exceptions.ExistingNameException;
import se_project.exceptions.InvalidNameException;
import se_project.exceptions.OperationNotFoundException;
import se_project.parser.ComplexNumberParser;
import se_project.parser.OperationParser;
import se_project.parser.ParserString;
import se_project.parser.StackOperationParser;
import se_project.parser.UserDefinedOperationParser;
import se_project.parser.VariableParser;

/**
 *
 * @author emanu
 */
public class InterfacciaControllerTest {

    private InterfacciaController interfacciaController = new InterfacciaController();
    private final Solver solver = Solver.getInstance();
    private final VariableParser variableParser = new VariableParser(new StackOperationParser(new OperationParser(new ComplexNumberParser(new ParserString()))));
    private UserDefinedOperationParser decoratorParserOperation = new UserDefinedOperationParser(variableParser);
    private VariablesStack variablesStack;
    OperationDict operationDict = OperationDict.getInstance();

    public InterfacciaControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws ExistingNameException, OperationNotFoundException, InvalidNameException, Exception {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSaveFunctionsFromFile() throws ExistingNameException, OperationNotFoundException, InvalidNameException, Exception {
        File file = null;
        boolean result = interfacciaController.SaveFunctionsFromFile(file);
        boolean expResult = false;
        assertEquals(expResult, result);
        file = new File("op.txt");
        //con un OperationDict vuoto.
        result = interfacciaController.SaveFunctionsFromFile(file);
        expResult = true;
        assertEquals(expResult, result);
        decoratorParserOperation.parse(">>somma$ + ");
        decoratorParserOperation.parse(">>differenza$ - ");
        result = interfacciaController.SaveFunctionsFromFile(file);
        assertEquals(expResult, result);
        //controllo se li ha salvati correttamente nel file.
        Scanner sc = new Scanner(file);
        //il metodo salva le operazioni con questo pattern
        //nameFunctions --> lista di operazioni.
        String line = sc.nextLine();
        //la prima linea contiene differenza.
        String name = line.split("-->")[0].replaceAll(" ", "").replaceAll("\\n", "");
        assertEquals("differenza", name);
        String operationList = operationDict.getOperationString(name).replaceAll(" ", "").replaceAll("\\n", "");
        assertEquals(operationList, "-");
        line = sc.nextLine();
        //la prima linea contiene differenza.
        name = line.split("-->")[0].replaceAll(" ", "").replaceAll("\\n", "");
        assertEquals("somma", name);
        operationList = operationDict.getOperationString(name).replaceAll(" ", "").replaceAll("\\n", "");
        assertEquals(operationList, "+");

    }

    /**
     * Test of uploadFunctionsFromFile method, of class InterfacciaController.
     */
    @Test
    public void testUploadFunctionsFromFile() throws ExistingNameException, OperationNotFoundException, InvalidNameException, Exception {
        System.out.println("uploadFunctionsFromFile");
        File file = null;
        InterfacciaController instance = new InterfacciaController();
        boolean result = instance.uploadFunctionsFromFile(file);
        boolean expResult = false;
        assertEquals(expResult, result);
        file = new File("op.txt");
        result = interfacciaController.SaveFunctionsFromFile(file);
        decoratorParserOperation.removeOperation("somma");
        decoratorParserOperation.removeOperation("differenza");
        instance = new InterfacciaController();
        result = instance.uploadFunctionsFromFile(file);
        expResult = true;
        assertEquals(expResult, result);
        //controllo che le operazioni siano state salvate correttamente.
        Scanner sc = new Scanner(file);
        //il metodo salva le operazioni con questo pattern
        //nameFunctions --> lista di operazioni.
        String line = sc.nextLine();
        //la prima linea contiene differenza.
        String name = line.split("-->")[0].replaceAll(" ", "").replaceAll("\\n", "");
        assertEquals("differenza", name);
        String operationList = operationDict.getOperationString(name).replaceAll(" ", "").replaceAll("\\n", "");
        assertEquals(operationList, "-");
        line = sc.nextLine();
        //la prima linea contiene differenza.
        name = line.split("-->")[0].replaceAll(" ", "").replaceAll("\\n", "");
        assertEquals("somma", name);
        operationList = operationDict.getOperationString(name).replaceAll(" ", "").replaceAll("\\n", "");
        assertEquals(operationList, "+");
        

    }

}
