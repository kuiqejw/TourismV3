package com.example.ongajong.tourismv3.Kwik;

import java.util.LinkedList;

public class isbus {
    public static boolean tf(LinkedList<move> a){ //a class to check if all the moves are already bus moves.
        boolean output = true;
        for(move b: a){
            if(b.type!=movetype.BUSTR){
                output = false;
            }
        }
        return output;
    }
}
