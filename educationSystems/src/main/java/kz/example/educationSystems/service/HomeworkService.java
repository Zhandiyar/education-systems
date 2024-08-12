package kz.example.educationSystems.service;

import jakarta.transaction.Transactional;
import kz.example.educationSystems.mapper.EntityMapper;
import kz.example.educationSystems.model.Homework;
import kz.example.educationSystems.model.Lesson;
import kz.example.educationSystems.repository.HomeworkRepository;
import kz.example.educationSystems.repository.LessonRepository;
import kz.example.educationSystems.web.dtos.HomeworkDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class HomeworkService {

    private final HomeworkRepository homeworkRepository;
    private final LessonRepository lessonRepository;
    private final EntityMapper entityMapper;

    @Transactional
    public HomeworkDto createHomework(Long lessonId, HomeworkDto homeworkDto) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new NoSuchElementException("Lesson not found"));
        Homework homework = entityMapper.toHomeworkEntity(homeworkDto);
        homework.setLesson(lesson);
        homework = homeworkRepository.save(homework);
        return entityMapper.toHomeworkDto(homework);
    }
}
