package lt.viko.eif.tpetrauskas.saitynas_final.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OkHttpClient entity is used to efficiently manage HTTP requests.
 */
@Configuration
public class OkHttpClient {
    /**
     * kHttpClient instance is used for HTTP requests.
     *
     * @return OkHttpClient object
     */
    @Bean
    public OkHttpClient OkHttpClient() {
        return new OkHttpClient();
    }
}
