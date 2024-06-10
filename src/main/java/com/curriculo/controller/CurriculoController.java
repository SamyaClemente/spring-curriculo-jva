
package com.curriculo.controller;

import com.curriculo.service.CurriculoService;
import com.curriculo.model.Curriculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curriculos")
public class CurriculoController {

    @Autowired
    private CurriculoService curriculoService;

    @GetMapping
    public List<Curriculo> getAllCurriculos() {
        return curriculoService.getAllCurriculos();
    }

    @GetMapping("/{id}")
    public Optional<Curriculo> getCurriculoById(@PathVariable Long id) {
        return curriculoService.getCurriculoById(id);
    }

    @PostMapping
    public Curriculo saveCurriculo(@RequestBody Curriculo curriculo) {
        return curriculoService.saveCurriculo(curriculo);
    }

    @PutMapping("/{id}")
    public Curriculo updateCurriculo(@PathVariable Long id, @RequestBody Curriculo curriculo) {
        // Verifica se o currículo existe antes de atualizá-lo
        if (curriculoService.getCurriculoById(id).isPresent()) {
            curriculo.setId(id); // Garante que o ID do currículo seja definido corretamente
            return curriculoService.saveCurriculo(curriculo); // Atualiza o currículo no banco de dados
        } else {
            throw  new RuntimeException ("Currículo não encontrado para o ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCurriculo(@PathVariable Long id) {
        curriculoService.deleteCurriculo(id);
    }
}