package ludo.comportamento;

import ludo.modelo.Casa;


public class ComportamentoIrPerderVez implements ComportamentoCasa{
	
	@Override
	public ResultadoAcao execultaAcao() {
		// TODO Auto-generated method stub
		return new ResultadoAcao(Acao.PARA, new Casa());
	}

}
