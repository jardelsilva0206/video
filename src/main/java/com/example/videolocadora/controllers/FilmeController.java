package com.example.videolocadora.controllers;

import com.example.videolocadora.dtos.FilmeDto;

import com.example.videolocadora.models.FilmeModel;
import com.example.videolocadora.services.FilmeService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/filme")
public class FilmeController {
    final FilmeService filmeService;


    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }
    @PostMapping
    public ResponseEntity<Object> saveFilme(@RequestBody @Valid FilmeDto filmeDto){
            var filmeModel = new FilmeModel();
        BeanUtils.copyProperties(filmeDto, filmeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeService.save(filmeModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getFilme(@PathVariable(value = "id") UUID id){
        Optional<FilmeModel> filmeModelOptional = filmeService.findById(id);
        if(!filmeModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(filmeModelOptional.get());
        }
        return ResponseEntity.status(HttpStatus.OK).body(filmeModelOptional.get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object>deleteFilme(@PathVariable(value = "id") UUID id){
        Optional<FilmeModel> filmeModelOptional = filmeService.findById(id);
        if(!filmeModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Film not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Film delete sucessfully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFilme(@PathVariable(value = "id") UUID id, @RequestBody @Valid
    FilmeDto filmeDto){
        Optional<FilmeModel> filmeModelOptional = filmeService.findById(id);
        if (!filmeModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Film not found!");
        }
        var filmeModel = filmeModelOptional.get();
        BeanUtils.copyProperties(filmeDto,filmeModel);
        filmeModel.setId(filmeModelOptional.get().getId());
        filmeModel.setNome(filmeModelOptional.get().getNome());
        filmeModel.setCategoria(filmeModelOptional.get().getCategoria());
        return ResponseEntity.status(HttpStatus.OK).body(filmeService.save(filmeModel));
    }

}
