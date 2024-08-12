package kz.example.educationSystems.service;

import kz.example.educationSystems.mapper.EntityMapper;
import kz.example.educationSystems.model.Homework;
import kz.example.educationSystems.model.HomeworkSubmission;
import kz.example.educationSystems.repository.HomeworkRepository;
import kz.example.educationSystems.repository.HomeworkSubmissionRepository;
import kz.example.educationSystems.web.dtos.HomeworkSubmissionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HomeworkSubmissionService {

    private final HomeworkSubmissionRepository homeworkSubmissionRepository;
    private final HomeworkRepository homeworkRepository;
    private final EntityMapper entityMapper;

    @Transactional
    public HomeworkSubmissionDto submitHomework(Long homeworkId, HomeworkSubmissionDto submissionDto) {
        Homework homework = homeworkRepository.findById(homeworkId)
                .orElseThrow(() -> new NoSuchElementException("Homework not found"));
        HomeworkSubmission submission = entityMapper.toHomeworkSubmissionEntity(submissionDto);
        submission.setHomework(homework);
        submission = homeworkSubmissionRepository.save(submission);
        return entityMapper.toHomeworkSubmissionDto(submission);
    }

    public List<HomeworkSubmissionDto> getHomeworkSubmissionsByHomeworkId(Long homeworkId) {
        return homeworkSubmissionRepository.findByHomeworkId(homeworkId)
                .stream()
                .map(entityMapper::toHomeworkSubmissionDto)
                .collect(Collectors.toList());
    }
}
