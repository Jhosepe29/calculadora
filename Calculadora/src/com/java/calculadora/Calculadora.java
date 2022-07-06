package com.java.calculadora;

import java.util.Scanner;
public class Calculadora {
    Scanner in = new Scanner(System.in);
    int numberA = 0;
    int numberB = 0;
    double numberAD = 0;
    double numberBD = 0;

    public double getNumberAD() {
        return numberAD;
    }

    public double getNumberBD() {
        return numberBD;
    }

    public void setNumberAD(double numberAD) {
        this.numberAD = numberAD;
    }

    public void setNumberBD(double numberBD) {
        this.numberBD = numberBD;
    }

    public int getNumberA() {
        return numberA;
    }

    public int getNumberB() {
        return numberB;
    }

    public void setNumberA(int numberA) {
        this.numberA = numberA;
    }

    public void setNumberB(int numberB) {
        this.numberB = numberB;
    }

    public void pedirNumeros(int numero) {
        String errorEntrada = "Entrada incorrecta";
        String entradaA = "Ingrese el primer número: ";
        String entradaB = "Ingrese el segundo número: ";
        if (numero == 1) {
            try {
                System.out.println(entradaA);
                this.setNumberA(in.nextInt());
            } catch (Exception e) {
                System.err.println(errorEntrada);
            }

        }
        if (numero == 2) {
            try {
                System.out.println(entradaB);
                this.setNumberB(in.nextInt());
            } catch (Exception e) {
                System.out.println(errorEntrada);
            }
        }
        if (numero == 3) {
            try {
                System.out.println("Ingrese el numerador: ");
                this.setNumberAD(in.nextDouble());
            } catch (Exception e) {
                System.out.println(errorEntrada);
            }
        }
        if (numero == 4) {
            try {
                System.out.println("Ingrese el denominador: ");
                this.setNumberBD(in.nextDouble());
            } catch (Exception e) {
                System.out.println(errorEntrada);
            }
        }
    }

    /*Metodo para refactorizar el valor de los numeros a y b*/
    public void refactorNumber() {
        this.setNumberB(0);
        this.setNumberA(0);
        this.setNumberAD(0);
        this.setNumberBD(0);
    }

    /*Metodo para summar dos numeros*/
    public String sumarNumeros(int a, int b) {
        String salida;
        salida = "" + (a + b);
        refactorNumber();
        return salida;
    }

    /*Metodo para restar dos numeros*/
    public String restarNumeros(int a, int b) {
        String salida;
        salida = "" + (a - b);
        refactorNumber();
        return salida;
    }

    /*Metodo para multiplicar dos numeros*/
    public String multiplicarNumeros(int a, int b) {
        String salida;
        salida = "" + (a * b);
        refactorNumber();
        return salida;
    }

    /*Metodo para dividir dos numeros*/
    public String dividirNumeros(double a, double b) {
        String salida = "";
        if (b != 0) {
            salida = "" + (a / b);
        } else {
            System.out.println(" la división por 0 no es valida");
        }

        refactorNumber();
        return salida;
    }

    /*Metodo para hace operacion modulo dos numeros*/
    public String modulo(double a, double b) {
        String salida;
        salida = "" + (a % b);
        return salida;
    }

    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);
        char seguir = 'y';
        String option;
        String textResultado = "--> Resultado ";
        String textMenu =  """
                            
                            **********************************
                                        Calculadora
                            Menu
                            1.Sumar (+)
                            2.Restar (-)
                            3.Multiplicar (x)
                            4.Dividir (/)
                            5.Modulo de la división (%)
                            6.Salir
                            
                            Ingrese una opción:""" ;

        Calculadora cal = new Calculadora();

        do {
            System.out.println(textMenu);
            option = enter.next();

            switch (option) {
                case "1" -> {
                    cal.pedirNumeros(1);
                    cal.pedirNumeros(2);
                    System.out.println(textResultado + cal.getNumberA() + " + " + cal.getNumberB() + " = " +
                            cal.sumarNumeros(cal.getNumberA(), cal.getNumberB()));
                }
                case "2" -> {
                    cal.pedirNumeros(1);
                    cal.pedirNumeros(2);
                    System.out.println(textResultado + cal.getNumberA() + " - " + cal.getNumberB() + " = " +
                            cal.restarNumeros(cal.getNumberA(), cal.getNumberB()));
                }
                case "3" -> {
                    cal.pedirNumeros(1);
                    cal.pedirNumeros(2);
                    System.out.println(textResultado+cal.getNumberA() + " x " + cal.getNumberB() + " = " +
                            cal.multiplicarNumeros(cal.getNumberA(), cal.getNumberB()));
                }
                case "4" -> {
                    cal.pedirNumeros(3);
                    cal.pedirNumeros(4);
                    if (cal.getNumberBD() != 0) {
                        System.out.println(textResultado + cal.getNumberAD() + " / " + cal.getNumberBD() + " = " +
                                cal.dividirNumeros(cal.getNumberAD(), cal.getNumberBD()));
                    }
                }
                case "5" -> {
                    cal.pedirNumeros(3);
                    cal.pedirNumeros(4);
                    System.out.println(textResultado + cal.getNumberAD() + " % " + cal.getNumberBD() + " = " +
                            cal.modulo(cal.getNumberAD(), cal.getNumberBD()));
                }
                case "6" -> {
                    seguir = 'n';
                    System.out.println("Hasta la próxima");

                }
                default -> System.out.println("Ingreso una opción no valida");
            }


        } while (seguir == 'y');
    }
}
