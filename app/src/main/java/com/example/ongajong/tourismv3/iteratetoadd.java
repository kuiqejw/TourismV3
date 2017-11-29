package com.example.ongajong.tourismv3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/**
 * FOR REFERENCE:
 * a --> MBS
 * b --> Singapore Flyer
 * c --> VivoCity
 * d --> Resorts World Sentosa
 * e --> Buddha Tooth Relic Temple
 * f --> Singapore Zoo/ Zoo
 * e.g. from A to B = {destination, foottime, taxicost,taxitime,buscost,bustime}
 *
 * These travel times and costs are referenced from gothere.sg and Google Maps Directions tool.
 */

// a module to com.example.ongajong.tourismv3.move through a file and keep adding to types.
//creates a com.example.ongajong.tourismv3.node module at the end.
public class iteratetoadd {
    //mbs
    static String[] ab  = {"SingaporeFlyer 14 3.22 3 0.83 17"};
    static String[] ac = {"VivoCity 69  6.96 14 1.18 26"};
    static String[] ad = {"ResortsWorldSentosa 76 8.50 19 4.03 35"};
    static String[] ae = {"BuddhaToothRelicTemple 28 4.98 8 0.88 19"};
    static String[] af = {"Zoo 269 18.40 30 1.96 84"};
    static String [][] a = {ab,ac,ad,ae,af};
    //flyer
    static String[] ba = {"MarinaBaySands 14 4.32 6 0.83 17"};
    static String[] bc = {"VivoCity 81 7.84 13 1.26 31"};
    static String[] bd = {"ResortsWorldSentosa 88 9.38 18 4.03 38"};
    static String[] be = {"BuddhaToothRelicTemple 39 4.76 8 0.98 24"};
    static String[] bf = {"Zoo 264 18.18 29 1.89 85"};
    static String [][] b = {ba,bc,bd,be,bf};
    //vivocity
    static String[] ca = {"MarinaBaySands 69 8.30 12 1.18 24"};
    static String[] cb = {"SingaporeFlyer 81 7.96 14 1.26 29"};
    static String[] cd = {"ResortsWorldSentosa 12 4.54 9 2.00 10"};
    static String[] ce = {"BuddhaToothRelicTemple 47 6.42 11 0.98 18"};
    static String[] cf = {"Zoo 270 22.58 31 1.99 85"};
    static String[][] c = {ca,cb,cd,ce,cf};
    //RWS
    static String[] da = {"MarinaBaySands 76 8.74 13 1.18 33"};
    static String[] db = {"SingaporeFlyer 88 8.40 14 1.26 38"};
    static String[] dc = {"VivoCity 12 3.22 4 0.0 10"};
    static String[] de = {"BuddhaToothRelicTemple 55 6.64 12 0.98 27"};
    static String[] df = {"Zoo 285 22.8 32 1.99 92"};
    static String[][] d = {da,db,dc,de,df};
    //Buddha
    static String[] ea = {"MarinaBaySands 28 5.32 7 0.88 18"};
    static String[] eb = {"SingaporeFlyer 39 4.76 8 0.98 23"};
    static String[] ec = {"VivoCity 47  4.98 9 0.98 19"};
    static String[] ed = {"ResortsWorldSentosa 55 6.52 14 3.98 28"};
    static String[] ef = {"Zoo 264 18.40 30 1.91 83"};
    static String[][] e = {ea,eb,ec,ed,ef};
    //zoo
    static String[] fa = {"MarinaBaySands 269 22.48 32 1.88 86"};
    static String[] fb = {"SingaporeFlyer 264 19.40 29 1.96 87"};
    static String[] fc = {"VivoCity 270 21.48 32 2.11 86"};
    static String[] fd = {"ResortsWorldSentosa 285 23.68 36 4.99 96"};
    static String[] fe = {"BuddhaToothRelicTemple 264 21.60 30 1.91 84"};
    static String[][] f = {fa,fb,fc,fd,fe};


    public static node add(String attraction){

        destina name = destinadeterminant.see(attraction);
        move foot;
        move taxi;
        move bus;
        String[][] temp = new String[5][1];
        node start = new node(name);
        if (attraction == "MarinaBaySands"){
            temp = a;
        }
        else if (attraction == "SingaporeFlyer"){
            temp = b;
        }else if (attraction == "VivoCity"){
            temp = c;
        }else if (attraction == "ResortsWorldSentosa"){
            temp = d;
        }else if (attraction == "BuddhaToothRelicTemple"){
            temp = e;
        }else{
            temp = f;
        }

        /*switch (attraction){
            case("MarinaBaySands"):
                temp = a;
            case("SingaporeFlyer"):
                temp = b;
            case("Vivocity"):
                temp = c;
            case("ResortsWorldSentosa"):
                temp = d;
            case("BuddhaToothRelicTemple"):
                temp = e;
            case("Zoo"):
                temp = f;
            }*/
        int i = 0;
        while (i<temp.length){
            String[] Splitup = temp[i][0].split("\\s+");
            destina here = destinadeterminant.see(Splitup[0]);
            //com.example.ongajong.tourismv3.move(destina destination, Double cost, movetype what, int time)
            foot = new move(here,null, movetype.FOOT, Integer.parseInt(Splitup[1]));
            taxi = new move(here,Double.parseDouble(Splitup[2]), movetype.TAXI, Integer.parseInt(Splitup[3]));
            bus = new move(here,Double.parseDouble(Splitup[4]), movetype.BUSTR, Integer.parseInt(Splitup[5]));
            start.addmoves(foot,taxi,bus,here);
            i++;
        }
        /*
        //AssetManager am = context.getAssets();   FOR ANDROID
        //InputStream is = am.open("test.txt");   FOR ANDROID
        //C:/Users/ongajong/AndroidStudioProjects/TourismV3/app/src/main/assets/newplace/
        String path = attraction+".txt"; //tourist attraction name.txt is the database.
        File f = new File(path);
        destina name  = destinadeterminant.see(attraction); //obtain name of destination in consideration
        move foot;
        move taxi;
        move bus;
        node a = new node(name);
        try {
            String[] Splitup;
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String View;
            while ((View =reader.readLine())!= null) {
                Splitup = View.split("\\s+"); //split by spaces.   format = destination 0, foottime 1, taxicost 2, taxitime 3, buscost 4, bustime 5
                //todo input a string to it.
                destina here = destinadeterminant.see(Splitup[0]); //to which destination?
                //com.example.ongajong.tourismv3.move(destina destination, Double cost, movetype what, int time)
                foot = new move(here,null, movetype.FOOT, Integer.parseInt(Splitup[1]));
                taxi = new move(here,Double.parseDouble(Splitup[2]), movetype.TAXI, Integer.parseInt(Splitup[3]));
                bus = new move(here,Double.parseDouble(Splitup[4]), movetype.BUSTR, Integer.parseInt(Splitup[5]));
                //public void addmoves(com.example.ongajong.tourismv3.move foot, com.example.ongajong.tourismv3.move taxi, com.example.ongajong.tourismv3.move trainy, destina where)
                a.addmoves(foot,taxi,bus,here);
            }
            //while loop will add till the end of file.

        }
        catch(java.io.FileNotFoundException ex) {
            System.out.println("INVALID FILE");
        }
        catch(java.io.IOException ex){
            System.out.println("INPUT WITHIN FILE INVALID.");
        }*/
    return start;
    }
}
