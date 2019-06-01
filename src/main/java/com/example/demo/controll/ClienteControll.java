package com.example.demo.controll;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.service.ClienteService;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/clientes")
public class ClienteControll {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	ResponseEntity  adicionar(@Valid @RequestBody Cliente contato) {
            clienteService.cadastrarCliente(contato);
            
            return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteService.mostraTodosClientes();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
		Cliente cli;
        try {
            cli = clienteService.buscaCliente(id);

        } catch (NoSuchElementException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(cli, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, 
			@Valid @RequestBody Cliente contato) {
		Cliente existente = clienteService.buscaCliente(id);
		
		        return new ResponseEntity(HttpStatus.CREATED);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		clienteService.excluirCliente(id);

        return new ResponseEntity(HttpStatus.OK);
        }
}