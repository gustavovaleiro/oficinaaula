package br.com.digitalhouse.oficina.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.digitalhouse.oficina.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private Long exp;
	
	public String generateToken(Usuario usuario) {
		
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("usrid", usuario.getId());
		claims.put("roles", usuario.getRoles());
		
		return Jwts.builder()
		   .setSubject(usuario.getUsername())
		   .setExpiration(new Date(System.currentTimeMillis() + exp))
		   .signWith(SignatureAlgorithm.HS512, secret.getBytes())
		   .addClaims(claims)
		   .compact();
		  
		
	}

}
