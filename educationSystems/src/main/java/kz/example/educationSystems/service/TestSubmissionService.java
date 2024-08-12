package kz.example.educationSystems.service;

import kz.example.educationSystems.mapper.EntityMapper;
import kz.example.educationSystems.model.Test;
import kz.example.educationSystems.model.TestSubmission;
import kz.example.educationSystems.model.User;
import kz.example.educationSystems.repository.TestRepository;
import kz.example.educationSystems.repository.TestSubmissionRepository;
import kz.example.educationSystems.repository.UserRepository;
import kz.example.educationSystems.web.dtos.TestSubmissionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestSubmissionService {

    private final TestSubmissionRepository testSubmissionRepository;
    private final TestRepository testRepository;
    private final UserRepository userRepository;
    private final EntityMapper entityMapper;

    @Transactional
    public TestSubmissionDto submitTest(Long testId, TestSubmissionDto submissionDto) {
        Test test = testRepository.findById(testId)
                .orElseThrow(() -> new NoSuchElementException("Test not found"));
        User student = userRepository.findById(submissionDto.getStudentId())
                .orElseThrow(() -> new NoSuchElementException("Student not found"));
        TestSubmission submission = entityMapper.toTestSubmissionEntity(submissionDto);
        submission.setTest(test);
        submission.setStudent(student);
        submission = testSubmissionRepository.save(submission);
        return entityMapper.toTestSubmissionDto(submission);
    }

    public List<TestSubmissionDto> getSubmissionsByTestId(Long testId) {
        return testSubmissionRepository.findByTestId(testId)
                .stream()
                .map(entityMapper::toTestSubmissionDto)
                .collect(Collectors.toList());
    }

    public TestSubmissionDto getTestResults(Long testId, Long studentId) {
        return testSubmissionRepository.findByTestIdAndStudentId(testId, studentId)
                .map(entityMapper::toTestSubmissionDto)
                .orElseThrow(() -> new NoSuchElementException("Test results not found"));
    }
}