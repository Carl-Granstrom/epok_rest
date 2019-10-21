package ltu.integration.prototype.service;

import lombok.RequiredArgsConstructor;
import ltu.integration.prototype.domain.Course;
import ltu.integration.prototype.domain.CourseInstance;
import ltu.integration.prototype.repository.CourseInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CourseInstanceServiceImplementation implements CourseInstanceService{

    @Autowired
    private final CourseInstanceRepository courseInstanceRepository;

    @Override
    public Flux<CourseInstance> findAll() {
        return courseInstanceRepository.findAll();
    }

    @Override
    public Flux<CourseInstance> findByName(String name){
        return courseInstanceRepository.findByName(name);
    }

    @Override
    public Mono<CourseInstance> findById(Long id){return courseInstanceRepository.findById(id);}

    /**
     * The implementation part of the database service to return a CourseInstance given a {@code courseCode} and a
     * {@code semester}.
     *
     * @param courseCode    The course-code for the {@code Course}
     * @param semester      The semester in which the sought {@code CourseInstance} was given
     * @return              A Mono emitting the {@code CourseInstance} if found
     */
    @Override
    public Mono<CourseInstance> findByCourseCodeAndSemester(String courseCode, String semester){
        return courseInstanceRepository.findByCourseCodeAndSemester(courseCode, semester);
    }

    @Transactional
    public Mono<CourseInstance> save(CourseInstance courseInstance) {
        return courseInstanceRepository.save(courseInstance);
    }
}
