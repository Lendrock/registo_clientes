package org.flim.registro_cliente;

import org.flim.registro_cliente.entity.Cliente;
import org.flim.registro_cliente.repository.ClienteRepository;
import org.flim.registro_cliente.service.ClienteService;
import org.flim.registro_cliente.service.IClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;


//@SpringBootApplication
public class RegistroClienteApplication implements CommandLineRunner {
	//Inyeccion de dependencias
	@Autowired
	private IClienteService clienteService;

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
		var opcion = Integer.parseInt(consola.nextLine());
		return opcion;
	}
	private boolean ejecutarOpciones(Scanner consola, int opcion){
		var salir = false;
		switch (opcion){
			case 1 -> {
				logger.info(salto+"***Lista de Clientes***"+salto);
				List<Cliente> clientes = clienteService.listarClientes();
				clientes.forEach(cliente -> logger.info(cliente.toString()+salto));
			}
			case 2 ->{
				logger.info(salto+"***Buscar Cliente por su código***"+salto);
				var codigo = Integer.parseInt(consola.nextLine());
				Cliente cliente = clienteService.buscarClienteporId(codigo);
				if (cliente != null){
					logger.info("Cliente encontrado" + cliente + salto);
				}else{
					logger.info("Cliente No encontrado" + cliente + salto);
				}
			}
			case 3 -> {
				logger.info(salto+"***Agregar Cliente***"+salto);
				logger.info("Ingrese el nombre del Cliente: ");
				var nombre = consola.nextLine();
				logger.info("Ingrese el apellido del Cliente: ");
				var apellido = consola.nextLine();
				logger.info("Ingrese el telefono del Cliente: ");
				var telefono = consola.nextLine();
				logger.info("Ingrese el correo del Cliente: ");
				var correo = consola.nextLine();
				logger.info("Ingrese el genero del Cliente: ");
				var genero = consola.nextLine();
				logger.info("Ingrese el edad del Cliente: ");
				var edad = Integer.parseInt(consola.nextLine());
				var cliente = new Cliente();
				cliente.setNombre(nombre);
				cliente.setApellido(apellido);
				cliente.setTelefono(telefono);
				cliente.setCorreo(correo);
				cliente.setGenero(genero);
				cliente.setEdad(edad);
				clienteService.guardarCliente(cliente);
				logger.info("Cliente agregado" + cliente+salto);
			}
			case 4 -> {
				logger.info(salto + "***Modificar Cliente***" + salto);
				//buscar por codigo
				logger.info("Agregue el código del cliente a modificar: ");
				var codigo = Integer.parseInt(consola.nextLine());
				Cliente cliente = clienteService.buscarClienteporId(codigo);
				//guardar si no es null
				if (cliente != null){
					logger.info("Ingrese el nombre del Cliente: ");
					var nombre = consola.nextLine();
					logger.info("Ingrese el apellido del Cliente: ");
					var apellido = consola.nextLine();
					logger.info("Ingrese el telefono del Cliente: ");
					var telefono = consola.nextLine();
					logger.info("Ingrese el correo del Cliente: ");
					var correo = consola.nextLine();
					logger.info("Ingrese el genero del Cliente: ");
					var genero = consola.nextLine();
					logger.info("Ingrese el edad del Cliente: ");
					var edad = Integer.parseInt(consola.nextLine());
					cliente.setNombre(nombre);
					cliente.setApellido(apellido);
					cliente.setTelefono(telefono);
					cliente.setCorreo(correo);
					cliente.setGenero(genero);
					cliente.setEdad(edad);
					clienteService.guardarCliente(cliente);
					logger.info("Cliente modificado" + cliente+salto);
				}else {
					logger.info("Cliente No encontrado" + cliente + salto);
				}
			}
			case 5 -> {
				logger.info(salto + "***Eliminar Cliente***" + salto);
				logger.info(salto+"Ingrese el código del cliente a eliminar: " + salto);
				var codigo = Integer.parseInt(consola.nextLine());
				var cliente = clienteService.buscarClienteporId(codigo);
				if (cliente != null){
					clienteService.eliminarCliente(cliente);
					logger.info("Cliente eliminado, adios "+ cliente + salto);
				}else{
					logger.info("Cliente No encontrado " + cliente + salto);
				}
			}
			case 6 ->{
				logger.info("Fiuuuuumba " + salto + salto);
				salir=true;
			}
			default -> logger.info("Opción invalida");

		}
		return false;
	}
}
