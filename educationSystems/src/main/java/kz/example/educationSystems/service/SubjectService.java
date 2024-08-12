package kz.example.educationSystems.service;

import jakarta.transaction.Transactional;
import kz.example.educationSystems.mapper.EntityMapper;
import kz.example.educationSystems.model.StudentSubject;
import kz.example.educationSystems.model.Subject;
import kz.example.educationSystems.model.Topic;
import kz.example.educationSystems.repository.StudentSubjectRepository;
import kz.example.educationSystems.repository.SubjectRepository;
import kz.example.educationSystems.repository.TopicRepository;
import kz.example.educationSystems.web.dtos.SubjectDto;
import kz.example.educationSystems.web.dtos.TopicDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final StudentSubjectRepository studentSubjectRepository;
    private final EntityMapper entityMapper;

    @Transactional
    public SubjectDto createSubject(SubjectDto subjectDto) {
        Subject subject = entityMapper.toSubjectEntity(subjectDto);
        subject = subjectRepository.save(subject);
        return entityMapper.toSubjectDto(subject);
    }

    public List<SubjectDto> getSubjectsByStudentId(Long studentId) {
        return studentSubjectRepository.findByStudentId(studentId)
                .stream()
                .map(StudentSubject::getSubject)
                .map(entityMapper::toSubjectDto)
                .collect(Collectors.toList());
    }
}
