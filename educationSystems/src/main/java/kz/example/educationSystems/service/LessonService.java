package kz.example.educationSystems.service;

import kz.example.educationSystems.mapper.EntityMapper;
import kz.example.educationSystems.model.Lesson;
import kz.example.educationSystems.model.Topic;
import kz.example.educationSystems.repository.LessonRepository;
import kz.example.educationSystems.repository.TopicRepository;
import kz.example.educationSystems.web.dtos.LessonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;
    private final TopicRepository topicRepository;
    private final EntityMapper entityMapper;


    @Transactional
    public LessonDto createLesson(Long topicId, LessonDto lessonDto) {
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new NoSuchElementException("Topic not found"));
        Lesson lesson = entityMapper.toLessonEntity(lessonDto);
        lesson.setTopic(topic);
        lesson = lessonRepository.save(lesson);
        return entityMapper.toLessonDto(lesson);
    }

    public List<LessonDto> getLessonsByTopicId(Long topicId) {
        return lessonRepository.findByTopicId(topicId)
                .stream()
                .map(entityMapper::toLessonDto)
                .collect(Collectors.toList());
    }

    public LessonDto getLessonById(Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new NoSuchElementException("Lesson not found"));
        return entityMapper.toLessonDto(lesson);
    }
}
