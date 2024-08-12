package kz.example.educationSystems.service;

import kz.example.educationSystems.mapper.EntityMapper;
import kz.example.educationSystems.model.Test;
import kz.example.educationSystems.model.TestSubmission;
import kz.example.educationSystems.model.Topic;
import kz.example.educationSystems.model.User;
import kz.example.educationSystems.repository.TestRepository;
import kz.example.educationSystems.repository.TestSubmissionRepository;
import kz.example.educationSystems.repository.TopicRepository;
import kz.example.educationSystems.repository.UserRepository;
import kz.example.educationSystems.web.dtos.TestDto;
import kz.example.educationSystems.web.dtos.TestSubmissionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;
    private final TopicRepository topicRepository;
    private final EntityMapper entityMapper;

    @Transactional
    public TestDto createTest(Long topicId, TestDto testDto) {
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new NoSuchElementException("Topic not found"));
        Test test = entityMapper.toTestEntity(testDto);
        test.setTopic(topic);
        test = testRepository.save(test);
        return entityMapper.toTestDto(test);
    }
}
