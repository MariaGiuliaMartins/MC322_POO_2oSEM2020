public enum Permissao {
	ADICIONAR_MEMBROS(1, "Usuário está autorizado a adicionar novos membros ao grupo."),
	REMOVER_MEMBROS(2, "Usuário está autorizado a remover membros do grupo."),
	ALTERAR_PERMISSAO(3, "Usuário está autorizado a alterar a permissão de outros usuários do grupo."),
	VISUALIZA_INFO(4, "Usuário está autorizado a ver as seguintes informações do grupo: Nome, Dono, Status e Membros.");
	
	//atributos
	private final int id;
	private final String descricao;
	
	//construtor
	Permissao(int id, String descricao){
		this.id = id;
		this.descricao = descricao;
	}
	
	
	public int getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	
	public String getAtributos() {
		String out = "Id: " + getId() + "\n";
		out += "Descrição: " + getDescricao() + "\n";
		return out;
	}
	
}
