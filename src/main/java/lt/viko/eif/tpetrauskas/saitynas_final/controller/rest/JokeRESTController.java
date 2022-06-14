package lt.viko.eif.tpetrauskas.saitynas_final.controller.rest;

import lt.viko.eif.tpetrauskas.saitynas_final.service.JokeService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class JokeRESTController {

    @RequestMapping("/joke")
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
