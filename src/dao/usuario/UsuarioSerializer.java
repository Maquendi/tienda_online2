package dao.usuario;

import dao.compartido.Serializador;
import dao.modelo.Usuario;
import dao.modelo.Persona;

public class UsuarioSerializer implements Serializador {


	private Usuario usuario;
	
	public UsuarioSerializer(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	@Override
	public String serializar() {
		final var SEPARATOR = ",";

		var usuarioStringBuilder = new StringBuilder();
		
		// 78sdf4sd8f5sd8fs755788,nombreusuario,contrasena
		
		return usuarioStringBuilder
		    .append(usuario.getId())
		    .append(SEPARATOR)
		    .append(usuario.getUserName())
		    .append(SEPARATOR)
		    .append(usuario.getPassword())
		    .toString();
	}

}
