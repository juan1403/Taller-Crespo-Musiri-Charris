package com.example.formativa_2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetalleActivity extends AppCompatActivity {

    TextView nombreTarea, categoriaTarea, estadoTarea;
    ImageView imagenTarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        nombreTarea = findViewById(R.id.detalle_nombre_tarea);
        categoriaTarea = findViewById(R.id.detalle_categoria_tarea);
        estadoTarea = findViewById(R.id.detalle_estado_tarea);
        imagenTarea = findViewById(R.id.detalle_imagen_tarea);

        String nombre = getIntent().getStringExtra("nombreTarea");
        String categoria = getIntent().getStringExtra("categoriaTarea");
        String estado = getIntent().getStringExtra("estadoTarea");
        String imagenUrl = getIntent().getStringExtra("imagenUrl");

        nombreTarea.setText(nombre);
        categoriaTarea.setText(categoria);
        estadoTarea.setText(estado);

        Glide.with(this)
                .load(imagenUrl)
                .into(imagenTarea);
    }
}
