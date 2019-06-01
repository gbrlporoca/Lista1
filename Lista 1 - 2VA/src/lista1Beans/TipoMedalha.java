package lista1Beans;

public enum TipoMedalha {
	OURO(1), PRATA(2), BRONZE(3);
	
	private int valor;
	
	TipoMedalha(int valor){
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}
}
