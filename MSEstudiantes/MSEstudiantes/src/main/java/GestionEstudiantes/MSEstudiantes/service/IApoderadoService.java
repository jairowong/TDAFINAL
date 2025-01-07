package GestionEstudiantes.MSEstudiantes.service;

import java.util.List;

import GestionEstudiantes.MSEstudiantes.model.ApoderadoModel;

public interface IApoderadoService {
    

    public List<ApoderadoModel> findAll();

    public ApoderadoModel findById(Integer id);

    public ApoderadoModel add(ApoderadoModel model);

    public ApoderadoModel update(ApoderadoModel model);

    public Boolean delete(Integer id);
}