package com.VitorElias.EventPass.EventPass.Service;

import com.VitorElias.EventPass.EventPass.Dto.Usuario.UsuarioRequestDTO;
import com.VitorElias.EventPass.EventPass.Dto.Usuario.UsuarioResponseDTO;
import com.VitorElias.EventPass.EventPass.Mapper.UsuarioMapper;
import com.VitorElias.EventPass.EventPass.Model.Usuario;
import com.VitorElias.EventPass.EventPass.Repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioResponseDTO create(UsuarioRequestDTO usuario){
         Usuario u = UsuarioMapper.toEntity(usuario);
         usuarioRepository.save(u);
         return UsuarioMapper.toDto(u);
    }

    public UsuarioResponseDTO update(UsuarioRequestDTO usuarioDTO, Long id){

        Optional<Usuario> u = usuarioRepository.findById(id);
        Usuario usuario = u.get();

        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setTelefone(usuarioDTO.getTelefone());
        usuario.setDataNascimento(usuarioDTO.getDataNascimento());

        usuarioRepository.save(usuario);
        return UsuarioMapper.toDto(usuario);


    }

    public UsuarioResponseDTO findAll(){return (UsuarioResponseDTO) UsuarioMapper.toDtoList(usuarioRepository.findAll());}

    public UsuarioResponseDTO findById(long id){
        Optional<Usuario> u = usuarioRepository.findById(id);
        return UsuarioMapper.toDto(u.get());
    }

    public void deleteById(Long id){
        usuarioRepository.deleteById(id);
    }
}
