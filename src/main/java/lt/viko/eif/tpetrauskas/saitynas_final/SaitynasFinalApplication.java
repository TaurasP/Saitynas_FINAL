package lt.viko.eif.tpetrauskas.saitynas_final;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main spring boot application's class.
 * Application gets random jokes from external jokes API.
 * User has ability save jokes he likes to DB and then CRUD them.
 */
@SpringBootApplication
public class SaitynasFinalApplication {
    /**
     * Main application's method used to run the project.
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SaitynasFinalApplication.class, args);
    }
}
