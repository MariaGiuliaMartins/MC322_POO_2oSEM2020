public enum Estado {
	Acre("Estado do Acre", "Sigla: AC"),
	Alagoas("Estado do Alagoas", "Sigla: AL"),
	Amapa("Estado do Amapá", "Sigla: AP"),
	Amazonas("Estado do Amazonas", "Sigla: AM"),
	Bahia("Estado da Bahia", "Sigla: BA"), 
	Ceara("Estado do Ceará", "Sigla: CE"),
	DistritoFederal("Unidade Federativa do Distrito Federal", "Sigla: DF"), 
	EspiritoSanto("Estado do Espírito Santo", "Sigla: ES"), 
	Goias("Estado de Goiás", "Sigla: GO"), 
	Maranhao("Estado do Maranhão", "Sigla: MA"),
	MatoGrosso("Estado do Mato Grosso", "Sigla: MT"),
	MatoGrossoDoSul("Estado do Mato Grosso do Sul", "Sigla: MS"),
	MinasGerais("Estado de Minas Gerais", "Sigla: MG"),
	Para("Estado do Pará", "Sigla: PA"),
	Paraiba("Estado da Paraíba", "Sigla: PB"),
	Parana("Estado do Paraná", "Sigla: PR"),
	Pernanbuco("Estado do Pernanbuco", "Sigla: PE"),
	Piaui("Estado do Piauí", "Sigla: PI"),
	Roraima("Estado de Roraima", "Sigla: RR"),
	Rondonia("Estado de Rondônio", "Sigla: RO"),
	RioDeJaneiro("Estado do Rio de Janeiro", "Sigla: RJ"),
	RioGrandeDoNorte("Estado do Rio Grande do Norte", "Sigla: RN"),
	RioGrandeDoSul("Estado do Rio Grande do Sul", "Sigla: RS"),
	SantaCatarina("Estado de Santa Catarina", "Sigla: SC"),
	SaoPaulo("Estado de São Paulo", "Sigla: SP"),
	Sergipe("Estado de Sergipe", "Sigla: SE"),
	Tocantins("Estado do Tocantins", "Sigla: TO");
	
	//atributos
	private final String nome;
	private final String sigla;
	
	//construtor
	Estado(String nome, String sigla){
		this.nome = nome;
		this.sigla = sigla;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	
	public String getAtributos() {
		String out = "Nome do estado: " + getNome() + "\n";
		out += "Sigla do estado: " + getSigla() + "\n";
		return out;
	}
	
}
