package com.thalles.teste.stock.auth.authservice.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.thalles.teste.stock.auth.authservice.model.Usuario;
import com.thalles.teste.stock.auth.authservice.repository.UsuarioRepository;

@Service // It has to be annotated with @Service.
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		// hard coding the users. All passwords must be encoded.
		Usuario usuario = repository.findById(email).get();
		if (usuario != null) {
			List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                	.commaSeparatedStringToAuthorityList("ROLE_TESTE");
			return new User(usuario.getEmail(), usuario.getSenha(), grantedAuthorities);
		} else {
			throw new UsernameNotFoundException("Username: " + email + " not found");
		}

	}
}