package ludo.comportamento;

import ludo.modelo.Casa;


public class ResultadoAcao {
	
	private String id_casa_destino;
	private Acao acao;
	
	public ResultadoAcao(Acao acao,String id_casa_destino) {
		this.acao = acao;
		this.id_casa_destino = id_casa_destino;
	}
	public Acao getAcao() {
		return acao;
	}
	public String getDestino() {
		return id_casa_destino;
	}
	

}
