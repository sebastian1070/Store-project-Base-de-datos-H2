package com.example.Store.project.controllers;



import com.example.Store.project.entities.CamisaEntity;
import com.example.Store.project.entities.PantalonEntity;
import com.example.Store.project.services.PantalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/pantalon")
public class PantalonController {
    private final PantalonService pantalonService;

    @Autowired

    public PantalonController(PantalonService pantalonService){
        this.pantalonService = pantalonService;
    }
    @GetMapping
    public List<PantalonEntity> getPantalonEntity(){
        return this.pantalonService.getPantalonEntity();
    }

    @PostMapping
    public void registrarPantalon(@RequestBody PantalonEntity pantalonEntity){
        this.pantalonService.newPantalon(pantalonEntity);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePantalon(@PathVariable Long id) {
        String result = pantalonService.deletePantalon(id);
        if (result.equals("Pantalon eliminado con éxito.")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(404).body(result);
        }
    }
}
