public enum Label {
	TO_DO("To do", "Vermelho"),
	DONE("Done", "Verde");
	
	//atributos
	private final String rotulo;
	private final String cor;
	
	//construtor
	Label(String rotulo, String cor) {
		this.rotulo = rotulo;
		this.cor = cor;
	}
	
	
	public String getRotulo() {
		return rotulo;
	}
	
	public String getCor() {
		return cor;
	}
	
	
	public String getAtributos() {
		String out = "Rótulo do label: " + getRotulo() + "\n";
		out += "Cor do label: " + getCor() + "\n";
		return out;
	}
}
