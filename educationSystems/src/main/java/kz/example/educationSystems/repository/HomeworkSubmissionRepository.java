package kz.example.educationSystems.repository;

import kz.example.educationSystems.model.HomeworkSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeworkSubmissionRepository extends JpaRepository<HomeworkSubmission, Long> {
    List<HomeworkSubmission> findByHomeworkId(Long homeworkId);
}
