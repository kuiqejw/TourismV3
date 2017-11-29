package com.example.ongajong.tourismv3;

import java.util.LinkedList;

public class costlist {
    public static LinkedList<Double> doo(LinkedList<move> a){
        LinkedList<Double> answer = new LinkedList<>();
        for(move b: a){
            answer.add(b.cost);
        }
        return answer;
    }
}
