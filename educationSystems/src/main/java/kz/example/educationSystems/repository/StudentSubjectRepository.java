package kz.example.educationSystems.repository;

import kz.example.educationSystems.model.StudentSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Long> {
    List<StudentSubject> findByStudentId(Long studentId);
}