package kz.example.educationSystems.repository;

import kz.example.educationSystems.model.Homework;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeworkRepository extends JpaRepository<Homework, Long> {
}