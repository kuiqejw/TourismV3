package com.example.ongajong.tourismv3;

import java.util.LinkedList;

public class Destinationorder {
    public static LinkedList<destina> get(LinkedList<move> a){
        LinkedList<destina> answer = new LinkedList<>();
        answer.add(a.getLast().towards); //obtain the starting com.example.ongajong.tourismv3.node
        for(move b: a){
            answer.add(b.towards);
        }
        return answer;
    }
}
