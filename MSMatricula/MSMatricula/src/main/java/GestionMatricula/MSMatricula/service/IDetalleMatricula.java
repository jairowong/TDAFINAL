package GestionMatricula.MSMatricula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestionMatricula.MSMatricula.model.DetalleMatricula;

@Service
public class IDetalleMatricula implements DetallaMatriculaIpm {

    @Autowired
    

    @Override
    public List<DetalleMatricula> mostrarDetalleMatricula() {

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarDetalleMatricula'");
    }

    @Override
    public DetalleMatricula mostrarDetalleMatriId(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarDetalleMatriId'");
    }

    @Override
    public DetalleMatricula crearDetalleMatri(DetalleMatricula detalle) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearDetalleMatri'");
    }

    @Override
    public DetalleMatricula modificarDetalleMatri(DetalleMatricula detalle) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarDetalleMatri'");
    }

    @Override
    public boolean eliminarDetalleMatri(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarDetalleMatri'");
    }
    
}
