package GestionPago.MSPago.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestionPago.MSPago.model.PagoModel;
import GestionPago.MSPago.repository.IPagoRepository;


@Service
public class PagoService {
    @Autowired
    private IPagoRepository pagoRepository;

    public List<PagoModel> findAll() {
        return (List<PagoModel>) pagoRepository.findAll();
    }
    
    public PagoModel add(PagoModel model) {
        return pagoRepository.save(model);
    }

    public PagoModel findById(int id) {
        Optional<PagoModel> pago = pagoRepository.findById(id);
        if(pago.isPresent()){
            return pago.get();
        }else{
            return null;
        }


    }
}
