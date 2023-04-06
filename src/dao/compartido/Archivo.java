package dao.compartido;


// pojo -->> plain old java object....
// Dto -- >>  data transfer object....

public class Archivo {
	
	private String nombreArchivo;
	
	private String contenido;
	
	public String getContenido() {
	  return contenido;	
	}
	
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
}