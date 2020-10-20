package br.com.digitalhouse.oficina.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.digitalhouse.oficina.model.AuthResponse;
import br.com.digitalhouse.oficina.model.Credential;
import br.com.digitalhouse.oficina.model.Usuario;
import br.com.digitalhouse.oficina.security.JwtUtil;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {
	
	private final AuthenticationManager authenticationManager;
    private final UsuarioService usuarioService;
	private final JwtUtil jwtUtil;
	
	public AuthResponse login(Credential credential) {
		
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(credential.getUsername(), credential.getPassword());
		
		Authentication authenticate = this.authenticationManager.authenticate(authenticationToken );
		
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		
		Usuario usuario = this.usuarioService.findByUsername(credential.getUsername());
		
		
		String jwt = this.jwtUtil.generateToken(usuario);
		
		return AuthResponse.builder()
				.jwt(jwt)
				.build();
		
	}

}
