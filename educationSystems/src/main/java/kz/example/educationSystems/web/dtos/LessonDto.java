package kz.example.educationSystems.web.dtos;

import lombok.Data;

@Data
public class LessonDto {
    private Long id;
    private String name;
    private String text;
    private Long topicId;
    private HomeworkDto homework;
}