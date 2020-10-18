import java.util.GregorianCalendar;

public class Usuario {
	//atributos
	private int id;
	private String login;
	private String email;
	private String senha;
	private GregorianCalendar dataAtivacao;
	private boolean status;
	
	//Método Construtor
	public Usuario(int id, String login, String email, String senha, GregorianCalendar dataAtivacao, boolean status) {
		this.id = id;
		this.login = login;
		this.email = email;
		this.senha = senha;
		this.dataAtivacao = dataAtivacao;
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
	
	///status
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	//toString
	@Override
	public String toString() {
		String out = getLogin() + " (id: " + getId() + ")\n";
		out = out + "e-mail: " + getEmail() + "\n";
		out = out + "Senha: " + getSenha() + "\n";
		out = out + "Data de ativação: " + getDataAtivacao() + "\n";
		out = out + "Status: " + getStatus();
		return out;
	}
}
