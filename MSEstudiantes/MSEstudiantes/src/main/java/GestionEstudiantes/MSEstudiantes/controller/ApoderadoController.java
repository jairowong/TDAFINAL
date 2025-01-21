package GestionEstudiantes.MSEstudiantes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import GestionEstudiantes.MSEstudiantes.model.ApoderadoModel;
import GestionEstudiantes.MSEstudiantes.router.RouterApi;
import GestionEstudiantes.MSEstudiantes.service.IApoderadoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(RouterApi.APODERADO)
public class ApoderadoController {

    @Autowired
    private IApoderadoService apoderadoService;

    // Método para listar Apoderados
    @GetMapping("/findAll")
    public ResponseEntity<List<ApoderadoModel>> findAll() {
        List<ApoderadoModel> lista = apoderadoService.findAll();
        return ResponseEntity.ok(lista);
    }

    // Crear Apoderado
    @PostMapping("/create")
    public ResponseEntity<ApoderadoModel> create(@Valid @RequestBody ApoderadoModel model) {   
        ApoderadoModel createdApoderado = apoderadoService.add(model);
        return ResponseEntity.ok(createdApoderado);
    }

    // Buscar Apoderado por ID
    @GetMapping("/findById/{id}")
    public ResponseEntity<ApoderadoModel> findById(@PathVariable Long id) {
        ApoderadoModel apoderado = apoderadoService.findById(id);
        if (apoderado != null) {
            return ResponseEntity.ok(apoderado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar Apoderado
    @PutMapping("/update/{id}")
    public ResponseEntity<ApoderadoModel> update(@PathVariable Long id, @Valid @RequestBody ApoderadoModel model) {
        ApoderadoModel updatedApoderado = apoderadoService.update(id, model);
        if (updatedApoderado != null) {
            return ResponseEntity.ok(updatedApoderado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar Apoderado
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean isDeleted = apoderadoService.delete(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
