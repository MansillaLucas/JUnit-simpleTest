package com.prueba.JUnit.Classes;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Calculator {

    public Integer calculate(Integer num1, Integer num2, String symbol) throws Exception{

        switch(symbol){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if(num2==0)
                    throw new NumberFormatException("No se puede dividir por cero");
                else
                    return num1/num2;
            default:
                throw new IllegalArgumentException("La operación detallada no es válida");
        }
    }

}
