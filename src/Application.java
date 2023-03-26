import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

import dao.Archivo;
import dao.EscritorDeArchivoDeTexto;
import dao.LectorDeArchivoDeTexto;
import dao.persona.PersonDeserializer;
import dao.persona.PersonSerializer;
import modelo.Persona;

public class Application {

	
	
	public static void main(String[] args) {
		
		probarLeerPersona();
	}
	
	
	public static void probarLeerPersona() {
		
		LectorDeArchivoDeTexto lector = new LectorDeArchivoDeTexto();
		
		Object[] personasLeidas = lector.leer("archivo_personas", new PersonDeserializer());
		
		
		System.out.println(Arrays.toString(personasLeidas));
	}
	
	public static void probarCrearPersona() {
		
		EscritorDeArchivoDeTexto escritor = new EscritorDeArchivoDeTexto();
		
		Archivo archivoTexto = new Archivo();
		archivoTexto.setNombreArchivo("archivo_personas");
		//archivoTexto.setContenido("Yefri,Feliz,Guillen,M,felizguillen@gmail.com,15-05-2010");
		
		Persona maquendi = new Persona();
		
		maquendi.setNombre("Maquendi");
		maquendi.setApellidoPaterno("Beltran");
		maquendi.setApellidoMaterno("Novas");
		maquendi.setEmail("mbn04251989@gmail.com");
		maquendi.setFechaDeNacimiento(LocalDate.of(1989, 04, 25));
		maquendi.setSexo("M");
		maquendi.setId(UUID.randomUUID().toString());
			
		
		PersonSerializer serializer = new PersonSerializer(maquendi);
		
		String personaValor = serializer.serializar();
		
		archivoTexto.setContenido(personaValor);
		
		escritor.crear(archivoTexto);
	}
}
