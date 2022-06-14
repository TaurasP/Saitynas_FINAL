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

@Controller
public class JokeController {

    @Autowired
    private JokeService jokeService;

    @GetMapping("/jokes")
    public String showJokes(Model model) {
        model.addAttribute("jokeList", jokeService.getAllJokes());
        return "jokes";
    }

    @GetMapping("/index")
    public String getRandomJoke(Model model) throws JSONException, IOException {
        model.addAttribute("joke", jokeService.getRandomJoke());
        return "index";
    }

    @PostMapping("/jokes/save")
    public String saveJoke(@ModelAttribute("joke") Joke joke) {
        jokeService.saveJoke(joke);
        return "redirect:/jokes";
    }

    @GetMapping("/jokes/delete/{id}")
    public String deleteJoke(@PathVariable(value = "id") Integer id) {
        this.jokeService.deleteJokeById(id);
        return "redirect:/jokes";
    }
}
