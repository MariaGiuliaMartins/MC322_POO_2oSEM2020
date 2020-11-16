import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Grupo {
	//atributos
	private final int id; //variavel final para o id ser único para cada grupo
	private static int quant_grupos = 0; //variavel estatica de quantidade de grupos
	private String nome;
	private String descricao;
	private final Usuario dono;
	protected ArrayList<Usuario> membros;
	private boolean status;
	private GregorianCalendar dataCriacao;
	
	//método construtor
	public Grupo(String nome, String descricao, Usuario dono, boolean status, GregorianCalendar dataCriacao) {
		this.id = Grupo.quant_grupos ++;
		Grupo.quant_grupos ++;
		this.nome = nome;
		this.descricao = descricao;
		this.dono = dono;
		this.membros = new ArrayList<Usuario>();
		this.membros.add(dono); //adicionando o dono no ArrayList de membros
		this.dono.getGrupos().add(this); //adicionando grupo criado na lista de grupos do usuario dono
		this.status = status;
		this.dataCriacao = dataCriacao;
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

	
	//toString
	@Override
	public String toString() {
		String out = "toString da Classe Grupo";
		out = out + "id do grupo: " + getId() + "\n";
		out = out + "Nome do grupo: " + getNome() + "\n";
		out = out + "Descrição do grupo: " + getDescricao() + "\n";
		out = out + "Dono do grupo: " + getDono() + "\n";
		out = out + "Status do grupo: " + getStatus() + "\n";
		out = out + "Data de criação do grupo: " + getDataCriacao() + "\n";
		return out;
	}
	
	
	
}
