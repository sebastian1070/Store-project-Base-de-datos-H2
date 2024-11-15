package com.example.Store.project.services;

import com.example.Store.project.entities.CamisaEntity;
import com.example.Store.project.entities.PantalonEntity;
import com.example.Store.project.repository.PantalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PantalonService {
    private final PantalonRepository pantalonRepository;

    @Autowired
    public PantalonService(PantalonRepository pantalonRepository){
        this.pantalonRepository = pantalonRepository;
    }
    // Método para obtener todas los pantalones
    public List<PantalonEntity> getPantalonEntity(){
        return this.pantalonRepository.findAll();
    }
    // Método para guardar un nuevo pantalon
    public void newPantalon(PantalonEntity pantalonEntity) {
        pantalonRepository.save(pantalonEntity);
    }
    // Método para eliminar un pantalon por su ID
    public String deletePantalon(Long id) {
        Optional<PantalonEntity> pantalon = pantalonRepository.findById(id);

        if (pantalon.isPresent()) {
            pantalonRepository.deleteById(id);
            return "Pantalon eliminado con éxito.";
        } else {
            return "Pantalon no encontrado.";
        }
    }

}