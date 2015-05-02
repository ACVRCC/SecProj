package calculator;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import java.io.Serializable;


@Named
@SessionScoped
public class ItemHistoric implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String ecraHistoric;
	private String resultHistoric;
	
	
	public ItemHistoric(){
		
		
	}
	
	
	
	public ItemHistoric(String ecraHistoric, String resultHistoric) {
		this.setEcraHistoric(ecraHistoric);
		this.setResultHistoric(resultHistoric);
	}


	public String getEcraHistoric() {
		return ecraHistoric;
	}


	public void setEcraHistoric(String ecraHistoric) {
		this.ecraHistoric = ecraHistoric;
	}


	public String getResultHistoric() {
		return resultHistoric;
	}


	public void setResultHistoric(String resultHistoric) {
		this.resultHistoric = resultHistoric;
	}
	
	
	
	
	

}
