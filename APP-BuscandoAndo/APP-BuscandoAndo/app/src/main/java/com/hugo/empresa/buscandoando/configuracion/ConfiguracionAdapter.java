package com.hugo.empresa.buscandoando.configuracion;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hugo.empresa.buscandoando.R;
import com.hugo.empresa.buscandoando.modelo.negocio;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by user on 8/05/2017.
 */

public class ConfiguracionAdapter extends RecyclerView.Adapter<ConfiguracionAdapter.HolderNegocio> {

    private List<negocio> atributosList;
    private Context context;

    public ConfiguracionAdapter(List<negocio> atributosList, Context context){
        this.atributosList = atributosList;
        this.context = context;
    }

    @Override
    public HolderNegocio onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_configuracion,parent,false);
        return new HolderNegocio(v);
    }

    @Override
    public void onBindViewHolder(HolderNegocio holder, final int position) {
        Picasso.with(context).load(atributosList.get(position).getNeg_imagen()).error(R.drawable.logo_icono).into(holder.imageView);
        //holder.imageView.setImageResource(atributosList.get(position).getNeg_imagen());
        holder.nombre.setText(atributosList.get(position).getNeg_nombre());
        holder.descripcion.setText(atributosList.get(position).getNeg_descripcion());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,crudnegocio.class);
                i.putExtra("key_idNegocio",atributosList.get(position).getNeg_codigo());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return atributosList.size();
    }

    static class HolderNegocio extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView imageView;
        TextView nombre;
        TextView descripcion;
        TextView provincia;
        TextView ciudad;


        public HolderNegocio(View itemView) {
            super(itemView);
            cardView=(CardView)itemView.findViewById(R.id.cardviewNegocio);
            imageView = (ImageView) itemView.findViewById(R.id.fotoDePerfilNegocio);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            descripcion = (TextView) itemView.findViewById(R.id.descripcion);


        }
    }

}
