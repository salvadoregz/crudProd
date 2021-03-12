package com.salvador.estrada.service;

import java.util.List;
import java.util.Optional;

import com.salvador.estrada.model.Cliente;

public interface IClienteService { 
	
	
	public void saveCliente(Cliente cliente); 
	
	public List<Cliente> lstCliente(); 
	
	public Optional<Cliente> getById(Long id); 
	
	public void eliminar(Long id);
	

}
