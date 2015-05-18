package ludo.modelo;

import ludo.comportamento.ComportamentoCasa;
import ludo.comportamento.ResultadoAcao;

public class Casa {
	private String id;
	private Casa proximo;
	private ComportamentoCasa comportamento;
	
	
	public Casa() {
		// TODO Auto-generated constructor stub
	}
	public Casa(String id,Casa proximo,ComportamentoCasa comportamento) {
		this.id = id;
		this.proximo = proximo;
		this.comportamento = comportamento;
	}
	
	public Casa getProximo() {
		return proximo;
	}
	
	public ResultadoAcao execultarAcao() {
		return comportamento.execultaAcao();
	}
	public String getId() {
		return id;
	}
	

}
