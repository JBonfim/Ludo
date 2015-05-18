package ludo.comportamento;

import ludo.modelo.Casa;


public class ComportamentoIrFim implements ComportamentoCasa{
	
	@Override
	public ResultadoAcao execultaAcao() {
		// TODO Auto-generated method stub
		return new ResultadoAcao(Acao.FIM, new Casa());
	}

}
