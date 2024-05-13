package pe.edu.vallegrande.academy.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "competence")
@Getter
@Setter
public class Competence {
    @Id
    @Column(value = "id")
    private Long id;

    @Column(value = "name")
    private String name;

    @Column(value = "status")
    private String status;
}
