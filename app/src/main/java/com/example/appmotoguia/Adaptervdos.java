package com.example.appmotoguia;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptervdos extends RecyclerView.Adapter<Adaptervdos.MyViewHolder> {

    private Context context;
    private ArrayList<String> umarca;
    private ArrayList<String> umodelo;
    private LayoutInflater layoutInflater;


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Mostrar solo los datos de modelo y marca
        holder.marcas.setText(umarca.get(position));
        holder.modelos.setText(umodelo.get(position));
    }

    @Override
    public int getItemCount() {
        return umarca.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView marcas, modelos;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // ... findViewById y otros inicializadores ...

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Obtener los datos de modelo y marca del elemento clickeado
                    String modelo = umodelo.get(getAdapterPosition());
                    String marca = umarca.get(getAdapterPosition());

                    // Crear un Intent para la actividad de edición
                    Intent intent = new Intent(context, EditarDatosMotoActivity.class);
                    // Pasar los datos del modelo y marca a la actividad de edición
                    intent.putExtra("modelo", modelo);
                    intent.putExtra("marca", marca);
                    context.startActivity(intent);
                }
            });
        }
    }
}
