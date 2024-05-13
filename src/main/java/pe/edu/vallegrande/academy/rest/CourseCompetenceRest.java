package pe.edu.vallegrande.academy.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.vallegrande.academy.dto.CourseCompetenceDto;
import pe.edu.vallegrande.academy.service.CourseCompetenceService;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("MyAcademy/courseCompetence")
public class CourseCompetenceRest {

    @Autowired
    private CourseCompetenceService courseCompetenceService;

    @GetMapping("/actives")
    public ResponseEntity<Flux<CourseCompetenceDto>> findAllActives() {
        return ResponseEntity.ok(courseCompetenceService.getActive());
    }

    @GetMapping("/inactives")
    public ResponseEntity<Flux<CourseCompetenceDto>> findAllInactives() {
        return ResponseEntity.ok(courseCompetenceService.getInactive());
    }
}
