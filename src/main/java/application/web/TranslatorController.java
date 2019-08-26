package application.web;

import application.exception.IncorrectLanguage;
import application.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslatorController {

    @Autowired
    private TranslationService translationService;

    @GetMapping("translate")
    public String translate(@RequestParam String text, @RequestParam String from, @RequestParam String to) {
        try {
            return translationService.translateText(text, from, to);
        } catch (IncorrectLanguage incorrectLanguage) {
            incorrectLanguage.printStackTrace();
            return incorrectLanguage.getMessage();
        }
    }
}
