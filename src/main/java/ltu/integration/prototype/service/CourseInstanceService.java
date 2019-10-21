package ltu.integration.prototype.service;

import ltu.integration.prototype.domain.CourseInstance;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseInstanceService {

    Mono<CourseInstance> findById(Long id);
    Flux<CourseInstance> findAll();
    Flux<CourseInstance> findByName(String name);

    /**
     * This is the service that delivers the lookup required by the assignment.
     *
     * @param courseCode    The course-code for the {@code Course}
     * @param semester      The semester in which the sought {@code CourseInstance} was given
     * @return              A mono emitting a {@code CourseInstance} if a match was found, otherwise emits a {@code null}
     */
    Mono<CourseInstance> findByCourseCodeAndSemester(String courseCode, String semester);
}
