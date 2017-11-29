package com.example.ongajong.tourismv3;

/**
 * Created by ongajong on 27/11/2017.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class TravelFrag extends Fragment {
    CheckBox MarinaBaySands,SingaporeFlyer,Vivocity,ResortsWorldSentosa,Zoo,BuddhaToothRelicTemple;
    Button btn_fast,btn_slow;
    LinkedList<String> locations = new LinkedList<>();
    TextView itinery;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview =  inflater.inflate(R.layout.tab_fragment_4, container, false);
        SingaporeFlyer = rootview.findViewById(R.id.checkBoxFlyer);
        Vivocity = rootview.findViewById(R.id.checkBoxVivocity);
        ResortsWorldSentosa = rootview.findViewById(R.id.checkBoxSentosa);
        Zoo = rootview.findViewById(R.id.checkBoxZoo);
        BuddhaToothRelicTemple = rootview.findViewById(R.id.checkBoxBuddha);
        itinery = rootview.findViewById(R.id.itinery);
        btn_fast = rootview.findViewById(R.id.btn_FastSearch);
        btn_slow = rootview.findViewById(R.id.btn_SlowSearch);


        btn_fast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int fare = 0;
                StringBuilder result = new StringBuilder();
                result.append("SelectedItems:");
                if (SingaporeFlyer.isChecked()){
                    result.append("\n Singapore Flyer Added");
                    locations.add("SingaporeFlyer");
                }if (Vivocity.isChecked()){
                    result.append("\n Vivocity");
                    locations.add("Vivocity");
                }if (ResortsWorldSentosa.isChecked()){
                    result.append("\n RWS");
                    locations.add("ResortsWorldSentosa");
                }if (Zoo.isChecked()){
                    result.append("\n Zoo");
                    locations.add("Zoo");
                }if (BuddhaToothRelicTemple.isChecked()){
                    result.append("\n Buddha");
                    locations.add("Buddha Tooth Relic Temple");
                }
                result.append("\n Fast Total: "+ fare);
                //Display on Toast
                Toast.makeText(getActivity(),result.toString(),Toast.LENGTH_LONG).show();
                itinery.setText(result);

            }
        });
        btn_slow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int fare = 0;
                StringBuilder result = new StringBuilder();
                result.append("SelectedItems:");
                if (SingaporeFlyer.isChecked()){
                    result.append("\n Singapore Flyer Added");
                    locations.add("SingaporeFlyer");
                }if (Vivocity.isChecked()){
                    result.append("\n Vivocity");
                    locations.add("Vivocity");
                }if (ResortsWorldSentosa.isChecked()){
                    result.append("\n RWS");
                    locations.add("ResortsWorldSentosa");
                }if (Zoo.isChecked()){
                    result.append("\n Zoo");
                    locations.add("Zoo");
                }if (BuddhaToothRelicTemple.isChecked()){
                    result.append("\n Buddha");
                    locations.add("Buddha Tooth Relic Temple");
                }
                result.append("\n Slow Total: "+ fare);
                //Display on Toast
                Toast.makeText(getActivity(),result.toString(),Toast.LENGTH_LONG).show();
                itinery.setText(result);


            }
        });
        return rootview;
    }
}