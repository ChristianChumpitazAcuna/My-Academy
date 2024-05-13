package pe.edu.vallegrande.academy.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.academy.model.Competence;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CompetenceRepository extends ReactiveCrudRepository<Competence, Long> {

    @Query(value = "UPDATE competence SET status = :status WHERE id = :id")
    Mono<Competence> updateStatus(Long id, String status);

    @Query(value = "SELECT * FROM competence WHERE status = :status")
    Flux<Competence> findByStatus(String status);
}
