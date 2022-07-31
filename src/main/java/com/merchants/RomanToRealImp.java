package com.merchants;

import java.util.*;

public class RomanToRealImp implements IRoman {
	
	
	
	   
	    HashMap<Character,Integer> initMap = new HashMap<Character, Integer>();
	    {
	        initMap.put('I',1);
	        initMap.put('V',5);
	        initMap.put('X',10);
	        initMap.put('L',50);
	        initMap.put('C',100);
	        initMap.put('D',500);
	        initMap.put('M',1000);
	    }

	    
	     public int calculateDemo(String inputRomanValue) throws Exception {
	       
	        if (inputRomanValue.equals("")){
	            return 0;
	        }
	        char[] romans = inputRomanValue.toCharArray();
	        int result = 0;
	        int repeatI = 0,repeatX = 0,repeatC = 0,repeatM = 0,repeatD = 0,repeatL = 0,repeatV = 0;

	        for (int i = 0; i <= romans.length - 1; i++) {
	            Character currentKey = null;
	            int currentValue = 0;
	            Character nextKey = null;
	            int nextValue = 0;
	            for(Character key:initMap.keySet()){
	                if(key == romans[i]){
	                    currentKey = key;
	                    currentValue = initMap.get(key);
	                }
	            }

	            // The symbols "I", "X", "C", and "M" can be repeated three times in succession
	            if('I' == romans[i]){
	                repeatI++;
	            }else if('X' == romans[i]){
	                repeatX++;
	            }else if('C' == romans[i]){
	                repeatC++;
	            }else if('M' == romans[i]){
	                repeatM++;
	            }else if('D' == romans[i]){
	                repeatD++;
	            }else if('L' == romans[i]){
	                repeatL++;
	            }else if('V' == romans[i]){
	                repeatV++;
	            }
	            if(repeatI > 3 || repeatX > 3 ||repeatC > 3 ||repeatM > 3){
	                throw new Exception("Not allow " + currentKey + " repeated more than 3 times");
	            }
	            //  "D", "L", and "V" can never be repeated.
	            if(repeatD > 1 || repeatL > 1 ||repeatV > 1){
	                throw new Exception("Not allow " + currentKey + " repeated more than 1 times");
	            }

	           
	            if (i >= romans.length - 1) {
	                result += currentValue;
	                break;
	            }
	          
	            for(Character key:initMap.keySet()){
	                if(key == romans[i+1]){
	                    nextKey = key;
	                    nextValue = initMap.get(key);
	                }
	            }
	            if (currentValue == 0) {
	                throw new Exception("unexpected roman char:"+romans[i]);
	            }
	            if (nextValue == 0) {
	                throw new Exception("unexpected roman char:"+romans[i + 1]);
	            }
	           
	            if (currentValue >= nextValue) {
	                result += currentValue;
	            }else {
	                // "I" can be subtracted from "V" and "X" only.
	                if(currentKey == 'I' && nextKey != 'V' && nextKey != 'X'){
	                    throw new Exception("Not allow " + nextKey + " subtract" + currentKey);
	                }
	                // "X" can be subtracted from "L" and "C" only.
	                if(currentKey == 'X' && nextKey != 'L' && nextKey != 'C'){
	                    throw new Exception("Not allow " + nextKey + " subtract" + currentKey);
	                }
	                //  "C" can be subtracted from "D" and "M" only.
	                if(currentKey == 'C' && nextKey != 'D' && nextKey != 'M'){
	                    throw new Exception("Not allow " + nextKey + " subtract" + currentKey);
	                }
	                //  "V", "L", and "D" can never be subtracted.
	                if('V' == romans[i] || 'L' == romans[i] || 'D' == romans[i]){
	                    throw new Exception("Not allow " + currentKey + " subtracted");
	                }
	                result += nextValue - currentValue;
	                i++;
	            }
	        }
	        return result;
	    }

	   

	}



