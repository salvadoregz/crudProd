package com.salvador.estrada.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salvador.estrada.model.Cliente;
import com.salvador.estrada.service.ClienteServiceImpl;

@RestController
@RequestMapping
public class Controller { 
	
	@Autowired  
	private  ClienteServiceImpl clienteServiceImpl;  
	
	@PostMapping("/guardar")  
	
	public ResponseEntity<?> listaCliente(@RequestBody Cliente cliente)
	{
		clienteServiceImpl.saveCliente(cliente);
		return ResponseEntity.ok("Cliente guardado stisfacoriamente");
	}
	
	
	@GetMapping("/listar")
	
	public ResponseEntity<List<Cliente>> listaCliente()
	{
		return ResponseEntity.ok("Datos encontrados").ok(clienteServiceImpl.lstCliente());
	}  
	
	@PutMapping("/editar/{id}") 
	
	public ResponseEntity<?> editCliente(@RequestBody Cliente cliente, @PathVariable Long id)
	{
		Optional<Cliente> cte = clienteServiceImpl.getById(id);  
		
		if(!cte.isPresent())
		{ 
			return ResponseEntity.ok("Id de cliente no existe!");	
		}else
		{ 
			cte.get().setNombre(cliente.getNombre());
			cte.get().setApellido(cliente.getApellido());
			cte.get().setEdad(cliente.getEdad());
			clienteServiceImpl.saveCliente(cte.get());
			return ResponseEntity.ok("Datos modificados exitosamente!");
		}
	}
	
	@DeleteMapping("/eliminar/{id}") 
	public ResponseEntity eliminarCliente(@PathVariable Long id)
	{
		Optional<Cliente> eliminaCliente = clienteServiceImpl.getById(id); 
		if(!eliminaCliente.isPresent())
		{
			return ResponseEntity.ok("Id de cliente no existe"); 
		}else
		{
			clienteServiceImpl.eliminar(id); 
			return ResponseEntity.ok("Cliente eliminado con exito!");
		}
	
	}
	
	
	
     
}
