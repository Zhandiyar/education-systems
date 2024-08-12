package kz.example.educationSystems.repository;

import kz.example.educationSystems.model.Topic;
import kz.example.educationSystems.web.dtos.TopicDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findBySubjectId(Long subjectId);
}