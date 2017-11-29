package com.example.ongajong.tourismv3.Kwik;

import java.util.HashMap;
import java.util.LinkedList;

public class parlourtrick {
    // a crude parlour trick designed to reduce time taken to complete the trip while utilising the budget to it's maximum
    //utilise a linkedlist to list all efficiencies of taxi com.example.ongajong.tourismv3.Kwik.move. All taxi moves are shortest possible...
    //or longest possible. Depends if i pretend that taxi moves have a basic start fare. the issue however is that not all
    //longest should be translated...
    //then again, max time taxi should be taken at all times because it means it was the longest travel time.
    //i don't want to bus a long distance, i HAVE to travel via taxi.
    //So as a result , i have to ensure that the shortest and least efficient is transformed to bus time, if it has overshot the budget.

    private LinkedList<destina> locations= new LinkedList<>();
    private HashMap<destina,node> reference = new HashMap<>();
    private LinkedList<move> journey = new LinkedList<>();
    private LinkedList<move> hold = new LinkedList<>();

    public  LinkedList<Object> mental(LinkedList<node> places, node start, double budget){
        this.locations.clear(); //initialise
        this.reference.clear(); //initialise
        this.hold.clear(); //initialise
        this.journey.clear(); //initialise
        for(node a: places){
            this.locations.add(a.name); //obtain locations list
        }
        reference.put(start.name, start);
        for(node a: places ){
            reference.put(a.name,a);
        }
        for(destina a: locations){
            try{hold.add(reference.get(start.name).possible.get(a).get(movetype.TAXI)); }//obtain all moves possible from the start com.example.ongajong.tourismv3.Kwik.node.
            catch(NullPointerException e){} //do nothing. This is bound to happen due to the start location being included inside the locations.
        }
        move efficient = new move(null,1.0,movetype.TAXI,1000000); //target, cost, taxi, time. Maximise inefficiency here.
        //efficient initialised with maximial inefficiency.
        for (move a: hold){
            if(a.efficiency<efficient.efficiency){
                efficient = a; //comparison in terms of most efficient movements.
            }
        }
        //now efficient holds the most efficient destination.
        journey.add(efficient); //add the most efficient...

        locations.removeFirstOccurrence(efficient.towards); //remove destination from allowed destination.

        while(locations.size()!=0){ //repeated till all locations visited.
            hold.clear();
            destina lasttouched = journey.getLast().towards;
            for(destina a:locations){
                try{hold.add(reference.get(lasttouched).possible.get(a).get(movetype.TAXI)); }////grab the possible movements via taxi from that spot.
                catch(NullPointerException e){} //do nothing. This is bound to happen due to the start location being included inside the locations.
            }
            efficient = new move(null,10000000000000000.0,movetype.TAXI,1); //target, cost, taxi, time. Maximise inefficiency here.
            for(move a:hold){
                if(a.efficiency>efficient.efficiency){
                    efficient = a;
                }
            }
            journey.add(efficient);
            destina remove = efficient.towards;
            locations.remove(locations.indexOf(remove));//remove destination from allowed destination
        } //The above for loop is iterated till all places are visited. Now just to home run back. (GREEDY ON EFFICIENCY)
        journey.add(reference.get(journey.getLast().towards).possible.get(start.name).get(movetype.TAXI));
        //get the last com.example.ongajong.tourismv3.Kwik.move back. it's a taxi ride back to the hotel.

        //Now to check if budget is overshot
        double summer =0;
        for(move a: journey){
            summer+=a.cost;
        }
        int timer=0;
        for(move a: journey){
            timer += a.time;
        }
        if(summer<=budget){
            LinkedList<Object> answer = new LinkedList<>();
            LinkedList<move> moves = new LinkedList<>();
            for(move a: journey){
                moves.add(a);
            }
            //0 = journey 1 = cost 2 = time
            answer.add(moves);
            answer.add(summer);
            answer.add(timer);
            return answer;
        }

        else{ //i.e. the movements are too expensive.
            //2 solutions, one is to greedy reduce by highest cost.
            //the other is to greedy reduce by lowest efficiency. So essentially, stuck with efficiency greed.
            move previousmove;
            int indexofworst;
            destina set;
            while(summer>budget && !isbus.tf(this.journey) ) {
                hold.clear();
                move worst = new move(null, 1.0, movetype.TAXI, 100000000); //best possible efficiency
                for (move a : journey) {
                    if (a.efficiency < worst.efficiency && a.type!=movetype.BUSTR ) {
                        worst = a;
                    } //find the worst efficiency item.
                }
                indexofworst = journey.indexOf(worst); //obtain the index of the worst efficiency.
                if(indexofworst==0){set= start.name;} //obtain previous location
                else{set = journey.get(indexofworst-1).towards;} //obtain previous location
                journey.remove(indexofworst); //remove previous bad com.example.ongajong.tourismv3.Kwik.move
                journey.add(indexofworst,reference.get(set).possible.get(worst.towards).get(movetype.BUSTR)); //change the type to bus/train for that com.example.ongajong.tourismv3.Kwik.move
                //add it to the journey at that location


                summer=0;
                for(move a: journey){
                    summer+=a.cost; //recompute cost
                }
            }
            if(summer>budget){//if the budget is still overshot
                while(summer>budget){
                    move changetowalk = new move(null, 0.0000001, movetype.BUSTR, 1); //holder to search for highest cost item.
                    for(move a:journey) {//iterate to find highest cost movement
                        if (a.cost > changetowalk.cost) {
                            changetowalk = a;
                        }
                    }
                    indexofworst = journey.indexOf(changetowalk); //obtain the index of the worst efficiency.
                    if (indexofworst == 0) {
                        set = start.name;
                    } //obtain previous location
                    else {
                        set = journey.get(indexofworst - 1).towards;
                    } //obtain previous location
                    journey.remove(indexofworst); //remove previous bad com.example.ongajong.tourismv3.Kwik.move
                    journey.add(indexofworst, reference.get(set).possible.get(changetowalk.towards).get(movetype.FOOT));
                    //greedy for lowest cost.
                    summer=0;
                    for(move ss:journey){
                        summer+= ss.cost;
                    }
                }
            }
            timer=0;
            for(move a:journey){
                timer+=a.time;
            }
            LinkedList<Object> answer = new LinkedList<>();
            LinkedList<move> moves = new LinkedList<>();
            for(move a: journey){
                moves.add(a);
            }
            answer.add(moves);
            answer.add(summer);
            answer.add(timer);
            return answer;
        }
    }
    //recursively transform the thing to bus, then into foot....

}
