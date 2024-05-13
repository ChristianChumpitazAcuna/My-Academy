package pe.edu.vallegrande.academy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.academy.dto.AuxiliaryRecordDto;
import pe.edu.vallegrande.academy.repository.AuxiliaryRecordRepository;
import reactor.core.publisher.Flux;

@Service
public class AuxiliaryRecordService {

    @Autowired
    private AuxiliaryRecordRepository auxiliaryRecordRepository;

    public Flux<AuxiliaryRecordDto> getActive() {
        return auxiliaryRecordRepository.findByStatus("A");
    }
}
