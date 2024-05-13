package pe.edu.vallegrande.academy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.academy.dto.AuxiliaryRecordDetailDto;
import pe.edu.vallegrande.academy.model.AuxiliaryRecordDetail;
import pe.edu.vallegrande.academy.repository.AuxiliaryRecordDetailRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AuxiliaryRecordDetailService {

    @Autowired
    private AuxiliaryRecordDetailRepository auxiliaryRecordDetailRepository;

    public Flux<AuxiliaryRecordDetailDto> getAll() {
        return auxiliaryRecordDetailRepository.getAll();
    }

    public Flux<AuxiliaryRecordDetail> saveAll(Flux<AuxiliaryRecordDetail> auxiliaryRecordDetails) {
        return auxiliaryRecordDetailRepository.saveAll(auxiliaryRecordDetails);
    }
}
