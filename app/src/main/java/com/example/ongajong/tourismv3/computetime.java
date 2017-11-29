package com.example.ongajong.tourismv3;

import java.util.LinkedList;

public class computetime {
    public static int doo (LinkedList<move> journey){
        int summer =0;
        for(move a:journey){
            summer+=a.time;
        }
        return summer;
    }
}
