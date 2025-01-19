package GestionMatricula.MSMatricula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestionMatricula.MSMatricula.model.ModelMatricula;
import GestionMatricula.MSMatricula.repositorio.MatriculaRepository;

@Service
public class IMatricula implements MatriculaImp {

    @Autowired
    MatriculaRepository matriculaRepository;

    @Override
    public List<ModelMatricula> mostrarMatricula() {
       return (List<ModelMatricula>) matriculaRepository.findAll();
    }

    @Override
    public ModelMatricula mostrarMatriId(Integer id) {
       return matriculaRepository.findById(id).orElse(null);
    }

    @Override
    public ModelMatricula crearMatri(ModelMatricula matricula) {
       return matriculaRepository.save(matricula);
    }

    @Override
    public ModelMatricula modificarMatri(ModelMatricula matricula) {
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
