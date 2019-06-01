package lista1Beans;

public enum Modalidade {
	CURLING("curling"), ESQUI_ALPINO("Esqui alpino"), ESQUI_COUNTRY("Esqui cross-country"), ESQUI_LIVRE("Esqui estilo livre"),
	HOQUEI("Hóquei no gelo"), PATINACAO_ARTISTICA("Patinacao artística"), PATINACAO_VELOCIDADE("Patinação de velocidade"),
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
