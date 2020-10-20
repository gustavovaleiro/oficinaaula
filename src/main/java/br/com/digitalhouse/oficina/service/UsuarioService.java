package br.com.digitalhouse.oficina.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.digitalhouse.oficina.model.Role;
import br.com.digitalhouse.oficina.model.Usuario;
import br.com.digitalhouse.oficina.repository.RoleRepository;
import br.com.digitalhouse.oficina.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private UsuarioRepository usuarioRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository,
			RoleRepository roleRepository,
			BCryptPasswordEncoder encoder) {
		this.usuarioRepository = usuarioRepository;
		this.roleRepository = roleRepository;
		this.encoder = encoder;
	}

	

	
	@Transactional
	public Usuario create(Usuario usuario) {
		
		usuario.getRoles().stream()
		  .filter( r -> r.getId() == null)
		  .forEach(r -> {
			  r = this.roleRepository.save(r);
		  });
		
		usuario.setSenha(this.encoder.encode(usuario.getSenha()));
		
		return this.usuarioRepository.save(usuario);
	
	}
	
	public List<Usuario> findAll(){
		return this.usuarioRepository.findAll();
	}
	
	
	public List<Role> findAllRole(){
		return this.roleRepository.findAll();
	}

	
	public Usuario findByUsername(String username) {
		return this.usuarioRepository.findByUsername(username)
				.orElseThrow(() ->  new RuntimeException("usuario não encontrado"));
	}
	
	
	
	
	
	
	
	
	
	
	
}
