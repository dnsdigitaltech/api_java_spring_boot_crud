package com.sosapi.crm.sosapi.controller;
import com.sosapi.crm.sosapi.model.Contato;

import com.sosapi.crm.sosapi.repository.RepositoryContato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoRESTController {
    @Autowired
    private RepositoryContato repositorio;

    @GetMapping
    public List<Contato> listar() {
        return repositorio.findAll();
    }

    @PostMapping
    public void salvar(@RequestBody Contato contato){
        repositorio.save(contato);
    }

    @PutMapping
    public void alterar(@RequestBody Contato contato){
        if(contato.getId() > 0)
        repositorio.save(contato);
    }

    @DeleteMapping
    public void excluir(@RequestBody Contato contato) {
        repositorio.delete(contato);
    }
}
