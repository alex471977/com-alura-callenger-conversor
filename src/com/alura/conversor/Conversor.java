package com.alura.conversor;

public class Conversor {

    public void hacerConversion(Monedas monedas,int valor){

        System.out.println("El valor: "+valor+" "+ monedas.base_code()+ " corresponde al valor final de =>>> "
                +monedas.conversion_result()+" "+monedas.target_code() );
    }
}
