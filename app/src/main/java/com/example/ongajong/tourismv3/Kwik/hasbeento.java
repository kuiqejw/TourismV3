package com.example.ongajong.tourismv3.Kwik;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

// utility class to find all unvisited places.


public class hasbeento {
    public static LinkedList<node> to(HashMap<destina,node> places, LinkedList<move> moves){
        Set<destina> targets =  places.keySet(); //obtain all targets
        LinkedList<node> answer = new LinkedList<>(); // a list to return with all unvisited locations
        LinkedList<destina> here = new LinkedList<>(); //a list with all visited destinas.
        for (move aa: moves){
            here.add(aa.towards);
        }
        for(destina as: targets){
            if(here.contains(as)){} //if destination has been visited do nothing
            else{answer.add(places.get(as));} //add to answer
        }
        /*for(com.example.ongajong.tourismv3.Kwik.node annn: answer){
            System.out.print(annn.name + " ");
        }
        System.out.println(" - has beento");*/
        return answer;
    }
}
