package GestionMatricula.MSMatricula.controllers;

import java.util.List;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import GestionMatricula.MSMatricula.model.Vacante;
import GestionMatricula.MSMatricula.route.Ruta;
import GestionMatricula.MSMatricula.service.VacanteServiceIpm;


@RestController


public class VacanteController {

    public static final Logger log=LoggerFactory.getLogger(VacanteController.class);

    @Autowired
    VacanteServiceIpm servicioIpm;

    @GetMapping()

    public ResponseEntity<List<Vacante>> mostrarVacantes(){
        

        try {
            log.info("listado de vacante");
            List<Vacante> lista=servicioIpm.mostrarVacante();
            if (lista.isEmpty()) {
               log.warn("nose encontro lista de vacantes");
               return ResponseEntity.notFound().build();
            }
             return ResponseEntity.ok(lista);
        } catch (Exception e) {
            log.error("error inesperado", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @GetMapping()

    public ResponseEntity<?> mostrarVacantes(@PathVariable Integer id){

        try {
            Vacante alum = servicioIpm.mostrarVacanteID(id);
            if(alum !=null){
                log.info("vacante encontrada");
                return ResponseEntity.ok(alum);
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id invalido");
            }
           
        } catch (Exception e) {
            log.error("vacante no encontrada", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

     @PostMapping()





    @DeleteMapping()

        public ResponseEntity<String> eliminarVacantes (@PathVariable Integer id){

            try {
                servicioIpm.eliminarVacante(id);
                log.info("vacante elimnada correctamente");
                return ResponseEntity.ok("vacante eliminada");
                
            } catch (Exception e) {
                log.error("nose pudo eliminar la vacante", e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("vacante no eliminada");
            }

        }

}
