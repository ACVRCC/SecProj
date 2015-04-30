package calculator;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class Statistic implements Serializable{


	private static final long serialVersionUID = 1L;
	private int countPlus=0;
	private int countMinus=0;
	private int countTimes=0;
	private int countDivide=0;


	public void countOperator(String operator){
	
		switch (operator){

		case "plus": countPlus++;
		case "minus": countMinus++;
		case "times": countTimes++;
		case "divide": countDivide++;
				
		break;		

		}
	
	}
	

	public int getCountPlus() {
		return this.countPlus;
	}
	

	public void setCountPlus(int countPlus) {
		this.countPlus = countPlus;
	}


	public int getCountMinus() {
		return countMinus;
	}


	public void setCountMinus(int countMinus) {
		this.countMinus = countMinus;
	}


	public int getCountTimes() {
		return countTimes;
	}


	public void setCountTimes(int countTimes) {
		this.countTimes = countTimes;
	}


	public int getCountDivide() {
		return countDivide;
	}


	public void setCountDivide(int countDivide) {
		this.countDivide = countDivide;
	}
	

	
	
}