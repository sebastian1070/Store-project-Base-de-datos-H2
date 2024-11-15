package com.example.Store.project.controllers;

import com.example.Store.project.entities.CamisaEntity;
import com.example.Store.project.services.CamisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="/camisa")
public class CamisaController {
   private final CamisaService camisaService;

   @Autowired

   public CamisaController(CamisaService camisaService){
       this.camisaService = camisaService;
   }
    @GetMapping
    public List<CamisaEntity> getCamisaEntity(){
       return this.camisaService.getCamisaEntity();
    }


    @PostMapping
    public void registrarCamisa(@RequestBody CamisaEntity camisaEntity){
       this.camisaService.newCamisa(camisaEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCamisa(@PathVariable Long id) {
        String result = camisaService.deleteCamisa(id);
        if (result.equals("Camisa eliminada con éxito.")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(404).body(result);
        }
    }
}
