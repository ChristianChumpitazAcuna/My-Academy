package pe.edu.vallegrande.academy.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "auxiliary_record")
@Getter
@Setter
public class AuxiliaryRecord {
    @Id
    @Column(value = "id")
    private Long id;

    @Column(value = "course_competence_id")
    private Long courseCompetenceId;

    @Column(value = "student_id")
    private Long studentId;

    @Column(value = "status")
    private String status;
}
