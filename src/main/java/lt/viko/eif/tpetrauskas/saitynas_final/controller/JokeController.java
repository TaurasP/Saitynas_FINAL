package lt.viko.eif.tpetrauskas.saitynas_final.controller;

import lt.viko.eif.tpetrauskas.saitynas_final.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JokeController {

    @Autowired
    private JokeService jokeService;

    @GetMapping("/jokes")
    public String showJokes(Model model) {
        model.addAttribute("jokeList", jokeService.getAllJokes());
        return "jokes";
    }
}
