import java.util.ArrayList;
import java.util.GregorianCalendar;


public abstract class Grupo {
	//atributos
	private final int id; //variavel final para o id ser único para cada grupo
	private static int quant_grupos = 0; //variavel estatica de quantidade de grupos
	private String nome;
	private String descricao;
	private final Usuario dono;
	private boolean status;
	private GregorianCalendar dataCriacao;
	protected ArrayList<Usuario> membros; //membros do grupo
	protected ArrayList<Usuario> permissaoAdicionar; //usuarios que podem adicionar outros 
	protected ArrayList<Usuario> permissaoRemover; //usuarios que podem remover outros
	protected ArrayList<Usuario> permissaoAlterar; //usuarios que podem alterar permissao de outro usuario do grupo
	protected ArrayList<Usuario> permissaoVisualizar; //usuarios que podem ver as ifos do grupo
	protected ArrayList<Usuario> permissaoCriarCartao; //usuarios que podem criar cartoes
	protected ArrayList<Cartao> cartoesAFazer; 
	protected ArrayList<Cartao> cartoesFeitos; 
	
	//método construtor
	public Grupo(String nome, String descricao, Usuario dono, boolean status, GregorianCalendar dataCriacao) {
		this.id = Grupo.quant_grupos ++;
		Grupo.quant_grupos ++;
		this.nome = nome;
		this.descricao = descricao;
		this.dono = dono;
		this.membros = new ArrayList<Usuario>();
		this.membros.add(dono); //adicionando o dono no ArrayList de membros
		this.permissaoAdicionar = new ArrayList<Usuario>();
		this.permissaoAdicionar.add(dono); //adicionando o dono no ArrayList de permissao adicionar
		this.permissaoRemover = new ArrayList<Usuario>();
		this.permissaoRemover.add(dono); //adicionando o dono no ArrayList de permissao remover
		this.permissaoAlterar = new ArrayList<Usuario>();
		this.permissaoAlterar.add(dono); //adicionando o dono no ArrayList de permissao alterar
		this.permissaoVisualizar = new ArrayList<Usuario>();
		this.permissaoVisualizar.add(dono); //adicionando o dono no ArrayList de permissao visualizar
		this.permissaoCriarCartao = new ArrayList<Usuario>();
		this.permissaoCriarCartao.add(dono); //adicionando o dono no ArrayList de permissao de criar cartoes
		this.dono.getGrupos().add(this); //adicionando grupo criado na lista de grupos do usuario dono
		this.status = status;
		this.dataCriacao = dataCriacao;
		this.cartoesAFazer = new ArrayList<Cartao>();
		this.cartoesFeitos = new ArrayList<Cartao>();
	}
	
	//demais métodos
	///id
	public int getId() {
		return this.id;
	}

	///nome
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	///descrição
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	///dono
	public Usuario getDono() {
		return dono;
	}
	
	///membros
	public ArrayList<Usuario> getMembros() {
		return membros;
	}
	
	//adiciona permissao
	public ArrayList<Usuario> getPermissaoAdicionar(){
		return permissaoAdicionar;
	}
	
	//remove permissao
	public ArrayList<Usuario> getPermissaoRemover(){
		return permissaoRemover;
	}
	
	///alterar permissao
	public ArrayList<Usuario> getPermissaoAlterar(){
		return permissaoAlterar;
	}
	
	///visualiza permissao
	public ArrayList<Usuario> getPermissaoVisualizar(){
		return permissaoVisualizar;
	}
	
	///permissao de criar cartao
	public ArrayList<Usuario> getPermissaoCriarCartao(){
		return permissaoCriarCartao;
	}
	
	///lista de cartões a fazer
	public ArrayList<Cartao> getCartoesAFazer(){
		return cartoesAFazer;
	}
	
	///lista de cartões feitos
	public ArrayList<Cartao> getCartoesFeitos(){
		return cartoesFeitos;
	}

	///status
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	///data de criação
	public String getDataCriacao() {
		return (String)(dataCriacao.get(GregorianCalendar.DAY_OF_MONTH) + "/" + dataCriacao.get(GregorianCalendar.MONTH) + "/" + dataCriacao.get(GregorianCalendar.YEAR));
	}
	
	public void setDataCriacao(GregorianCalendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public void setDataCriacao(int dia, int mes, int ano) {
		dataCriacao.set(GregorianCalendar.DATE, dia);
		dataCriacao.set(GregorianCalendar.MONTH, mes);
		dataCriacao.set(GregorianCalendar.YEAR, ano);
	}

	///adiciona membro
	public abstract void adicionaMembro(Usuario requisitor, Usuario novo, ArrayList<Permissao> permissao);
	
	///remove membro
	public abstract void removeMembro(Usuario requisitor, Usuario del);
	
	///adicionar permissao
	public abstract void adicionarPermissao(Usuario requisitor, Usuario nova_permissao, ArrayList<Permissao> permissao);
	
	///remover permissao
	public abstract void removerPermissao(Usuario requisitor, Usuario nova_permissao, ArrayList<Permissao> permissao);
	
	///adicionar cartao
	public abstract void adicionarCartao(Cartao novo_cartao);
	
	///toString
	@Override
	public String toString() {
		String out = "id do grupo: " + getId() + "\n";
		out = out + "Nome do grupo: " + getNome() + "\n";
		out = out + "Descrição do grupo: " + getDescricao() + "\n";
		out = out + "Dono do grupo: " + getDono().getLogin() + "\n";
		out = out + "Status do grupo: " + getStatus() + "\n";
		out = out + "Data de criação do grupo: " + getDataCriacao() + "\n";
		return out;
	}
	
	
	
}
