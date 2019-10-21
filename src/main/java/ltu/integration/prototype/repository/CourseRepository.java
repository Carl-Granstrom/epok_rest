package ltu.integration.prototype.repository;

import ltu.integration.prototype.domain.Course;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface CourseRepository extends ReactiveCrudRepository<Course, UUID> {

    Flux<Course> findByName(String name);
}
