package com.senai.cadastroendereco.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.cadastroendereco.entities.Pessoa;
import com.senai.cadastroendereco.repositories.PessoaRepository;

@Service
public class PessoaService {

	//ATRIBUTOS
	@Autowired
	private PessoaRepository pessoaRepository;
	
	//MÉTODOS
	//Para criar uma nova pessoa
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	//Para buscar uma pessoa pelo id
	public Pessoa burcarPorId(Long id) {
		return pessoaRepository.findById(id).orElse(null);
	}
	
	//Para buscar todas as pessoas
	public List<Pessoa> listarTodas(){
		return pessoaRepository.findAll();
	}
	
	//Para deletar uma pessoa pelo id
	public void deletarPorId(Long id) {
		pessoaRepository.deleteById(id);
	}
	
	//Para buscar a pessoa pelo email
	public Pessoa buscarPorEmail(String email) {
		return pessoaRepository.findByEmail(email);
	}
	
	//Para verificar o email e a senha durante o login
	public Pessoa autenticarPessoa(String email, String senha) {
		Pessoa pessoa = pessoaRepository.findByEmail(email);//Criamos um objeto somente para puxar o findByEmail e ver se o email existe, nele tudo está armazenado (nome, id, email, senha, etc)
		
		if(pessoa != null && pessoa.getSenha().equals(senha)) {//Confere se a pessoa existe e se a senha digitada é igual a senha armazenada
			return pessoa;
		} else {
			return null;
		}
	}
}
