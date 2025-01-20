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
    public  ResponseEntity<?> create(@Valid @RequestBody ApoderadoModel model)
    {   
        return ResponseEntity.ok(apoderadoService.add(model));
    }

    // findById
    @GetMapping("/findById/{id}")
    public  ResponseEntity<?> findById( @RequestBody ApoderadoModel model)
    {
        return ResponseEntity.ok(apoderadoService.add(model));
    }

    // update
    @PutMapping("/update/{id}")
    public  ResponseEntity<?> update(@Valid @RequestBody ApoderadoModel model)
     {
        return ResponseEntity.ok(apoderadoService.add(model));
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> delete(@RequestBody ApoderadoModel model) 
    {
        return ResponseEntity.ok(apoderadoService.add(model));
        
    }
}

