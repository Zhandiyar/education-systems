package kz.example.educationSystems.repository;

import kz.example.educationSystems.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByTopicId(Long topicId);
}