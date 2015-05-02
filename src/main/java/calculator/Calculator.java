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
		ecra="";
		result="";
		memory="";
	

	}

	public void keyZero(ActionEvent event){

		ecra = validator.validaZero(getEcra(), event.getComponent().getId(), getResult());
	}

	public void keyDot(ActionEvent event){

		ecra = validator.validaDot(getEcra(), event.getComponent().getId(), getResult());
	}

	public void key(ActionEvent event){

		ecra = validator.validaNumber(getEcra(), event.getComponent().getId(), getResult());
		
		}

	public void keyOperator(ActionEvent event){

		ecra = validator.validaOperator(getEcra(), event.getComponent().getId(), getResult());
		statistic.countOperator(event.getComponent().getId());
	}


	public String expressionBuilder(String expression ) throws Exception {

		
		Expression e = new ExpressionBuilder(expression)
		.variables("pi","e")
		.build()
		.setVariable("e",Math.E)
		.setVariable("pi",Math.PI);
		result= Double.toString(e.evaluate());
		

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
				ecra = "erro!";
				result="0";
			}
			

		}
	}

	public void keyClear(ActionEvent event){

		if(event.getComponent().getId().equals("clear")){

			setResult("0");
			setEcra("");

		}
	}

	public void keyClearEntry(ActionEvent event){


		if(event.getComponent().getId().equals("clearEntry"))	
			setEcra("");

	}

	public void keyMemo(ActionEvent event){

		if(event.getComponent().getId().equals("memo")){
			memory=result;
		}

	}

	public void keyMemoMr(ActionEvent event){

		if(event.getComponent().getId().equals("memoMr"))
			try {
				ecra=ecra+"+"+memory;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				ecra = "erro!";
			}

	}

	public void keyMemoCl(ActionEvent event){

		if(event.getComponent().getId().equals("memoCl"))
			setMemory("0");

	}

	public void keyDelete(ActionEvent event){

		ecra = validator.validaDelete(getEcra(), event.getComponent().getId(), getResult());

	}
	
	public void insertEcraHistoric(ItemHistoric item, String var){
		
		if (var.equals("ecraHistoric")) 
			this.ecra= item.getEcraHistoric();

	
	
	}
	
	public void insertResultHistoric(ItemHistoric item, String var){
		
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

	public void setResult(String result) {
		this.result = result;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}




}

