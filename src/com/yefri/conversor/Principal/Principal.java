package com.yefri.conversor.Principal;

import com.yefri.conversor.Calculos.ConsultaMonedas;
import com.yefri.conversor.Modelos.Moneda;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException{
        Scanner leer = new Scanner(System.in);
        ConsultaMonedas consulta = new ConsultaMonedas();
        byte opcion=0;
        boolean calcular = false;
        String monedaBase ="", monedaCambio ="";
        double monto=0;
        while(opcion != 9) {
            //menu
            System.out.println("**************************************************************");
            System.out.println("**            SISTEMA DE CONVERSION DE MONEDAS              **");
            System.out.println("**************************************************************");
            System.out.println(" ____________________________________________________________");
            System.out.println("| Opcion |    Moneda Base       |     Moneda de cambio       |");
            System.out.println("|--------|----------------------|----------------------------|");
            System.out.println("|  (1)   | Dolar Americano USD  | Peso Chileno CLP           |");
            System.out.println("|--------|----------------------|----------------------------|");
            System.out.println("|  (2)   | Peso Chileno CLP     | Dolar Americano USD        |");
            System.out.println("|--------|----------------------|----------------------------|");
            System.out.println("|  (3)   | Dolar Americano USD  | Peso Colombiano COP        |");
            System.out.println("|--------|----------------------|----------------------------|");
            System.out.println("|  (4)   | Peso Colombiano COP  | Dolar Americano USD        |");
            System.out.println("|--------|----------------------|----------------------------|");
            System.out.println("|  (5)   | Dolar Americano USD  | Peso Argentino ARS         |");
            System.out.println("|--------|----------------------|----------------------------|");
            System.out.println("|  (6)   | Peso Argentino ARS   | Dolar Americano USD        |");
            System.out.println("|--------|----------------------|----------------------------|");
            System.out.println("|  (7)   | Dolar Americano USD  | Real Brasileño BRL         |");
            System.out.println("|--------|----------------------|----------------------------|");
            System.out.println("|  (8)   | Real Brasileño BRL   | Dolar Americano USD        |");
            System.out.println("|--------|----------------------|----------------------------|");
            System.out.println("|  (9)   | Salir del sistema...                              |");
            System.out.println("|--------|---------------------------------------------------|");
            System.out.print("    Por favor elija su opcion: ");
            opcion = leer.nextByte();

            if (opcion >=1 && opcion<=8){
                System.out.print("\nPor favor ingrese el Monto que desea cambiar: ");
                monto = leer.nextDouble();
                calcular = true;
            }
            switch (opcion){
                case 1:
                    monedaBase = "USD";
                    monedaCambio = "CLP";

                    break;
                case 2:
                    monedaBase = "CLP";
                    monedaCambio = "USD";
                    break;
                case 3:
                    monedaBase = "USD";
                    monedaCambio = "COP";
                    break;
                case 4:
                    monedaBase = "COP";
                    monedaCambio = "USD";
                    break;
                case 5:
                    monedaBase = "USD";
                    monedaCambio = "ARS";
                    break;
                case 6:
                    monedaBase = "ARS";
                    monedaCambio = "USD";
                    break;
                case 7:
                    monedaBase = "USD";
                    monedaCambio = "BRL";
                    break;
                case 8:
                    monedaBase = "BRL";
                    monedaCambio = "USD";
                    break;
                case 9:
                    System.out.println("\n \nGracias por usar nuestro sistema...\n \n");
                    calcular = false;
                    break;
                default:
                    System.out.println("\n \nLa opcion debe estar entre 1 y 9...\n \n");
                    calcular = false;
            }
            if (calcular){
                Moneda moneda = consulta.calculaDivisa(monedaBase, monedaCambio, monto);
                System.out.println("--------------------------------------------------------------------------------------------------------");
                System.out.println(moneda);
                System.out.println("--------------------------------------------------------------------------------------------------------");
                System.out.println("\n Presione <ENTER> para volver al menu \n");
                new java.util.Scanner(System.in).nextLine();
            }
        }
    }
}
