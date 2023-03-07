package com.example.videolocadora.services;

import com.example.videolocadora.models.LocacaoModel;
import com.example.videolocadora.repositories.LocacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LocacaoService {
    final LocacaoRepository locacaoRepository;

    public LocacaoService(LocacaoRepository locacaoRepository){
        this.locacaoRepository = locacaoRepository;
    }

    @Transactional
    public LocacaoModel save(LocacaoModel locacaoModel){
        return locacaoRepository.save(locacaoModel);
    }

    public List<LocacaoModel> findAll(){
        return locacaoRepository.findAll();
    }
    public Optional<LocacaoModel>findById(UUID id){
        return locacaoRepository.findById(id);
    }

    @Transactional
    public void delete(LocacaoModel locacaoModel){
        locacaoRepository.delete(locacaoModel);
    }
}
