package pe.edu.vallegrande.academy.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "student")
@Getter
@Setter
public class Student {
    @Id
    @Column(value = "id")
    private Long id;

    @Column(value = "name")
    private String name;

    @Column(value = "last_name")
    private String lastName;

    @Column(value = "email")
    private String email;

    @Column(value = "status")
    private String status;

    @Column(value = "grade_id")
    private Long grade;
}
