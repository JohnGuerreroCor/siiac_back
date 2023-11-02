package com.usco.edu.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Usuario implements Serializable {

	private int codigo;

	private String username;

	private String password;

	private boolean state;

	private PersonaUsuario persona;

	private String role;

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", username=" + username + ", password=" + password 
				+ ", state=" + state + ", persona=" + persona + ", role=" + role + "]";
	}
	
	private static final long serialVersionUID = 1L;

}