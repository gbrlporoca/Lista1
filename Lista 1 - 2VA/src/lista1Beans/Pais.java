package lista1Beans;

public enum Pais {
	BRA ("Brasil"), BRN ("Bahrein"), BUL ("Bulgária"), CAN ("Canadá"), CHN ("China"), COL ("Colômbia"), CRO ("Croácia"), CUB ("Cuba"),
	CYP ("Chipre"), CZE ("República Checa"), DEN ("Dinamarca"), DOM ("República Dominicana"), EGY ("Egito"), ESP ("Espanha"), EST ("Estônia");
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
