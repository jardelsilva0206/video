package com.example.videolocadora.repositories;

import com.example.videolocadora.models.LocacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocacaoRepository extends JpaRepository<LocacaoModel, UUID> {

}
