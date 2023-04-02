package dao.compartido;

public interface EscritorDeArchivo {
	
	void crear(Archivo archivo);
	
	default String getBasePath() {
		final String basePath = System.getProperty("user.dir");
		return basePath + "\\" + "archivos\\";
	}
}
