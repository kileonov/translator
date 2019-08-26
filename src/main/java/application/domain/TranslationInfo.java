package application.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class TranslationInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Timestamp timeInfo;
    private String parameters;
    private String translatedText;

    protected TranslationInfo() {}

    public TranslationInfo(Timestamp timeInfo, String parameters, String translatedText) {
        this.timeInfo = timeInfo;
        this.parameters = parameters;
        this.translatedText = translatedText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getTimeInfo() {
        return timeInfo;
    }

    public void setTimeInfo(Timestamp timeInfo) {
        this.timeInfo = timeInfo;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TranslationInfo that = (TranslationInfo) o;
        if (getId() == null || that.getId() == null) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "TranslationInfo{" +
                "id=" + id +
                ", timeInfo=" + timeInfo +
                ", parameters='" + parameters + '\'' +
                ", translatedText='" + translatedText + '\'' +
                '}';
    }
}
