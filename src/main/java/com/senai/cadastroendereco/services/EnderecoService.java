package com.senai.cadastroendereco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.cadastroendereco.entities.Endereco;
import com.senai.cadastroendereco.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	//ATRIBUTOS
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	//Para salvar um novo endereço
	public Endereco salvar(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	//Para buscar todos os enderecos
	public List<Endereco> listarTodos(){
		return enderecoRepository.findAll();
	}
	
	//Para buscar endereço pelo id
	public Optional<Endereco> buscarPorId(Long id){
		return enderecoRepository.findById(id);
	}
	
	//Para deletar um endereço pelo id
	public void deletarPorId(Long id) {
		enderecoRepository.deleteById(id);
	}
	
}
