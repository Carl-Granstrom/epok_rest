package ltu.integration.prototype.service;

import lombok.RequiredArgsConstructor;
import ltu.integration.prototype.domain.Course;
import ltu.integration.prototype.domain.CourseInstance;
import ltu.integration.prototype.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CourseServiceImplementation implements CourseService{

    @Autowired
    private final CourseRepository courseRepository;

    @Override
    public Flux<CourseInstance> findAll() {
        return courseRepository.findAll();
    }

    public Flux<CourseInstance> findByName(String name){
        return courseRepository.findByName(name);
    }

    @Transactional
    public Mono<Course> save(Course course) {

        //Can be used to apply logic to saving the entity
        return courseRepository.save(course).map(c -> {
            return c;
        });
    }
}
