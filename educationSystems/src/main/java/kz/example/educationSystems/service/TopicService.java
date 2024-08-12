package kz.example.educationSystems.service;

import kz.example.educationSystems.mapper.EntityMapper;
import kz.example.educationSystems.model.Subject;
import kz.example.educationSystems.model.Topic;
import kz.example.educationSystems.repository.SubjectRepository;
import kz.example.educationSystems.repository.TopicRepository;
import kz.example.educationSystems.web.dtos.TopicDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;
    private final SubjectRepository subjectRepository;
    private final EntityMapper entityMapper;

    @Transactional
    public TopicDto createTopic(Long subjectId, TopicDto topicDto) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new NoSuchElementException("Subject not found"));
        Topic topic = entityMapper.toTopicEntity(topicDto);
        topic.setSubject(subject);
        topic = topicRepository.save(topic);
        return entityMapper.toTopicDto(topic);
    }

    public List<TopicDto> getTopicsBySubjectId(Long subjectId) {
        return topicRepository.findBySubjectId(subjectId)
                .stream()
                .map(entityMapper::toTopicDto)
                .collect(Collectors.toList());
    }
}
