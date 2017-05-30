package com.example.rubenvel.ligaaguila.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rubenvel.ligaaguila.R;
import com.example.rubenvel.ligaaguila.content.NoticiaContentActivity;
import com.example.rubenvel.ligaaguila.databinding.TemplateNoticiaBinding;
import com.example.rubenvel.ligaaguila.models.Noticia;
import com.example.rubenvel.ligaaguila.util.NoticiaData;

import java.util.List;

/**
 * Created by rubev on 19/05/2017.
 */

public class NoticiasAdapter  extends RecyclerView.Adapter<NoticiasAdapter.NoticiaHolder>{

    public interface OnNoticiaSelected{
        void onNoticia(int position);
    }

    LayoutInflater inflater;
    OnNoticiaSelected onNoticiaSelected;
    View.OnClickListener onClickListener;
    List<Noticia> data;

    //public NoticiasAdapter(LayoutInflater layoutInflater, NoticiasFragment noticiasFragment) {
    //    this.inflater = layoutInflater;
    //    this.onNoticiaSelected = noticiasFragment;
    //}

    public NoticiasAdapter(List<Noticia> data, LayoutInflater inflater, View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.data = data;
        this.inflater = inflater;
    }


   // public NoticiasAdapter(LayoutInflater inflater, List<Noticia> dataN, OnNoticiaSelected onNoticiaSelected) {
    //    this.inflater = inflater;
     //   this.data = dataN;
     //   this.onNoticiaSelected = onNoticiaSelected;
    //}

    //Se crea el viewHolder
    @Override
    public NoticiaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_noticia, parent, false);
        NoticiaHolder holder = new NoticiaHolder(v);
        return holder;
    }
    //Se enlaza el viewHolder - Cuando se ponen datos
    @Override
    public void onBindViewHolder(NoticiaHolder holder, int position) {

        holder.binding.setNoticia(NoticiaData.getDataNoticia().get(position));
        holder.binding.setHandler(this);

        //Eventos
        holder.setOnClickListeners();
    }
    //Retorna el tamaño
    @Override
    public int getItemCount() {
        return NoticiaData.getDataNoticia().size();
    }

    //public void onClick(View v){
    //    int pos = (int) v.getTag();
    //    onNoticiaSelected.onNoticia(pos);
    //}
    //region ViewHolder
    public static class NoticiaHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //Este ViewHolder es la clase que da acceso a los views del template
        TemplateNoticiaBinding binding;

        Context context;


        public NoticiaHolder(View itemView) {
            super(itemView);
            binding = TemplateNoticiaBinding.bind(itemView);
            context = itemView.getContext();
        }

        void setOnClickListeners(){
            binding.card.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            int pos = 0;

        Intent intent = new Intent(context, NoticiaContentActivity.class);
            intent.putExtra(NoticiaContentActivity.POS_EXTRA, pos);
            context.startActivity(intent);
        }
    }
    //endregion
}
