package pe.edu.vallegrande.academy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.academy.model.Student;
import pe.edu.vallegrande.academy.repository.StudentRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Flux<Student> findInactives() {
        return studentRepository.findByStatus("I");
    }

    public Flux<Student> findActivess() {
        return studentRepository.findByStatus("A");
    }

    public Mono<Student> save(Student student) {
        return studentRepository.save(student);
    }

    public Mono<Student> delete(Long id) {
        return studentRepository.updateStatus(id, "I");
    }

    public Mono<Student> activate(Long id) {
        return studentRepository.updateStatus(id, "A");
    }

    public Mono<Student> update(Long id, Student student) {
        return studentRepository.findById(id)
                .flatMap(existingStudent -> {
                    if (student.getName() != null) {
                        existingStudent.setName(student.getName());
                    }
                    if (student.getLastName() != null) {
                        existingStudent.setLastName(student.getLastName());
                    }
                    if (student.getEmail() != null) {
                        existingStudent.setEmail(student.getEmail());
                    }
                    if (student.getGrade() != null) {
                        existingStudent.setGrade(student.getGrade());
                    }
                    return studentRepository.save(existingStudent);
                });
    }
}
