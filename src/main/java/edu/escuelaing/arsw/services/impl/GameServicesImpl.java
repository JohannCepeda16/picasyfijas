package edu.escuelaing.arsw.services.impl;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Component;

import edu.escuelaing.arsw.services.GameServices;

@Component
public class GameServicesImpl implements GameServices {

    private ArrayList<Integer> numbers;

    public GameServicesImpl() {
        numbers = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            numbers.add(random.nextInt(9));
        }
    }

    @Override
    public String play(ArrayList<Integer> userNumbers) {
        Integer picas = 0, fijas = 0;
        for (int i = 0; i < this.numbers.size(); i++) {
            if(this.numbers.contains(userNumbers.get(i))){
                if(this.numbers.get(i).equals(userNumbers.get(i))){
                    fijas++;
                }else{
                    picas++;
                }
            }
        }

        return "Picas: " + picas + " Fijas: " + fijas;
    }

}
