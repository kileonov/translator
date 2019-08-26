package application.configuration;

import com.github.vbauer.yta.service.YTranslateApi;
import com.github.vbauer.yta.service.YTranslateApiImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TranslationConfiguration {

    @Value("${translation.key}")
    private String translationKey;

    @Bean
    public YTranslateApi yTranslateApi() {
        return new YTranslateApiImpl(translationKey);
    }
}
