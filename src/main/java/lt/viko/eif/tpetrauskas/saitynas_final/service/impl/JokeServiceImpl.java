package lt.viko.eif.tpetrauskas.saitynas_final.service.impl;


import lt.viko.eif.tpetrauskas.saitynas_final.model.Joke;
import lt.viko.eif.tpetrauskas.saitynas_final.repository.JokeRepository;
import lt.viko.eif.tpetrauskas.saitynas_final.service.JokeService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class JokeServiceImpl implements JokeService {

    @Autowired
    private JokeRepository jokeRepository;

    @Override
    public List<Joke> getAllJokes() {
        return jokeRepository.findAll();
    }

    @Override
    public void saveJoke(Joke joke) {
        this.jokeRepository.save(joke);
    }

    @Override
    public Joke getJokeById(Integer id) {
        Optional<Joke> optional = jokeRepository.findById(id);
        Joke joke;
        if (optional.isPresent()) {
            joke = optional.get();
        } else {
            throw new RuntimeException("Juokelis nerastas pagal id: " + id);
        }
        return joke;
    }

    @Override
    public void deleteJokeById(Integer id) {
        this.jokeRepository.deleteById(id);
    }

    @Override
    public String getRandomJoke() throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://lithuanian-jokes.p.rapidapi.com/random")
                .get()
                .addHeader("X-RapidAPI-Key", "e888809ecemshfeb640a479bcb54p1c6e82jsn6b2d576abd25")
                .addHeader("X-RapidAPI-Host", "lithuanian-jokes.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();

        String jsonData = response.body().string();
        JSONObject jsonObject = new JSONObject(jsonData);

        return jsonObject.getString("text");
    }
}
