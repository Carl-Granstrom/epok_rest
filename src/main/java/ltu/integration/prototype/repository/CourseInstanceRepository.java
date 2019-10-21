package ltu.integration.prototype.repository;

import ltu.integration.prototype.domain.CourseInstance;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseInstanceRepository extends ReactiveCrudRepository<CourseInstance, Long> {

    Mono<CourseInstance> findById(Long id);
    Flux<CourseInstance> findAll();
    Flux<CourseInstance> findByName(String name);

    //This is the query which is used to return the course information according to the EPoK service-specification, from
    //which can be extracted the code for signing up to a course.
    Mono<CourseInstance> findByCourseCodeAndSemester(String courseCode, String semester);
}
