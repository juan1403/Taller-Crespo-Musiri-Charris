package com.example.formativa_2;

public class Tarea {
    private String imagenUrl;
    private String nombre;
    private String categoria;
    private String estado;

    public Tarea(String imagenUrl, String nombre, String categoria, String estado) {
        this.imagenUrl = imagenUrl;
        this.nombre = nombre;
        this.categoria = categoria;
        this.estado = estado;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getEstado() {
        return estado;
    }
}
