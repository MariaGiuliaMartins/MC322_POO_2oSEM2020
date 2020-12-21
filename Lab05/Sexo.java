public enum Sexo {
	Homem("Sexo Masculino", "Sigla: M"),
	Mulher("Sexo Feminino", "Sigla: F");
	
	//atributos
	private final String descricao;
	private final String sigla;
	
	//construtor
	Sexo(String descricao, String sigla){
		this.descricao = descricao;
		this.sigla = sigla;
	}
	
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	
	public String getAtributos() {
		String out = getDescricao() + "\n";
		out += "Sigla: " + getSigla() + "\n";
		return out;
	}
}
