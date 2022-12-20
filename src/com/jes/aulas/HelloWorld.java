package com.jes.aulas;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        
    	Scanner in = new Scanner(System.in);  
        System.out.print("Seja bem vindo ao sistema de chamados, insira seu nome para iniciar");  
        String name = in.nextLine();  
        System.out.println("Certo " + name + " vamos come�ar!");             
        
        
        in.close();         
    }
    
}




//TODO
//Existe o seguinte cenário: Você está na sua empresa e sua internet caiu, descreva o passo a passo para acionar a area de infra
//e resolver o seu problema (minimo 20 passos)

 
//TODO Montar um mapa mental da aula 1

//Aula 1:

//Parte eletrica (Zeros e Uns):
//Binário para Hexadecimal
//Portas logicas (AND, NOT, OR, *XOR)
//*Exclusiva

//Programação é um facilitador

//Compilação - https://www.instagram.com/p/CkRq49cuJOk/
//Instalar JDK
//javac arquivo.java
//java arquivo (sem extensão)

//Organização - package, main, src
//Bibliotecas nativas - O pacote java. lang contém as classes que constituem recursos básicos da linguagem, necessários à execução de qualquer programa Java.

