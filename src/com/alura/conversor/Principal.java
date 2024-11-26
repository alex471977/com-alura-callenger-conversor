package com.alura.conversor;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args)  {

        var opcion=0;
        int valor=0;
        Scanner scanner= new Scanner(System.in);

        while (opcion>=0){

            System.out.println("***********************************************************************\n" +
                    "Sea bienvenido/a al Conversor de Monedas =\n" +
                    "\n" +
                    "1) Dolar =>> Peso argentino\n" +
                    "2) Peso argentino =>> Dolar\n" +
                    "3) Dolar =>> Real brasileño\n" +
                    "4) Real brasileño =>> Dolar\n" +
                    "5) Dolar =>> Peso colombiano\n" +
                    "6) Peso colombiano =>> Dolar\n" +
                    "7) salir\n" +
                    "Elija una opción valida.\n" +
                    "**********************************************************************************");

           try {
               opcion = scanner.nextInt();
           }catch (InputMismatchException e){
               System.out.println("valor no valido1 "+e.getMessage());
               break;
           }
            if (opcion == 7) {
                break;
            }else if (opcion<=0 || opcion>=8) {
                System.out.println("opcion no valida");
                break;
            }
            try {
                System.out.println("Ingrese el valor que desea convertir: ");
                valor = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("valor no valido2 "+ e.getMessage());
                break;
            }
                if (valor <=0) {
                    break;
                }
                PedidoMoneda pedido = new PedidoMoneda();
                Monedas monedas = pedido.pedirMoneda(opcion, valor);
                Conversor conversor = new Conversor();
                conversor.hacerConversion(monedas, valor);

        }


    }
}
