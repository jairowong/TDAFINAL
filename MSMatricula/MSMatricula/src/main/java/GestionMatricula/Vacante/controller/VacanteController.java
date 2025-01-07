package GestionMatricula.Vacante.controller;

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

import GestionMatricula.Vacante.model.Vacante;
import GestionMatricula.Vacante.route.Ruta;
import GestionMatricula.Vacante.service.VacanteServiceIpm;


@RestController
@RequestMapping(Ruta.Api)

public class VacanteController {

    public static final Logger log=LoggerFactory.getLogger(VacanteController.class);

    @Autowired
    VacanteServiceIpm servicioIpm;



    @GetMapping(Ruta.ListaVacante)

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

    @GetMapping(Ruta.BuscarVacanteid)

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

     @PostMapping(Ruta.CrearVacante)

    public ResponseEntity<?> crearAlumnos(@RequestBody Vacante vacam){
        try {
            if (vacam.getIdgrado()==null || vacam.getIdseccion()==null || vacam.getVacantes_disponibles()==null || vacam.getAño_alectivo()==null){
                log.error("nose pudo crear la vacante");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("nose creo el alumno");      
            }log.info("vacante creada");
            return ResponseEntity.status(HttpStatus.CREATED).body(servicioIpm.crearVacante(vacam));
        } catch (Exception e) {
            log.error("vacante no creada", e );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("nose pudo crear vacante");
        }
    }

    @PutMapping(Ruta.ModificarVacante)

    public ResponseEntity<?> modificarvacantes(@PathVariable Integer id, @RequestBody Vacante vacam){

        Vacante modiVacam = new Vacante();
        if (vacam.getIdgrado()==null || vacam.getIdseccion()==null || vacam.getVacantes_disponibles()==null || vacam.getAño_alectivo()==null) {
            log.error("nose pudo modificar la vacante");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("nose creo la vacante");            
        }  try {
            modiVacam.setId(id);
            modiVacam.setIdgrado(vacam.getIdgrado());
            modiVacam.setIdseccion(vacam.getIdseccion());
            modiVacam.setVacantes_disponibles(vacam.getVacantes_disponibles());
            modiVacam.setAño_alectivo(vacam.getAño_alectivo());

            Vacante vacanteModificado = servicioIpm.modificarVacante(modiVacam);
            if (vacanteModificado == null) {
                log.error("nose pudo modificar la vacante");
                return ResponseEntity.notFound().build();
            } else{
                log.info("vacante modificada");
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("vacante modificada");
            }
        } catch (Exception e) {
            log.error("vacante no modificada", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("vacante no modificada");
        }

    }

    @DeleteMapping(Ruta.EliminarVacante)

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
