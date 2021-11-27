/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import other.Utilities;
import se_project.exceptions.DivisionByZeroException;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.UndefinedPhaseException;

/**
 *
 * @author Alessandro Recupido
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
     * Such method is a static method of the class Operations. It performs the
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
     * Such method is a static method of the class Operations. It performs the
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
     * Such method is a static method of the class Operations. It performs the
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
     * Such method is a static method of the class Operations. It performs the
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
            throws DivisionByZeroException, InvalidNumberException {
        if (number1 == null || number2 == null) {
            throw new InvalidNumberException();
        }

        if (number2.getModule() == 0) {
            throw new DivisionByZeroException();
        }
        double n1Module = number1.getModule();
        double n2Module = number2.getModule();
        
        double n1Phase;
        try {
            n1Phase = number1.getPhase();
        } catch (UndefinedPhaseException ex) {
            n1Phase = 0;
        }
        double n2Phase;
        try {
            n2Phase = number2.getPhase();
        } catch (UndefinedPhaseException ex) {
            n2Phase = 0;
        }
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
     * Such method is a static method of the class Operations. It performs the
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
 /**
     * Represents the sqrt Operation.
     *
     * @author Alessandro Recupido
     * @version 1.0
     * @param number
     * @return a complex number .
     *
     * @throws InvalidNumberException
     *
     * Such method is a static method of the class Operations. It performs the
     * sqrt of the parameter passed to such function, returning a linked list containing 
     * two complex numbers x1,x2 such that x1^2 = number and x2^2=number.
     *
     * Such operation is executed computing the trigonometric form of the number passed as 
     * parameter, applying the DeMoivre's formula.
     * If the number is 0+0j, there is no phase for this complex number, so it's impossible 
     * to compute the trigonometric form. So, such function catches this error and returns 
     * a list containing 0+0j only.
     *After having obtained the absolute and the phase of the number, it is necessary 
     * to compute the sqrt of the phase.
     * Then it is necessary to compute the sin and the cos part.
     * with k that goes from 0 to 1(included):
     * 
     * 
     *                            (   phase+2*k*PI )
     * cos_part = sqrt(abs) * cos (----------------)
     *                            (        n       )
     * 
     * 
     *  
     *                            (   phase+2*k*PI )
     * sin_part = sqrt(abs) * sin (----------------)
     *                            (        n       )
     * 
     * 
     * As result, each complex root is defined as: 
     * 
     * r(k) =  cos_part(k) + sin_part(k).
     * 
     * The result is defined as: [r(0), r(1)]
     * 
     * As follows, some examples:
     *
     * o suppose 1 => sqrrt (1+2j) = [+1 -1]
     *
     * o suppose -4 =>sqrt(-3+5j) = [-2j 2j]
     * 
     * o suppose j => sqrt(j) = [ 0.7071 + 0.7071j, -0.7071 -0.7071j]
     *      * 
     * o suppose 1+j => sqrt(1+j) = [ 1.0987 + 0.4551j, -1.0987 - 0.4551j]
     * 
     * o suppose 0 => sqrt(0)=0
     *
     *
     */
    public static LinkedList<ComplexNumber> squareRoot(ComplexNumber number) throws InvalidNumberException{
        if(number==null)
            throw new InvalidNumberException();
        LinkedList<ComplexNumber> ret = new LinkedList<>();

        double mod = number.getModule();
        double phase;
        try {
            phase = number.getPhase();
        } catch (UndefinedPhaseException ex) {
            ret.add(number);
            return ret;
        }
        double retMod = Utilities.round(Math.sqrt(mod),4);
        double sinPart,cosPart;
        double shift;
        for(int i=0;i<2;i++){
            shift = (phase+2*i*Math.PI);
        cosPart = Utilities.round(Math.cos(0.5 * shift),4);
        sinPart = Utilities.round((Math.sin(0.5 * shift)),4);
      
        ret.addLast(new ComplexNumber(Utilities.round(retMod*cosPart,4),Utilities.round(retMod*sinPart,4)));
        }
        return ret;
    }
}
    