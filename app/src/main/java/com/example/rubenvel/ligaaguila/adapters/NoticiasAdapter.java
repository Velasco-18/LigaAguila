package com.example.rubenvel.ligaaguila.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rubenvel.ligaaguila.R;
import com.example.rubenvel.ligaaguila.databinding.TemplateNoticiaBinding;
import com.example.rubenvel.ligaaguila.models.Noticia;

import java.util.List;

/**
 * Created by rubev on 19/05/2017.
 */

public class NoticiasAdapter  extends RecyclerView.Adapter<NoticiasAdapter.NoticiaHolder>{

    public interface OnNoticiaSelected{
        void onNoticia(int position);
    }

    LayoutInflater inflater;
    List<Noticia> data;
    OnNoticiaSelected onNoticiaSelected;

    public NoticiasAdapter(LayoutInflater inflater, List<Noticia> data, OnNoticiaSelected onNoticiaSelected) {
        this.inflater = inflater;
        this.data = data;
        this.onNoticiaSelected = onNoticiaSelected;
    }

    //Se crea el viewHolder
    @Override
    public NoticiaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_noticia, parent, false);
        return new NoticiaHolder(v);
    }
    //Se enlaza el viewHolder - Cuando se ponen datos
    @Override
    public void onBindViewHolder(NoticiaHolder holder, int position) {
        Noticia n = data.get(position);
        holder.binding.setNoticia(n);
        holder.binding.getRoot().setTag(position);
        holder.binding.setHandler(this);
    }
    //Retorna el tamaño
    @Override
    public int getItemCount() {
        return data.size();
    }

    public void onClick(View view){
        int pos = (int) view.getTag();
        onNoticiaSelected.onNoticia(pos);
    }
    //region ViewHolder
    static class NoticiaHolder extends RecyclerView.ViewHolder{
        //Acceso al view
        TemplateNoticiaBinding binding;

        public NoticiaHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
    //endregion

}
