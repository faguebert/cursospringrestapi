package curso.api.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.api.rest.model.Usuario;
import curso.api.rest.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
public class IndexController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Usuario> buscarUsuarioPorID(@PathVariable Long id) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);		
		
		return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Usuario>> buscarUsuarios() {
		
		List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
		
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
		
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.CREATED);
	}
	
	@PutMapping(value= "/", produces="application/json")
	public ResponseEntity<Usuario>atualizar(@RequestBody Usuario usuario){
		
		Usuario usuarioAtualizado = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(usuarioAtualizado, HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/{id}", produces = "application/text")
	public ResponseEntity<String> deletar(@PathVariable Long id){
		
		usuarioRepository.deleteById(id);
		
		return new ResponseEntity<String>("Usuario excluido com sucesso.", HttpStatus.OK);
	}
	
	
	
}
