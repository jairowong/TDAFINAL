package GestionEstudiantes.MSEstudiantes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import GestionEstudiantes.MSEstudiantes.model.EstudianteModel;
import GestionEstudiantes.MSEstudiantes.service.EstudianteService;
import GestionEstudiantes.MSEstudiantes.router.RouterApi;

@RestController
@RequestMapping(RouterApi.ESTUDIANTE)
public class EstudianteController {

    @Autowired
    EstudianteService estudianteService;

    // Método para listar estudiantes
    @GetMapping("/findAll")
    public List<EstudianteModel> FindAll()
    {
        List<EstudianteModel> lista = estudianteService.findAll();
        return lista;
    }
    

    @PostMapping("/create")
    public  ResponseEntity<?> create(@Valid @RequestBody EstudianteModel model)
    {   
        return ResponseEntity.ok(estudianteService.add(model));
    }

    // findById
    @GetMapping("/findById/{id}")
    public  ResponseEntity<?> findById(@Valid @RequestBody EstudianteModel model)
    {
        return ResponseEntity.ok(estudianteService.add(model));
    }

    // update
    @PutMapping("/update/{id}")
    public  ResponseEntity<?> update(@Valid @RequestBody EstudianteModel model)
    {
        return ResponseEntity.ok(estudianteService.add(model));
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> delete(@Valid @RequestBody EstudianteModel model)
     {
        return ResponseEntity.ok(estudianteService.add(model));
    }
}
