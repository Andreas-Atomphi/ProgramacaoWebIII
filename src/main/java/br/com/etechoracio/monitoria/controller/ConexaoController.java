package br.com.etechoracio.monitoria.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.etechoracio.monitoria.business.ConexaoBussines;
import br.com.etechoracio.monitoria.dto.ConexaoDTO;
import br.com.etechoracio.monitoria.model.Conexao;

@RestController
@RequestMapping("/conexoes")
public class ConexaoController {
    
    private ConexaoBussines conexBussines;

    @Autowired
    ModelMapper mapper;

    @ResponseBody
    @PostMapping(
        consumes = "application/json", 
        produces = "application/json"
        )
    public ResponseEntity<Conexao> inserir(@RequestBody ConexaoDTO cnxDTO)
    {
       return ResponseEntity.ok(mapper.map(cnxDTO, Conexao.class));
    }
}