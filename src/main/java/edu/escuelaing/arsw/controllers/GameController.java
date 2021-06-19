package edu.escuelaing.arsw.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.arsw.services.GameServices;

/**
 * Constrolador del juego
 */
@RestController
@RequestMapping(value = "/")
public class GameController {

    @Autowired
    GameServices gameServices;

    /**
     * Constructor de la clase
     */
    public GameController() {

    }

    /**
     * Despliega un formulario para que el usuario digite los numeros
     * @return
     */
    @GetMapping("")
    public String form() {

        String output = "<!DOCTYPE html>\r\n"
                + "<html>\r\n"
                + "<body>\r\n"
                + "<h2>HTML Forms</h2>\r\n"
                + "<form action=\"play\">\r\n"
                + " <label for=\"name\">Numeros (separados por coma ','):</label><br>\r\n"
                + " <input maxlength='8' type=\"text\" id=\"numbers\" name=\"numbers\" value=\"\"><br>\r\n"
                + " <input type=\"submit\" value=\"Jugar\">\r\n"
                + "</form> \r\n"
                + "</body> \r\n"
                + "</html> \r\n";

        return output;
    }

    /**
     * Permite jugar y saber cuantas picas y fijas se tienen
     * @param numbers Lista de numeros para jugar
     * @return
     */
    @GetMapping(value = "/play")
    public String play(@RequestParam("numbers") String numbers) {
        try {
            String[] numbersList = numbers.split(",");
            ArrayList<Integer> numList = new ArrayList<Integer>();
            for (String number : numbersList) {
                numList.add(Integer.parseInt(number));
            }
            return gameServices.play(numList);
        } catch (Exception e) {
            e.printStackTrace();
            return "Ha ocurrido une error";
        }
    }

}
