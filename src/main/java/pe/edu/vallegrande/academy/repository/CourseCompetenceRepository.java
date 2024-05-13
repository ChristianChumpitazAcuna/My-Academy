package pe.edu.vallegrande.academy.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.academy.dto.CourseCompetenceDto;
import pe.edu.vallegrande.academy.model.CourseCompetence;
import reactor.core.publisher.Flux;

@Repository
public interface CourseCompetenceRepository extends ReactiveCrudRepository<CourseCompetence, Long> {


    @Query("SELECT \n" +
            "  cc.id,\n" +
            "  c.name AS course,\n" +
            "  comp.name AS competence\n" +
            "FROM course_competence cc\n" +
            "JOIN course c\n" +
            "  ON cc.course_id = c.id\n" +
            "JOIN competence comp\n" +
            "  ON cc.competence_id = comp.id\n" +
            "WHERE cc.status = :status;")
    Flux<CourseCompetenceDto> findByStatus(String status);
}
