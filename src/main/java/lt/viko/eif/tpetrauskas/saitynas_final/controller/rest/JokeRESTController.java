package lt.viko.eif.tpetrauskas.saitynas_final.controller.rest;

import lt.viko.eif.tpetrauskas.saitynas_final.service.JokeService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * JokeRESTController is responsible for managing HTTP GET request from external jokes API.
 */
@RestController
@RequestMapping("/api")
public class JokeRESTController {
    @Autowired
    JokeService jokeService;

    /**
     * Gets random joke and sends as string to joke.html page.
     *
     * @return random joke as string
     * @throws IOException
     * @throws JSONException
     */
    @RequestMapping("/joke")
    public String getRandomJoke() throws IOException, JSONException {
        return jokeService.getRandomJoke().getText();
    }
}
