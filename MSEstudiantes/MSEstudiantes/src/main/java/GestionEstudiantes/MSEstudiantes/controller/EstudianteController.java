package GestionEstudiantes.MSEstudiantes.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import GestionEstudiantes.MSEstudiantes.model.EstudianteModel;
import GestionEstudiantes.MSEstudiantes.service.EstudianteService;
import jakarta.validation.Valid;
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
        
        return estudianteService.findAll();
    }
    

    @PostMapping("/create")
    public EstudianteModel create(@Valid @RequestBody EstudianteModel model)
    {   
        return estudianteService.add(model);
    }

    // findById
    @GetMapping("/findById/{id}")
    public EstudianteModel findById(@PathVariable Integer id) {
        return estudianteService.findById(id);
    }

    // update
    @PutMapping("/update/{id}")
    public EstudianteModel update(@PathVariable Long id, @Valid @RequestBody EstudianteModel model) {
        model.setId(id);
        return estudianteService.update(model);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        estudianteService.delete(id);
        return "Estudiante eliminado con éxito";
    }
}
