package ltu.integration.prototype.domain;

import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue
    @Column(name = "course_id", updatable = false, nullable = false)
    private Long id;

    @NaturalId
    @Column(name = "course_code", updatable = false, nullable = false)
    private String courseCode;

    //Possibly requires hibernate, and not entirely necessary, remove if it causes problems
    @Column(nullable=false, unique=true)
    final private UUID uuid = UUID.randomUUID();

    @Basic
    @Column(name = "course_name")
    String name;

}
