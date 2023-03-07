package com.example.videolocadora.repositories;

import com.example.videolocadora.models.FilmeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FilmeRepository extends JpaRepository<FilmeModel, UUID> {

}
