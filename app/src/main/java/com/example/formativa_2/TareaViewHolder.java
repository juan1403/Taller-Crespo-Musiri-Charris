package com.example.formativa_2;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.formativa_2.R;
import com.example.formativa_2.Tarea;

public class TareaViewHolder extends RecyclerView.ViewHolder {

    private TextView nombreTarea;
    private TextView categoriaTarea;
    private TextView estadoTarea;

    public TareaViewHolder(@NonNull View itemView) {
        super(itemView);
        nombreTarea = itemView.findViewById(R.id.nombre_tarea);
        categoriaTarea = itemView.findViewById(R.id.categoria_tarea);
        estadoTarea = itemView.findViewById(R.id.estado_tarea);
    }

    public void bind(Tarea tarea) {
        nombreTarea.setText(tarea.getNombre());
        categoriaTarea.setText(tarea.getCategoria());
        estadoTarea.setText(tarea.getEstado());
    }
}
