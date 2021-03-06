package com.example.ongajong.tourismv3;

/**
 * Created by ongajong on 27/11/2017.
 */
import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class TravelFrag extends Fragment {
    CheckBox MarinaBaySands,SingaporeFlyer,VivoCity,ResortsWorldSentosa,Zoo,BuddhaToothRelicTemple;
    Button btn_fast,btn_slow;
    LinkedList<String> locations = new LinkedList<>();
    TextView itinery;
    EditText budget;
    AssetManager assetMan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview =  inflater.inflate(R.layout.tab_fragment_4, container, false);
        SingaporeFlyer = rootview.findViewById(R.id.checkBoxFlyer);
        VivoCity = rootview.findViewById(R.id.checkBoxVivocity);
        ResortsWorldSentosa = rootview.findViewById(R.id.checkBoxSentosa);
        Zoo = rootview.findViewById(R.id.checkBoxZoo);
        BuddhaToothRelicTemple = rootview.findViewById(R.id.checkBoxBuddha);
        itinery = rootview.findViewById(R.id.itinery);
        btn_fast = rootview.findViewById(R.id.btn_FastSearch);
        btn_slow = rootview.findViewById(R.id.btn_SlowSearch);
        budget = rootview.findViewById(R.id.Budget);


        btn_fast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int fare = 0;
                StringBuilder result = new StringBuilder();
                Double newBudget = Double.parseDouble(budget.getText().toString());
                locations.clear();
                result.append("SelectedItems:");
                if (SingaporeFlyer.isChecked()){
                    result.append("\n Singapore Flyer Added");
                    locations.add("SingaporeFlyer");
                }if (VivoCity.isChecked()){
                    result.append("\n VivoCity");
                    locations.add("VivoCity");
                }if (ResortsWorldSentosa.isChecked()){
                    result.append("\n RWS");
                    locations.add("ResortsWorldSentosa");
                }if (Zoo.isChecked()){
                    result.append("\n Zoo");
                    locations.add("Zoo");
                }if (BuddhaToothRelicTemple.isChecked()){
                    result.append("\n Buddha");
                    locations.add("BuddhaToothRelicTemple");
                }
                if (locations.isEmpty()){
                    Toast.makeText(getActivity(),"No location selected", Toast.LENGTH_LONG).show();
                }
                //Display on Toast
                //Toast.makeText(getActivity(),result.toString(),Toast.LENGTH_LONG).show();
                else{LinkedList<Object> ans = trialrun.fast(locations,newBudget);
                String total = ans.get(1).toString();
                String total1 = ans.get(2).toString();
                String total2 = ans.get(0).toString();
                itinery.setText("$" +total+" Time: " +total1+ " min Route: "+total2);}


            }
        });
        btn_slow.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                int fare = 0;
                locations.clear();
                StringBuilder result = new StringBuilder();
                Double newBudget = Double.parseDouble(budget.getText().toString());
                result.append("SelectedItems:");
                if (SingaporeFlyer.isChecked()){
                    result.append("\n Singapore Flyer Added");
                    locations.add("SingaporeFlyer");
                }if (VivoCity.isChecked()){
                    result.append("\n VivoCity");
                    locations.add("VivoCity");
                }if (ResortsWorldSentosa.isChecked()){
                    result.append("\n RWS");
                    locations.add("ResortsWorldSentosa");
                }if (Zoo.isChecked()){
                    result.append("\n Zoo");
                    locations.add("Zoo");
                }if (BuddhaToothRelicTemple.isChecked()){
                    result.append("\n Buddha");
                    locations.add("BuddhaToothRelicTemple");
                }
                result.append("\n Slow Total: "+ fare);
                if (locations.isEmpty()){
                    Toast.makeText(getActivity(),"No location selected", Toast.LENGTH_LONG).show();
                }
                //Display on Toast
                //Toast.makeText(getActivity(),result.toString(),Toast.LENGTH_LONG).show();
                else{LinkedList<Object> ans = trialrun.brute(locations,newBudget);
                String total = String.format("%.2f",ans.get(1));
                String total1 = ans.get(2).toString();
                String total2 = ans.get(0).toString();
                itinery.setText("$" +total+" Time: " +total1+ " min Route: "+total2);}


            }
        });
        return rootview;
    }
}