package com.example.videolocadora.controllers;

import com.example.videolocadora.dtos.ClienteDto;
import com.example.videolocadora.models.ClienteModel;
import com.example.videolocadora.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/cliente")
public class ClienteController {
    final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Object> saveCliente(@RequestBody @Valid ClienteDto clienteDto) {
        if (clienteService.existsByNomeCliente(clienteDto.getNomeCliente())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Nome de cliente em uso");
        }
        if (clienteService.existsByNumeroCliente(clienteDto.getNumeroCliente())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Numero de cliente em uso");
        }
        if(clienteService.existsByEmail(clienteDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Email já em uso");
        }
        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteModel));
    }
@GetMapping
public ResponseEntity<List<ClienteModel>> getAllClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
}
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCliente(@PathVariable(value = "id") UUID id){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if(!clienteModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(clienteModelOptional.get());
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteModelOptional.get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object>deleteCliente(@PathVariable(value = "id") UUID id){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if(!clienteModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Client delete sucessfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCliente(@PathVariable(value = "id") UUID id, @RequestBody @Valid
                                                ClienteDto clienteDto){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if (!clienteModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found!");
        }
        var clienteModel = clienteModelOptional.get();
        BeanUtils.copyProperties(clienteDto,clienteModel);
        clienteModel.setNumeroCliente(clienteModelOptional.get().getNumeroCliente());
        clienteModel.setNomeCliente(clienteModelOptional.get().getNomeCliente());
        clienteModel.setEmail(clienteModelOptional.get().getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(clienteModel));
    }
}
