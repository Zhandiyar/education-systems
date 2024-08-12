package kz.example.educationSystems.web.dtos;

import lombok.Data;
import java.util.List;

@Data
public class TestDto {
    private Long id;
    private String question;
    private String correctAnswer;
    private List<String> options;
    private Long topicId;
}