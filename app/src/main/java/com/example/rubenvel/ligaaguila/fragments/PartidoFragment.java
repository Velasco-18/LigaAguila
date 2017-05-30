package com.example.rubenvel.ligaaguila.fragments;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rubenvel.ligaaguila.R;
import com.example.rubenvel.ligaaguila.adapters.PartidosAdapter;
import com.example.rubenvel.ligaaguila.databinding.FragmentPartidoBinding;
import com.example.rubenvel.ligaaguila.util.PartidoData;

/**
 * A simple {@link Fragment} subclass.
 */
public class PartidoFragment extends Fragment implements View.OnClickListener{

    public static PartidoFragment instace(){return new PartidoFragment();}

    public interface OnItemClick{
        void onClick(int pos);
    }


    public PartidoFragment() {
        // Required empty public constructor
    }

    FragmentPartidoBinding binding;
    PartidosAdapter adapter;
    OnItemClick onItemClick;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_partido, container, false);

        adapter = new PartidosAdapter(getLayoutInflater(null), PartidoData.getDataPartido(), this);
        binding.partidoList.setAdapter(adapter); //Posicion Recycler
        binding.partidoList.setLayoutManager(new LinearLayoutManager(getActivity())); //Organizar elementos en pantalla

        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {

        //int pos = binding.partidoList.getChildAdapterPosition(v);
        //onItemClick.onClick(pos);

        //Intent intent = new Intent(getContext(), PartidosAdapter.class);
        //intent.putExtra("posicion", pos);
        //startActivity(intent);

    }

}
