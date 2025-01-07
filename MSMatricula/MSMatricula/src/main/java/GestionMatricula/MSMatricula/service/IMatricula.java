package GestionMatricula.MSMatricula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestionMatricula.MSMatricula.model.Matricula;
import GestionMatricula.MSMatricula.repositorio.MatriculaRepository;

@Service
public class IMatricula implements MatriculaImp {

    @Autowired
    MatriculaRepository matriculaRepository;

    @Override
    public List<Matricula> mostrarMatricula() {
       return (List<Matricula>) matriculaRepository.findAll();
    }

    @Override
    public Matricula mostrarMatriId(Integer id) {
       return matriculaRepository.findById(id).orElse(null);
    }

    @Override
    public Matricula crearMatri(Matricula matricula) {
       return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula modificarMatri(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public boolean eliminarMatri(Integer id) {
        matriculaRepository.existsById(id);
        if (matriculaRepository.existsById(id)) {
            matriculaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    
    
}
