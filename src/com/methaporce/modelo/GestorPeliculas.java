// Clase GestorPeliculas (com.methaporce.modelo)
package com.methaporce.modelo;

import java.util.ArrayList;
import java.util.List;

public class GestorPeliculas {
    private List<Pelicula> peliculas = new ArrayList<>();

    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    public void eliminarPelicula(int id) {
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getId() == id) {
                peliculas.remove(i);
                break;
            }
        }
    }

    public List<Pelicula> obtenerTodas() {
        return peliculas;
    }

    public List<Pelicula> obtenerDisponibles() {
        List<Pelicula> disponibles = new ArrayList<>();
        for (Pelicula peli : peliculas) {
            if (peli.isDisponible()) {
                disponibles.add(peli);
            }
        }
        return disponibles;
    }

    public List<Pelicula> obtenerNoDisponibles() {
        List<Pelicula> noDisponibles = new ArrayList<>();
        for (Pelicula peli : peliculas) {
            if (!peli.isDisponible()) {
                noDisponibles.add(peli);
            }
        }
        return noDisponibles;
    }

    public void marcarDisponible(int id) {
        for (Pelicula peli : peliculas) {
            if (peli.getId() == id) {
                peli.setDisponible(true);
                break;
            }
        }
    }
}