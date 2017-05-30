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
import com.example.rubenvel.ligaaguila.adapters.NoticiasAdapter;
import com.example.rubenvel.ligaaguila.databinding.FragmentNoticiasBinding;
import com.example.rubenvel.ligaaguila.util.NoticiaData;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoticiasFragment extends Fragment implements View.OnClickListener{

    public static NoticiasFragment instace(){return new NoticiasFragment();}

    public interface OnItemClick{
        void onClick(int pos);
    }

    FragmentNoticiasBinding binding;
    NoticiasAdapter adapter;
    OnItemClick onItemClick;

    public NoticiasFragment() {
        // Required empty public constructor
    }

    /*@Override
       public void onAttach(Context context) {
       super.onAttach(context);
       onItemClick = (OnItemClick) context;
    //}*/

    //@Override
    //public void onAttachFragment(Fragment childFragment) {
     //   super.onAttachFragment(childFragment);
     //   onItemClick = (OnItemClick) childFragment;
   // }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_noticias, container, false);

        adapter = new NoticiasAdapter(NoticiaData.getDataNoticia(),getLayoutInflater(null), this);
        binding.noticiasList.setAdapter(adapter);//Posicion del RecyclerView
        binding.noticiasList.setLayoutManager(new LinearLayoutManager(getActivity())); //Organizar elementos en pantalla

        //cargarDatos();

        return binding.getRoot();
    }

    public void notifyDataSet(){
        if(adapter != null)
            adapter.notifyDataSetChanged();
    }

    //@Override
    //public void onNoticia(int position) {

        //int pos = binding.noticiasList.getChildAdapterPosition(position);

    //    Intent intent = new Intent(getContext(), NoticiaContentActivity.class);
    //    intent.putExtra(NoticiaContentActivity.POS_EXTRA, position);
    //    startActivity(intent);
   // }
//////////////////////////////////////////
    //@Override
    public void onClick(View v) {
       int pos = binding.noticiasList.getChildAdapterPosition(v);
        onItemClick.onClick(pos);

        Intent intent = new Intent(getContext(), NoticiasAdapter.class);
        intent.putExtra("posicion", pos);
        startActivity(intent);
    }
}
