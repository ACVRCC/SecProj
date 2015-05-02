/**

 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
/*Trabalho executado por Alberto Centeno e Sérgio Moutinho*/

package calculator;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;
import net.objecthunter.exp4j.operator.Operator;

@Named
@SessionScoped
public class Calculator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String ecra;
	private String result;
	private String memory;


	@Inject
	Validator validator;
	@Inject
	Historic historic;
	@Inject
	Statistic statistic;

	public Calculator() {
		ecra = "";
		result = "0";
		memory = "";
	}

	public void keyDot(ActionEvent event) {

		ecra = validator.validaDot(getEcra(), event.getComponent().getId(),
				getResult());
	}

	public void key(ActionEvent event) {

		ecra = validator.validaNumber(getEcra(), event.getComponent().getId(),
				getResult());
	}
	
	Function cosd = new Function("cosd", 1) {
		@Override
		public double apply(double... args) {
			return Math.cos(Math.toRadians(args[0]));
		}
	};
	
	Function sind = new Function("sind", 1) {
		@Override
		public double apply(double... args) {
			return Math.sin(Math.toRadians(args[0]));
		}
	};
	
	Function tand = new Function("tand", 1) {
		@Override
		public double apply(double... args) {
			return Math.tan(Math.toRadians(args[0]));
		}
	};
	
	Function acosd = new Function("acosd", 1) {
		@Override
		public double apply(double... args) {
			return 180/Math.PI*Math.acos(args[0]);
		}
	};
	
	Function asind = new Function("asind", 1) {
		@Override
		public double apply(double... args) {
			return 180/Math.PI*Math.asin(args[0]);
		}
	};
	
	Function atand = new Function("atand", 1) {
		@Override
		public double apply(double... args) {
			return 180/Math.PI*Math.atan(args[0]);
		}
	};
	
	Operator factorial = new Operator("!", 1, true,
			Operator.PRECEDENCE_POWER + 1) {
		@Override
		public double apply(double... args) {
			final int arg = (int) args[0];
			if (arg != args[0]) {
				throw new IllegalArgumentException("Não é numero inteiro");
			}
			if (arg < 0) {
				throw new IllegalArgumentException(
						"Não pode ser inferior a zero");
			}
			double result = 1;
			for (int i = 1; i <= arg; i++) {
				result *= i;
			}
			return result;
		}
	};

	public void keyOperator(ActionEvent event) {

		ecra = validator.validaOperator(getEcra(),
				event.getComponent().getId(), getResult());
		statistic.countOperator(event.getComponent().getId());
	}

	public void keyFunction(ActionEvent event) {

		ecra = validator.validaFunction(getEcra(),
				event.getComponent().getId(), getResult());
		statistic.countOperator(event.getComponent().getId());
	}

	public String expressionBuilder(String expression) throws Exception {

		Expression e = new ExpressionBuilder(expression)
		.operator(factorial)
		.function(cosd)
		.function(sind)
		.function(tand)
		.function(acosd)
		.function(asind)
		.function(atand)
		.variables("pi", "e")
		.build()
		.setVariable("e", Math.E)
		.setVariable("pi", Math.PI);
		result = Double.toString(e.evaluate());

		return result;
	}

	public void keyEquals(ActionEvent event){

		if(event.getComponent().getId().equals("equals")){

			try {
				setResult(expressionBuilder(getEcra()));
				historic.addItems(getEcra(), getResult());
				ecra="";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				ecra = "expressão não válida!";
				result="0";
			}
		}
	}

	public void keyClear(ActionEvent event) {

		if (event.getComponent().getId().equals("clear")) {

			setResult("0");
			setEcra("");
		}
	}

	public void keyClearEntry(ActionEvent event) {

		if (event.getComponent().getId().equals("clearEntry"))
			setEcra("");
	}

	public void keyMemo(ActionEvent event) {

		if (event.getComponent().getId().equals("memo")) {
			memory = result;
		}
	}

	public void keyMemoMr(ActionEvent event) {

		if (event.getComponent().getId().equals("memoMr"))
			try {
				ecra = ecra + "+" + memory;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				ecra = "erro!";
			}
	}

	public void keyMemoCl(ActionEvent event) {

		if (event.getComponent().getId().equals("memoCl"))
			setMemory("");
	}

	public void keyDelete(ActionEvent event) {

		ecra = validator.validaDelete(getEcra(), event.getComponent().getId(),
				getResult());
	}

	public void insertHistoric(ItemHistoric item, String var){

		if (var.equals("ecraHistoric")) 
			this.ecra= item.getEcraHistoric();
		if (var.equals("resultHistoric")) 
			this.result= item.getResultHistoric();
	}

	public String getEcra() {
		return ecra;
	}

	public void setEcra(String ecra) {
		this.ecra = ecra;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String string) {
		this.result = string;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

}	