package pe.edu.vallegrande.academy.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "course_competence")
@Getter
@Setter
public class CourseCompetence {
    @Id
    @Column(value = "id")
    private Long id;

    @Column(value = "course_id")
    private Long courseId;

    @Column(value = "competence_id")
    private Long competenceId;
}
