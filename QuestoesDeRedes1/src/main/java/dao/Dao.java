package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.Pergunta;

public class Dao {
	public static List<Pergunta> perguntas = new ArrayList<Pergunta>();
	public static Random gerador = new Random(999);
	
	static {
		Pergunta pergunta1 = new Pergunta("No modelo de refer�ncia OSI, os protocolos HTTP, SMTP e FTP est�o associados � camada de", 
								new String[] {"apresenta��o.", "aplica��o.", "enlace de dados.", "rede.", "transporte." }, 1);
		Pergunta pergunta2 = new Pergunta("Assinale a alternativa que apresenta a camada do modelo OSI, que trabalha com os protocolos UDP e TCP.",
								new String[] {"F�sica.", "De enlace.", "De rede.", "De transporte.", "De aplica��o." }, 3);
		Pergunta pergunta3 = new Pergunta("O modelo de refer�ncia OSI possui 7 (sete) camadas. Marque a alternativa que apresenta essas camadas na ordem correta.",
								new String[] {"F�sica-Enlace-Transporte-Redes-Sess�o-Apresenta��o-Aplica��o.",
												"F�sica-Enlace-Redes-Transporte-Sess�o-Apresenta��o-Aplica��o.",
												"F�sica-Enlace-Redes-Transporte-Sess�o-Aplica��o-Apresenta��o.",
												"F�sica-Enlace-Transporte-Redes-Sess�o-Aplica��o-Apresenta��o.",
												"F�sica-Enlace-Redes-Sess�o-Transporte-Aplica��o-Apresenta��o." }, 1);
		Pergunta pergunta4 = new Pergunta("No modelo OSI, a camada respons�vel pela comuta��o de pacotes � conhecida como:",
								new String[] {"apresenta��o.", "rede.", "sess�o.", "internet.", "transporte." }, 1);
		Dao.perguntas.add(pergunta1);
		Dao.perguntas.add(pergunta2);
		Dao.perguntas.add(pergunta3);
		Dao.perguntas.add(pergunta4);
		
	}

	public static List<Pergunta> getTodasPerguntas() {
		return perguntas;
	}

	public static void addPergunta(Pergunta pergunta) {
		Dao.perguntas.add( pergunta );
	}
	
	public static Pergunta getPerguntaAleatoria() {
		int tamanhoArrayPerguntas = Dao.perguntas.size()-1;
		int aleatorio = gerador.nextInt(tamanhoArrayPerguntas);
											System.out.println(aleatorio);
		return getPergunta(aleatorio);
	}
	
	public static Pergunta getPergunta(int indicePergunta) {
		return Dao.perguntas.get(indicePergunta);
	}
	
	/*public static boolean verSeAcertou(Pergunta p, int i) {
		boolean retorno = false;
		Iterator<Pergunta> it = Dao.perguntas.iterator();
		Pergunta atual = null;
		while(it.hasNext()) {
			atual = it.next();
			if(atual.equals(p)) break;
		}
		if(atual != null && atual.getCorreta() == i) retorno = true;
		return retorno;
	}*/
	
	public static boolean verSeAcertou(int indicePergunta, int numeroAlternativaCorreta) {
		boolean retorno = false;
		Pergunta atual = Dao.perguntas.get(indicePergunta);
		
		if(atual != null && atual.getCorreta() == numeroAlternativaCorreta) retorno = true;
		return retorno;
	}
	
	public static int getIndicePergunta(Pergunta p) {
		return Dao.perguntas.indexOf(p);
	}
	
}
