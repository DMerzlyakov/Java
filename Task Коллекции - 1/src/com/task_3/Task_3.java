package com.task_3;

import java.util.*;


public class Task_3 {

    static void buildCountDictionary(String string){

        string = string.toLowerCase();
        Map<Character, Integer> dictionary = new HashMap<>();
        for(int i = 0; i < string.length(); i++){
            char symbol = string.charAt(i);
            if(symbol >= 'а' && symbol <= 'я'){
                dictionary.compute(symbol, (a, b) -> b == null ? 1 : b + 1);
            }
        }
        ArrayList<Map.Entry<Character, Integer>> count =
                new ArrayList<>(dictionary.entrySet());
        count.sort((a, b) -> Character.compare(a.getKey(), b.getKey()));
        for(Map.Entry<Character, Integer> count_1 : count){
            System.out.println(count_1.getKey() + " " + count_1.getValue());
        }
}
}
