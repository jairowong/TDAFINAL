package GestionEstudiantes.MSEstudiantes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import GestionEstudiantes.MSEstudiantes.model.EstudianteModel;
import GestionEstudiantes.MSEstudiantes.service.EstudianteService;
import GestionEstudiantes.MSEstudiantes.router.RouterApi;

@RestController
@RequestMapping(RouterApi.ESTUDIANTE)
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    // Método para listar estudiantes
    @GetMapping("/findAll")
    public List<EstudianteModel> findAll() {
        return estudianteService.findAll();
    }

    // Crear estudiante
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody EstudianteModel model) {   
        EstudianteModel createdEstudiante = estudianteService.add(model);
        return ResponseEntity.ok(createdEstudiante);
    }

    // Buscar estudiante por ID
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) { // Usar Long
        EstudianteModel estudiante = estudianteService.findById(id);
        if (estudiante != null) {
            return ResponseEntity.ok(estudiante);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar estudiante
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody EstudianteModel model) { // Usar Long
        EstudianteModel updatedEstudiante = estudianteService.update(id, model);
        if (updatedEstudiante != null) {
            return ResponseEntity.ok(updatedEstudiante);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar estudiante
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) { // Usar Long
        boolean isDeleted = estudianteService.delete(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
