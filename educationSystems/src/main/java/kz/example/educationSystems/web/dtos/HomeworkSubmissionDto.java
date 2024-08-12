package kz.example.educationSystems.web.dtos;

import lombok.Data;

@Data
public class HomeworkSubmissionDto {
    private Long id;
    private String text;
    private Long homeworkId;
    private Long studentId;
}
