import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner; //para ler a entrada do teclado

public abstract class Usuario {
	//atributos
	private int id;
	private String login;
	private String email;
	private String senha;
	private String descricao;
	private GregorianCalendar dataAtivacao;
	protected ArrayList<Grupo> grupos;
	protected boolean status;
	
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
	
	///criar um grupo
	public abstract void criarGrupo(String nome_grupo, String descricao_grupo, boolean visibilidade);
	
	///remover um grupo
	public void removerGrupo(Grupo grupo_remover) {//remove o grupo passado como parametro do array list de grupos que o usuario faz parte
		for (int i = 0; i < this.getGrupos().size(); i++) {
			if (this.getGrupos().get(i) == grupo_remover) { //checando se o usuário a ser deletado existe
				this.getGrupos().remove(i);
				System.out.println("Grupo " + grupo_remover.getNome() + " do usuário " + this.getLogin() + " removido com sucesso!!!");
				break;
			}
		}
	}
	
	///criar cartão
	public void criarCartao(int id) {
		Scanner digitado; //para podermos conversar com o usuario
		boolean criando_cartao = true;
		while(criando_cartao == true) {
			ArrayList<Label> inicial = new ArrayList<Label>(); //array list de labels para inicializar o cartao
			
			digitado = new Scanner(System.in);
			System.out.println("Qual o nome do seu cartão? ");				
			String n = digitado.nextLine();
			
			System.out.println("Qual o assunto do seu cartão? ");				
			String a = digitado.nextLine();
			
			System.out.println("Qual a visibilidade do seu cartão? ");				
			int v = digitado.nextInt();
			
			System.out.println("Dia de criação do seu cartão: ");
			int dia = digitado.nextInt();
			System.out.println("Mês de criação do seu cartão: ");
			int mes = digitado.nextInt();
			System.out.println("Ano de criação do seu cartão: ");
			int ano = digitado.nextInt();
			GregorianCalendar dataCriacao1 = new GregorianCalendar(ano, mes, dia);
			
			//primeiro procuramos a qual grupo o usuario se refera a partir do id passado como parâmetro
			for (int i = 0; i < this.getGrupos().size(); i++) {
				if (this.getGrupos().get(i).getId() == id) { //se encontramos o grupo passado
					//agora temos que ver se este usuario possui a permissao de criar cartao neste grupo
					for (int j = 0; j < this.getGrupos().get(i).getPermissaoCriarCartao().size(); j++){
						if (this.getGrupos().get(i).getPermissaoCriarCartao().get(j) == this) { //se esse usuario tem a permissao de criar cartoes
							Cartao novo_cartao = new Cartao(v, n, inicial, this, a, this.getStatus(), dataCriacao1);
							this.getGrupos().get(i).adicionarCartao(novo_cartao);
							System.out.println(this.getLogin() + " criou um cartão com sucesso!!!");
						}
					}
				}
			}
			criando_cartao = false;
		}
	}
	
	
	///toString
	@Override
	public String toString() {
		String out = getLogin() + " (id: " + getId() + ")\n";
		out = out + "Login: " + getLogin() + "\n";
		out = out + "e-mail: " + getEmail() + "\n";
		out = out + "Senha: " + getSenha() + "\n";
		out = out + "Descrição do usuário: " + getDescricao()+ "\n";
		out = out + "Data de ativação: " + getDataAtivacao() + "\n";
		out = out + "Grupos que este usuário faz parte: \n";
		for (int i = 0; i < getGrupos().size(); i++) {
			out += "Grupo " + i + ": " + getGrupos().get(i).getNome() + "; ";
		}
		out = out + "Status: " + getStatus() + "\n";
		return out;
	}
}
