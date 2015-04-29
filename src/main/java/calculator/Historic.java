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
	private String exp;

	public Historic() {
		results = new ArrayList<String>();
		setExp("0");
	}



	
	 public void addEcras(String expression){
		 
		 results.add(expression);
	 }
	 
	 public void addExp(String expression){
		 
		 setExp(expression);
	 }




	public String getExp() {
		return exp;
	}




	public void setExp(String exp) {
		this.exp = exp;
	}
	 
	 
	 

	

}
