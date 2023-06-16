package dao.usuario;

import dao.compartido.DeSerializer;
import dao.modelo.Usuario;

public class UsuarioDeserializer implements DeSerializer{

	@Override
	public Object deSerializar(String linea) {
		
		// 78sdf4sd8f5sd8fs755788,nombreusuario,contrasena
		
		final String SEPARATOR = ",";
		
		String[] datosDelUsuario = linea.split(SEPARATOR);
		
		Usuario usuario = new Usuario();
		
		usuario.setId(datosDelUsuario[0]);
		usuario.setUserName(datosDelUsuario[1]);
		usuario.setPassword(datosDelUsuario[2]);
		
		return usuario;
	}

}
