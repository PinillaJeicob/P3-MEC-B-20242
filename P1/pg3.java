con la misma clase crear un metodo puro que me permita sumar dos fracciones y que me devuelva su resultado//

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoparcial;

/**
 *
 * @author Multipropósito2
 */
public class Fraccion {
   
    private int numerador;
    private int denominador;

    
    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser cero.");
        }
        this.denominador = denominador;
    }

    
    public int getNumerador() {
        return numerador;
    }

    
    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    
    public int getDenominador() {
        return denominador;
    }

    
    public void setDenominador(int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser cero.");
        }
        this.denominador = denominador;
    }

   
    public String toString() {
        return numerador + "/" + denominador;
    }
    public static Fraccion sumar(Fraccion f1, Fraccion f2) {
        int nuevoNumerador = f1.numerador * f2.denominador + f2.numerador * f1.denominador;
        int nuevoDenominador = f1.denominador*f2.denominador + f2.numerador*f1.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }
    public static void main(String[] args) {
       
        Fraccion fraccion = new Fraccion(3, 4);
       
        
        Fraccion fraccion1 = new Fraccion(3, 4);
        Fraccion fraccion2 = new Fraccion(5, 3);
        Fraccion fraccion3 = new Fraccion(2, 8);
        
        fraccion.setNumerador(5);
        fraccion.setDenominador(8);
        System.out.println("Fracción 1: " + fraccion1);
        System.out.println("Fracción 2: " + fraccion2);
        System.out.println("Fracción 3: " + fraccion3);
        
    }
   
}

