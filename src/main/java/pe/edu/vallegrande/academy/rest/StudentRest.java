package pe.edu.vallegrande.academy.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.academy.model.Student;
import pe.edu.vallegrande.academy.service.AppsScriptService;
import pe.edu.vallegrande.academy.service.StudentService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("MyAcademy/student")
public class StudentRest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private AppsScriptService appsScriptService;

    @GetMapping("generatePdf")
    public Mono<ResponseEntity<String>> generatePdf() {
        return appsScriptService.generatePdf()
                .map(response -> ResponseEntity.ok("PDFs generados exitosamente: " + response))
                .onErrorReturn(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error al generar PDFs"));
    }

    @GetMapping("/actives")
    public ResponseEntity<Flux<Student>> findAllActives() {
        return ResponseEntity.ok(studentService.getActives());
    }

    @GetMapping("/inactives")
    public ResponseEntity<Flux<Student>> findAllInactives() {
        return ResponseEntity.ok(studentService.getInactives());
    }

    @PostMapping()
    public ResponseEntity<Mono<Student>> save(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.save(student));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Mono<Student>> update(@PathVariable Long id,
                                                @RequestBody Student student) {
        return ResponseEntity.ok(studentService.update(id, student));
    }

    @PatchMapping("restore/{id}")
    public ResponseEntity<Mono<Student>> activate(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.activate(id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Mono<Student>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.delete(id));
    }
}
