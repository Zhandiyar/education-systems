package kz.example.educationSystems.web.rest;

import kz.example.educationSystems.service.*;
import kz.example.educationSystems.web.dtos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teachers")
public class TeacherController {

    private final SubjectService subjectService;
    private final LessonService lessonService;
    private final HomeworkService homeworkService;
    private final TestService testService;
    private final StudentSubjectService studentSubjectService;
    private final HomeworkSubmissionService homeworkSubmissionService;
    private final TestSubmissionService testSubmissionService;
    private final TopicService topicService;

    // Создание предмета
    @PostMapping("/subjects")
    public SubjectDto createSubject(@RequestBody SubjectDto subjectDto) {
        return subjectService.createSubject(subjectDto);
    }

    // Создание темы по предмету
    @PostMapping("/subjects/{subjectId}/topics")
    public TopicDto createTopic(@PathVariable Long subjectId, @RequestBody TopicDto topicDto) {
        return topicService.createTopic(subjectId, topicDto);
    }

    // Создание урока по теме
    @PostMapping("/topics/{topicId}/lessons")
    public LessonDto createLesson(@PathVariable Long topicId, @RequestBody LessonDto lessonDto) {
        return lessonService.createLesson(topicId, lessonDto);
    }

    // Создание домашнего задания к уроку
    @PostMapping("/lessons/{lessonId}/homeworks")
    public HomeworkDto createHomework(@PathVariable Long lessonId, @RequestBody HomeworkDto homeworkDto) {
        return homeworkService.createHomework(lessonId, homeworkDto);
    }

    // Создание теста по теме
    @PostMapping("/topics/{topicId}/tests")
    public TestDto createTest(@PathVariable Long topicId, @RequestBody TestDto testDto) {
        return testService.createTest(topicId, testDto);
    }

    // Прикрепление ученика к предмету
    @PostMapping("/subjects/{subjectId}/students/{studentId}")
    public void attachStudentToSubject(@PathVariable Long subjectId, @PathVariable Long studentId) {
        studentSubjectService.attachStudentToSubject(subjectId, studentId);
    }

    // Просмотр исполнения домашнего задания
    @GetMapping("/homeworks/{homeworkId}/submissions")
    public List<HomeworkSubmissionDto> getHomeworkSubmissions(@PathVariable Long homeworkId) {
        return homeworkSubmissionService.getHomeworkSubmissionsByHomeworkId(homeworkId);
    }

    // Просмотр количества правильных ответов в тесте
    @GetMapping("/tests/{testId}/submissions")
    public List<TestSubmissionDto> getTestSubmissions(@PathVariable Long testId) {
        return testSubmissionService.getSubmissionsByTestId(testId);
    }
}
