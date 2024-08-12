package kz.example.educationSystems.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String text;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @OneToOne(mappedBy = "lesson", cascade = CascadeType.ALL)
    private Homework homework;
}
