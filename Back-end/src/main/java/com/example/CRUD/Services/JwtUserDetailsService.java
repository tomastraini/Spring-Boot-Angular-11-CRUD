package com.example.CRUD.Services;

import java.util.ArrayList;

import com.example.CRUD.Models.Usuarios;
import com.example.CRUD.Repositories.UsuariosRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	public UsuariosRepo repo;

	public JwtUserDetailsService(UsuariosRepo repo) {
		this.repo = repo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuarios us =  repo.findAll().stream().filter(x -> x.usuario.contains(username)).findFirst().get();

		if (us.usuario.equals(username)) {
			return new User(us.usuario, us.pass,
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}