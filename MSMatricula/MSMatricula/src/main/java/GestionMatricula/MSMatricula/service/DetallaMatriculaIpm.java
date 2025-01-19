package GestionMatricula.MSMatricula.service;

import java.util.List;

import GestionMatricula.MSMatricula.model.DetalleMatricula;

public interface DetallaMatriculaIpm {
    public List<DetalleMatricula> mostrarDetalleMatricula();
    public DetalleMatricula mostrarDetalleMatriId(Integer id);
    public DetalleMatricula crearDetalleMatri(DetalleMatricula detalle);
    public DetalleMatricula modificarDetalleMatri(DetalleMatricula detalle);
    public boolean eliminarDetalleMatri(Integer id);

    
}
