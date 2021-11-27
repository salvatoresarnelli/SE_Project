/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.lang.Math;
import other.Utilities;
import se_project.exceptions.UndefinedPhaseException;

/**
 *
 * @author aless
 */
public class ComplexNumber {
    
    private double a;
    private double b;

    public ComplexNumber(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public ComplexNumber() {
        a=0;
        b=0;
    }

    public void setRealPart(double a) {
        this.a = a;
    }

    public void setImaginaryPart(double b) {
        this.b = b;
    }

    public double getRealPart() {
        return a;
    }

    public double getImaginaryPart() {
        return b;
    }
    
    public double getModule(){
    return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
    
     public double getPhase() throws UndefinedPhaseException{
     if (a==0 && b==0)
         throw new UndefinedPhaseException();
     if(a<0 && b<0){
         return Math.atan(b/a)-Math.PI;
     }
     if(a<0 && b>=0){
         return Math.atan(b/a)+Math.PI;
     }
     if(a>0){
        return Math.atan(this.b/this.a);
     }
     
     if(a==0 && b< 0){
     return -Math.PI/2;}
     if(a==0 && b>0){
         return Math.PI/2;
     }
     return -1;
    }
 
     public static ComplexNumber fromTrigonometric(double mod, double phase){
         double newA = mod * Math.cos(phase);
         double newB = mod * Math.sin(phase);
         return new ComplexNumber(Utilities.round(newA,3),Utilities.round(newB,3));
    }
     
     public ComplexNumber conjugated(ComplexNumber n){
         n.b+=-2*n.b;
         return n;
     }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

   
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append(Double.toString(this.a));     
        sb.append((this.b>=0) ? "+" : "");
        sb.append(Double.toString(this.b));
        sb.append("j");
        return sb.toString();
    }
     
     
     
}

