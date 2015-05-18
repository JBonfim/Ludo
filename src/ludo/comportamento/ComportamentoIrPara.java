package ludo.comportamento;

import ludo.modelo.Casa;


public class ComportamentoIrPara implements ComportamentoCasa{
	
	@Override
	public ResultadoAcao execultaAcao() {
		// TODO Auto-generated method stub
		return new ResultadoAcao(Acao.IR_PARA, new Casa());
	}

}
