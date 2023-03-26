package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscritorDeArchivoDeTexto implements EscritorDeArchivo{

	/**
	 * 
	 */
	@Override
	public void crear(Archivo archivo) {
		
		String basePath = this.getBasePath();
		
		String nombreArchivo = archivo.getNombreArchivo();
		
		String rutaCompleta = basePath + "\\" + nombreArchivo + ".txt";
		
		appendUsingPrintWriter(rutaCompleta, archivo.getContenido());
	}
	
	
	private void appendUsingPrintWriter(String filePath, String text) {
		File file = new File(filePath);
		FileWriter fr = null;
		BufferedWriter br = null;
		PrintWriter pr = null;
		try {
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			pr = new PrintWriter(br);
			pr.println(text);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				pr.close();
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
