package com.VitorElias.EventPass.EventPass.Repository;

import com.VitorElias.EventPass.EventPass.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
