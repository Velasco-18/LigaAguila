package com.example.rubenvel.ligaaguila.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rubenvel.ligaaguila.R;
import com.example.rubenvel.ligaaguila.adapters.PosicionesAdapter;
import com.example.rubenvel.ligaaguila.databinding.FragmentPosicionesBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class PosicionesFragment extends Fragment {

    public static PosicionesFragment instace(){return new PosicionesFragment();}

    public PosicionesFragment() {
        // Required empty public constructor
    }

    FragmentPosicionesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_posiciones, container, false);
        //binding.
        return binding.getRoot();
    }

}
