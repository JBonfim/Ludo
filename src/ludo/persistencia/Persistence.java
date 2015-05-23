package ludo.persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import ludo.comportamento.ComportamentoInicio;
import ludo.comportamento.ComportamentoIrFim;
import ludo.comportamento.ComportamentoIrPara;
import ludo.comportamento.ComportamentoIrPerderVez;
import ludo.comportamento.ComportamentoNada;
import ludo.comportamento.ComportamentoRepete;
import ludo.modelo.Casa;

public class Persistence {
	public Persistence() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@SuppressWarnings("resource")
	public Map<String, Casa> reader_Arquivo_Casa() throws PersistenciaException{
		File arquivoEmbarcacao = new File("Arquivos/entrada.txt");
		Map<String, Casa> casas = new HashMap<String, Casa>();
		FileInputStream stream = null;
		String msgErro = "";
		
		if(!arquivoEmbarcacao.exists()){
			//verifica se o arquivo existe, 
			msgErro = "Aquivo:  não existe";
			throw new PersistenciaException("Aquivo:  não existe");
		}
		
		try {
			stream = new FileInputStream(arquivoEmbarcacao);
			BufferedReader reader = new BufferedReader(	new InputStreamReader(stream));
			
			String linha;
			int qtlinha = 1;
			String tipoLeitura="";
			int id_proximacasa = 0;
			while ((linha = reader.readLine()) != null) {				
				StringTokenizer tokens = new StringTokenizer(linha,":");
				
				if(linha.contains("# TABULEIRO:")){
					tipoLeitura="TABULEIRO";
				}
				else if(linha.contains("FIM_TABULEIRO")) {
					tipoLeitura="FIM_TABULEIRO";
					break;
				}
				else if(tipoLeitura=="TABULEIRO"){
					id_proximacasa++;
					String id_casa = tokens.nextToken();
					String comportamento = tokens.nextToken();
					Casa c = null ;
					if(comportamento.equals("INICIO")){
						c = new Casa(id_casa, "C"+id_proximacasa, new ComportamentoInicio());
					}
					else if(comportamento.equals("REPETE")){
						c = new Casa(id_casa, "C"+id_proximacasa, new ComportamentoRepete());
					}
					else if(comportamento.equals("NADA")){
						c = new Casa(id_casa, "C"+id_proximacasa, new ComportamentoNada());
					}
					else if(comportamento.equals("VOLTA")){
						c = new Casa(id_casa, "C"+id_proximacasa, new ComportamentoIrPara(retornaIdProximaCasa(tokens.nextToken(),Integer.parseInt( id_casa.substring(1)), "SUB")));
					}
					else if(comportamento.contains("AVANCA")){
						c = new Casa(id_casa, "C"+id_proximacasa, new ComportamentoIrPara(retornaIdProximaCasa(tokens.nextToken(),Integer.parseInt( id_casa.substring(1)), "SOM")));
					}else if(comportamento.equals("PARA")){
						c = new Casa(id_casa, "C"+id_proximacasa, new ComportamentoIrPerderVez());
					}else if(comportamento.equals("IR_PARA")){
						c = new Casa(id_casa, "C"+id_proximacasa,  new ComportamentoIrPara(retornaIdProximaCasa(tokens.nextToken(),Integer.parseInt( id_casa.substring(1)), "SOM")));
					}else if(comportamento.equals("FIM")){
						c = new Casa(id_casa, "C"+id_proximacasa, new ComportamentoIrFim());
					}
					casas.put(id_casa, c);
				}
				
				
				
				
			}
			reader.close();
			return casas;
		} catch (Exception e ) {			
			throw new PersistenciaException(msgErro);
			
		}
		
			
			
		
		
		//return embarcacoes;
	}
	private String retornaIdProximaCasa(String ir_para,int id_casa_atal,String opcao_som_sub){
		String id="";
		if(ir_para.length()==2){
			return ir_para;
		}
		int irPara = Integer.parseInt(ir_para);
		if(opcao_som_sub=="SOM"){
			id="C"+(id_casa_atal+irPara);
		}
		else if(opcao_som_sub=="SUB"){
			id="C"+(id_casa_atal-irPara);
		}
		return id;
	}
	
}
