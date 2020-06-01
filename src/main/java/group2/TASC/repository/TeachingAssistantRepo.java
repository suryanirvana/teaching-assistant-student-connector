package group2.TASC.repository;

import group2.TASC.model.TeachingAssistant;
import group2.TASC.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachingAssistantRepo extends JpaRepository<TeachingAssistant, Long> {
    TeachingAssistant findByUsername(String username);
}
