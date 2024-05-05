package pe.edu.vallegrande.academy.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "grade")
@Getter
@Setter
public class Grade {

    @Id
    @Column(value = "id")
    private Long id;

    @Column(value = "grade")
    private String grade;

    @Column(value = "section")
    private String section;

    @Column(value = "academic_level")
    private String academicLevel;

    @Column(value = "status")
    private String status;
}
