package GestionMatricula.Solicitu_Matricula.controller;

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


import GestionMatricula.Solicitu_Matricula.route.Ruta;
import GestionMatricula.Solicitu_Matricula.model.Solicitud;
import GestionMatricula.Solicitu_Matricula.service.SolicitudServiceIpm;

@RestController
@RequestMapping(Ruta.Api)

public class SolicitudController {

    public static final Logger log=LoggerFactory.getLogger(SolicitudController.class);

    @Autowired
    SolicitudServiceIpm servicioIpm;

    @GetMapping(Ruta.ListaSolicitud)
    public ResponseEntity<List<Solicitud>> mostrarSolitudes(){
        

        try {
            log.info("listado de solicitud");
            List<Solicitud> lista=servicioIpm.mostrarSolicitud();
            if (lista.isEmpty()) {
               log.warn("nose encontro lista de solicitud");
               return ResponseEntity.notFound().build();
            }
             return ResponseEntity.ok(lista);
        } catch (Exception e) {
            log.error("error inesperado", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @GetMapping(Ruta.BuscarSolicitudid)

    public ResponseEntity<?> mostrarSolicitudes(@PathVariable Integer id){

        try {
            Solicitud soli = servicioIpm.mostrarSolicitudID(id);
            if(soli !=null){
                log.info("solicitud encontrada");
                return ResponseEntity.ok(soli);
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id invalido");
            }
           
        } catch (Exception e) {
            log.error("solicitud no encontrada", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @PostMapping(Ruta.CrearSolicitud)

    public ResponseEntity<?> crearSolicitudes(@RequestBody Solicitud soli){
        try {
            if (soli.getFecha_solicitud()==null || soli.getEstado()==null) {
                log.error("nose pudo crear solicitud");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("nose creo la solicitud");      
            }log.info("solicitud creada");
            return ResponseEntity.status(HttpStatus.CREATED).body(servicioIpm.crearSolicitud(soli));
        } catch (Exception e) {
            log.error("solicitud no creado", e );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("nose creo la solicitud");
        }
    }

    @PutMapping(Ruta.ModificarSolicitud)

    public ResponseEntity<?> modificarSolicitudes(@PathVariable Integer id, @RequestBody Solicitud soli){

        Solicitud modiSoli = new Solicitud();
        if (soli.getFecha_solicitud()==null && soli.getEstado()==null) {
            log.error("nose pudo modificar la solicitud");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("nose creo la solicitud");            
        }  try {
            modiSoli.setId(id);
            modiSoli.setFecha_solicitud(soli.getFecha_solicitud());
            modiSoli.setEstado(soli.getEstado());

            Solicitud solicitudModificado = servicioIpm.modificarSolicitud(modiSoli);
            if (solicitudModificado == null) {
                log.error("nose modifico la solicitud");
                return ResponseEntity.notFound().build();
            } else{
                log.info("se modifico la solicitud");
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("solicitud modificado");
            }
        } catch (Exception e) {
            log.error("solicitud no modificado", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("solicitud no modificado");
        }

    }

    @DeleteMapping(Ruta.EliminarSolicitud)

        public ResponseEntity<String> eliminarSolicitudes (@PathVariable Integer id){

            try {
                servicioIpm.eliminarSolicitud(id);
                log.info("solicitud elimnado correctamente");
                return ResponseEntity.ok("solicitud eliminado");
                
            } catch (Exception e) {
                log.error("nose pudo eliminar la solicitud", e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("solicitud no eliminado");
            }

}

}
