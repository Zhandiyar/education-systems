package kz.example.educationSystems.repository;

import kz.example.educationSystems.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
