package com.example.ongajong.tourismv3;

import java.util.LinkedList;

public class debugprintjourney {
    public static String print(LinkedList<move> a){
        String s = "";
        System.out.println("DEBUGPRINT");
        for(move ooop : a){
            s+= "\n Destination: ";
            s+= ooop.towards;
            s+= " Transport: ";
            s+= ooop.type;
            s+= " Cost: $";
            s+= String.format("%.2f", ooop.cost);
            s += " Time: ";
            s+= ooop.time;
            s += "min \n";
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
