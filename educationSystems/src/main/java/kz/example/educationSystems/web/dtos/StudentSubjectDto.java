package kz.example.educationSystems.web.dtos;

import lombok.Data;

@Data
public class StudentSubjectDto {
    private Long id;
    private Long studentId;
    private Long subjectId;
}
