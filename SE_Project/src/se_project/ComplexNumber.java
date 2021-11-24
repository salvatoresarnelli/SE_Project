/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.lang.Math;
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

    public ComplexNumber(double a) {
        this.a = a;
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
         return -Math.PI/2;
     }
     return -1;
    }
 
     public static ComplexNumber fromTrigonometric(double mod, double phase){
         double a = mod * Math.cos(phase);
         double b = mod * Math.sin(phase);
         return new ComplexNumber(a,b);
     }
     
     public ComplexNumber conjugated(ComplexNumber n){
         n.b+=-2*n.b;
         return n;
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

