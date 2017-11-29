package com.example.ongajong.tourismv3.Kwik;

import java.util.LinkedList;

public class typeofmoves {
    public static LinkedList<movetype> doo (LinkedList<move> a ){
        LinkedList<movetype> answer = new LinkedList<>();
        for(move b: a){
            answer.add(b.type);
        }
        return answer;
    }
}
