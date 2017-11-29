package com.example.ongajong.tourismv3.Kwik;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

// a module to com.example.ongajong.tourismv3.Kwik.move through a file and keep adding to types.
//creates a com.example.ongajong.tourismv3.Kwik.node module at the end.
public class iteratetoadd {
    public static node add(String attraction){
        //AssetManager am = context.getAssets();   FOR ANDROID
        //InputStream is = am.open("test.txt");   FOR ANDROID
        String path ="C:/Users/User/Desktop/place/"+attraction+".txt"; //tourist attraction name.txt is the database.
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
                destina here = destinadeterminant.see(Splitup[0]); //to which destination?
                //com.example.ongajong.tourismv3.Kwik.move(destina destination, Double cost, movetype what, int time)
                foot = new move(here,null, movetype.FOOT, Integer.parseInt(Splitup[1]));
                taxi = new move(here,Double.parseDouble(Splitup[2]), movetype.TAXI, Integer.parseInt(Splitup[3]));
                bus = new move(here,Double.parseDouble(Splitup[4]), movetype.BUSTR, Integer.parseInt(Splitup[5]));
                //public void addmoves(com.example.ongajong.tourismv3.Kwik.move foot, com.example.ongajong.tourismv3.Kwik.move taxi, com.example.ongajong.tourismv3.Kwik.move trainy, destina where)
                a.addmoves(foot,taxi,bus,here);
            }
            //while loop will add till the end of file.

        }
        catch(java.io.FileNotFoundException ex) {
            System.out.println("INVALID FILE");
        }
        catch(java.io.IOException ex){
            System.out.println("INPUT WITHIN FILE INVALID.");
        }
    return a;
    }
}
