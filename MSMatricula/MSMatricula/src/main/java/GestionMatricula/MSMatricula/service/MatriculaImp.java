package GestionMatricula.MSMatricula.service;

import java.util.List;

import org.springframework.stereotype.Service;

import GestionMatricula.MSMatricula.model.Matricula;

@Service
public interface MatriculaImp {
    public List<Matricula> mostrarMatricula();
    public Matricula mostrarMatriId(Integer id);
    public Matricula crearMatri(Matricula matricula);
    public Matricula modificarMatri(Matricula matricula);
    public boolean eliminarMatri(Integer id);
}
