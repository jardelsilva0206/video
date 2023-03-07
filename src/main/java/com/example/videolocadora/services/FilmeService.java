package com.example.videolocadora.services;

import com.example.videolocadora.models.FilmeModel;
import com.example.videolocadora.repositories.FilmeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FilmeService {
    final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository){
        this.filmeRepository = filmeRepository;
    }

    @Transactional
    public FilmeModel save(FilmeModel filmeModel){
        return filmeRepository.save(filmeModel);
    }

    public List<FilmeModel> findAll(){
        return filmeRepository.findAll();
    }

    public Optional<FilmeModel> findById(UUID id){
        return filmeRepository.findById(id);
    }

    @Transactional
    public void delete(FilmeModel filmeModel){
        filmeRepository.delete(filmeModel);
    }
}
