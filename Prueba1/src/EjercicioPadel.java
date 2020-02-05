/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciopadel;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author adry_
 */
public class EjercicioPadel {

    /**
     * @param args the command line argumentsbfx´4Vj8g bf0x c    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        HashMap<String, Integer> ligas = new HashMap<String, Integer>();
        String categoria;
        String resultado;
        String[] partes;

        int contadorPartidos = 0;
        categoria = in.nextLine();
        while (!categoria.equals("FIN")) {

            resultado = in.nextLine();

            while (!resultado.equals("FIN")) {
                partes = resultado.split(" ");
                altaEquipo(ligas, partes);
                actualizarPuntos(partes[0], partes[2], Integer.parseInt(partes[1]), Integer.parseInt(partes[3]), ligas);
                contadorPartidos++;
                resultado = in.nextLine();
            }

            System.out.println(campeon(ligas) + " " + partidosRestantes(ligas, contadorPartidos));

            ligas.clear();
            contadorPartidos = 0;
            ligas = new HashMap<String, Integer>();
            categoria = in.nextLine();
        }

    }

    public static void altaEquipo(HashMap<String, Integer> ligas, String[] partes) {
        if (!ligas.containsKey(partes[0])) {
            ligas.put(partes[0], 0);
        }
        if (!ligas.containsKey(partes[2])) {
            ligas.put(partes[2], 0);
        }
    }

    public static void actualizarPuntos(String equipo1, String equipo2, int resultado1, int resultado2, HashMap<String, Integer> ligas) {
        int puntosGanador = 2;
        int puntosPerdedor = 1;

        if (resultado1 > resultado2) {
            ligas.put(equipo1, (ligas.get(equipo1) + puntosGanador));
            ligas.put(equipo2, (ligas.get(equipo2) + puntosPerdedor));
        } else if (resultado1 < resultado2) {
            ligas.put(equipo2, (ligas.get(equipo2) + puntosGanador));
            ligas.put(equipo1, (ligas.get(equipo1) + puntosPerdedor));
        }
    }

    public static String campeon(HashMap<String, Integer> ligas) {
        String ganador = null;
        int puntosGanador = 0;

        for (String equipo : ligas.keySet()) {
            if (ligas.get(equipo) > puntosGanador) {
                ganador = equipo;
                puntosGanador = ligas.get(equipo);
            } else if (ligas.get(equipo) == puntosGanador) {
                ganador = "EMPATE";
            }
        }
        return ganador;

    }

    public static int partidosRestantes(HashMap<String, Integer> ligas, int contador) {
        return (ligas.size() * (ligas.size() - 1) - contador);
    }
}
