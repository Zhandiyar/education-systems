package kz.example.educationSystems.repository;

import kz.example.educationSystems.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}