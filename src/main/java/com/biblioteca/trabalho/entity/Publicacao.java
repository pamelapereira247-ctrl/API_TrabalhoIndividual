package com.biblioteca.trabalho.entity; 

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable; 
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Embeddable
public class Publicacao {

    @NotEmpty(message = "Por favor, informe o autor do livro.")
    @Size(max = 25, message = "ATENÇÃO: O nome do autor possui mais de 25 caracteres.")
    @Column(name = "autor")
    private String autor;

    @Column(name = "data_publicacao")
    private LocalDate dataPublicacao; 

    @Column(name = "editora")
    private String editora;

    public Publicacao() {
    }

    public Publicacao(String autor, LocalDate dataPublicacao, String editora) {
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.editora = editora;
    }

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}
    
}