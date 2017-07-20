package dev.console;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.exception.CalculException;
import dev.service.CalculService;

public class App {
	private static final Logger LOG = LoggerFactory.getLogger(App.class);

	private Scanner scanner;

	private CalculService calculatrice;

	public App(Scanner scanner, CalculService calculatrice) {

		this.scanner = scanner;

		this.calculatrice = calculatrice;

	}

	protected void afficherTitre() {
		LOG.info("**** Application Calculatrice ****");

	}

	public void demarrer() throws CalculException {
		afficherTitre();

		// Synthèse
		while (true) {
			LOG.info("Veuillez saisir une expression :");
			String expression = scanner.next();

			if (expression.equalsIgnoreCase("Fin")) {
				LOG.info("Au revoir");
				break;
			} else {
				evaluer(expression);
			}
		}

	}

	protected void evaluer(String expression) {
		try {
			int somme = calculatrice.additionner(expression);
			LOG.info("{}={}", expression, somme);
		} catch (CalculException e) {
			LOG.info(e.getMessage());

		}

	}

}