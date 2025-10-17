package com.biblioteca.trabalho.entity; 

import jakarta.persistence.*; 
import jakarta.validation.Valid; 
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity 
@Table(name = "livro") 
public class Livro {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @NotEmpty(message = "Por favor, informe o título do livro.")
    @Size(max = 40, message = "ATENÇÃO: O nome do livro possui mais de 40 caracteres.")
    @Column(name = "titulo", nullable = false, length = 40)
    private String titulo;

    @NotNull(message = "Por favor, informe a quantidade de páginas.")
    @Min(value = 1, message = "ATENÇÃO: A quantidade de páginas deve ser maior que zero.")
    @Column(name = "qtd_paginas", nullable = false)
    private Integer qtdPaginas;

    @Embedded
    @Valid
    private Publicacao publicacao;

    public Livro() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getQtdPaginas() {
		return qtdPaginas;
	}

	public void setQtdPaginas(Integer qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}

}