package br.com.etechoracio.monitoria.business;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etechoracio.monitoria.dao.ConexaoDAO;
import br.com.etechoracio.monitoria.dto.ConexaoDTO;
import br.com.etechoracio.monitoria.dto.IdentificadorDTO;
import br.com.etechoracio.monitoria.model.Conexao;

@Service
public class ConexaoBussines {
    
    ConexaoDTO conexaoDTO;

    @Autowired
    ConexaoDAO conexaoDAO;

    @Autowired
    ModelMapper mapper;

    public ConexaoDTO inserir(ConexaoDTO cnxDTO)
    {
        Conexao aSalvar = mapper.map(cnxDTO, Conexao.class);

        conexaoDAO.save(aSalvar);

        ConexaoDTO resultado = mapper.map(aSalvar, ConexaoDTO.class);

        return resultado;

    }

}