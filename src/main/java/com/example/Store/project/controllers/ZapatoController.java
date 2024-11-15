package com.example.Store.project.controllers;



import com.example.Store.project.entities.PantalonEntity;
import com.example.Store.project.entities.ZapatoEntity;
import com.example.Store.project.services.ZapatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/zapato")
public class ZapatoController {
    private final ZapatoService zapatoService;

    @Autowired

    public ZapatoController(ZapatoService zapatoService){
        this.zapatoService = zapatoService;
    }
    @GetMapping
    public List<ZapatoEntity> getZapatoEntity(){
        return this.zapatoService.getZapatoEntity();
    }
    @PostMapping
    public void registrarZapato(@RequestBody ZapatoEntity zapatoEntity){
        this.zapatoService.newZapato(zapatoEntity);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteZapato(@PathVariable Long id) {
        String result = zapatoService.deleteZapato(id);
        if (result.equals("Zapato eliminado con éxito.")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(404).body(result);
        }
    }
}