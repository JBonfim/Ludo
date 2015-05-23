
package ludo.main;

import java.util.Map;

import ludo.comportamento.Acao;
import ludo.comportamento.ComportamentoInicio;
import ludo.comportamento.ComportamentoIrFim;
import ludo.comportamento.ComportamentoIrPara;
import ludo.comportamento.ComportamentoIrPerderVez;
import ludo.comportamento.ComportamentoNada;
import ludo.comportamento.ComportamentoRepete;
import ludo.modelo.Casa;
import ludo.modelo.Tabuleiro;
import ludo.persistencia.Persistence;
import ludo.persistencia.PersistenciaException;

public class Main {
	
	public void jogo_teste(){

		//String id, String id_proximo_casa, ComportamenCasa comportamento
		Casa c0 = new Casa("C0","C1",new ComportamentoInicio());
		Casa c1 = new Casa("C1","C2",new ComportamentoRepete());
		Casa c2 = new Casa("C2","C3",new ComportamentoNada());
		Casa c3 = new Casa("C3","C4",new ComportamentoIrPara());
		Casa c4 = new Casa("C4","C5",new ComportamentoIrPerderVez());
		Casa c5 = new Casa("C5","C5",new ComportamentoIrFim());
		
		Tabuleiro tabuleiro = new Tabuleiro(2);
		tabuleiro.addCasa(c0);
		tabuleiro.addCasa(c1);
		tabuleiro.addCasa(c2);
		tabuleiro.addCasa(c3);
		tabuleiro.addCasa(c4);
		tabuleiro.addCasa(c5);
		
		tabuleiro.posicao_Inicio_Jogadores();
		
		
		System.out.println("JOGO>"+tabuleiro.status_Jogo());
		System.out.println("J1>1");
		System.out.println("JOGO>"+tabuleiro.status_Jogo());
		System.out.println("J2>3");
		if(tabuleiro.mover(0, 1)== Acao.REPETE){
			System.out.println("JOGO>ERRO:JOGADOR DA VEZ: J1");
		}
		System.out.println("J1>1");
		if(tabuleiro.mover(0, 1)==Acao.REPETE){
			
		}
		System.out.println("JOGO>"+tabuleiro.status_Jogo());
		System.out.println("J2>3");
		tabuleiro.mover(1, 3);
		System.out.println("JOGO>"+tabuleiro.status_Jogo());
		System.out.println("J1>2");
		if(tabuleiro.mover(0, 2)==Acao.PARA){
			System.out.println("JOGO>"+tabuleiro.status_Jogo());
			System.out.println("J1>4");
			System.out.println("JOGO>ERRO:JOGADOR DA VEZ: J2");
		}
		System.out.println("J2>6");
		if(tabuleiro.mover(1, 6) == Acao.FIM){
			System.out.println("JOGO>FIM DE JOGO:VENCEDOR J2");
		}
	}
	
	public void percistencia(){
		//new Main().jogo_teste();
				try {
					Map<String, Casa> casas = new Persistence().reader_Arquivo_Casa();
					for (String key : casas.keySet()) {
						System.out.println("Casa: "+key+"  irpara: "+casas.get(key).execultarAcao().getDestino());
						
						
						
					}
					
				} catch (PersistenciaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	
	
	public static void main(String[] args) {
		Main m = new Main();
		m.jogo_teste();
		m.percistencia();
	}
}
