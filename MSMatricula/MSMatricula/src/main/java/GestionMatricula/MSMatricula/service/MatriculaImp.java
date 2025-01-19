package GestionMatricula.MSMatricula.service;

import java.util.List;

import org.springframework.stereotype.Service;

import GestionMatricula.MSMatricula.model.ModelMatricula;

@Service
public interface MatriculaImp {
    public List<ModelMatricula> mostrarMatricula();
    public ModelMatricula mostrarMatriId(Integer id);
    public ModelMatricula crearMatri(ModelMatricula matricula);
    public ModelMatricula modificarMatri(ModelMatricula matricula);
    public boolean eliminarMatri(Integer id);
}
