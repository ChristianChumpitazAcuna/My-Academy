package pe.edu.vallegrande.academy.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pe.edu.vallegrande.academy.model.Student;
import pe.edu.vallegrande.academy.repository.StudentRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AppsScriptService {

    @Autowired
    private StudentRepository studentRepository;

    private final String SCRIPT_ID = "AKfycbyhUeEXow4MrVBnU1BgfRiA5K-J4w6UocZqZ78-XbodY7mxzP7K8Jvl0Hm2hFMwEuNq";

    public Mono<String> generatePdf() {

        Flux<Student> students = studentRepository.findByStatus("A");

        String URL = "https://script.google.com/macros/s/" + SCRIPT_ID + "/exec";

        WebClient webClient = WebClient.create();

        ObjectMapper objectMapper = new ObjectMapper();

        return students.collectList().flatMap(list -> {
            try {
                String json = objectMapper.writeValueAsString(list);
                return webClient.post()
                        .uri(URL)
                        .body(Mono.just(json), String.class)
                        .retrieve()
                        .bodyToMono(String.class);
            } catch (Exception e) {
                return Mono.error(new RuntimeException(e));
            }
        });
    }
}
