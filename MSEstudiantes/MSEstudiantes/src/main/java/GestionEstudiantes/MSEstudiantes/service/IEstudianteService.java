package GestionEstudiantes.MSEstudiantes.service;


import java.util.List;

import GestionEstudiantes.MSEstudiantes.model.EstudianteModel;
public interface IEstudianteService {
    

    public List<EstudianteModel> findAll();

    public EstudianteModel findById(Integer id);

    public EstudianteModel add(EstudianteModel model);

    public EstudianteModel update(EstudianteModel model);

    public Boolean delete(Integer id);
}
