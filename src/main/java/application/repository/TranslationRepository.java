package application.repository;

import application.domain.TranslationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslationRepository extends JpaRepository<TranslationInfo, Long> {
}
