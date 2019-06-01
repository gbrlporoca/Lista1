package lista1Beans;

public class Medalha implements Comparable<Medalha>{
	
	private TipoMedalha tipo;
	private Modalidade modalidade;
	private Pais pais;
	
	public Medalha(String tipo, String modalidade, String pais) {
		
		this.tipo = TipoMedalha.valueOf(tipo);
		this.modalidade = Modalidade.valueOf(modalidade);
		this.pais = Pais.valueOf(pais);
	}
	
	public Medalha() {
		
	}

	public Medalha(TipoMedalha value, Modalidade value2, Pais value3) {
		this.tipo = value;
		this.modalidade = value2;
		this.pais = value3;
	}

	public TipoMedalha getTipo() {
		return tipo;
	}

	public void setTipo(TipoMedalha tipo) {
		this.tipo = tipo;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	public boolean equals(Object obj) {
		
		boolean resultado = false;
		
		if(obj instanceof Medalha) {
			Medalha m = (Medalha) obj;
			if(this.tipo == m.tipo && this.modalidade == m.modalidade) {
				resultado = true;
			}
		}
		
		return resultado;
	}

	@Override
	public int compareTo(Medalha o) {
		return this.modalidade.compareTo(o.modalidade);
	}
	
	public String toString() {
		return " " + TipoMedalha.valueOf(this.tipo.toString()).getValor() 
				+ " " + Modalidade.valueOf(this.modalidade.toString()).getValor()
				+ " " + Pais.valueOf(this.pais.toString()).getValor();
	}
}
