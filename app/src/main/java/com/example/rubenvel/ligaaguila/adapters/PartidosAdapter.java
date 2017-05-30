package com.example.rubenvel.ligaaguila.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rubenvel.ligaaguila.R;
import com.example.rubenvel.ligaaguila.databinding.TemplatePartidoBinding;
import com.example.rubenvel.ligaaguila.models.Partido;
import com.example.rubenvel.ligaaguila.util.NoticiaData;
import com.example.rubenvel.ligaaguila.util.PartidoData;

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
    View.OnClickListener onClickListener;

    public PartidosAdapter(LayoutInflater inflater, List<Partido> dataP, View.OnClickListener onClickListener){
        this.inflater = inflater;
        this.dataP = dataP;
        this.onClickListener = onClickListener;
    }
    //Se crea el viewHolder
    @Override
    public PartidoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_partido, parent, false);
        PartidoHolder holder = new PartidoHolder(v);
        return holder;
    }
    //Se enlaza el viewHolder - Cuando se ponen datos
    @Override
    public void onBindViewHolder(PartidoHolder holder, int position) {

        holder.binding.setPartido(PartidoData.getDataPartido().get(position));
        holder.binding.setHandler(this);
        //Eventos
        holder.setOnClickListeners();
    }
    //Retorna el tamaño
    @Override
    public int getItemCount() {
        return dataP.size();
    }

    //public void onClick(View view){
    //    int pos = (int) view.getTag();
    //    onPartidoSelected.onPartido(pos);
    //}

    //region ViewHolder
    public static class PartidoHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //Este ViewHolder es la clase que da acceso a los views del template
        TemplatePartidoBinding binding;

        Context context;

        public PartidoHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();

            binding = DataBindingUtil.bind(itemView);
        }

        void setOnClickListeners(){
            binding.cardPartido.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = 0;

           // Intent intent = new Intent(context, NoticiaContentActivity.class);
           // intent.putExtra(NoticiaContentActivity.POS_EXTRA, pos);
           // context.startActivity(intent);
        }
    }
    //endregion
}
