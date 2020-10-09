package br.com.etechoracio.monitoria.business;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etechoracio.monitoria.model.Disciplina;
import br.com.etechoracio.monitoria.dao.DisciplinaDAO;
import br.com.etechoracio.monitoria.dto.DisciplinaDTO;

@Service
public class DisciplinaBusiness {
	
	@Autowired
	private DisciplinaDAO disciplinaDAO;

	@Autowired
	private ModelMapper mapper;
	
	public List<DisciplinaDTO> listarTodos(){

		List<Disciplina> resposta = disciplinaDAO.findAll();		
		return resposta
		.stream()
		.map(e -> mapper
		.map(e, DisciplinaDTO.class))
		.collect(Collectors.toList());
	}

}
