package com.example.formativa_2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.formativa_2.DetalleActivity;
import com.example.formativa_2.R;
import com.example.formativa_2.Tarea;

import java.util.List;

public class TareaAdaptador extends RecyclerView.Adapter<TareaAdaptador.TareaViewHolder> {

    private List<Tarea> listaTareas;
    private Context contexto;

    public TareaAdaptador(List<Tarea> listaTareas, Context contexto) {
        this.listaTareas = listaTareas;
        this.contexto = contexto;
    }

    @NonNull
    @Override
    public TareaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarea_item, parent, false);
        return new TareaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TareaViewHolder holder, int position) {
        Tarea tarea = listaTareas.get(position);
        holder.nombreTarea.setText(tarea.getNombre());
        holder.categoriaTarea.setText(tarea.getCategoria());
        holder.estadoTarea.setText(tarea.getEstado());

        Glide.with(contexto)
                .load(tarea.getImagenUrl())
                .into(holder.imagenTarea);

        switch (tarea.getEstado()) {
            case "Completado":
                holder.itemView.setBackgroundColor(android.graphics.Color.parseColor("#A5D6A7"));
                break;
            case "En progreso":
                holder.itemView.setBackgroundColor(android.graphics.Color.parseColor("#FFF59D"));
                break;
            case "Pendiente":
                holder.itemView.setBackgroundColor(android.graphics.Color.parseColor("#EF5350"));
                break;
            default:
                holder.itemView.setBackgroundColor(android.graphics.Color.TRANSPARENT);
                break;
        }

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(contexto, DetalleActivity.class);
            intent.putExtra("nombreTarea", tarea.getNombre());
            intent.putExtra("categoriaTarea", tarea.getCategoria());
            intent.putExtra("estadoTarea", tarea.getEstado());
            intent.putExtra("imagenUrl", tarea.getImagenUrl());
            contexto.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listaTareas.size();
    }

    public static class TareaViewHolder extends RecyclerView.ViewHolder {
        ImageView imagenTarea;
        TextView nombreTarea;
        TextView categoriaTarea;
        TextView estadoTarea;

        public TareaViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenTarea = itemView.findViewById(R.id.img_tarea);
            nombreTarea = itemView.findViewById(R.id.nombre_tarea);
            categoriaTarea = itemView.findViewById(R.id.categoria_tarea);
            estadoTarea = itemView.findViewById(R.id.estado_tarea);
        }
    }
}
