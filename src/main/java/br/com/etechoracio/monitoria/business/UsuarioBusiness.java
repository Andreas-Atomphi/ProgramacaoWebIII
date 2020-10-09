package br.com.etechoracio.monitoria.business;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.etechoracio.monitoria.model.Aula;
import br.com.etechoracio.monitoria.model.Disciplina;
import br.com.etechoracio.monitoria.model.Disponibilidade;
import br.com.etechoracio.monitoria.model.Usuario;
import br.com.etechoracio.monitoria.dao.AulaDAO;
import br.com.etechoracio.monitoria.dao.DisciplinaDAO;
import br.com.etechoracio.monitoria.dao.DisponibilidadeDAO;
import br.com.etechoracio.monitoria.dao.UsuarioDAO;
import br.com.etechoracio.monitoria.dto.DisciplinaDTO;
import br.com.etechoracio.monitoria.dto.DisponibilidadeDTO;
import br.com.etechoracio.monitoria.dto.UsuarioDTO;

 // Informa ao sistema que essa é uma camada de serviço.
// que prove serviços a outros lugares.
@Service
public class UsuarioBusiness {
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private ModelMapper mapper;

	private AulaDAO aulaDAO;

	private DisciplinaDAO disciplinaDAO;

	private DisponibilidadeDAO disponibilidadeDAO;
	
	public UsuarioDTO inserir(UsuarioDTO usrDTO)
	{
		Optional<Usuario> existente = usuarioDAO.findByWhatsapp(usrDTO.getWhatsapp());
		if(existente.isPresent())
		{
			throw new IllegalArgumentException("Usuário já existente com esse whatsapp.");
		}

		Usuario paraSalvar = mapper.map(usrDTO, Usuario.class);

		usuarioDAO.save(
			paraSalvar
		);

		Disciplina disciplina = disciplinaDAO.getOne(usrDTO.getDisciplina().getId());

		Aula aula = Aula.builder().disciplina(disciplina).usuario(paraSalvar).build();

		aulaDAO.save(aula);

		List<Disponibilidade> disponibilidades = usrDTO.getDisponibilidades().stream().map(e -> {
			Disponibilidade resultado = mapper.map(e, Disponibilidade.class
			);
			return resultado;
		}).collect(Collectors.toList());

		disponibilidadeDAO.saveAll(disponibilidades);

		UsuarioDTO resultado = mapper.map(paraSalvar, UsuarioDTO.class);

		DisciplinaDTO disciplinaResultado = mapper.map(disciplina, DisciplinaDTO.class);

		List<DisponibilidadeDTO> disponibilidadesResultado = disponibilidades
		.stream()
		.map(e -> mapper.map(e, DisponibilidadeDTO.class))
		.collect(Collectors.toList());

		resultado.setDisciplina(disciplinaResultado);
		resultado.setDisponibilidade(disponibilidadesResultado);

		return resultado;
	}

	public List<UsuarioDTO> listarTodos(){
		List<Usuario> resposta = usuarioDAO.findAll();		
		
		return resposta
		.stream()
		.map(e -> mapper.map(e, UsuarioDTO.class))
		.collect(Collectors.toList());
	}

}
