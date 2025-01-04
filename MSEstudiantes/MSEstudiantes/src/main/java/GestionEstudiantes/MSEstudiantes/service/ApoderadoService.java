package GestionEstudiantes.MSEstudiantes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestionEstudiantes.MSEstudiantes.model.ApoderadoModel;
import GestionEstudiantes.MSEstudiantes.repository.IApoderadoRepository;

@Service
public class ApoderadoService implements IApoderadoService {


   @Autowired
   IApoderadoRepository repository;

   @Override
   public List<ApoderadoModel> findAll() {
       return (List<ApoderadoModel>)repository.findAll();
   }

   @Override
   public ApoderadoModel findById(Integer id) {
       return (ApoderadoModel)repository.findById(id).get();
   }

   @Override
   public ApoderadoModel add(ApoderadoModel model) {
       return repository.save(model);
   }

   @Override
   public ApoderadoModel update(ApoderadoModel model) {
       return repository.save(model);
   }

   @Override
   public Boolean delete(Integer id) {
       repository.deleteById(id);
       return true;
   }
   
}  