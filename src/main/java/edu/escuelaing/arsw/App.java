package edu.escuelaing.arsw;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal del programa
 *
 */
@SpringBootApplication
public class App {

    /**
     * Metodo que ejecuta la aplicacion
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", getPort()));
        app.run(args);
    }

    /**
     * Obtiene un puerto por defecto cuando el de ambiente esta ocupado
     * @return
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 8080; // returns default port if heroku-port isn't set(i.e. on localhost)
    }
}
