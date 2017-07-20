package dev.console;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.exception.CalculException;
import dev.service.CalculService;

public class AppTest {

	@Rule

	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	private App app;

	private CalculService calculService;

	private static final Logger LOG = LoggerFactory.getLogger(AppTest.class);

	@Before

	public void setUp() throws Exception {

		// this.calculService = new CalculService();
		//
		// this.app = new App(new Scanner(System.in), calculService);

		Scanner sc = new Scanner(System.in);
		this.calculService = mock(CalculService.class);
		this.app = new App(sc, calculService);

	}

	@Test
	public void testAfficherTitre() throws Exception {

		this.app.afficherTitre();

		String logConsole = systemOutRule.getLog();


		assertThat(logConsole).contains("**** Application Calculatrice ****");

	}

	@Test

	public void testEvaluer() throws Exception {

		LOG.info("Etant donné, un service CalculService qui retourne 35 à l'évaluation de l'expression 1+34");

		String expression = "1+34";

		when(calculService.additionner(expression)).thenReturn(35);

		LOG.info("Lorsque la méthode evaluer est invoquée");

		this.app.evaluer(expression);

		LOG.info("Alors le service est invoqué avec l'expression {}", expression);

		verify(calculService).additionner(expression);

		LOG.info("Alors dans la console, s'affiche le resultat attendu" + "\n");

		assertThat(systemOutRule.getLog()).contains("1+34=35");

	}

	@Test
	public void testEvaluerWithExpressionNonValide() {

		try {
			calculService.additionner("");
		} catch (CalculException e) {
			LOG.info(e.getMessage());

		}

	}

	// Synthese
	@Test
	public void testDemarrer_ValeurSaisie_Fin_etape1() throws CalculException {

		app.demarrer();

		String console = systemOutRule.getLog();
		assertThat(console.contains("Au revoir")).isTrue();

	}

	// TODO
	// @Test
//	public void test_Synthese_etap2() throws CalculException {
//
//		// String expression = ("1+2");
//		systemInMock.provideLines("1+2");
//
//		app.demarrer();
//		when(calculService.additionner(expression)).thenReturn(3);
//
//		this.app.evaluer(expression);
//
//		LOG.info("Alors le service est invoqué avec l'expression {}", expression);
//
//		verify(calculService).additionner(expression);
//
//		LOG.info("Alors dans la console, s'affiche 1+2=3" + "\n");
//
//		assertThat(systemOutRule.getLog()).contains("1+2=3");
//
//
//	}

}