package com.merchants;

import java.util.Scanner;


public class TestStart {
	 public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	       System.out.println("enter the capital letter");
	        RomanToRealImp test = new RomanToRealImp();
	        while (true){
	            if (scan.hasNextLine()) {
	                String inputRomanValue = scan.nextLine();
	                try {
	                    System.out.println("Their money is " + inputRomanValue + ".");
	                    System.out.println("My money is  " + test.calculateDemo(inputRomanValue) + ".");
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
}
