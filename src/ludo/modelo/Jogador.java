package ludo.modelo;

public class Jogador {
	
	private String jogador;
	private boolean jogar;
	
	
	public Jogador(String jogador) {
		this.jogador = jogador;
	}
	
	public String getJogador() {
		return jogador;
	}
	
	public boolean getJogar(){
		return this.jogar;
	}
	public void setJogar(boolean jogar) {
		this.jogar = jogar;
	}
	

}
