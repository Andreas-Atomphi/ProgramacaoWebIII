package br.com.etechoracio.monitoria.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import javax.validation.executable.ValidateOnExecution;

import br.com.etechoracio.monitoria.model.Disciplina;
import br.com.etechoracio.monitoria.model.Disponibilidade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

	@NotNull
	private long id;

	@NotNull
	private String nome;
	
	@Null
	@Size(max=200)
	private String avatar;
	
	//"+55 | 11955555555"
	@NotNull
	@Size(min=11, max=14)
	private String whatsapp;
	
	@Null
	@Size(max=200)
	private String habilidades;

	private DisciplinaDTO disciplina;

	private List<DisponibilidadeDTO> disponibilidades;

	public String getWhatsapp(){
		return whatsapp;
	};

	public DisciplinaDTO getDisciplina(){
		return disciplina;
	};

	public List<DisponibilidadeDTO> getDisponibilidades(){
		return disponibilidades;
	}

	public void setDisciplina(DisciplinaDTO disc) {
		disciplina = disc;
	}

	public void setDisponibilidade(List<DisponibilidadeDTO> disponibilidadesResultado) {
		disponibilidades = disponibilidadesResultado;
	}


}
