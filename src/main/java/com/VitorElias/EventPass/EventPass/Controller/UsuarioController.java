package com.VitorElias.EventPass.EventPass.Controller;

import com.VitorElias.EventPass.EventPass.Dto.Usuario.UsuarioRequestDTO;
import com.VitorElias.EventPass.EventPass.Dto.Usuario.UsuarioResponseDTO;
import com.VitorElias.EventPass.EventPass.Service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final static Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService service;

    @PutMapping("/")
    public ResponseEntity<UsuarioResponseDTO> create(@RequestBody UsuarioRequestDTO usuario){

        logger.info("Recebendo usuario, chamando a service o metodo create e com o parametro usuario: {}",usuario);
        UsuarioResponseDTO usuarioResponse = service.create(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioResponse);
    }


}
