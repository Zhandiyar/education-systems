package kz.example.educationSystems.web.dtos;

import lombok.Data;

import java.util.List;

@Data
public class SubjectDto {
    private Long id;
    private String name;
    private String description;
    private List<TopicDto> topics;
}
