package org.flim.registro_cliente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


@SpringBootApplication
public class RegistroClienteApplication implements CommandLineRunner {

	//Profesionalizar nuestro SOUT con un logger
	private static final Logger logger = LoggerFactory.getLogger(RegistroClienteApplication.class);
	//Agregar un String para el salto de linea
	String salto = System.lineSeparator();

	public static void main(String[] args) {
		//antes de iniciar
		logger.info("Iniciado la aplicacion");
		SpringApplication.run(RegistroClienteApplication.class, args);
		//al finalizar
		logger.info("Aplicacion finalizada");
	}

	@Override
	public void run(String... args) throws Exception {
		registroClientesApp();
	}
	private void registroClientesApp(){
		logger.info("+++++Bienvenido a la aplicacion de Registro de Cliente+++++");
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir){
			var opcion = mostrarMenu(consola);
			salir = ejecutarOpciones(consola, opcion);
			logger.info(salto);
		}
	}
	private int mostrarMenu(Scanner consola){
		logger.info("""
				***Aplicacion***
				1.Listar Cliente
				2.Buscar Cliente
				3.Agregar Cliente
				4.Mopdificar Cliente
				5.Eliminar Cliente
				6.Salir
				""");
		return 0;
	}
	private boolean ejecutarOpciones(Scanner consola, int opcion){
		return false;
	}
}
