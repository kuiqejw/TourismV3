package com.example.ongajong.tourismv3.Kwik;

import java.util.LinkedList;

public class computecost {
    public static double doo(LinkedList<move> a){
        double summer=0;
        for(move s: a){
            summer+=s.cost;
        }
        return summer;
    }
}
