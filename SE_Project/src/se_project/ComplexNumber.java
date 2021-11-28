/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.lang.Math;
import other.Utilities;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.UndefinedPhaseException;

/**
 *
 * @author pio
 */
public class ComplexNumber {

    private double a;
    private double b;

    /**
     * Metodo costruttore della classe ComplexNumber.
     *
     * @author pio
     * @param a
     * @param b
     */
    public ComplexNumber(double a, double b) {
        if (a == -0) {
            a = 0;
        }
        if (b == -0) {
            b = 0;
        }
        this.a = a;
        this.b = b;
    }

    /**
     * Metodo costruttore della classe ComplexNumber in caso di assenza di
     * parametri.
     *
     * @author pio
     * @param
     */
    public ComplexNumber() {
        a = 0;
        b = 0;
    }

    /**
     * Il metodo si occupa di settare la parte reale di un numero complesso.
     *
     * @author pio
     * @param a
     */
    public void setRealPart(double a) {
        this.a = a;
    }

    /**
     * Il metodo si occupa di settare la parte immaginaria di un numero
     * complesso.
     *
     * @author pio
     * @param b
     */
    public void setImaginaryPart(double b) {
        this.b = b;
    }

    /**
     * Il metodo si occupa di ricavare la parte reale di un numero complesso.
     *
     * @author pio
     * @param
     * @return parte reale del numero complesso.
     */
    public double getRealPart() {
        return a;
    }

    /**
     * Il metodo si occupa di ricavare la parte immaginaria di un numero
     * complesso.
     *
     * @author pio
     * @param
     * @return parte immaginaria del numero complesso.
     */
    public double getImaginaryPart() {
        return b;
    }

    /**
     * Il metodo si occupa di ricavare il modulo di un numero complesso.
     *
     * @author pio
     * @param
     * @return modulo del numero complesso.
     */
    public double getModule() {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    /**
     * Il metodo si occupa di ricavare la fase di un numero complesso.
     *
     * @author pio
     * @throws se_project.exceptions.UndefinedPhaseException
     * @param
     * @return fase del numero complesso.
     *
     */
    public double getPhase() throws UndefinedPhaseException {
        if (a == 0 && b == 0) {
            throw new UndefinedPhaseException();
        }
        if (a < 0 && b < 0) {
            return Math.atan(b / a) - Math.PI;
        }
        if (a < 0 && b >= 0) {
            return Math.atan(b / a) + Math.PI;
        }
        if (a > 0) {
            return Math.atan(this.b / this.a);
        }

        if (a == 0 && b < 0) {
            return -Math.PI / 2;
        }
        if (a == 0 && b > 0) {
            return Math.PI / 2;
        }
        return -1;
    }

    /**
     * Il metodo si occupa di trasformare il numero complesso in forma
     * trigonometrica in un numero complesso in forma cartesiana.
     *
     * @author pio
     * @param mod
     * @param phase
     * @return numero complesso in forma cartesiana.
     */
    public static ComplexNumber fromTrigonometric(double mod, double phase) {
        double newA = mod * Math.cos(phase);
        double newB = mod * Math.sin(phase);
        return new ComplexNumber(Utilities.round(newA, 3), Utilities.round(newB, 3));
    }

    /**
     * Il metodo si occupa di calcolare il coniugato di un numero compesso.
     *
     * @author pio
     * @param n
     * @return congiugato del numero complesso.
     * @throws se_project.exceptions.InvalidNumberException
     */
    public ComplexNumber conjugated(ComplexNumber n) throws InvalidNumberException {
        if (n == null) {
            throw new InvalidNumberException();
        }
        n.b += -2 * n.b;
        return n;
    }

    /**
     * Il metodo fornisce un codice hash
     *
     * @author pio
     * @param
     * @return numero intero corrispondete al codice hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * Il metodo si occupa verificare se un numero complesso è uguale ad un
     * oggetto.
     *
     * @author pio
     * @return true, se il numero complesso è uguale ad un altro oggetto, false
     * altrimenti.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComplexNumber other = (ComplexNumber) obj;
        if (Double.doubleToLongBits(this.a) != Double.doubleToLongBits(other.a)) {
            return false;
        }
        if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(other.b)) {
            return false;
        }
        return true;
    }

    /**
     * Il metodo si occupa di effettuare la stampa di un numero complesso.
     *
     * @author pio
     * @param
     * @return stringa che corrisponde al numero complesso.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        if (a == 0) {
            if (b == 0) {
                sb.append((a % 1 == 0) ? Integer.toString((int) a) : Double.toString(this.a));
            } else {
                sb.append((this.b == 1) ? "j"
                        : (this.b == -1) ? "-j"
                                : (((b % 1 == 0) ? (Integer.toString((int) b))
                                        : (Double.toString(b))) + "j"));

            }

        } else {
            sb.append((a % 1 == 0) ? Integer.toString((int) a) : Double.toString(this.a));
            if (b != 0) {
                sb.append((this.b >= 0) ? "+" : "").append((this.b == 1) ? "j"
                        : (this.b == -1) ? "-j"
                                : (((b % 1 == 0) ? (Integer.toString((int) b))
                                        : (Double.toString(b)) )+ "j"));

            }

        }
        return sb.toString();

    }
}
