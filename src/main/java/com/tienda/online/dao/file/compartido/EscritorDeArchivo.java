package com.tienda.online.dao.file.compartido;

import java.util.List;

public interface EscritorDeArchivo {
	
	void escribir(String nombreArchivo, Linea linea);

	void escribir(String nombreArchivo, List<Linea> linea);
	
	default String getBasePath() {
		final String basePath = System.getProperty("user.dir");
		return basePath + "\\" + "archivos\\";
	}
}
