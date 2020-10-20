package br.com.digitalhouse.oficina.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.digitalhouse.oficina.model.AuthResponse;
import br.com.digitalhouse.oficina.model.Credential;
import br.com.digitalhouse.oficina.service.AuthService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AuthResource {
	
	private final AuthService authService;
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login( @RequestBody Credential credential){
		
		AuthResponse login = this.authService.login(credential);
		
		return ResponseEntity.ok(login);
		
	
	}

}
