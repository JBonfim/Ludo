package ludo.main;

import ludo.comportamento.Acao;
import ludo.comportamento.ComportamentoInicio;
import ludo.comportamento.ComportamentoIrPara;
import ludo.comportamento.ResultadoAcao;
import ludo.modelo.Casa;

public class Main {
	
	public static void main(String[] args) {
		Casa c = new Casa("C1",new Casa("C2",new Casa(),new ComportamentoIrPara()),new ComportamentoInicio());
		ResultadoAcao result = c.execultarAcao();
		 if(result.getAcao() == Acao.INICIO){
			 System.out.println(c.getProximo().getId());
		 }
		
	}

}
