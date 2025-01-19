package GestionMatricula.MSMatricula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestionMatricula.MSMatricula.model.ModelDetalleMatricula;
import GestionMatricula.MSMatricula.repositorio.DetalleMatriculaRepository;

@Service
public class IDetalleMatricula implements DetallaMatriculaIpm {

    @Autowired
    DetalleMatriculaRepository detalleRepository;
    

    @Override
    public List<ModelDetalleMatricula> mostrarDetalleMatricula() {
        return (List<ModelDetalleMatricula>) detalleRepository.findAll();
    }

    @Override
    public ModelDetalleMatricula mostrarDetalleMatriId(Integer id) {
        return detalleRepository.findById(id).orElse(null);
    }

    @Override
    public ModelDetalleMatricula crearDetalleMatri(ModelDetalleMatricula detalle) {
     return detalleRepository.save(detalle);
    }

    @Override
    public ModelDetalleMatricula modificarDetalleMatri(ModelDetalleMatricula detalle) {
     return detalleRepository.save(detalle);
    }

    @Override
    public boolean eliminarDetalleMatri(Integer id) {
        detalleRepository.existsById(id);
        if (detalleRepository.existsById(id)) {
            detalleRepository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }
    
}
