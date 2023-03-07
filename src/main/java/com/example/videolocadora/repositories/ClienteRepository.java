package com.example.videolocadora.repositories;

import com.example.videolocadora.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, UUID>{
 boolean existsByNomeCliente(String nome);

 boolean existsByNumeroCliente(String numero);

 boolean existsByEmail(String email);

}
