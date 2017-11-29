package com.example.ongajong.tourismv3.Kwik;

import java.util.HashMap;

//a com.example.ongajong.tourismv3.Kwik.node maker for the family. Do not use unless required.
//this com.example.ongajong.tourismv3.Kwik.node is more of a consideration com.example.ongajong.tourismv3.Kwik.node.
// in other words, there is a single com.example.ongajong.tourismv3.Kwik.node that states
public class node{
	public HashMap<destina,HashMap<movetype,move>> possible;
	public destina name;
	node(destina name){
	    this.possible = new HashMap<>();
	    this.name = name;
    }
    //at initialisation, this destination is in no way connected to any other destinations. we must add them all in manually.


    public void addmoves(move foot, move taxi, move trainy, destina where){
	    //it is assumed that I will NEVER need to perform an add of the same location more than once. So this, should never return an error.
        //unless of course you placed something wrong as an argument, or the where was already added.
        // to be honest it won't return an error though. you'll just overwrite it. you nitwit.
        HashMap<movetype, move> placer = new HashMap<>();
        placer.put(taxi.type,taxi); // place in taxi
        placer.put(foot.type,foot); //place in by foot
        placer.put(trainy.type,trainy); //place in trains.
        //Realise that the way i placed them is entirely interchangeable. as long as no duplicate type exists, nothing is ever overwritten.
        this.possible.put(where,placer); //now place into the master.
    /*    System.out.print(this.possible.get(where).get(taxi.type).towards);
        System.out.print(" ");
        System.out.print(this.possible.get(where).get(taxi.type).type);
        System.out.print(" ");
        System.out.print(this.possible.get(where).get(taxi.type).cost);
        System.out.print(" ");
        System.out.print(this.possible.get(where).get(taxi.type).time);
        System.out.print(" ");
        System.out.println(this.possible.get(where).get(taxi.type).efficiency);

        System.out.print(this.possible.get(where).get(trainy.type).towards);
        System.out.print(" ");
        System.out.print(this.possible.get(where).get(trainy.type).type);
        System.out.print(" ");
        System.out.print(this.possible.get(where).get(trainy.type).cost);
        System.out.print(" ");
        System.out.print(this.possible.get(where).get(trainy.type).time);
        System.out.print(" ");
        System.out.println(this.possible.get(where).get(trainy.type).efficiency);

        System.out.print(this.possible.get(where).get(foot.type).towards);
        System.out.print(" ");
        System.out.print(this.possible.get(where).get(foot.type).type);
        System.out.print(" ");
        System.out.print(this.possible.get(where).get(foot.type).cost);
        System.out.print(" ");
        System.out.print(this.possible.get(where).get(foot.type).time);
        System.out.print(" ");
        System.out.println(this.possible.get(where).get(foot.type).efficiency);*/
    }
}

