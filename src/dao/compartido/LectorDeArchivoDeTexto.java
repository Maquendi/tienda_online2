package dao.compartido;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LectorDeArchivoDeTexto implements LectorDeArchivo {

	
	
	@Override
	public Object[] leer(String nombreArchivo, DeSerializer deSerializer) {
		
		String rutaBase = this.getBasePath();
		
		String nombreArchivoCompleto = rutaBase + nombreArchivo + ".txt";
		
		return leerContenido(nombreArchivoCompleto, deSerializer);
	}
	
	
	public Object[] leerContenido(String nombreArchivo, DeSerializer deSerializer)  { 
		Archivo archivo = new Archivo();
		archivo.setNombreArchivo(nombreArchivo);
		
		List<Object> objectosLeidos = new ArrayList<>();
		
    	String cadena; 
        FileReader f;
		try {
			f = new FileReader(nombreArchivo);
			
			BufferedReader b = new BufferedReader(f); 
	        
	        while((cadena = b.readLine())!=null) { 
	        	Object objeto = deSerializer.deSerializar(cadena);
	        	objectosLeidos.add(objeto);
	        } 
	        
	        b.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return objectosLeidos.toArray();
	} 

}
