package com.example.ongajong.tourismv3;

import java.util.Arrays;
import java.util.LinkedList;

public class trialrun{
    public static LinkedList<Object> brute(LinkedList<String> places, double budget){
        //name price
        //Singapore Flyer $2.33 Bus
        //Take a METHODOFTRANSPORT from DESTINATION1 to DESTINATION2 (COST)
        //TOTAL COST: COST | TOTAL TIME: TIME
        //typeofmoves -> movetypetranslate
        //destinationorder +translator
        //computecost&computetime
        LinkedList<node> master = new LinkedList<>();
        for(String s: places){
            node nodes = iteratetoadd.add(s);
            master.add(nodes);
        }
        node startnode = iteratetoadd.add("MarinaBaySands");
        brutetraversal brute = new brutetraversal();
        System.out.println(startnode.possible.get(destina.BuddhaToothRelicTemple).get(movetype.BUSTR).cost);
        LinkedList<Object> answer = brute.findans(master,startnode,budget);
        LinkedList<move> truth = (LinkedList<move>) answer.get(0);
        LinkedList<Object> popme = new LinkedList<>();
        String s = debugprintjourney.print(truth);
        popme.add(s);
        popme.add(answer.get(1));
        popme.add(answer.get(2));
        //String s = debugprintjourney.print(truth);


        /*
        LinkedList<destina> destinations = Destinationorder.get(truth);
        LinkedList<String> movements = movetypetranslate.doo(typeofmoves.doo(truth));
        LinkedList<Double> costs = costlist.doo(truth);
        String s = "";
        int counter =0;
        String d1;
        String d2;
        String c;
        String m;
        for(Double d: costs){
            d1 = destinations.get(counter).toString();
            d2 = destinations.get(counter+1).toString();
            c = costs.get(counter).toString();
            m = movements.get(counter);
            s+= " Take a ";
            s+= m;
            s+= " from ";
            s+=d1;
            s+=" to ";
            s+=d2;
            s+=" (";
            s+=c;
            s+=") \n ";
            counter+=1;*/

        //}
        return popme;
    }
    public static LinkedList<Object> fast(LinkedList<String> places, double budget){
        //name price
        //Singapore Flyer $2.33 Bus
        //Take a METHODOFTRANSPORT from DESTINATION1 to DESTINATION2 (COST)
        //TOTAL COST: COST | TOTAL TIME: TIME
        //typeofmoves -> movetypetranslate
        //destinationorder +translator
        //computecost&computetime
        LinkedList<node> master = new LinkedList<>();
        master.clear();
        for(String s: places){
            node nodes = iteratetoadd.add(s);
            master.add(nodes);
        }
        for(node s: master){
            System.out.println(s.name);
        }
        node startnode = iteratetoadd.add("MarinaBaySands");
        parlourtrick trick = new parlourtrick();
        LinkedList<Object> answer = trick.mental(master,startnode,budget);
        LinkedList<move> truth = (LinkedList<move>) answer.get(0);
        LinkedList<Object> popme = new LinkedList<>();
        String s = debugprintjourney.print(truth);
        popme.add(s);
        popme.add(answer.get(1));
        popme.add(answer.get(2));
        /*
        LinkedList<destina> destinations = Destinationorder.get(truth);
        LinkedList<String> movements = movetypetranslate.doo(typeofmoves.doo(truth));
        LinkedList<Double> costs = costlist.doo(truth);
        String s = "";
        int counter =0;
        String d1;
        String d2;
        String c;
        String m;
        for(Double d: costs){
            d1 = destinations.get(counter).toString();
            d2 = destinations.get(counter+1).toString();
            c = costs.get(counter).toString();
            m = movements.get(counter);
            s+= " Take a ";
            s+= m;
            s+= " from ";
            s+=d1;
            s+=" to ";
            s+=d2;
            s+=" (";
            s+=c;
            s+=") \n ";
            counter+=1;

        }*/
        return popme;




    }
    public static void main(String[] args) {
        LinkedList<String> a = new LinkedList<>(Arrays.asList("MarinaBaySands","SingaporeFlyer","VivoCity","ResortsWorldSentosa","Zoo","BuddhaToothRelicTemple"));
        LinkedList<node> master = new LinkedList<>();
        for(String s: a){
            System.out.println(s);
            node ao = iteratetoadd.add(s);
            master.add(ao);
        }
        node hhhhhh = iteratetoadd.add("MarinaBaySands");
        /*for(com.example.ongajong.tourismv3.node n: master){
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
