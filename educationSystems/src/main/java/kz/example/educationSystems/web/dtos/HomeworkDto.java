package kz.example.educationSystems.web.dtos;

import lombok.Data;

@Data
public class HomeworkDto {
    private Long id;
    private String text;
    private Long lessonId;

}
