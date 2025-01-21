package GestionEstudiantes.MSEstudiantes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import GestionEstudiantes.MSEstudiantes.model.DocumentacionModel;
import GestionEstudiantes.MSEstudiantes.router.RouterApi;
import GestionEstudiantes.MSEstudiantes.service.IDocumentacionService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(RouterApi.DOCUMENTACION)
public class DocumentacionController {

    @Autowired
    private IDocumentacionService documentacionService;

    // Método para listar documentos
    @GetMapping("/findAll")
    public ResponseEntity<List<DocumentacionModel>> findAll() {
        List<DocumentacionModel> lista = documentacionService.findAll();
        return ResponseEntity.ok(lista);
    }

    // Crear Documento
    @PostMapping("/create")
    public ResponseEntity<DocumentacionModel> create(@Valid @RequestBody DocumentacionModel model) {   
        DocumentacionModel createdDocumentacion = documentacionService.add(model);
        return ResponseEntity.ok(createdDocumentacion);
    }

    // Buscar Documento por ID
    @GetMapping("/findById/{id}")
    public ResponseEntity<DocumentacionModel> findById(@PathVariable Long id) {
        DocumentacionModel documentacion = documentacionService.findById(id);
        if (documentacion != null) {
            return ResponseEntity.ok(documentacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar Documento
    @PutMapping("/update/{id}")
    public ResponseEntity<DocumentacionModel> update(@PathVariable Long id, @Valid @RequestBody DocumentacionModel model) {
        DocumentacionModel updatedDocumentacion = documentacionService.update(id, model);
        if (updatedDocumentacion != null) {
            return ResponseEntity.ok(updatedDocumentacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar Documento
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean isDeleted = documentacionService.delete(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
