package pe.edu.vallegrande.academy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.academy.dto.CourseCompetenceDto;
import pe.edu.vallegrande.academy.repository.CourseCompetenceRepository;
import reactor.core.publisher.Flux;

@Service
public class CourseCompetenceService {
    @Autowired
    private CourseCompetenceRepository courseCompetenceRepository;

    public Flux<CourseCompetenceDto> getActive() {
        return courseCompetenceRepository.findByStatus("A");
    }

    public Flux<CourseCompetenceDto> getInactive() {
        return courseCompetenceRepository.findByStatus("I");
    }
}
