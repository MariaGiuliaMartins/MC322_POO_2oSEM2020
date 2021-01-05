import java.util.GregorianCalendar;

public class UsuarioConvidado extends Usuario {
	//parâmetros
	private GregorianCalendar dataExpiracao;
	
	//construtor
	public UsuarioConvidado (int id, Perfil perfil, String login, String email, String senha, GregorianCalendar dataAtivacao, boolean status,  GregorianCalendar dataExpiracao) {
		super(id, perfil, login, email, senha, dataAtivacao, status);
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
	
	///toString
	@Override
	public String toString() {
		super.toString();
		String out = "Data de Expriação: " + getDataExpiracao() + "\n";
		return out;
	}
}
