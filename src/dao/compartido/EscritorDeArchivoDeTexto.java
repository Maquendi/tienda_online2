package dao.compartido;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EscritorDeArchivoDeTexto implements EscritorDeArchivo{

	/**
	 * 
	 */
	@Override
	public void escribir(String nombreArchivo, Linea linea) {
		
		String basePath = this.getBasePath();
		
		String rutaCompleta = basePath + "\\" + nombreArchivo + ".txt";
		
		appendUsingPrintWriter(rutaCompleta, List.of(linea.getContenido()), false);
	}
	
	
	private void appendUsingPrintWriter(String filePath, List<String> lineas, boolean cleanFirst) {
		File file = new File(filePath);
		FileWriter fr = null;
		BufferedWriter br = null;
		PrintWriter pr = null;
		try {
			
			if(cleanFirst)
			{
				file.delete();
			}
			
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			pr = new PrintWriter(br);
						
			for(int i=0; i < lineas.size(); i++) {
				pr.println(lineas.get(i));
			}
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



	@Override
	public void escribir(String nombreArchivo, List<Linea> lineas) {
		
		String basePath = this.getBasePath();
		
		String rutaCompleta = basePath + "\\" + nombreArchivo + ".txt";
		
		List<String> listaContenidos = lineas.stream().map(line -> line.getContenido())
		           .collect(Collectors.toList());
		
		appendUsingPrintWriter(rutaCompleta, listaContenidos, true);
	}
}
