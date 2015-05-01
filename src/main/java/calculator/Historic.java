package calculator;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
/*Trabalho executado por Alberto Centeno e Sérgio Moutinho*/
@Named
@SessionScoped
public class Historic implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	private ArrayList<String> results;

	public Historic() {
		results = new ArrayList<String>();

	}

	public void addResults(String expression){
		
		results.add(expression);
	
	}

	public ArrayList<String> getResults() {
		return results;
	}

	public void setResults(ArrayList<String> results) {
		this.results = results;
	}

	

}
