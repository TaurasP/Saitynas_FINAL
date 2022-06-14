package lt.viko.eif.tpetrauskas.saitynas_final.service;

import lt.viko.eif.tpetrauskas.saitynas_final.model.Joke;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public interface JokeService {
    Joke getRandomJoke() throws IOException, JSONException;
    List<Joke> getAllJokes();
    void saveJoke(Joke joke);
    Joke getJokeById(Integer id);
    void deleteJokeById(Integer id);
}
