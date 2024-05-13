package pe.edu.vallegrande.academy.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.academy.model.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface StudentRepository extends ReactiveCrudRepository<Student, Long> {

    @Query(value = "UPDATE student SET status = :status WHERE id = :id")
    Mono<Student> updateStatus(Long id, String status);

    @Query(value = "SELECT * FROM student WHERE status = :status")
    Flux<Student> findByStatus(String status);

}
