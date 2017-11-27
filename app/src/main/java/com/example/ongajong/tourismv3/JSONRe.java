/*
package com.example.ongajong.tourismv3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;



public class JSONRe extends AppCompatActivity {

    AnimeJsonData[] animeJsonData;
    private RecyclerView animeList;
    private AnimeAdaptor mAnimeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 3 - read the saved json file and parse it (see the TODOs below)
        parseJson();


        //TODO 4.9 get a reference to the recycler view widget
        //TODO 4.10 create an instance of LinearLayoutManager and
        //          assign it to the recycler view object
        //TODO 4.11 create an instance of the Adapter and
        //          assign it to the recycler view object

    }

    //TODO 3.1 Create an inner class matching the keys of the JSON array
    public class AnimeJsonData{

        String name;
        String anime;
        String file;
        //complete the rest

    }

    private String readTxt(int resource){
        String line;
        String output = "";
        InputStream inputStream = getResources().openRawResource(resource);
        //TODO 3.2 Complete readTxt to take in a resource ID of a file,
        //          read it and return it as a single string
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while((line = reader.readLine())!= null){

            }}
            catch (Exception e){
                e.printStackTrace();
            }
            return output;
        }




    void parseJson(){

        Gson gson = new Gson();
        //TODO 3.3 Invoke readTxt
        String jsonData = readTxt(R.raw.pictures)
        //TODO 3.4 parse the JSON file
        animeJsonData = gson.fromJson(jsonData,AnimeJsonData[].class);

    }
}
*/
