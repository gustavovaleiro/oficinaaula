package br.com.digitalhouse.oficina.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.digitalhouse.oficina.model.Usuario;
@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByUsername(String username);

}
