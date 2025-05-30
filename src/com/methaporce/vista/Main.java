// Clase Main (com.methaporce.vista)
package com.methaporce.vista;

import com.methaporce.modelo.GestorPeliculas;
import com.methaporce.modelo.Pelicula;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorPeliculas gestor = new GestorPeliculas();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hola Mundo");
        System.out.println("Hola Mundo 222");
        int opcion;

        do {
            System.out.println("\n1. Agregar película");
            System.out.println("2. Eliminar película");
            System.out.println("3. Ver todas las películas");
            System.out.println("4. Ver disponibles");
            System.out.println("5. Ver no disponibles");
            System.out.println("6. Marcar como disponible");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("¿Disponible? (true/false): ");
                    boolean disponible = scanner.nextBoolean();
                    gestor.agregarPelicula(new Pelicula(id, nombre, disponible));
                    break;

                case 2:
                    System.out.print("ID a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    gestor.eliminarPelicula(idEliminar);
                    break;

                case 3:
                    mostrarLista(gestor.obtenerTodas(), "Todas las películas:");
                    break;

                case 4:
                    mostrarLista(gestor.obtenerDisponibles(), "Películas disponibles:");
                    break;

                case 5:
                    mostrarLista(gestor.obtenerNoDisponibles(), "Películas no disponibles:");
                    break;

                case 6:
                    System.out.print("ID a marcar disponible: ");
                    int idMarcar = scanner.nextInt();
                    gestor.marcarDisponible(idMarcar);
                    break;

                case 7:
                    System.out.println("¡Adiós!");
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 7);
        scanner.close();
    }

    private static void mostrarLista(List<Pelicula> peliculas, String mensaje) {
        System.out.println("\n" + mensaje);
        for (Pelicula peli : peliculas) {
            System.out.println("ID: " + peli.getId() + " - " + peli.getNombre() +
                    " (" + (peli.isDisponible() ? "Disponible" : "No disponible") + ")");
        }
    }
}