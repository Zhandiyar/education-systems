package kz.example.educationSystems.service;

import kz.example.educationSystems.mapper.EntityMapper;
import kz.example.educationSystems.model.StudentSubject;
import kz.example.educationSystems.model.Subject;
import kz.example.educationSystems.repository.StudentSubjectRepository;
import kz.example.educationSystems.repository.SubjectRepository;
import kz.example.educationSystems.web.dtos.SubjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentSubjectService {

    private final StudentSubjectRepository studentSubjectRepository;
    private final SubjectRepository subjectRepository;
    private final EntityMapper entityMapper;

    @Transactional
    public void attachStudentToSubject(Long subjectId, Long studentId) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new NoSuchElementException("Subject not found"));


        StudentSubject studentSubject = new StudentSubject();
        studentSubject.setSubject(subject);
        studentSubjectRepository.save(studentSubject);
    }
}
