package kz.example.educationSystems.web.rest;

import kz.example.educationSystems.service.*;
import kz.example.educationSystems.web.dtos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {

    private final SubjectService subjectService;
    private final LessonService lessonService;
    private final HomeworkSubmissionService homeworkSubmissionService;
    private final TestSubmissionService testSubmissionService;
    private final TopicService topicService;

    // Просмотр предметов, к которым прикреплен ученик
    @GetMapping("/{studentId}/subjects")
    public List<SubjectDto> getSubjectsForStudent(@PathVariable Long studentId) {
        return subjectService.getSubjectsByStudentId(studentId);
    }

    // Просмотр тем по предмету
    @GetMapping("/subjects/{subjectId}/topics")
    public List<TopicDto> getTopicsBySubject(@PathVariable Long subjectId) {
        return topicService.getTopicsBySubjectId(subjectId);
    }

    // Просмотр уроков по теме
    @GetMapping("/topics/{topicId}/lessons")
    public List<LessonDto> getLessonsByTopic(@PathVariable Long topicId) {
        return lessonService.getLessonsByTopicId(topicId);
    }

    // Просмотр урока
    @GetMapping("/lessons/{lessonId}")
    public LessonDto getLessonById(@PathVariable Long lessonId) {
        return lessonService.getLessonById(lessonId);
    }

    // Выполнение домашнего задания
    @PostMapping("/homeworks/{homeworkId}/submissions")
    public HomeworkSubmissionDto submitHomework(@PathVariable Long homeworkId, @RequestBody HomeworkSubmissionDto submissionDto) {
        return homeworkSubmissionService.submitHomework(homeworkId, submissionDto);
    }

    // Прохождение теста
    @PostMapping("/tests/{testId}/submissions")
    public TestSubmissionDto submitTest(@PathVariable Long testId, @RequestBody TestSubmissionDto submissionDto) {
        return testSubmissionService.submitTest(testId, submissionDto);
    }

    // Просмотр результатов теста
    @GetMapping("/tests/{testId}/submissions/{studentId}")
    public TestSubmissionDto getTestResults(@PathVariable Long testId, @PathVariable Long studentId) {
        return testSubmissionService.getTestResults(testId, studentId);
    }
}
