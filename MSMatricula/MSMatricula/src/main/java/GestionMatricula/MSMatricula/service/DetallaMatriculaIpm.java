package GestionMatricula.MSMatricula.service;

import java.util.List;

import GestionMatricula.MSMatricula.model.ModelDetalleMatricula;

public interface DetallaMatriculaIpm {
    public List<ModelDetalleMatricula> mostrarDetalleMatricula();
    public ModelDetalleMatricula mostrarDetalleMatriId(Integer id);
    public ModelDetalleMatricula crearDetalleMatri(ModelDetalleMatricula detalle);
    public ModelDetalleMatricula modificarDetalleMatri(ModelDetalleMatricula detalle);
    public boolean eliminarDetalleMatri(Integer id);

    
}
