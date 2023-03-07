package com.example.videolocadora.dtos;

import jakarta.validation.constraints.NotBlank;

public class FilmeDto {
    @NotBlank
    private String idFilme;

    @NotBlank
    private String nomeFilme;

    @NotBlank
    private String categoriaFilme;

    public String getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(String idFilme) {
        this.idFilme = idFilme;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getCategoriaFilme() {
        return categoriaFilme;
    }

    public void setCategoriaFilme(String categoriaFilme) {
        this.categoriaFilme = categoriaFilme;
    }
}
