package lt.viko.eif.tpetrauskas.saitynas_final.controller.rest;

import lt.viko.eif.tpetrauskas.saitynas_final.service.JokeService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class JokeRESTController {
    @Autowired
    JokeService jokeService;

    @RequestMapping("/joke")
    public String getRandomJoke() throws IOException, JSONException {
        return jokeService.getRandomJoke().getText();
    }
}
