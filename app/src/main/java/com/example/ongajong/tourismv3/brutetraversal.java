package com.example.ongajong.tourismv3;

import java.util.HashMap;
import java.util.LinkedList;

public class brutetraversal {
    // a public static class, that returns a linked list in the following form-> 0=LinkedList<com.example.ongajong.tourismv3.node> 1=time taken 2=cost 3=Linkedlist, movetypes
    //0 dictates the path travelled
    private LinkedList<node> master= new LinkedList<>(); //contains a linked list of all possible locations
    private node start; //saves the start com.example.ongajong.tourismv3.node.
    public HashMap<destina,node> alllocations = new HashMap<>(); //contains a hashmap of all possible locations
    private double budget;
    private int branches=0;


    public LinkedList<Object> findans(LinkedList<node> attractions, node start, double budget){
        //com.example.ongajong.tourismv3.node start = start from where
        //com.example.ongajong.tourismv3.node end = end where?
        //the purpose is to create a brute attack that looks for all possible permutations.
        this.master = attractions;
        this.budget=budget;
        //this.master.removeFirstOccurrence(start); //remove the start com.example.ongajong.tourismv3.node from consideration
        node removal=null;
        for(node cons: this.master){
            if (cons.name.equals(start.name)){
                removal =cons;
            }
        }
        this.master.removeFirstOccurrence(removal);
        //System.out.println("Started Find Answer: ");
        //master does not contain start com.example.ongajong.tourismv3.node.
        LinkedList<move> ans = new LinkedList<>();
        for (node moe: master){
            alllocations.put(moe.name,moe); //place each com.example.ongajong.tourismv3.node into the master hashmap!
            //note that alllocations does not include the start com.example.ongajong.tourismv3.node!
        }
        this.start =start;
        ans = recur(ans); //perform a recursion search down the tree. using an empty linked list to begin the trek.

        int timetaken;
        double cost;

        timetaken = computetime.doo(ans);
        cost = computecost.doo(ans);
        LinkedList<Object> answer = new LinkedList<>();
        answer.add(ans);
        answer.add(cost);
        answer.add(timetaken);
        return answer;
        //0=journey
        //1=cost
        //2=time
    }

    public LinkedList<move> recur(LinkedList<move> journey){
        int time; // hold current considered moveset's time.
        double cost; //hold current considered moveset's cost.
        int besttime=1000000000; //ridiculously high number
        double bestcost=10000000000.0; //ridiculously high number
        LinkedList<move> bestmoves=new LinkedList<>(); //best movement thus far.
        LinkedList<move> hold = new LinkedList<>(); //a list to hold the current considered moveset.



        if(journey.size()==0){//this is the home com.example.ongajong.tourismv3.node, where the final answer is given.

            for(node a:this.master){
                //now to iterate to all possible destinations, testing each of the moves.
                hold.add(start.possible.get(a.name).get(movetype.FOOT));//take the foot path, iterate.
                hold = recur(hold);
                cost =computecost.doo(hold);
                time =computetime.doo(hold); //compute cost and time

                /*System.out.println("");
                System.out.println("TRUE FOOTSTART ENDING");
                com.example.ongajong.tourismv3.debugprintjourney.print(hold);
                System.out.println("Cost: " +cost);
                System.out.println("Time: " + time);*/
                if(hold.size() ==0){ cost =this.budget+1.00;}
                if(cost<=this.budget &&time<besttime){   //better in both ways..

                    //Bias towards lower time.
                    //then consider if the cost is lower.
                    if(time<besttime){
                        bestmoves.clear();
                        for(move aaa: hold){
                            bestmoves.add(aaa);
                        }
                        besttime = time;//if good, keep
                        bestcost= cost;
                    }
                    else {
                        if (cost<bestcost){
                            bestmoves.clear();
                            for(move aaa: hold){
                                bestmoves.add(aaa);
                            }
                            besttime = time;//if good, keep
                            bestcost= cost;
                        }
                    }
                    /*System.out.println("");
                    System.out.println("Currentbestmove");
                    com.example.ongajong.tourismv3.debugprintjourney.print(bestmoves);

                    System.out.println("Cost: " +bestcost);
                    System.out.println("Time: " + besttime);
                    System.out.println("Branches: " + this.branches);*/
                }
                hold.clear();
                hold.add(start.possible.get(a.name).get(movetype.TAXI)); //take the taxi path, iterate
                hold = recur(hold);
                cost =computecost.doo(hold);
                time =computetime.doo(hold);//compute cost and time

                /*System.out.println("");
                System.out.println("TRUE TAXISTART ENDING");
                com.example.ongajong.tourismv3.debugprintjourney.print(hold);
                System.out.println("Cost: " +cost);
                System.out.println("Time: " + time);*/
                if(hold.size() ==0){ cost =this.budget+1.00;}
                if(cost<=this.budget &&time<=besttime){

                    //Bias towards lower time.
                    //then consider if the cost is lower.
                    if(time<besttime){
                        bestmoves.clear();
                        for(move aaa: hold){
                            bestmoves.add(aaa);
                        }
                        besttime = time;//if good, keep
                        bestcost= cost;
                    }
                    else {
                        if (cost<bestcost){
                            bestmoves.clear();
                            for(move aaa: hold){
                                bestmoves.add(aaa);
                            }
                            besttime = time;//if good, keep
                            bestcost= cost;
                        }
                    }



                    /*System.out.println("");
                    System.out.println("Currentbestmove");
                    com.example.ongajong.tourismv3.debugprintjourney.print(bestmoves);

                    System.out.println("Cost: " +bestcost);
                    System.out.println("Time: " + besttime);
                    System.out.println("Branches: " + this.branches);*/

                }
                hold.clear();
                hold.add(start.possible.get(a.name).get(movetype.BUSTR)); //take the bus path, iterate
                hold = recur(hold);
                cost =computecost.doo(hold);
                time =computetime.doo(hold);//compute cost and time
                if(hold.size() ==0){ cost =this.budget+1.00;}
                /*System.out.println("");
                System.out.println("TRUE BUSSTART ENDING");
                com.example.ongajong.tourismv3.debugprintjourney.print(hold);
                System.out.println("Cost: " +cost);
                System.out.println("Time: " + time);*/


                if(cost<=this.budget &&time<=besttime){

                    //Bias towards lower time.
                    //then consider if the cost is lower.
                    if(time<besttime){
                        bestmoves.clear();
                        for(move aaa: hold){
                            bestmoves.add(aaa);
                        }
                        besttime = time;//if good, keep
                        bestcost= cost;
                    }
                    else {
                        if (cost<bestcost){
                            bestmoves.clear();
                            for(move aaa: hold){
                                bestmoves.add(aaa);
                            }
                            besttime = time;//if good, keep
                            bestcost= cost;
                        }
                    }
                    /*System.out.println("");
                    System.out.println("Currentbestmove");
                    com.example.ongajong.tourismv3.debugprintjourney.print(bestmoves);

                    System.out.println("Cost: " +bestcost);
                    System.out.println("Time: " + besttime);
                    System.out.println("Branches: " + this.branches);*/
                }
                hold.clear();
            }
            /*System.out.println("");
            System.out.println("TRUEEND");
            com.example.ongajong.tourismv3.debugprintjourney.print(bestmoves);

            System.out.println("Cost: " +bestcost);
            System.out.println("Time: " + besttime);
            System.out.println("Branches: " + this.branches);*/
            return bestmoves;
        } //end of home com.example.ongajong.tourismv3.node.










        //beginning of end com.example.ongajong.tourismv3.node. i.e. we have visited all possible nodes!
        else if(journey.size()==this.master.size()){ //all possible nodes iterated!
            this.branches+=3;
            //System.out.println("Reached an end.");

            move secondlast = journey.getLast(); //get the last com.example.ongajong.tourismv3.move that was made to determine the location!
            node lastvisited = alllocations.get(secondlast.towards); //obtain the location you were at.
            move bus =lastvisited.possible.get(start.name).get(movetype.BUSTR); //obtain the bustrain com.example.ongajong.tourismv3.move to the start again
            move taxi =lastvisited.possible.get(start.name).get(movetype.TAXI); //obtain the taxi com.example.ongajong.tourismv3.move to the start again
            move foot =lastvisited.possible.get(start.name).get(movetype.FOOT); //obtain the foot com.example.ongajong.tourismv3.move to the start again


            journey.add(bus); //consider bus
            time = computetime.doo(journey); //get time
            cost = computecost.doo(journey); //get cost
            /*System.out.println("Cost: " +bestcost);
            System.out.println("Time: " + besttime);
            com.example.ongajong.tourismv3.debugprintjourney.print(journey);*/
            //com.example.ongajong.tourismv3.debugprintjourney.print(journey);
            if(cost<this.budget && time<besttime){
               // System.out.println("BUSBEST");
                //Bias towards lower time.
                //then consider if the cost is lower.
                if(time<besttime){
                    bestmoves.clear();
                    for(move aaa: journey){
                        bestmoves.add(aaa);
                    }
                    besttime = time;//if good, keep
                    bestcost= cost;
                }
                else {
                    if (cost<bestcost){
                        bestmoves.clear();
                        for(move aaa: journey){
                            bestmoves.add(aaa);
                        }
                        besttime = time;//if good, keep
                        bestcost= cost;
                    }
                }
            }

            journey.remove(bus);
            journey.add(taxi);
            time = computetime.doo(journey); //get time
            cost = computecost.doo(journey); //get cost
            /*com.example.ongajong.tourismv3.debugprintjourney.print(journey);
            System.out.println("Cost: " +bestcost);
            System.out.println("Time: " + besttime);*/
            if(cost<this.budget && time<besttime){

               // System.out.println("TAXIBEST");
                //Bias towards lower time.
                //then consider if the cost is lower.
                if(time<besttime){
                    bestmoves.clear();
                    for(move aaa: journey){
                        bestmoves.add(aaa);
                    }
                    besttime = time;//if good, keep
                    bestcost= cost;
                }
                else {
                    if (cost<bestcost){
                        bestmoves.clear();
                        for(move aaa: journey){
                            bestmoves.add(aaa);
                        }
                        besttime = time;//if good, keep
                        bestcost= cost;
                    }
                }
            }


            journey.remove(taxi);
            journey.add(foot);
            time = computetime.doo(journey); //get time
            cost = computecost.doo(journey); //get cost
            /*com.example.ongajong.tourismv3.debugprintjourney.print(journey);
            System.out.println("Cost: " +bestcost);
            System.out.println("Time: " + besttime);*/
            if(cost<this.budget && time<besttime){
                //Bias towards lower time.
                //then consider if the cost is lower.
                if(time<besttime){
                    bestmoves.clear();
                    for(move aaa: journey){
                        bestmoves.add(aaa);
                    }
                    besttime = time;//if good, keep
                    bestcost= cost;
                }
                else {
                    if (cost<bestcost){
                        bestmoves.clear();
                        for(move aaa: journey){
                            bestmoves.add(aaa);
                        }
                        besttime = time;//if good, keep
                        bestcost= cost;
                    }
                }
            }
            //all 3 moves considered, return the best!
            /*System.out.println("ONE POSSIBLE SET, AFTER CONSIDERING ALL 3 ENDING METHODS");
            com.example.ongajong.tourismv3.debugprintjourney.print(bestmoves);
            System.out.println("Cost: " +bestcost);
            System.out.println("Time: " + besttime);*/
            journey.removeLast(); //remove the last com.example.ongajong.tourismv3.move.
            return bestmoves;


        }







        //beginning of middling com.example.ongajong.tourismv3.node.
        else if(journey.size()>=1){
            //System.out.println("Middle stage");
            //for all possible nodes not in the current journey, iterate in.
            LinkedList<node> placestogo = hasbeento.to(this.alllocations,journey); //obtain the places we have yet to go to.
            destina lastplace = journey.getLast().towards; //the last place he was at.
            node lastplacenode = this.alllocations.get(lastplace); //get that com.example.ongajong.tourismv3.node.
            /*for(com.example.ongajong.tourismv3.node target: placestogo){
                System.out.print(target.name +" ");
            }
            System.out.println(" -DESTINATIONS TO BE REACHED");*/
            for(node targets: placestogo){
                /*System.out.println(targets.name +" CURRENT FOCUS ");
                for(com.example.ongajong.tourismv3.move asdd:journey){
                    System.out.print(asdd.towards+" ");
                }
                //System.out.println(" -JOURNEY THUS FAR");*/
                //System.out.println("Considers one.");
                move bus = lastplacenode.possible.get(targets.name).get(movetype.BUSTR); //get the movetype bus train to location
                move foot = lastplacenode.possible.get(targets.name).get(movetype.FOOT); //get the movetype foot to location
                move taxi = lastplacenode.possible.get(targets.name).get(movetype.TAXI); //get the movetype taxi to location
                journey.add(bus);
                //System.out.println(journey.size() + " " + master.size());
                hold = recur(journey);
               // com.example.ongajong.tourismv3.debugprintjourney.print(journey);
                time = computetime.doo(hold); //get time
                cost = computecost.doo(hold); //get cost
                if(hold.size() ==0){ cost =this.budget+1.00;}
                if(cost<this.budget && time<besttime){

                    //Bias towards lower time.
                    //then consider if the cost is lower.
                    if(time<besttime){
                        bestmoves.clear();
                        for(move aaa: hold){
                            bestmoves.add(aaa);
                        }
                        besttime = time;//if good, keep
                        bestcost= cost;
                    }
                    else {
                        if (cost<bestcost){
                            bestmoves.clear();
                            for(move aaa: hold){
                                bestmoves.add(aaa);
                            }
                            besttime = time;//if good, keep
                            bestcost= cost;
                        }
                    }
                }
                journey.removeLast(); //remove original added at this stage.
                journey.add(taxi);  //com.example.ongajong.tourismv3.move to next type.

                //System.out.println("Considers second.");
                //System.out.println(journey.size() + " " + master.size());
                hold = recur(journey);
                time = computetime.doo(hold); //get time
                cost = computecost.doo(hold); //get cost
                if(hold.size() ==0){ cost =this.budget+1.00;}
                if(cost<this.budget && time<besttime){

                    //Bias towards lower time.
                    //then consider if the cost is lower.
                    if(time<besttime){
                        bestmoves.clear();
                        for(move aaa: hold){
                            bestmoves.add(aaa);
                        }
                        besttime = time;//if good, keep
                        bestcost= cost;
                    }
                    else {
                        if (cost<bestcost){
                            bestmoves.clear();
                            for(move aaa: hold){
                                bestmoves.add(aaa);
                            }
                            besttime = time;//if good, keep
                            bestcost= cost;
                        }
                    }
                }

                journey.removeLast();
                //System.out.println("Considers third.");
                journey.add(foot); //com.example.ongajong.tourismv3.move to next type.
                //System.out.println(journey.size() + " " + master.size());
                hold = recur(journey); //recur
                //com.example.ongajong.tourismv3.debugprintjourney.print(journey);
                //System.out.println("");
                time = computetime.doo(hold); //get time
                cost = computecost.doo(hold); //get cost
                if(hold.size() ==0){ cost =this.budget+1.00;}
                if(cost<this.budget && time<besttime){

                    //Bias towards lower time.
                    //then consider if the cost is lower.
                    if(time<besttime){
                        bestmoves.clear();
                        for(move aaa: hold){
                            bestmoves.add(aaa);
                        }
                        besttime = time;//if good, keep
                        bestcost= cost;
                    }
                    else {
                        if (cost<bestcost){
                            bestmoves.clear();
                            for(move aaa: hold){
                                bestmoves.add(aaa);
                            }
                            besttime = time;//if good, keep
                            bestcost= cost;
                        }
                    }
                }
                journey.removeLast();
                //System.out.println("");
                //System.out.println("Middle returns a possible of all 3");
                //com.example.ongajong.tourismv3.debugprintjourney.print(bestmoves);
                //System.out.println("Cost: " +bestcost);
                //System.out.println("Time: " + besttime);
                //System.out.println("backup1");
            }
            return bestmoves;
        }

        return bestmoves;//redundant return to prevent compile error
    }
}
