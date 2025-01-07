package GestionMatricula.MSMatricula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestionMatricula.MSMatricula.model.Vacante;
import GestionMatricula.MSMatricula.repositorio.VacanteRepository;

@Service

public class VacanteServiceIpm implements IVacanteService {

    @Autowired
    VacanteRepository vacanterepository;

    @Override
    public List<Vacante> mostrarVacante() {
        return (List<Vacante>) vacanterepository.findAll();

    }

    @Override
    public Vacante mostrarVacanteID(Integer id) {
        return vacanterepository.findById(id).orElse(null);
    }

    @Override
    public Vacante crearVacante(Vacante vacante) {
        return vacanterepository.save(vacante);
    }

    @Override
    public Vacante modificarVacante(Vacante vacam) {
        return vacanterepository.save(vacam);
    }

    @Override
    public boolean eliminarVacante(Integer id) {
        vacanterepository.existsById(id);
        if (vacanterepository.existsById(id)) {
            vacanterepository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }

}
