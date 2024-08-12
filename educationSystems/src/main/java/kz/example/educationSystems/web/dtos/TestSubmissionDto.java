package kz.example.educationSystems.web.dtos;

import lombok.Data;
import java.util.List;

@Data
public class TestSubmissionDto {
    private Long id;
    private List<String> answers;
    private Long testId;
    private Long studentId;
}