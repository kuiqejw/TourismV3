package com.example.ongajong.tourismv3;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ongajong on 27/11/2017.
 */

public class AttractionFrag extends Fragment {

    List<Album> destinations;
    RecyclerView rv;

    public AttractionFrag(){}

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.tab_fragment_4, container, false);
        rv = rootView.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        initializeData();
        initializeAdapter();

        final LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return rootView;
    }
    public void initializeData() {
        destinations = new ArrayList<>();
        destinations.add(new Album("Botanic Gardens", R.drawable.botanicgardens));
        destinations.add(new Album("Gardens By the bay", R.drawable.gardensbybay));
        destinations.add(new Album("Marina Bay Sands", R.drawable.mbs));
        destinations.add(new Album("National Orchid Garden", R.drawable.nationalorchid));
        destinations.add(new Album("Universal Studios Singapore", R.drawable.sentosa));
        destinations.add(new Album("Singapore Flyer", R.drawable.singaporeflyer));
        destinations.add(new Album("Singapore Zoo", R.drawable.zoo4));
        destinations.add(new Album("Buddha Tooth Relic Temple", R.drawable.buddhatemple));
    }
    public void initializeAdapter(){
        MyAdapter adapter = new MyAdapter((ArrayList<Album>) destinations);
        rv.setAdapter(adapter);
    }
}


