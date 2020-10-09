package br.com.etechoracio.monitoria.controller;

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

import br.com.etechoracio.monitoria.model.Usuario;
import br.com.etechoracio.monitoria.business.UsuarioBusiness;
import br.com.etechoracio.monitoria.dao.UsuarioDAO;
import br.com.etechoracio.monitoria.dto.UsuarioDTO;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioBusiness usuarioBusiness;

	private UsuarioDTO usuarioDTO;
/*
	public ResponseEntity<Usuario> inserir(@RequestBody Usuario usr) {
		return usuarioBusiness.inserir(mapper.map);
	}
	
	@GetMapping
	public List<UsuarioDTO> listarTodos(){
		return usuarioBusiness.listarTodos();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> deletar(@PathVariable Long id) {
		
		if(usuarioDAO.existsById(id)) {
			usuarioDAO.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarPorID(@PathVariable Long id){
		Optional<Usuario> resultado = usuarioDAO.findById(id);
		if(resultado.isPresent()) {
			return ResponseEntity.ok(resultado.get());
		}
		return ResponseEntity.noContent().build();
	}
	
	

}

*/
}