package GestionMatricula.MSMatricula.service;

import java.util.List;

import GestionMatricula.MSMatricula.model.Vacante;

public interface IVacanteService {

    public List<Vacante> mostrarVacante();
    public Vacante mostrarVacanteID(Integer id);
    public Vacante crearVacante(Vacante vacante);
    public Vacante modificarVacante(Vacante vacam);
    public boolean eliminarVacante(Integer id);
 

}
