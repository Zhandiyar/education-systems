package kz.example.educationSystems.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @OneToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
}
