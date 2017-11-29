package com.example.ongajong.tourismv3.Kwik;

import static jdk.nashorn.internal.objects.Global.Infinity;

public class move{
	public movetype type; //type of movement
	public destina towards; //headed towards?
	public Double cost; //cost of such a movement. defaults to zero if it's a foot type.
	public int time; //how long the movecost is, in minutes, rounded up.
	public Double efficiency; //how efficient this movement is in terms of (1/dollars)/min.  Efficiency is in regards to your money.
	//in other words, having a very long travel time, and a very large cost, will make your efficiency drop.
	//inversely, having a very short travel time, and a very small amount of money spent will be efficient in terms of money usage.


	
	//Initialise
	
	move(destina destination, Double a, movetype what, int time){
		if(what != movetype.FOOT){ //it is not a foot type. i won't check for invalidity
			this.cost = a;
			this.towards = destination;
			this.type = what;
			this.time = time;
			this.efficiency = time/a; // time/money. money is the constraint..
		}
		else{ // it's a foot type.
			this.cost =0.0; //no cost for walking
			this.towards = destination;
			this.type = what;
			this.time = time;
			this.efficiency = Infinity; //There is nothing to calculate in terms of wallet efficiency here.
		}
	}
	
}