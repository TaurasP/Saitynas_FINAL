package lt.viko.eif.tpetrauskas.saitynas_final.controller;

import lt.viko.eif.tpetrauskas.saitynas_final.model.Joke;
import lt.viko.eif.tpetrauskas.saitynas_final.service.JokeService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

/**
 * JokeController is responsible for managing all HTTP requests.
 */
@Controller
public class JokeController {

    @Autowired
    private JokeService jokeService;

    /**
     * Gets the list of all jokes form DB.
     *
     * @param model
     * @return the list of jokes
     */
    @GetMapping("/jokes")
    public String showJokes(Model model) {
        model.addAttribute("jokeList", jokeService.getAllJokes());
        return "jokes";
    }

    /**
     * Gets one random joke from external jokes API.
     *
     * @param model
     * @return opens index.html page
     * @throws JSONException
     * @throws IOException
     */
    @GetMapping("/index")
    public String getRandomJoke(Model model) throws JSONException, IOException {
        model.addAttribute("joke", jokeService.getRandomJoke());
        return "index";
    }

    /**
     * Allows to add a new joke..
     *
     * @param model
     * @return opens add-update-joke.html page
     */
    @GetMapping("/jokes/add")
    public String showNewJokeForm(Model model) {
        model.addAttribute("joke", new Joke());
        return "add-update-joke";
    }

    /**
     * Allows to edit joke.
     *
     * @param id
     * @param model
     * @return opens add-update-joke.html page
     */
    @GetMapping("/jokes/edit/{id}")
    public String showJokeFormForUpdate(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("joke", jokeService.getJokeById(id));
        return "add-update-joke";
    }

    /**
     * Saves joke to DB.
     *
     * @param joke
     * @return redirects to jokes.html page
     */
    @PostMapping("/jokes/save")
    public String saveJoke(@ModelAttribute("joke") Joke joke) {
        jokeService.saveJoke(joke);
        return "redirect:/jokes";
    }

    /**
     * Deletes joke by its id.
     *
     * @param id
     * @return redirects to jokes.html page
     */
    @GetMapping("/jokes/delete/{id}")
    public String deleteJoke(@PathVariable(value = "id") Integer id) {
        this.jokeService.deleteJokeById(id);
        return "redirect:/jokes";
    }
}
