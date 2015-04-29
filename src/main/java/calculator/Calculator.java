/**

 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */

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
	private double result;
	private double memory;
	@Inject
	Validator validator;
	@Inject
	Historic historic;


	public Calculator() {
		ecra="";
		result=0;
		memory=0;

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
	}


	public double expressionBuilder(String expression ) throws Exception {

		Expression e = new ExpressionBuilder(expression)
		.build();
		result = e.evaluate();

		return result;
	}

	public void keyEquals(ActionEvent event){

		if(event.getComponent().getId().equals("equals")){
			
			historic.addEcras(getEcra());

			try {
				setResult(expressionBuilder(getEcra()));
				setEcra("");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				ecra = "erro!";
			}

		}
	}

	public void keyClear(ActionEvent event){

		if(event.getComponent().getId().equals("clear")){

			setResult(0);
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
			setMemory(0);

	}

	public String getEcra() {
		return ecra;
	}

	public void setEcra(String ecra) {
		this.ecra = ecra;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public double getMemory() {
		return memory;
	}

	public void setMemory(double memory) {
		this.memory = memory;
	}








}

