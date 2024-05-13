package pe.edu.vallegrande.academy.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.academy.dto.AuxiliaryRecordDto;
import reactor.core.publisher.Flux;

@Repository
public interface AuxiliaryRecordRepository extends ReactiveCrudRepository<AuxiliaryRecordRepository, Long>{

    @Query("select \n" +
            "  ar.id,\n" +
            "  c.name as course,\n" +
            "  comp.name as competence,\n" +
            "  s.name as student\n" +
            "from auxiliary_record ar\n" +
            "join course_competence cc\n" +
            "  on ar.course_competence_id = cc.id\n" +
            "\n" +
            "join course c\n" +
            "  on cc.course_id = c.id\n" +
            "\n" +
            "join competence comp\n" +
            "  on cc.competence_id = comp.id\n" +
            "\n" +
            "join student s\n" +
            "  on ar.student_id = s.id\n" +
            "where ar.status = :status;")
    Flux<AuxiliaryRecordDto>findByStatus(String status);
}
