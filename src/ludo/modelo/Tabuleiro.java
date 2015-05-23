package ludo.modelo;

import java.util.HashMap;
import java.util.Map;

import ludo.comportamento.Acao;

public class Tabuleiro {
	
	private Map<String, Casa> tabuleiro;
	
	private Casa[] posicaoJogador;///os jogadores é posicionado de acordo com o indice, por exemplo indice 0 pertence ao jogador 1 e assim sucessivamente
	
	public Tabuleiro(int qteJogador) {
		this.posicaoJogador = new Casa[qteJogador];
		this.tabuleiro = new HashMap<String, Casa>();
		
	}
	
	public void addCasa(Casa casa){
		this.tabuleiro.put(casa.getId(), casa);
	}
	public void addCasas(Map<String, Casa> casas){
		this.tabuleiro= casas;
	}
	
	public Acao mover(int jogador,int dado){
			//System.out.println("Jog: "+jogador+" dado: "+dado);
			Casa casa_Atual_jogador = this.posicaoJogador[jogador];
			Casa proxima_casa = this.tabuleiro.get(casa_Atual_jogador.getProximo());
			for(int i =1;i<dado;i++){
				proxima_casa = this.tabuleiro.get(proxima_casa.getProximo());
			}
			 if(proxima_casa.execultarAcao().getAcao() == Acao.NADA){
				//Ao cair nesta casa o jogador passa a vez para o próximo.
				posicaoJogador[jogador]=proxima_casa;
				return Acao.NADA;
			}
			else if(proxima_casa.execultarAcao().getAcao() == Acao.REPETE){
				//Ao cair nesta casa, o jogador pode jogar mais uma vez.
				posicaoJogador[jogador]=proxima_casa;
				
				return Acao.REPETE;//### Apagar comentario, inidica jogador da vez
			}
			else if(proxima_casa.execultarAcao().getAcao() == Acao.PARA){
				//O jogador fica uma rodada sem jogar.
				posicaoJogador[jogador]=proxima_casa;
				return Acao.PARA;
			}
			else if(proxima_casa.execultarAcao().getAcao() == Acao.IR_PARA){
				//A peça vai para a casa x
				posicaoJogador[jogador]=this.tabuleiro.get(proxima_casa.execultarAcao().getDestino());
				return Acao.IR_PARA;
			}
			else if(proxima_casa.execultarAcao().getAcao() == Acao.FIM){
				//Casa que indica o fim do jogo. O primeiro jogador a atingir esta casa será o ganhador do jogo.
				posicaoJogador[jogador]=proxima_casa;
				return Acao.FIM;
			}
			
		return Acao.INICIO;
	}
	
	public void posicao_Inicio_Jogadores(){
		for(int i=0;i<posicaoJogador.length;i++){
			posicaoJogador[i]=this.tabuleiro.get("C0");//aqui coloca todos os jogadores na pocicao inicio do jogo
		}
	}
	public Casa getCasa_Posicao_Jogador(int jogador){
		if(jogador>posicaoJogador.length){
			return null;
		}
		return posicaoJogador[jogador];
	}
	public String status_Jogo(){
		String status="";
		for(int i=0;i<posicaoJogador.length;i++){
			status+="J"+(i+1)+":"+posicaoJogador[i].getId()+"/";
		}
		status = status.substring(0, status.length()-1);//Remove o ultimo caractere da String
		return status;
	}
	
	
	
	
}
