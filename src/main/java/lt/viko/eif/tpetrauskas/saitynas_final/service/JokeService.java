package lt.viko.eif.tpetrauskas.saitynas_final.service;

import lt.viko.eif.tpetrauskas.saitynas_final.model.Joke;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

/**
 * JokeService is an interface used for JokeServiceImpl.
 */
public interface JokeService {
    Joke getRandomJoke() throws IOException, JSONException;
    String getRandomJokeAsJSON() throws IOException, JSONException;
    List<Joke> getAllJokes();
    void saveJoke(Joke joke);
    Joke getJokeById(Integer id);
    void deleteJokeById(Integer id);
}
