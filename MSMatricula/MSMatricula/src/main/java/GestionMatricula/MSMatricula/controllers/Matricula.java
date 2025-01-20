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
import GestionMatricula.MSMatricula.model.ModelMatricula;
import GestionMatricula.MSMatricula.service.IMatricula;

@Controller
@RequestMapping("api/matricula")
public class Matricula {

    private static final Logger logger= LoggerFactory.getLogger(Matricula.class);
    
    @Autowired
    IMatricula matriservice;

    @GetMapping("/mostrar")
    public ResponseEntity<List<ModelMatricula>> buscarMatricula(){
        try{
            logger.info("matricula encontrada");
            List<ModelMatricula> modelMatri= matriservice.mostrarMatricula();
            if(modelMatri.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(modelMatri);
        }catch(Exception e){
            logger.error("matricula no encontrada");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/mostrar/")
    public ResponseEntity<?> buscarporId(@PathVariable Integer id){
        try {
            ModelMatricula modelMatri= matriservice.mostrarMatriId(id);
            if (modelMatri !=null) {
                logger.info("se encontro el id del detalle");
                return ResponseEntity.ok(modelMatri);
                
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no se encontro el id del detalle");
            }
        } catch (Exception e) {
            logger.error(null, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no existe el id");
        }
    }

        @PostMapping("/crear")
    public ResponseEntity<?> crearDetalle(@RequestBody ModelMatricula matri){
        try {
            if (matri.getMat_estado()==null || matri.getMat_grado()==null) {
                logger.error("no se creo el detalle de la matricula");
                return ResponseEntity.status(HttpStatus.CONFLICT).body("detalle no creado");
            }
                logger.info("creando el detalle de la Matricula");
                return ResponseEntity.status(HttpStatus.CREATED).body(matriservice.crearMatri(matri));
        } catch (Exception e) {
            logger.error("error al crear detalle");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no se creo el detalle");
        }
    }
@PutMapping("/api/modificar")
    public ResponseEntity<?> modificarDetalle(@PathVariable Integer id, @RequestBody ModelMatricula detamo){
        ModelMatricula modificar= new ModelDetalleMatricula();
        if(detamo.getGrado()==null || detamo.getCurso()==null){
            logger.error( "no se pudo cambiar el detalle");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("hola");
        }
        try {
            modificar.setCurso(detamo.getCurso());
            modificar.setGrado(detamo.getGrado());
            ModelDetalleMatricula update= matriservice.(modificar);
            if(update==null){
                logger.error("no se modifico");
                return ResponseEntity.notFound().build();
            }else{
                logger.info("se modifico el detalle");
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("se modifico");
            }
        } catch (Exception e) {
           logger.error("no se creo el detalle");
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("se modifico el detalle");
        }
    }


    
    @DeleteMapping("/borrar")
    public ResponseEntity<String> eliminar(@PathVariable Integer id){
        try {
            boolean elininar=matriservice.eliminarMatri(id);
            if (elininar) {
                logger.info("detalle eliminado");
                return ResponseEntity.ok("se elimino el detalle");
            }else{
                logger.warn("no existe el id del detalle para elininar"+id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id no encontrado");
            }
        } catch (Exception e) {
           logger.error("error al eliminar detalle");
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ocurrio un error");
        }
    }
}
