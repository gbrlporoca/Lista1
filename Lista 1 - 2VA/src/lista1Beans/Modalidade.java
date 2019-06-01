package lista1Beans;

public enum Modalidade {
	CURLING("curling"), ESQUI_ALPINO("Esqui alpino"), ESQUI_COUNTRY("Esqui cross-country"), ESQUI_LIVRE("Esqui estilo livre"),
	HOQUEI("H�quei no gelo"), PATINACAO_ARTISTICA("Patinacao art�stica"), PATINACAO_VELOCIDADE("Patina��o de velocidade"),
	SALTO_ESQUI("Salto de esqui"), SNOWBOARD("Snowboard");
	private String valor;
	
	Modalidade(String valor){
		this.valor = valor;
	}
	
	public String getValor() {
		return this.valor;
	}
	
	public String toString() {
		return valor;
	}
}
