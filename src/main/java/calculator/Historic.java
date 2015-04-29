package calculator;

import javax.enterprise.context.SessionScoped;

import java.io.Serializable;
import java.util.ArrayList;

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



	
	 public void addEcras(String expression){
		 
		 results.add(expression);
	 }
	 
	 
	 

	

}
