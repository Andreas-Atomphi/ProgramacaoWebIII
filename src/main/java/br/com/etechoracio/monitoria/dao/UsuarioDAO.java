package br.com.etechoracio.monitoria.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.monitoria.model.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long>{ 
	
	Optional<Usuario> findByWhatsapp(String whatsapp);

}

