package com.VitorElias.EventPass.EventPass.Service;

import com.VitorElias.EventPass.EventPass.Dto.Usuario.UsuarioRequestDTO;
import com.VitorElias.EventPass.EventPass.Dto.Usuario.UsuarioResponseDTO;
import com.VitorElias.EventPass.EventPass.Mapper.UsuarioMapper;
import com.VitorElias.EventPass.EventPass.Model.Usuario;
import com.VitorElias.EventPass.EventPass.Repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    public UsuarioResponseDTO create(UsuarioRequestDTO usuario){
         logger.info("Entrando na função create com o parametro Usuario: \n {}",usuario);
         Usuario u = UsuarioMapper.toEntity(usuario);

         logger.info("convertendo a classe usuarioRequestDTO para usuario: \n {} ",u);
         usuarioRepository.save(u);

         logger.info("Salvando o usuario novo no banco de dados convertendo e retornando ao banco! ");
         return UsuarioMapper.toDto(u);
    }

    public UsuarioResponseDTO update(UsuarioRequestDTO usuarioDTO, Long id){

        logger.info("Recebendo os dados da função {} \n , E buscando o usuario com o id ={}",usuarioDTO,id);
        Optional<Usuario> u = usuarioRepository.findById(id);

        logger.info("convertendo optional em usuario");
        Usuario usuario = u.get();
        logger.info("buscando usuario {}",usuario);

        usuario.setNome(usuarioDTO.getNome());
        logger.info("Atualizando nome do usuario  {}",usuarioDTO.getNome());

        usuario.setEmail(usuarioDTO.getEmail());
        logger.info("Atualizando email do usuario {}",usuarioDTO.getEmail());

        usuario.setSenha(usuarioDTO.getSenha());
        logger.info("Atualizando senha do usuario {}",usuarioDTO.getSenha());

        usuario.setCpf(usuarioDTO.getCpf());
        logger.info("Atualizando CPF do usuario {}",usuarioDTO.getCpf());

        usuario.setTelefone(usuarioDTO.getTelefone());
        logger.info("Atualizando telefone do usuario {}",usuarioDTO.getTelefone());

        usuario.setDataNascimento(usuarioDTO.getDataNascimento());
        logger.info("Atualizando data de nascimento do usuario {}",usuarioDTO.getDataNascimento());

        usuarioRepository.save(usuario);
        logger.info("salvando usuario {}",usuario);

        return UsuarioMapper.toDto(usuario);


    }

    public UsuarioResponseDTO findAll(){
        logger.info("Buscando todos os usuarios");
        return (UsuarioResponseDTO) UsuarioMapper.toDtoList(usuarioRepository.findAll());
    }

    public UsuarioResponseDTO findById(long id){
        logger.info("Recebendo o id do parametro id={}",id);
        Usuario u = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado para id: " + id));
        logger.info("Usuario encontrado: {}", u);

        return UsuarioMapper.toDto(u);
    }

    public void deleteById(Long id){
        logger.info("Recebendo dados do parametro e passsando para a função!");
        usuarioRepository.deleteById(id);
        logger.info("Sucesso");
    }
}
