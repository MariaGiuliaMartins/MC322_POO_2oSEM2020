import java.util.GregorianCalendar;

public class UsuarioConvidado extends Usuario {
	//parâmetros
	private GregorianCalendar dataExpiracao;
	
	//construtor
	public UsuarioConvidado (int id, String login, String email, String senha, String descricao, GregorianCalendar dataAtivacao, boolean status,  GregorianCalendar dataExpiracao) {
		super(id, login, email, senha, descricao, dataAtivacao, status);
		this.dataExpiracao = dataExpiracao;
	}
	
	//getters e setters
	public String getDataExpiracao() {
		return (String)(dataExpiracao.get(GregorianCalendar.DAY_OF_MONTH) + "/" + dataExpiracao.get(GregorianCalendar.MONTH) + "/" + dataExpiracao.get(GregorianCalendar.YEAR));
	}
	
	
	public void setDataExpiracao(GregorianCalendar dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}
	
	public void setDataExpiracao(int dia, int mes, int ano) {
		dataExpiracao.set(GregorianCalendar.DATE, dia);
		dataExpiracao.set(GregorianCalendar.MONTH, mes);
		dataExpiracao.set(GregorianCalendar.YEAR, ano);
	}
	
	//criar grupo
	public void criarGrupo(String nome_grupo, String descricao_grupo, boolean visibilidade) {
		System.out.println("Usuário convidado " + this.getLogin() + " não pode criar um grupo, pois não é administrador.");
	}
}
