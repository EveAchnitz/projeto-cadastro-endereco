package com.senai.cadastroendereco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.cadastroendereco.entities.Pessoa;
import com.senai.cadastroendereco.services.PessoaService;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    //Criar uma nova pessoa
    @PostMapping
    public Pessoa salvar(@RequestBody Pessoa pessoa) {
        return pessoaService.salvar(pessoa);
    }

    //Buscar uma pessoa pelo ID
    @GetMapping("/{id}")
    public Pessoa buscarPorId(@PathVariable Long id) {
        return pessoaService.burcarPorId(id);
    }

    //Excluir uma pessoa
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        pessoaService.deletarPorId(id);
    }

    //Listar todas as pessoas
    @GetMapping
    public List<Pessoa> listarTodas() {
        return pessoaService.listarTodas();
    }

    //Buscar pessoa por email
    @GetMapping("/email/{email}")
    public Pessoa buscarPorEmail(@PathVariable String email) {
        return pessoaService.buscarPorEmail(email);
    }

    //Método de login
    @PostMapping("/login")
    public Pessoa login(@RequestBody Pessoa loginRequest) { //a senha e o email digitado está sendo armazenado no loginRequest, e agora estamos chamando os seus valores e armazenando nos parâmetros desse método lá no service
    	Pessoa pessoa = pessoaService.autenticarPessoa(loginRequest.getEmail(), loginRequest.getSenha()); //Criamos um objeto somente para chamar o autenticarPessoa e verificar as credenciais, e esse objeto armazena o resultado do autenticarPessoa do service (pessoa ou null)
    	
    	if(pessoa != null) {
    		return pessoa;
    	} else {
    		return null;
    	}
    }
    
}