package com.example.rubenvel.ligaaguila.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rubenvel.ligaaguila.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoriaFragment extends Fragment {

    public static HistoriaFragment instace(){return new HistoriaFragment();}

    public HistoriaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_historia, container, false);
    }

}
