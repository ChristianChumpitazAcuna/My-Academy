package pe.edu.vallegrande.academy.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.academy.dto.AuxiliaryRecordDetailDto;
import pe.edu.vallegrande.academy.model.AuxiliaryRecordDetail;
import reactor.core.publisher.Flux;

@Repository
public interface AuxiliaryRecordDetailRepository extends ReactiveCrudRepository<AuxiliaryRecordDetail, Long> {

    @Query("select\n" +
            "  ar.id as id,\n" +
            "  s.name as student,\n" +
            "  ARRAY_AGG(ard.note) as notes\n" +
            "from auxiliary_record_detail ard\n" +
            "join auxiliary_record ar\n" +
            "  on ard.auxiliary_record_id = ar.id\n" +
            "join student s\n" +
            "  on ar.student_id = s.id\n" +
            "group by s.name, ar.id;")
    Flux<AuxiliaryRecordDetailDto> getAll();
}
