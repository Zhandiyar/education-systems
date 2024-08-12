package kz.example.educationSystems.web.dtos;

import lombok.Data;

import java.util.List;

@Data
public class TopicDto {
    private Long id;
    private String name;
    private String description;
    private Long subjectId;
    private List<LessonDto> lessons;
}
