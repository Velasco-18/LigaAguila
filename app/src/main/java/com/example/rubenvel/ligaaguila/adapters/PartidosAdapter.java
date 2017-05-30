package com.example.rubenvel.ligaaguila.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rubenvel.ligaaguila.R;
import com.example.rubenvel.ligaaguila.databinding.TemplatePartidoBinding;
import com.example.rubenvel.ligaaguila.models.Partido;

import java.util.List;

/**
 * Created by rubev on 25/05/2017.
 */

public class PartidosAdapter extends RecyclerView.Adapter<PartidosAdapter.PartidoHolder>{

    public interface OnPartidoSelected{
        void onPartido(int position);
    }

    LayoutInflater inflater;
    List<Partido> dataP;
    OnPartidoSelected onPartidoSelected;

    public PartidosAdapter(LayoutInflater inflater, List<Partido> dataP, OnPartidoSelected onPartidoSelected){
        this.inflater = inflater;
        this.dataP = dataP;
        this.onPartidoSelected = onPartidoSelected;
    }
    //Se crea el viewHolder
    @Override
    public PartidosAdapter.PartidoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_partido, parent, false);
        return new PartidoHolder(v);
    }
    //Se enlaza el viewHolder - Cuando se ponen datos
    @Override
    public void onBindViewHolder(PartidoHolder holder, int position) {
        Partido p = dataP.get(position);
        holder.binding.setPartido(p);
        holder.binding.getRoot().setTag(position);
        holder.binding.setHandler(this);
    }
    //Retorna el tamaño
    @Override
    public int getItemCount() {
        return dataP.size();
    }

    public void onClick(View view){
        int pos = (int) view.getTag();
        onPartidoSelected.onPartido(pos);
    }

    //region ViewHolder
    public static class PartidoHolder extends RecyclerView.ViewHolder{
        //Este ViewHolder es la clase que da acceso a los views del template
        TemplatePartidoBinding binding;

        public PartidoHolder(View itemView) {
            super(itemView);

            binding = DataBindingUtil.bind(itemView);
        }
    }
    //endregion
}
