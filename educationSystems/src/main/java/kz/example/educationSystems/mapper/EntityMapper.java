package kz.example.educationSystems.mapper;

import kz.example.educationSystems.model.*;
import kz.example.educationSystems.web.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface EntityMapper {

    // Homework
    @Mapping(source = "lesson.id", target = "lessonId")
    HomeworkDto toHomeworkDto(Homework homework);

    @Mapping(source = "lessonId", target = "lesson.id")
    Homework toHomeworkEntity(HomeworkDto homeworkDto);

    // HomeworkSubmission
    @Mapping(source = "homework.id", target = "homeworkId")
    @Mapping(source = "student.id", target = "studentId")
    HomeworkSubmissionDto toHomeworkSubmissionDto(HomeworkSubmission homeworkSubmission);

    @Mapping(source = "homeworkId", target = "homework.id")
    @Mapping(source = "studentId", target = "student.id")
    HomeworkSubmission toHomeworkSubmissionEntity(HomeworkSubmissionDto homeworkSubmissionDto);

    // Lesson
    @Mapping(source = "topic.id", target = "topicId")
    LessonDto toLessonDto(Lesson lesson);

    @Mapping(source = "topicId", target = "topic.id")
    Lesson toLessonEntity(LessonDto lessonDto);

    // StudentSubject
    @Mapping(source = "student.id", target = "studentId")
    @Mapping(source = "subject.id", target = "subjectId")
    StudentSubjectDto toStudentSubjectDto(StudentSubject studentSubject);

    @Mapping(source = "studentId", target = "student.id")
    @Mapping(source = "subjectId", target = "subject.id")
    StudentSubject toStudentSubjectEntity(StudentSubjectDto studentSubjectDto);

    // Subject
    SubjectDto toSubjectDto(Subject subject);

    Subject toSubjectEntity(SubjectDto subjectDto);

    // Test
    @Mapping(source = "topic.id", target = "topicId")
    TestDto toTestDto(Test test);

    @Mapping(source = "topicId", target = "topic.id")
    Test toTestEntity(TestDto testDto);

    // TestSubmission
    @Mapping(source = "test.id", target = "testId")
    @Mapping(source = "student.id", target = "studentId")
    TestSubmissionDto toTestSubmissionDto(TestSubmission testSubmission);

    @Mapping(source = "testId", target = "test.id")
    @Mapping(source = "studentId", target = "student.id")
    TestSubmission toTestSubmissionEntity(TestSubmissionDto testSubmissionDto);

    // Topic
    @Mapping(source = "subject.id", target = "subjectId")
    TopicDto toTopicDto(Topic topic);

    @Mapping(source = "subjectId", target = "subject.id")
    Topic toTopicEntity(TopicDto topicDto);
}

