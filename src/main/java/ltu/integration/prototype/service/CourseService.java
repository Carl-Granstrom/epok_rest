package ltu.integration.prototype.service;

import ltu.integration.prototype.domain.Course;
import ltu.integration.prototype.domain.CourseInstance;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseService {

    /**
     * Find all courses in the database.
     *
     * @return A Flux emitting courses.
     */
    Flux<CourseInstance> findAll();

    /**
     * Find a course by name.
     *
     * @return A Flux emitting courses.
     */
    Flux<CourseInstance> findByName(String name);

    /**
     * Create a course in the database.
     */
    Mono<Course> save(Course course);

}
