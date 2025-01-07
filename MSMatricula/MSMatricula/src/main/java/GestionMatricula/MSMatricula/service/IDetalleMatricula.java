package GestionMatricula.MSMatricula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestionMatricula.MSMatricula.model.DetalleMatricula;
import GestionMatricula.MSMatricula.repositorio.DetalleMatriculaRepository;

@Service
public class IDetalleMatricula implements DetallaMatriculaIpm {

    @Autowired
    DetalleMatriculaRepository detalleRepository;
    

    @Override
    public List<DetalleMatricula> mostrarDetalleMatricula() {
        return (List<DetalleMatricula>) detalleRepository.findAll();
    }

    @Override
    public DetalleMatricula mostrarDetalleMatriId(Integer id) {
        return detalleRepository.findById(id).orElse(null);
    }

    @Override
    public DetalleMatricula crearDetalleMatri(DetalleMatricula detalle) {
     return detalleRepository.save(detalle);
    }

    @Override
    public DetalleMatricula modificarDetalleMatri(DetalleMatricula detalle) {
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
