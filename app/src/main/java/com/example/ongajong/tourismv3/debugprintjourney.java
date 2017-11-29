package com.example.ongajong.tourismv3;

import java.util.LinkedList;

public class debugprintjourney {
    public static String print(LinkedList<move> a){
        String s = "";
        System.out.println("DEBUGPRINT");
        for(move ooop : a){
            s+= "Destintion: ";
            s+= ooop.towards;
            s+= " Transport: ";
            s+= ooop.type;
            s+= " Cost: ";
            s+= ooop.cost;
            s += " Time: ";
            s+= ooop.time;
            s += "\n";
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
