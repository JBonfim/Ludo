package ludo.comportamento;



public class ComportamentoIrPara implements ComportamentoCasa{
	private String posicao;
	public ComportamentoIrPara(String posicao) {
		this.posicao = posicao;
	}
	public ComportamentoIrPara() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public ResultadoAcao execultaAcao() {
		// TODO Auto-generated method stub
		//int ir_para = 0+(int)( 9*Math.random() ) ;
		return new ResultadoAcao(Acao.IR_PARA,this.posicao);
	}

}
