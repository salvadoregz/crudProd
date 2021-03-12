package com.salvador.estrada.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salvador.estrada.model.Cliente;
import com.salvador.estrada.repository.ClienteRepository;
@Service
public class ClienteServiceImpl implements IClienteService { 
	
	@Autowired 
	private ClienteRepository clienteRepository;
     
	@Override
	public void saveCliente(Cliente cliente) {
		
		clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> lstCliente() {
		
		return clienteRepository.findAll();
	}

	@Override
	public Optional<Cliente> getById(Long id) {
		return clienteRepository.findById(id);
	}

	@Override
	public void eliminar(Long id) {
		clienteRepository.deleteById(id);
		
	}

}
