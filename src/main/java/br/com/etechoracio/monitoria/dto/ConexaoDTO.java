package br.com.etechoracio.monitoria.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;

@JsonSerialize
@Getter
@Setter
public class ConexaoDTO {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern= "dd/mm/yyyy HH:mm")
	private Date dataTentativa;
	
	private IdentificadorDTO usuario;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern= "dd/mm/yyyy HH:mm")
	public void setDataTentativa(Date data)
	{
		dataTentativa = data;
	}

	public void setUsuario(IdentificadorDTO usr)
	{
		usuario = usr;
	}

}
