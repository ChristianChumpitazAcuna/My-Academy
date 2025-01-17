package pe.edu.vallegrande.academy.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@Setter
public class AuxiliaryRecordDetailDto {
    private Long id;

    private String student;

    private Long[] notes;
}
