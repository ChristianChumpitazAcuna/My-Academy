package pe.edu.vallegrande.academy.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.academy.model.Course;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CourseRepository extends ReactiveCrudRepository<Course, Long> {

    @Query(value = "UPDATE course SET status = :status WHERE id = :id")
    Mono<Course> updateStatus(Long id, String status);

    @Query(value = "SELECT * FROM course WHERE status = :status")
    Flux<Course> findByStatus(String status);
}
