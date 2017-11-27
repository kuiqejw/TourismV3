package com.example.ongajong.tourismv3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ongajong.tourismv3.Recycler.RecyclerViewActivity;

/**
 * Created by ongajong on 27/11/2017.
 */

public class AttractionFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_fragment_2, container, false);
        Intent intent = new Intent(getActivity(), RecyclerViewActivity.class);
        startActivity(intent);
        return v;
    }
}