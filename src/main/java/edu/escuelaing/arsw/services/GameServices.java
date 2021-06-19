package edu.escuelaing.arsw.services;

import java.util.ArrayList;

public interface GameServices {
    /**
     * Recibe la lista de numeros para comparar con los autogenerados
     * @param numbers
     * @return
     */
    String play(ArrayList<Integer> numbers);
}
