package GestionMatricula.MSMatricula.controllers;

import java.util.List;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



import GestionMatricula.MSMatricula.model.Vacante;
import GestionMatricula.MSMatricula.service.VacanteServiceIpm;


@Controller
@RequestMapping("apivacante")

public class VacanteController {

    public static final Logger log=LoggerFactory.getLogger(VacanteController.class);

    @Autowired
    VacanteServiceIpm servicioIpm;

    @GetMapping("/listarvacante")

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

    @GetMapping("/api/mostrarvacante/{id}")

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

      @PostMapping("/api/crearvacantes")

    public ResponseEntity<?> crearvacantes(@RequestBody Vacante vaca){
        try {
            if (vaca.getAño_alectivo()==null || vaca.getVacantes_disponibles()==0 || vaca.getIdseccion()==0) {
                log.error("nose pudo crear la vacante");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("nose creo la vacante");      
            }log.info("vacante creada");
            return ResponseEntity.status(HttpStatus.CREATED).body(servicioIpm.crearVacante(vaca));
        } catch (Exception e) {
            log.error("vacante no creada", e );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("nose creo la vacante");
        }
    }

     @PutMapping("/api/modificarVacante/{id}")

    public ResponseEntity<?> modificarVacante(@PathVariable Integer id, @RequestBody Vacante vaca){

        Vacante modiVaca = new Vacante();
        if (vaca.getAño_alectivo()==null) {
            log.error("nose pudo modificar la vacante");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("nose creo la vacante");            
        }  try {
            
            modiVaca.setVacantes_disponibles(vaca.getVacantes_disponibles());
            modiVaca.setAño_alectivo(vaca.getAño_alectivo());

            Vacante vacanteModificado = servicioIpm.modificarVacante(modiVaca);
            if (vacanteModificado == null) {
                log.error("nose modifico la vacante");
                return ResponseEntity.notFound().build();
            } else{
                log.info("se modifico la vacante");
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("vacante modificada");
            }
        } catch (Exception e) {
            log.error("vacante no modificada", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("vacante no modificado");
        }

    }
   
    @DeleteMapping("/api/eliminarvacante/{id}")

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
