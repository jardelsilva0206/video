package com.example.videolocadora.services;

import com.example.videolocadora.models.ClienteModel;
import com.example.videolocadora.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {
    final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ClienteModel save(ClienteModel clienteModel){
        return clienteRepository.save(clienteModel);
    }

    public boolean existsByNomeCliente(String nome){
        return clienteRepository.existsByNomeCliente(nome);
    }
    public boolean existsByNumeroCliente(String numeroCliente){
        return clienteRepository.existsByNumeroCliente(numeroCliente);
    }
    public boolean existsByEmail(String email){
        return clienteRepository.existsByEmail(email);
    }
    public List<ClienteModel> findAll(){
        return clienteRepository.findAll();
    }

    public Optional<ClienteModel> findById(UUID id){
        return clienteRepository.findById(id);
    }

    @Transactional
    public void delete(ClienteModel clienteModel){
        clienteRepository.delete(clienteModel);
    }


}
