package GestionEstudiantes.MSEstudiantes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import GestionEstudiantes.MSEstudiantes.model.ApoderadoModel;
import GestionEstudiantes.MSEstudiantes.router.RouterApi;
import GestionEstudiantes.MSEstudiantes.service.ApoderadoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(RouterApi.APODERADO)
public class ApoderadoController {

    @Autowired
    ApoderadoService apoderadoService;

    // Método para listar Apoderados
    @GetMapping("/findAll")
    public List<ApoderadoModel> FindAll()
    {
        List<ApoderadoModel> lista = apoderadoService.findAll();
        return lista;
    }
    

    @PostMapping("/create")
    public ApoderadoModel create(@Valid @RequestBody ApoderadoModel model)
    {   
        return apoderadoService.add(model);
    }

    // findById
    @GetMapping("/findById/{id}")
    public ApoderadoModel findById(@PathVariable Integer id) {
        return apoderadoService.findById(id);
    }

    // update
    @PutMapping("/update/{id}")
    public ApoderadoModel update(@PathVariable Long id, @Valid @RequestBody ApoderadoModel model) {
        model.setId(id);
        return apoderadoService.update(model);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        apoderadoService.delete(id);
        return "Apoderado eliminado con éxito";
    }
}

