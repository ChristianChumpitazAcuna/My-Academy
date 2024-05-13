package pe.edu.vallegrande.academy.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.academy.dto.AuxiliaryRecordDetailDto;
import pe.edu.vallegrande.academy.model.AuxiliaryRecordDetail;
import pe.edu.vallegrande.academy.service.AuxiliaryRecordDetailService;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("MyAcademy/auxiliaryRecordDetail")
public class AuxiliaryRecordDetailRest {

    @Autowired
    private AuxiliaryRecordDetailService auxiliaryRecordDetailService;

    @GetMapping("/actives")
    public ResponseEntity<Flux<AuxiliaryRecordDetailDto>> findAllActives() {
        return ResponseEntity.ok(auxiliaryRecordDetailService.getAll());
    }

    @PostMapping()
    public Flux<AuxiliaryRecordDetail> saveAll(@RequestBody Flux<AuxiliaryRecordDetail> auxiliaryRecordDetails){
        return auxiliaryRecordDetailService.saveAll(auxiliaryRecordDetails);
}

}
