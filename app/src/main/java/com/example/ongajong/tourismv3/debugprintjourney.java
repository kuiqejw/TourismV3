package com.example.ongajong.tourismv3;

import java.util.LinkedList;

public class debugprintjourney {
    public static void print(LinkedList<move> a){
        System.out.println("DEBUGPRINT");
        for(move ooop : a){
            System.out.print(ooop.towards);
            System.out.print(" ");
            System.out.print(ooop.type);
            System.out.print(" ");
            System.out.print(ooop.cost);
            System.out.print(" ");
            System.out.println(ooop.time);
        }

    }
}
