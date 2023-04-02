package dao.compartido;

public interface LectorDeArchivo {
	Object[] leer(String nombreArchivo, DeSerializer deSerializer);
  
	default String getBasePath() {
		final String basePath = System.getProperty("user.dir");
		return basePath + "\\" + "archivos\\";
	}
}
