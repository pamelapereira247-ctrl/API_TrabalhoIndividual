package com.biblioteca.trabalho.controller;

import com.biblioteca.trabalho.entity.Livro;
import com.biblioteca.trabalho.repository.LivroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository; 

    // 1. GET ALL
    @GetMapping
    public List<Livro> getAllLivros() {
        return livroRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> getLivroById(@PathVariable Long id) {
        return livroRepository.findById(id)
                .map(livro -> ResponseEntity.ok(livro))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Livro createLivro(@Valid @RequestBody Livro livro) {
        return livroRepository.save(livro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> updateLivro(@PathVariable Long id, @Valid @RequestBody Livro livroDetalhes) {
        return livroRepository.findById(id)
        		.map(livroExistente -> {
                    livroExistente.setTitulo(livroDetalhes.getTitulo());
                    livroExistente.setQtdPaginas(livroDetalhes.getQtdPaginas());
                    livroExistente.setPublicacao(livroDetalhes.getPublicacao());

                    Livro livroAtualizado = livroRepository.save(livroExistente);
                    return ResponseEntity.ok(livroAtualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteLivro(@PathVariable Long id) {
        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}