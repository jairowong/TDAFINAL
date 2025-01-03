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

import GestionEstudiantes.MSEstudiantes.service.DocumentacionService;
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
    public DocumentacionModel create(@RequestBody DocumentacionModel model)
    {   
        return documentacionService.add(model);
    }

    // findById
    @GetMapping("/findById/{id}")
    public DocumentacionModel findById(@PathVariable Integer id) {
        return documentacionService.findById(id);
    }

    // update
    @PutMapping("/update/{id}")
    public DocumentacionModel update(@PathVariable Long id, @RequestBody DocumentacionModel model) {
        model.setIdDocumentacion(id);
        return documentacionService.update(model);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        documentacionService.delete(id);
        return "Estudiante eliminado con éxito";
    }
}
