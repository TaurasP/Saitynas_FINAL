package lt.viko.eif.tpetrauskas.saitynas_final.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OkHttpClient {
    @Bean
    public OkHttpClient OkHttpClient() {
        return new OkHttpClient();
    }
}
