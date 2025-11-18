package com.VitorElias.EventPass.EventPass.Mapper;

import com.VitorElias.EventPass.EventPass.Dto.Usuario.UsuarioRequestDTO;
import com.VitorElias.EventPass.EventPass.Dto.Usuario.UsuarioResponseDTO;
import com.VitorElias.EventPass.EventPass.Model.Usuario;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {

    private UsuarioMapper() {}

    public static Usuario toEntity(UsuarioRequestDTO dto) {
        if (dto == null) return null;
        return new Usuario(
                dto.getId(),
                dto.getNome(),
                dto.getEmail(),
                dto.getSenha(),
                dto.getCpf(),
                dto.getTelefone(),
                dto.getDataNascimento()
        );
    }
    public static UsuarioResponseDTO toDto(Usuario usuario) {
        if (usuario == null) return null;
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getDataNascimento(),
                usuario.isAtivo()
        );
    }
    public static List<UsuarioResponseDTO> toDtoList(List<Usuario> usuarios) {
        if (usuarios == null) return Collections.emptyList();

        return usuarios.stream()
                .map(UsuarioMapper::toDto)
                .collect(Collectors.toList());
    }
}
