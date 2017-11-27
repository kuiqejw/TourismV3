package com.example.ongajong.tourismv3.Recycler;

/**
 * Created by ongajong on 27/11/2017.
 */

public class Album {
    private String travelRoute;
    private String travelCost;
    private String travelTime;
    private int travelIcon;


    public int getTravelIcon(){
        return travelIcon;
    }
    public String getTravelRoute(){
        return travelRoute;
    }
    public void setTravelRoute(){
        this.travelRoute = travelRoute;
    }
    public String getTravelTime(){
        return travelTime;
    }
    public void setTravelTime(){
        this.travelTime= travelTime;
    }
    public String getTravelCost(){
        return travelCost;
    }
    public void setTravelCost(){
        this.travelCost= travelCost;
    }
}
