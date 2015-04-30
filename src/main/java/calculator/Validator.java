package calculator;

import javax.enterprise.context.SessionScoped;

import java.io.Serializable;

@SessionScoped
public class Validator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String validaZero(String expression, String id, Double result) {

		expression += "0";

		return expression;
	}

	public String validaNumber(String expression, String number, Double result) {

		String add = "";

		switch (number) {

		case "num1":
			add = "1";
			break;
		case "num2":
			add = "2";
			break;
		case "num3":
			add = "3";
			break;
		case "num4":
			add = "4";
			break;
		case "num5":
			add = "5";
			break;
		case "num6":
			add = "6";
			break;
		case "num7":
			add = "7";
			break;
		case "num8":
			add = "8";
			break;
		case "num9":
			add = "9";
			break;
		case "pi":
			add = "pi";
			break;
		case "e":
			add = "e";
			break;
		}

		if (expression.equals("0"))
			expression = add;
		else
			expression += add;

		return expression;
	}

	public String validaOperator(String expression, String operator,
			Double result) {

		String add = "";

		switch (operator) {

		case "plus":
			add = "+";
			break;
		case "minus":
			add = "-";
			break;
		case "times":
			add = "*";
			break;
		case "divide":
			add = "/";
			break;
		case "openParent":
			add = "(";
			break;
		case "closeParent":
			add = ")";
			break;
		case "sqrt":
			add = "sqrt";
			break;
		case "sin":
			add = "sin";
			break;
		case "cos":
			add = "cos";
			break;
		case "tan":
			add = "tan";
			break;
		case "invSin":
			add = "asin";
			break;
		case "invCos":
			add = "acos";
			break;
		case "invTan":
			add = "atan";
			break;
		case "square":
			add = "sqr";
			break;
		case "absolute":
			add = "abs";
			break;
		case "exp":
			add = "exp";
			break;
		case "log":
			add = "log";
			break;
		case "cubicRoot":
			add = "cbrt";
			break;
		case "pow":
			add = "^";
			break;
		}

		if (expression.equals(""))
			expression = Double.toString(result) + add;
		else
			expression += add;
		/*
		 * else if (isLastCharNumeric(expression)) expression += add; else
		 * expression = expression.substring(0, expression.length() - 1) + add;
		 */

		return expression;
	}

	public String validaDot(String expression, String dot, Double result) {

		if (dot.equals("dot")) {
			if (!lastChar(expression).equals("."))
				expression += ".";
		}

		return expression;

	}

	public String lastChar(String str) {

		String lastChar = "";

		if (str.length() > 1)
			lastChar = str.substring(str.length() - 1, str.length());
		else
			lastChar = str;

		return lastChar;
	}

	public boolean isLastCharNumeric(String str) {
		try {
			double d = Double.parseDouble(lastChar(str));
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
