package models;

public class Pergunta {
	private String pergunta;
	private String[] respostas;
	private int correta;
	
	public Pergunta(String pergunta, String[] respostas, int correta) {
		super();
		this.pergunta = pergunta;
		this.respostas = respostas;
		this.correta = correta;
	}

	public String getPergunta() {
		return pergunta;
	}

	public String[] getRespostas() {
		return respostas;
	}

	public int getCorreta() {
		return correta;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pergunta other = (Pergunta) obj;
		if (pergunta == null) {
			if (other.pergunta != null)
				return false;
		} else if (!pergunta.equals(other.pergunta))
			return false;
		return true;
	}
	
}
