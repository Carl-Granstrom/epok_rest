package ltu.integration.prototype.domain;

import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

/**
 * CourseInstance is fully denormalized because R2DBC does not support @OneToMany yet. This means every CourseInstance
 * must contain full course information.
 *
 * TODO Research how to implement manually. Probably a real headache kind of issue.
 * TODO add validation to university, signUpCode and semester because of format restrictions.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseInstance {


    //****************** Course Info ************************//

    @Basic
    @Column(name = "course_code", updatable = false, nullable = false)
    private String courseCode;

    @Basic
    @Column(name = "course_name")
    private String name;

    //on the form [UNI], for example: LTU, UME
    @Basic
    @Column(name = "university")
    private String university;


    //****************** CourseInstance Info ************************//

    @Id
    @Column(name = "course_instance_id", updatable = false, nullable = false)
    private Long id;

    //on the form [UNI]-[course_instance_id], for example: LTU-37012
    //todo just a composite of university and course_instance_id, so not really necessary, might still be convenient tho.
    @Basic
    @Column(name = "signup_code", updatable = false, nullable = false)
    private String signUpCode;

    //on the form [HT]/[VT] + [YY], for example: HT19 or VT11
    @Basic
    @Column(name = "semester", updatable = false, nullable = false)
    private String semester;

}
