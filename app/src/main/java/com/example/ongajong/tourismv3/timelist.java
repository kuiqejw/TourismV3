package com.example.ongajong.tourismv3;

import java.util.LinkedList;

public class timelist {
    public static LinkedList<Integer> doo(LinkedList<move> a){
        LinkedList<Integer> answer = new LinkedList<>();
        for(move b: a){
            answer.add(b.time);
        }
        return answer;
    }
}
