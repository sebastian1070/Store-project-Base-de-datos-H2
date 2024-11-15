package com.example.Store.project.services;

import com.example.Store.project.entities.CamisaEntity;
import com.example.Store.project.repository.CamisaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CamisaService {
    private final CamisaRepository camisaRepository;

    @Autowired
    public CamisaService(CamisaRepository camisaRepository){
        this.camisaRepository = camisaRepository;
    }
    // Método para obtener todas las camisas
    public List<CamisaEntity> getCamisaEntity(){
        return  this.camisaRepository.findAll();
    }
    // Método para guardar una nueva camisa
    public void newCamisa(CamisaEntity camisaEntity){
        camisaRepository.save(camisaEntity);
    }
    // Método para eliminar una camisa por su ID
    public String deleteCamisa(Long id) {
        Optional<CamisaEntity> camisa = camisaRepository.findById(id);

        if (camisa.isPresent()) {
            camisaRepository.deleteById(id);
            return "Camisa eliminada con éxito.";
        } else {
            return "Camisa no encontrada.";
        }
    }
}
