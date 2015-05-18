package ludo.comportamento;

import ludo.modelo.Casa;


public class ResultadoAcao {
	
	private Casa destino;
	private Acao acao;
	
	public ResultadoAcao(Acao acao,Casa destino) {
		this.acao = acao;
		this.destino = destino;
	}
	public Acao getAcao() {
		return acao;
	}
	public Casa getDestino() {
		return destino;
	}
	

}
