package calculator;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="estatistica")
@ApplicationScoped
public class Statistic implements Serializable{

	private static final long serialVersionUID = 1L;

	private Estatistica[] lista = new Estatistica[] {

			new Estatistica("+"),
			new Estatistica("-"),
			new Estatistica("*"),
			new Estatistica("/"),
			
	};

	public Estatistica[] getLista() {

		return lista;

	}

	public class Estatistica{
		
		String operator;

		public Estatistica( String operator) {

			this.operator = operator;
		}



		public String getOperator() {
			return operator;
		}

		public void setOperator(String operator) {
			this.operator = operator;
		}


	}
}