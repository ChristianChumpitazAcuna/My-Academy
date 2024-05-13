package pe.edu.vallegrande.academy.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "course")
@Getter
@Setter
public class Course {
    @Id
    @Column(value = "id")
    private Long id;

    @Column(value = "name")
    private String name;

    @Column(value = "academic_program")
    private String academicProgram;

    @Column(value = "module")
    private String module;

    @Column(value = "status")
    private String status;
}
