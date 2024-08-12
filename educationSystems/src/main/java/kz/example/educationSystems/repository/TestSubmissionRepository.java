package kz.example.educationSystems.repository;

import kz.example.educationSystems.model.TestSubmission;
import kz.example.educationSystems.web.dtos.TestSubmissionDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TestSubmissionRepository extends JpaRepository<TestSubmission, Long> {
    List<TestSubmission> findByTestId(Long testId);

    Optional<TestSubmission> findByTestIdAndStudentId(Long testId, Long studentId);
}
