import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Usuario {
	//atributos
	private int id;
	private String login;
	private String email;
	private String senha;
	private String descricao;
	private GregorianCalendar dataAtivacao;
	private ArrayList<Grupo> grupos;
	private boolean status;
	
	//Método Construtor
	public Usuario(int id, String login, String email, String senha, String descricao, GregorianCalendar dataAtivacao, boolean status) {
		this.id = id;
		this.login = login;
		this.email = email;
		this.senha = senha;
		this.descricao = descricao;
		this.dataAtivacao = dataAtivacao;
		this.grupos = new ArrayList<Grupo>();
		this.status = status;
	}
	
	//Demais métodos
	///id
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	///login
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	///email
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	///senha
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	///descricao
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	///dataAtivacao
	public String getDataAtivacao() {
		return (String)(dataAtivacao.get(GregorianCalendar.DAY_OF_MONTH) + "/" + dataAtivacao.get(GregorianCalendar.MONTH) + "/" + dataAtivacao.get(GregorianCalendar.YEAR));
	}
	
	
	public void setDataAtivacao(GregorianCalendar dataAtivacao) {
		this.dataAtivacao = dataAtivacao;
	}
	
	public void setDataAtivacao(int dia, int mes, int ano) {
		dataAtivacao.set(GregorianCalendar.DATE, dia);
		dataAtivacao.set(GregorianCalendar.MONTH, mes);
		dataAtivacao.set(GregorianCalendar.YEAR, ano);
	}
	
	///grupos
	public ArrayList<Grupo> getGrupos(){
		return grupos;
	}
	
	///status
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	//criar um grupo para este usuario --> vai pra lista de grupos
	public void criarGrupo(String nome_grupo, String descricao_grupo, boolean status_grupo) {
		if (status_grupo == false) { //status false -> cria grupo publico
			GrupoPublico novo_grupo = new GrupoPublico(nome_grupo, descricao_grupo, this, this.status, (GregorianCalendar) GregorianCalendar.getInstance());
		}
		else {
			GrupoPrivado novo_grupo = new GrupoPrivado(nome_grupo, descricao_grupo, this, this.status, (GregorianCalendar) GregorianCalendar.getInstance());
		}
	}
	
	//remover um grupo
	public void removerGrupo(Grupo grupo_remover) {//remove o grupo passado como parametro do array list de grupos que o usuario faz parte
		for (int i = 0; i < this.getGrupos().size(); i++) {
			if (this.getGrupos().get(i) == grupo_remover) { //checando se o usuário a ser deletado existe
				this.getGrupos().remove(i);
				System.out.println("Grupo " + grupo_remover.getNome() + " do usuário " + this.getLogin() + " removido com sucesso!!!");
				break;
			}
		}
		
	}
	
	
	//toString
	@Override
	public String toString() {
		String out = getLogin() + " (id: " + getId() + ")\n";
		out = out + "e-mail: " + getEmail() + "\n";
		out = out + "Senha: " + getSenha() + "\n";
		out = out + "Descrição do usuário: " + getDescricao()+ "\n";
		out = out + "Data de ativação: " + getDataAtivacao() + "\n";
		out = out + "Grupos que este usuário faz parte: " + getGrupos() + "\n";
		out = out + "Status: " + getStatus() + "\n";
		return out;
	}
}
