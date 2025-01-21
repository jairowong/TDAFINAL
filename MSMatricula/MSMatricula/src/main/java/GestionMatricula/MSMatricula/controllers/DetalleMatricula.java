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
import GestionMatricula.MSMatricula.model.ModelDetalleMatricula;
import GestionMatricula.MSMatricula.service.IDetalleMatricula;



@Controller
@RequestMapping("/apiDetalle")
public class DetalleMatricula {

    private static final Logger loger=LoggerFactory.getLogger(DetalleMatricula.class);
    
    @Autowired
     IDetalleMatricula detalleservice;

    @GetMapping("/mostrar")
    public ResponseEntity<List<ModelDetalleMatricula>> buscar(){

        try {
            loger.info("se mostro correctamente");
            List<ModelDetalleMatricula> detalleMatri= detalleservice.mostrarDetalleMatricula();
            if(detalleMatri.isEmpty()){
                return ResponseEntity.noContent().build();
            }
                return ResponseEntity.ok(detalleMatri);
       
        } catch (Exception e) {
            loger.error("no se mostro correctamente la lista de detalle", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    } 

    @GetMapping("/mostrar/{id}")
    public ResponseEntity<?> buscarporId(@PathVariable Integer id){
        try {
            ModelDetalleMatricula detamodel= detalleservice.mostrarDetalleMatriId(id);
            if (detamodel !=null) {
                loger.info("se encontro el id del detalle");
                return ResponseEntity.ok(detamodel);
                
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no se encontro el id del detalle");
            }
        } catch (Exception e) {
            loger.error(null, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no existe el id");
        }
    }

    @PostMapping("/api/crear")
    public ResponseEntity<?> crearDetalle(@RequestBody ModelDetalleMatricula detaMo){
        try {
            if (detaMo.getGrado()==null || detaMo.getCurso()==null) {
                loger.error("no se creo el detalle de la matricula");
                return ResponseEntity.status(HttpStatus.CONFLICT).body("detalle no creado");
            }
                loger.info("creando el detalle de la Matricula");
                return ResponseEntity.status(HttpStatus.CREATED).body(detalleservice.crearDetalleMatri(detaMo));
        } catch (Exception e) {
            loger.error("error al crear detalle");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no se creo el detalle");
        }
    }

        @PutMapping("/modificar/{id}")
    public ResponseEntity<String> modificarDetalle(@PathVariable Integer id, @RequestBody ModelDetalleMatricula detamo) {
        if (detamo.getGrado()==null || detamo.getCurso()==null) {
            loger.error("Datos incompletos para modificar el detalle.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Datos incompletos.");
        }
        try {
            detamo.setIddetalle_matricula(id); // Asegurarse de que el ID sea correcto
            ModelDetalleMatricula actualizado = detalleservice.modificarDetalleMatri(detamo);
            if (actualizado == null) {
                loger.error("No se encontró el detalle con ID: " + id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el detalle.");
            }
            loger.info("Detalle modificado correctamente.");
            return ResponseEntity.status(HttpStatus.OK).body("Detalle modificado con éxito.");
        } catch (Exception e) {
            loger.error("Error al modificar el detalle: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor.");
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id){
        try {
            boolean elininar=detalleservice.eliminarDetalleMatri(id);
            if (elininar) {
                loger.info("detalle eliminado");
                return ResponseEntity.ok("se elimino el detalle");
            }else{
                loger.warn("no existe el id del detalle para elininar"+id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id no encontrado");
            }
        } catch (Exception e) {
           loger.error("error al eliminar detalle");
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ocurrio un error");
        }
    }

}
