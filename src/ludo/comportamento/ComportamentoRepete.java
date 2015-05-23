package ludo.comportamento;

import ludo.modelo.Casa;


public class ComportamentoRepete implements ComportamentoCasa{
	
	@Override
	public ResultadoAcao execultaAcao() {
		// TODO Auto-generated method stub
		return new ResultadoAcao(Acao.REPETE, "");
	}

}
