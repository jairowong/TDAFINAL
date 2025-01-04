package GestionEstudiantes.MSEstudiantes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import GestionEstudiantes.MSEstudiantes.service.EstudianteService;
import GestionEstudiantes.MSEstudiantes.router.RouterApi;

@RestController
@RequestMapping(RouterApi.DOCUMENTACION)
public class DocumentacionController {

    @Autowired
    DocumentacionService documentacionService;

    // Método para listar documentos
    @GetMapping("/findAll")
    public List<EstudianteModel> FindAll()
    {
        List<EstudianteModel> lista = estudianteService.findAll();
        return lista;
    }
    

    @PostMapping("/create")
    public EstudianteModel create(@RequestBody EstudianteModel model)
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
    public EstudianteModel update(@PathVariable Long id, @RequestBody EstudianteModel model) {
        model.setIdEstudiante(id);
        return estudianteService.update(model);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        estudianteService.delete(id);
        return "Estudiante eliminado con éxito";
    }
}
