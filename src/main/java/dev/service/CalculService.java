package dev.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.exception.CalculException;

public class CalculService {

	private static final Logger LOG = LoggerFactory.getLogger(CalculService.class);

	public int additionner(String expression) throws CalculException {

		LOG.debug("Evaluation de l'expression " + expression);

		int sum = 0;

		if ((expression.trim() == null) || (expression.trim().isEmpty())) {
			throw new CalculException();
		} else {
			for (int i = 0; i < expression.length(); i++) {

				if (Character.isDigit(expression.charAt(i))) {

					sum = sum + Character.getNumericValue(expression.charAt(i));
				}
			}

			return sum;
		}



	}

}
