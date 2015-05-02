package calculator;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;

@Named
@SessionScoped
public class Historic implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	private ArrayList<ItemHistoric> items;

	public Historic() {
		items = new ArrayList<ItemHistoric>();

	}

	public void addItems(String expression, String result){
		
		items.add(new ItemHistoric (expression,result));
	
	}

	public ArrayList<ItemHistoric> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemHistoric> items) {
		this.items = items;
	}

	

}
