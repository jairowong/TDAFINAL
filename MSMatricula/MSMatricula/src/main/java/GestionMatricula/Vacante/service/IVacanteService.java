package GestionMatricula.Vacante.service;

import java.util.List;
import GestionMatricula.Vacante.model.Vacante;

public interface IVacanteService {

    public List<Vacante> mostrarVacante();
    public Vacante mostrarVacanteID(Integer id);
    public Vacante crearVacante(Vacante vacante);
    public Vacante modificarVacante(Vacante vacam);
    public boolean eliminarVacante(Integer id);
 

}
