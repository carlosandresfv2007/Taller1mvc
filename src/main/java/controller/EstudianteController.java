package controller;

// Capa de presentación. Expone los endpoints REST y delega la lógica al Service.
// POST retorna 201 Created en éxito o 400 Bad Request si el ID ya existe.
// GET retorna 200 OK con la lista completa de estudiantes registrados.



import model.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.EstudianteService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteSerrvice;

    @PostMapping
    public ResponseEntity<?> registrarEstudiante(@RequestBody Estudiante estudiante) {
        try {
            Estudiante registrado = estudianteSerrvice.registrarEstudiante(estudiante);
            Map<String, Object> response = new HashMap<>();
            response.put("mensaje", "Estudiante registrado exitosamente");
            response.put("estudiante", registrado);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @GetMapping
    public ResponseEntity<List<Estudiante>> listarEstudiantes() {
        return ResponseEntity.ok(estudianteSerrvice.listarEstudiantes());
    }
}
