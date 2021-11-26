/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.util.LinkedList;
import se_project.exceptions.DivisionByZeroException;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.UndefinedPhaseException;

/**
 *
 * @author aless
 */
/**
 *
 * @author aless
 */
public interface Operations {
    /**
     * Represents the sum
     *
     * @author Alessandro Recupido
     * @version 1.0
     * @param number1
     * @param number2
     * @return the sum beetween number1 and number2.
     * @throws InvalidNumberException
     *
     * Such method is a static method of the class Solver. It performs the
     * addiction between the two parameters passed to the function.
     *
     * Such operation is executed summing the real part of the first number and
     * the real part of the second number in order to get the real part of the
     * returned value, and summing the immaginary part of the first number with
     * the immaginary part of the second number.
     *
     * As follows, some examples:
     *
     * o suppose a=1 b=j => such function returns the complex number (1+0),
     * j(0+1) o suppose a=4+2j b=3+7j => such function returns the complex
     * number (4+3),j(2+7)
     *
     */
    public static ComplexNumber addOperation(ComplexNumber number1, ComplexNumber number2) throws InvalidNumberException {
        if (number1 == null || number2 == null) {
            throw new InvalidNumberException();
        }
        double a = number1.getRealPart() + number2.getRealPart();
        double b = number1.getImaginaryPart() + number2.getImaginaryPart();
        return new ComplexNumber(a, b);
    }

    /**
     * Represents the difference.
     *
     * @author Alessandro Recupido
     * @version 1.0
     * @param number1
     * @param number2
     * @return the difference beetween number1 and number2.
     * @throws InvalidNumberException
     *
     * Such method is a static method of the class Solver. It performs the
     * difference between the two parameters passed to the function.
     *
     * Such operation is executed subtracting the real part of the first number
     * and the real part of the second number in order to get the real part of
     * the returned value, and summing the immaginary part of the first number
     * with the immaginary part of the second number.
     *
     * As follows, some examples:
     *
     * o suppose a=1 b=j => such function returns the complex number (1-0),
     * j(0-1) = 1-j o suppose a=4+2j b=3+7j => such function returns the complex
     * number (4-3),j(2-7) =1-5j
     *
     */
    public static ComplexNumber differenceOperation(ComplexNumber number1, ComplexNumber number2) throws InvalidNumberException {
        if (number1 == null || number2 == null) {
            throw new InvalidNumberException();
        }
        double a = number1.getRealPart() - number2.getRealPart();
        double b = number1.getImaginaryPart() - number2.getImaginaryPart();
        return new ComplexNumber(Math.round(a),Math.round(b));
    }

    /**
     * Represents the multiplication.
     *
     * @author Alessandro Recupido
     * @version 1.0
     * @param number1
     * @param number2
     * @return the multiplication beetween number1 and number2.
     * @throws InvalidNumberException
     *
     * Such method is a static method of the class Solver. It performs the
     * moltiplication between the two parameters passed to the function.
     *
     * Such operation is executed multiplying the real part of the first number
     * and the real part of the second number, subtracting to such result the
     * product between the imaginary part of the fisrt number multiplied for the
     * imaginary part of the second number in order to get the real part of the
     * returned value. The imaginary part is obtained multiplying the real part
     * of the first number for the imaginary part of the second number and
     * adding to it the product between the imaginary part of the first number
     * and the real part of the second number.
     *
     * As follows, some examples:
     *
     * o suppose a=1 b=j => such function returns the complex number (1*0 -
     * 0*j),(1*j+0*0)=0+j=j
     *
     * o suppose a=4+2j b=3+7j => such function returns the complex number (4*3
     * -2*7),(4*7j+2j*3) =(12-14), (28j+6j) = -2+34j.
     *
     *
     */
    public static ComplexNumber dotOperation(ComplexNumber number1, ComplexNumber number2) throws InvalidNumberException {
        if (number1 == null || number2 == null) {
            throw new InvalidNumberException();
        }

        double a = number1.getRealPart() * number2.getRealPart() - number1.getImaginaryPart() * number2.getImaginaryPart();
        double b = number1.getRealPart() * number2.getImaginaryPart() + number2.getRealPart() * number1.getImaginaryPart();
        return new ComplexNumber(Math.round(a), Math.round(b));
    }

    /**
     * Represents the division.
     *
     * @author Alessandro Recupido
     * @version 1.0
     * @param number1
     * @param number2
     * @return the division beetween number1 and number2.
     * @throws se_project.exceptions.UndefinedPhaseException
     * @throws se_project.exceptions.DivisionByZeroException
     * @throws InvalidNumberException
     *
     * Such method is a static method of the class Solver. It performs the
     * division between the two parameters passed to the function.
     *
     * Such operation is executed obtaining the module and the phase of each of the parameters.
     * The result is computed as the division between the modules and the difference between the 
     * phases.At the end, such value's been converted into a new ComplexNumber.
     * 
     * As follows, some examples:
     *
     * o suppose number1=1 number2=j => such function returns the complex number 
     * 
     *
     * o suppose a=4+2j b=3+7j => such function returns the complex number (4*3
     * -2*7),(4*7j+2j*3) =(12-14), (28j+6j) = -2+34j.
     *
     *
     */
    public static ComplexNumber divisionOperation(ComplexNumber number1, ComplexNumber number2)
            throws UndefinedPhaseException, DivisionByZeroException, InvalidNumberException {
        if (number1 == null || number2 == null) {
            throw new InvalidNumberException();
        }

        if (number2.getModule() == 0) {
            throw new DivisionByZeroException();
        }
        double n1Module = number1.getModule();
        double n2Module = number2.getModule();
        double n1Phase = number1.getPhase();
        double n2Phase = number2.getPhase();
        double resultModule = n1Module / n2Module;
        double resultPhase = n1Phase - n2Phase;
        return ComplexNumber.fromTrigonometric(resultModule, resultPhase);
    }

    /**
     * Represents the sign Operation.
     *
     * @author Alessandro Recupido
     * @version 1.0
     * @param number
     * @return the number passed with opposite sign.
     *
     * @throws InvalidNumberException
     *
     * Such method is a static method of the class Solver. It performs the
     * sign of the parameter passed to such function.
     *
     * Such operation is executed multiplying both real part and imaginary part with -1.
     *
     * As follows, some examples:
     *
     * o suppose 1+2j => sign (1+2j) = -1-2j
     *
     * o suppose -3+5j =>sign(-3+5j) = 3-5j
     * 
     * o suppose 2 => sign(2) =-2
     * 
     * o suppose 0 => sign(0)=0
     *
     *
     */
    public static ComplexNumber signOperation(ComplexNumber number) throws InvalidNumberException {
        if (number == null) {
            throw new InvalidNumberException();
        }
        
        double real = number.getRealPart();
        double imag = number.getImaginaryPart();
        if(real!=0)
            real=real*-1;
        if (imag!=0)
            imag=imag*-1;
        return new ComplexNumber(real,imag);
    }

    public static LinkedList<ComplexNumber> squareRoot(ComplexNumber number) throws UndefinedPhaseException{
        double mod = number.getModule();
        double phase = number.getPhase();
        double retMod = Math.sqrt(mod);
        LinkedList<ComplexNumber> ret= new LinkedList<>();
        double sinPart=0,cosPart=0;
        
        for(int i=0;i<2;i++){
        cosPart = Math.round(Math.cos(0.5 * (phase+2*i*Math.PI)));
        sinPart = Math.round(Math.sin(0.5 * (phase+2*i*Math.PI)));
        ret.addLast(new ComplexNumber(retMod*cosPart,retMod*sinPart));
        }
        return ret;
    }
}
    