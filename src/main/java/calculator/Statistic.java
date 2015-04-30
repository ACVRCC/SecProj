package calculator;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class Statistic implements Serializable{


	private static final long serialVersionUID = 1L;
	private int countPlus=0;
	

	


	public void countOperator(String operator){
	
		switch (operator){

		case "plus": countPlus++;
				
		break;
		

		}
	
	}
	
	

	public int getCountPlus() {
		return this.countPlus;
	}
	

	public void setCountPlus(int countPlus) {
		this.countPlus = countPlus;
	}
	

	
	
}