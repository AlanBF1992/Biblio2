package cl.praxis.Gestor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestorBibliotecaApplication implements CommandLineRunner {

	private final static Logger LOG = LoggerFactory.getLogger(GestorBibliotecaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GestorBibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("Iniciando el Gestor de Biblioteca 0.0.1");
		LOG.info("Haciendo lo que se pide, aka, nada");
	}
}
