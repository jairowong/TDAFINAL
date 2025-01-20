package GestionEstudiantes.MSEstudiantes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import GestionEstudiantes.MSEstudiantes.service.DocumentacionService;
import jakarta.validation.Valid;
import GestionEstudiantes.MSEstudiantes.model.DocumentacionModel;
import GestionEstudiantes.MSEstudiantes.router.RouterApi;

@RestController
@RequestMapping(RouterApi.DOCUMENTACION)
public class DocumentacionController {

    @Autowired
    DocumentacionService documentacionService;

    // Método para listar documentos
    @GetMapping("/findAll")
    public List<DocumentacionModel> FindAll()
    {
        List<DocumentacionModel> lista = documentacionService.findAll();
        return lista;
    }
    

    @PostMapping("/create")
     public  ResponseEntity<?> create(@Valid @RequestBody DocumentacionModel model)
    {   
        return ResponseEntity.ok(documentacionService.add(model));
    }

    // findById
    @GetMapping("/findById/{id}")
    public  ResponseEntity<?> findById(@Valid @RequestBody DocumentacionModel model) 
    {
        return ResponseEntity.ok(documentacionService.add(model));
    }

    // update
    @PutMapping("/update/{id}")
    public  ResponseEntity<?> update(@Valid @RequestBody DocumentacionModel model)
     {
        return ResponseEntity.ok(documentacionService.add(model));
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> delete(@Valid @RequestBody DocumentacionModel model)
    {
        return ResponseEntity.ok(documentacionService.add(model));   
    }
}
