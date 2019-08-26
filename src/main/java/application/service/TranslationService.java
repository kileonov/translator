package application.service;

import application.domain.TranslationInfo;
import application.exception.IncorrectLanguage;
import application.repository.TranslationRepository;
import com.github.vbauer.yta.model.Direction;
import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.service.YTranslateApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;
import java.util.StringJoiner;

@Service
public class TranslationService {

    @Autowired
    private YTranslateApi yTranslateApi;

    @Autowired
    private TranslationRepository translationRepository;

    public String translateText(String text, String from, String to) throws IncorrectLanguage {
        Language fromLang = getLanguageByCode(from);
        Language toLang = getLanguageByCode(to);

        StringJoiner resultJoiner = new StringJoiner(" ");
        String[] words = text.split(" ");
        Arrays.stream(words)
                .map(word -> yTranslateApi.translationApi().translate(word, Direction.of(fromLang, toLang)))
                .forEach(word -> resultJoiner.add(word.toString()));

        String result = resultJoiner.toString();
        TranslationInfo translationInfo = createTranslationInfo(text, from, to, result);
        translationRepository.save(translationInfo);
        return result;
    }

    private Language getLanguageByCode(String lang) throws IncorrectLanguage {
        Language fromLang = Language.of(lang);
        if (fromLang.name().isEmpty()) throw new IncorrectLanguage("Incorrect language parameter [" + lang + "]");
        return fromLang;
    }

    private TranslationInfo createTranslationInfo(String text, String from, String to, String translatedText) {
        String requestedParameters = new StringBuilder()
                .append("[text = ").append(text).append(",")
                .append("from = ").append(from).append(",")
                .append("to = ").append(to).append("]")
                .toString();
        return new TranslationInfo(Timestamp.from(Instant.now()), requestedParameters, translatedText);
    }
}
