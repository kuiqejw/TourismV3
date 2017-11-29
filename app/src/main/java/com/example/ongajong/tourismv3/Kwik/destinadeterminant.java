package com.example.ongajong.tourismv3.Kwik;

public class destinadeterminant {
    public static destina see(String s){
        if(s.equals("MarinaBaySands")){
            return destina.MarinaBaySands;
        }
        if(s.equals("SingaporeFlyer")){
            return destina.SingaporeFlyer;
        }
        if(s.equals("VivoCity")){
            return destina.VivoCity;
        }
        if(s.equals("ResortsWorldSentosa")){
            return destina.ResortsWorldSentosa;
        }
        if(s.equals("Zoo")){
            return destina.Zoo;
        }
        if(s.equals("BuddhaToothRelicTemple")){
            return destina.BuddhaToothRelicTemple;
        }
        return null;



    }
}
