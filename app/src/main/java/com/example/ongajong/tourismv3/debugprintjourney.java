package com.example.ongajong.tourismv3;

import java.util.LinkedList;

public class debugprintjourney {
    public static String print(LinkedList<move> a){
        String s = "";
        System.out.println("DEBUGPRINT");
        for(move ooop : a){
            s+= ooop.towards;
            s+= ooop.type;
            s+= ooop.cost;
            s+= ooop.time;
            System.out.print(ooop.towards);
            System.out.print(" ");
            System.out.print(ooop.type);
            System.out.print(" ");
            System.out.print(ooop.cost);
            System.out.print(" ");
            System.out.println(ooop.time);
        }
        return s;

    }
}
