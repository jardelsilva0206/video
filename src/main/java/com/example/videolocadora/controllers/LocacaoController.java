package com.example.videolocadora.controllers;


import com.example.videolocadora.dtos.LocacaoDto;

import com.example.videolocadora.models.ClienteModel;
import com.example.videolocadora.models.LocacaoModel;
import com.example.videolocadora.services.LocacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/locacao")
public class LocacaoController {
    final LocacaoService locacaoService;

    public LocacaoController(LocacaoService locacaoService) {
        this.locacaoService = locacaoService;
    }
    @PostMapping
    public ResponseEntity<Object> saveLocacao(@RequestBody @Valid LocacaoDto locacaoDto){
        var locacaoModel = new LocacaoModel();
        BeanUtils.copyProperties(locacaoDto, locacaoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(locacaoService.save(locacaoModel));
    }
    @GetMapping
    public ResponseEntity<List<LocacaoModel>> getAllLocacao(){
        return ResponseEntity.status(HttpStatus.OK).body(locacaoService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getLocacao(@PathVariable(value = "id") UUID id){
        Optional<LocacaoModel> locacaoModelOptional = locacaoService.findById(id);
        if(!locacaoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(locacaoModelOptional.get());
        }
        return ResponseEntity.status(HttpStatus.OK).body(locacaoModelOptional.get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object>deleteLocacao(@PathVariable(value = "id") UUID id){
        Optional<LocacaoModel> locacaoModelOptional = locacaoService.findById(id);
        if(!locacaoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("locacao not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body("locacao delete sucessfully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateLocacao(@PathVariable(value = "id") UUID id, @RequestBody @Valid
    LocacaoDto locacaoDto){
        Optional<LocacaoModel> locacaoModelOptional = locacaoService.findById(id);
        if (!locacaoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Locacao not found!");
        }
        var locacaoModel = locacaoModelOptional.get();
        BeanUtils.copyProperties(locacaoDto,locacaoModel);
        locacaoModel.setIdLocacao(locacaoModelOptional.get().getIdLocacao());
        locacaoModel.setIdCliente(locacaoModelOptional.get().getIdCliente());
        locacaoModel.setIdFilme(locacaoModelOptional.get().getIdFilme());
        locacaoModel.setDataRetirada(locacaoModelOptional.get().getDataRetirada());
        locacaoModel.setDataDevolucao(locacaoModelOptional.get().getDataDevolucao());
        locacaoModel.setValor(locacaoModelOptional.get().getValor());
        locacaoModel.setFeitoPagamento(locacaoModelOptional.get().getFeitoPagamento());
        return ResponseEntity.status(HttpStatus.OK).body(locacaoService.save(locacaoModel));
    }
}
