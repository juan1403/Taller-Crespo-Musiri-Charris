package com.example.formativa_2;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formativa_2.TareaAdaptador;
import com.example.formativa_2.Tarea;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcv_tareas;
    List<Tarea> listaTareas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        rcv_tareas = findViewById(R.id.rcv_tareas);

        Tarea tarea1 = new Tarea("https://csaconsultores.com/wp-content/uploads/2019/10/etiqueta-alimento.png", "Comprar víveres", "Compras", "Pendiente");
        Tarea tarea2 = new Tarea("https://deposeguro.com/wp-content/uploads/2024/04/Image-blog-web-21.jpg", "Completar tarea", "Trabajo", "En progreso");
        Tarea tarea3 = new Tarea("https://media.revistagq.com/photos/65b12cd1df908a3c3a4d7373/16:9/w_2560%2Cc_limit/fitness%2520portada.jpg", "Ejercicio en el gimnasio", "Salud", "Completado");
        Tarea tarea4 = new Tarea("https://laud.udistrital.edu.co/sites/default/files/imagen-noticia/2022-04/LAUD%20Dia%20del%20Libro.jpg", "Leer un libro", "Ocio", "Pendiente");

        listaTareas.add(tarea1);
        listaTareas.add(tarea2);
        listaTareas.add(tarea3);
        listaTareas.add(tarea4);

        rcv_tareas.setLayoutManager(new GridLayoutManager(this, 2));
        rcv_tareas.setAdapter(new TareaAdaptador(listaTareas, this));
    }
}
