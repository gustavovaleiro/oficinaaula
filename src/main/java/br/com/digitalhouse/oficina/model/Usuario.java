package br.com.digitalhouse.oficina.model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Usuario  {
	
	

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length=8, nullable = false)
	private String username;
	
	@Column(length=100, nullable = false)
	private String senha;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "usuarios_roles",
			joinColumns = @JoinColumn(name="usuario_id"),
			inverseJoinColumns  = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public List<String> getSimpleRoles() {
		return this.roles.stream().map(role -> role.getName()).collect(Collectors.toList());
	}
}
