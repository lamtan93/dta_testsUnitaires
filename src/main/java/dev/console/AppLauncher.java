package dev.console;

import java.util.Scanner;

import dev.exception.CalculException;
import dev.service.CalculService;

public class AppLauncher {

	public static void main(String[] args) throws CalculException {

		try (Scanner scanner = new Scanner(System.in)) {

			new App(scanner, new CalculService()).demarrer();

		}

}

}