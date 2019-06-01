package lista1Beans;

public enum Pais {
	BRA ("Brasil"), BRN ("Bahrein"), BUL ("Bulg�ria"), CAN ("Canad�"), CHN ("China"), COL ("Col�mbia"), CRO ("Cro�cia"), CUB ("Cuba"),
	CYP ("Chipre"), CZE ("Rep�blica Checa"), DEN ("Dinamarca"), DOM ("Rep�blica Dominicana"), EGY ("Egito"), ESP ("Espanha"), EST ("Est�nia");
	private String valor;
	
	Pais(String valor){
		this.valor = valor;
	}
	
	public String getValor(){
		return this.valor;
	}
	public String toString() {
		return valor;
	}
}
