package org.example;


import Client.CoinConverter;

public class Main {
    public static void main(String[] args) {

        CoinConverter coinConverter = new CoinConverter();
        double answer = coinConverter.convert("USD", "BDT", 2);
        System.out.println(answer);
        
    }
}