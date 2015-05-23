package ludo.modelo;

import ludo.comportamento.ComportamentoCasa;
import ludo.comportamento.ResultadoAcao;

public class Casa {
	private String id;
	private String id_proximo_casa;
	private ComportamentoCasa comportamento;
	
	
	public Casa() {
		// TODO Auto-generated constructor stub
	}
	public Casa(String id,String id_proximo_casa,ComportamentoCasa comportamento) {
		this.id = id;
		this.id_proximo_casa = id_proximo_casa;
		this.comportamento = comportamento;
	}
	
	public String getProximo() {
		return id_proximo_casa;
	}
	
	public ResultadoAcao execultarAcao() {
		return comportamento.execultaAcao();
	}
	public String getId() {
		return id;
	}
	

}
