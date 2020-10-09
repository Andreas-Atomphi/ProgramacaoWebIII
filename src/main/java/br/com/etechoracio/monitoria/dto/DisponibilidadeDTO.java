package br.com.etechoracio.monitoria.dto;

import java.util.Date;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.etechoracio.monitoria.enums.DiaSemanaEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisponibilidadeDTO {
	
	@NotNull
	private Long id;
	
	@Null
	@Size(max=15)
	private DiaSemanaEnum diaSemanaEnum;
	
	@NotNull
	@FutureOrPresent
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern= "hh:mm")
	private Date horaInicio;

	@NotNull
	@FutureOrPresent
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern= "hh:mm")
	private Date horaFim;

}
