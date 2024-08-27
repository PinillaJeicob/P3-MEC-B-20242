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
    // Atributos privados
    private int numerador;
    private int denominador;

    // Constructor
    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        // Asegurarse de que el denominador no sea cero
        if (denominador == 0) {
            system.out.println("argumento invalido");
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

    public static void main(String[] args) {
       
        Fraccion fraccion = new Fraccion(3, 4);
        System.out.println("Fracción inicial: " + fraccion);

        fraccion.setNumerador(5);
        fraccion.setDenominador(8);
        System.out.println("Fracción modificada: " + fraccion);
    }
}

