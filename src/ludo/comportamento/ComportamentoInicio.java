package ludo.comportamento;



public class ComportamentoInicio implements ComportamentoCasa{
	
	@Override
	public ResultadoAcao execultaAcao() {
		// TODO Auto-generated method stub
		
		return new ResultadoAcao(Acao.INICIO, "");
	}

}
