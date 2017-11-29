package com.example.ongajong.tourismv3.Kwik;

import java.util.Arrays;
import java.util.LinkedList;

public class trialrun{
    public static void main(String[] args) {
        LinkedList<String> a = new LinkedList<>(Arrays.asList("MarinaBaySands","SingaporeFlyer","VivoCity","ResortsWorldSentosa","Zoo","BuddhaToothRelicTemple"));
        LinkedList<node> master = new LinkedList<>();
        for(String s: a){
            node ao = iteratetoadd.add(s);
            master.add(ao);
        }
        node hhhhhh = iteratetoadd.add("MarinaBaySands");
        /*for(com.example.ongajong.tourismv3.Kwik.node n: master){
            System.out.println(n.name +" FILE");
            Set<destina> asd =n.possible.keySet();
            for(destina ppp:asd){
                System.out.println(ppp);
                System.out.print(n.possible.get(ppp).get(movetype.BUSTR).towards);
                System.out.print(" ");
                System.out.print(n.possible.get(ppp).get(movetype.BUSTR).type);
                System.out.print(" ");
                System.out.print(n.possible.get(ppp).get(movetype.BUSTR).cost);
                System.out.print(" ");
                System.out.print(n.possible.get(ppp).get(movetype.BUSTR).time);
                System.out.print(" ");
                System.out.println(n.possible.get(ppp).get(movetype.BUSTR).efficiency);

                System.out.print(n.possible.get(ppp).get(movetype.FOOT).towards);
                System.out.print(" ");
                System.out.print(n.possible.get(ppp).get(movetype.FOOT).type);
                System.out.print(" ");
                System.out.print(n.possible.get(ppp).get(movetype.FOOT).cost);
                System.out.print(" ");
                System.out.print(n.possible.get(ppp).get(movetype.FOOT).time);
                System.out.print(" ");
                System.out.println(n.possible.get(ppp).get(movetype.FOOT).efficiency);

                System.out.print(n.possible.get(ppp).get(movetype.TAXI).towards);
                System.out.print(" ");
                System.out.print(n.possible.get(ppp).get(movetype.TAXI).type);
                System.out.print(" ");
                System.out.print(n.possible.get(ppp).get(movetype.TAXI).cost);
                System.out.print(" ");
                System.out.print(n.possible.get(ppp).get(movetype.TAXI).time);
                System.out.print(" ");
                System.out.println(n.possible.get(ppp).get(movetype.TAXI).efficiency); //TO TEST FOR PROPER ADDING INTO NODES

            }

        }*/

        brutetraversal ccc = new brutetraversal();
        double aasd = System.nanoTime();
        LinkedList<Object> abc = ccc.findans(master,hhhhhh,20.00);
        double aadd= System.nanoTime();
        System.out.println("Time for computation: "+ ((aadd-aasd)* Math.pow(10,-9)));
        LinkedList<move> akk = (LinkedList<move>) abc.get(0);
        System.out.println("Final Answer");
        debugprintjourney.print(akk);
        double iii = (double)abc.get(1);
        System.out.println("cost: " + iii);
        int ikk = (int) abc.get(2);
        System.out.println("Time: "+ikk);
        //0 = journey 1 = cost 2 = time

        System.out.println("");
        System.out.println("");
        System.out.println("");
        parlourtrick trick= new parlourtrick();
        double hop = System.nanoTime();
        LinkedList<Object> answer2 = trick.mental(master,hhhhhh,20.0);
        double bop = System.nanoTime();
        System.out.println("Time for Computation 2:" + ((bop-hop)* Math.pow(10,-9)));
        LinkedList<move> trial2 = (LinkedList<move>) answer2.get(0);

        System.out.println("Answer 2 ");
        debugprintjourney.print(trial2);
        double ik = (double) answer2.get(1);
        System.out.println("cost: "+ ik);
        int iko = (int) answer2.get(2);
        System.out.println("Time: " + iko);
        //0 = journey 1 = cost 2 = time

    }
}
