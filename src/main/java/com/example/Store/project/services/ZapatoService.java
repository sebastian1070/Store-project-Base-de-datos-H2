package com.example.Store.project.services;

import com.example.Store.project.entities.PantalonEntity;
import com.example.Store.project.entities.ZapatoEntity;
import com.example.Store.project.repository.ZapatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZapatoService {
    private final ZapatoRepository zapatoRepository;

    @Autowired
    public ZapatoService(ZapatoRepository zapatoRepository){
        this.zapatoRepository = zapatoRepository;
    }
    // Método para obtener todos los zapatos
    public List<ZapatoEntity> getZapatoEntity(){
        return this.zapatoRepository.findAll();
    }
    // Método para guardar un nuevo zapato
    public void newZapato(ZapatoEntity zapatoEntity) {
        zapatoRepository.save(zapatoEntity);
    }
    // Método para eliminar un pantalon por su ID
    public String deleteZapato(Long id) {
        Optional<ZapatoEntity> zapato = zapatoRepository.findById(id);

        if (zapato.isPresent()) {
            zapatoRepository.deleteById(id);
            return "Zapato eliminado con éxito.";
        } else {
            return "Zapato no encontrado.";
        }
    }
}
