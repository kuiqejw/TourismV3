package com.example.ongajong.tourismv3;

import java.util.LinkedList;

public class movetypetranslate {
    public static LinkedList<String> doo(LinkedList<movetype> a){
        LinkedList<String> answer = new LinkedList<>();
        for(movetype c: a){
            if (c.equals(movetype.TAXI)){
                answer.add("taxi");
            }
            else if(c.equals(movetype.BUSTR)){
                answer.add("bus/train");
            }
            else if(c.equals(movetype.FOOT)){
                answer.add("walk");
            }
            else{
                answer.add(null);
            }
        }
        return answer;
    }
}
