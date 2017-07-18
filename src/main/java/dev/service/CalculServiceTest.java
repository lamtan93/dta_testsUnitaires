package dev.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.exception.CalculException;

public class CalculServiceTest {

	private static final Logger LOG = LoggerFactory.getLogger(CalculServiceTest.class);

	@Test
	public void testAdditionner() throws Exception {

		LOG.info("Etant donn�, une instance de la classe CalculService");

		// TODO
		CalculService calService = new CalculService();

		LOG.info("Lorsque j'�value l'addition de l'expression 1+3+4");

		// TODO

		int somme = calService.additionner("1+3+4");

		LOG.info("Alors j'obtiens le resultat 8");

		assert somme == 8;
		// TODO

	}

	@Test
	public void testExceptionWithExpressionNonValide() {

		LOG.info("Etant donn�, une instance de la classe CalculService");

		// TODO
		CalculService calService = new CalculService();

		LOG.info("Lorsque j'�value l'addition de l'expression 1+3+4");

		// TODO

		int somme = 0;
		try {
			somme = calService.additionner("");
		} catch (CalculException e) {

			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testSomme3valeurs() throws Exception {

		LOG.info("Etant donné, une instance de la classe CalculService");

		// TODO
		CalculService calService = new CalculService();
		LOG.info("Lorsque j'évalue l'addition de l'expression 1+3+4");

		// TODO
		int somme = calService.additionner("1+3+4");

		LOG.info("Alors j'obtiens le résultat 8");

		assertThat(somme).isEqualTo(8);

	}

}
