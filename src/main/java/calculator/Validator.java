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
		
		expression+="0";
		
		return expression;
	}
	
	public String validaNumber(String expression, String number, Double result){
	
	String add="";

	switch (number){

	case "num1": add="1";break;
	case "num2": add="2";break;
	case "num3": add="3";break;
	case "num4": add="4";break;
	case "num5": add="5";break;
	case "num6": add="6";break;
	case "num7": add="7";break;
	case "num8": add="8";break;
	case "num9": add="9";break;

	}

	if(expression.equals("0"))
		expression = add;
	else
		expression+=add;
	
	return expression;
}


	public String validaOperator(String expression, String operator, Double result){

		String add="";

		switch (operator){

		case "plus": add="+";break;
		case "minus": add="-";break;
		case "times": add="*";break;
		case "divide": add="/";break;

		}

		if(expression.equals(""))
			expression = Double.toString(result)+add;
		else if(isLastCharNumeric(expression))
			expression+=add;
		else
			expression= expression.substring(0,expression.length()-1)+add;

		return expression;
	}

	public String validaDot(String expression, String dot, Double result){

		if(dot.equals("dot")){
			if(!lastChar(expression).equals("."))
				expression+=".";	
		}

		return expression;

	}

	public String lastChar(String str){

		String lastChar = "";

		if(str.length()>1)
			lastChar = str.substring(str.length()-1,str.length());
		else
			lastChar=str;

		return lastChar;
	}



	public boolean isLastCharNumeric(String str)  
	{  
		try  
		{  
			double d = Double.parseDouble(lastChar(str));  
		}  
		catch(NumberFormatException nfe)  
		{  
			return false;  
		}  
		return true;  
	}




}
