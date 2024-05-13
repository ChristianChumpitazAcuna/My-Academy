package pe.edu.vallegrande.academy.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.vallegrande.academy.dto.AuxiliaryRecordDto;
import pe.edu.vallegrande.academy.service.AuxiliaryRecordService;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("MyAcademy/auxiliaryRecord")
public class AuxiliaryRecordRest {

    @Autowired
    private AuxiliaryRecordService auxiliaryRecordService;

    @GetMapping("/actives")
    public ResponseEntity<Flux<AuxiliaryRecordDto>> findAllActives() {
        return ResponseEntity.ok(auxiliaryRecordService.getActive());
    }
}
