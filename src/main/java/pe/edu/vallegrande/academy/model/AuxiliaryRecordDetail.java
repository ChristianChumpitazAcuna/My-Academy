package pe.edu.vallegrande.academy.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "auxiliary_record_detail")
@Getter
@Setter
public class AuxiliaryRecordDetail {

    @Id
    @Column(value = "id")
    private Long id;

    @Column(value = "note")
    private Long note;

    @Column(value = "auxiliary_record_id")
    private Long auxiliaryRecordId;
}
