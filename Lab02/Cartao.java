import java.util.GregorianCalendar;

public class Cartao {
	//atributos
	private static int numeroCartoes = 0; //incializada com 0, atributo de classe
	private static int id = 0; //variavel ja inicializada com 0
	private int visibilidade;
	private String nome;
	private Usuario dono;
	private boolean invitationOnly;
	private GregorianCalendar dataCriacao;
	
	//metodo construtor sem parametros
	public Cartao() {
		numeroCartoes ++; //a cada novo cartao criado, incrementa-se o numero de cartoes criados
		id ++; //a cada novo cartao criado, incrementa-se o id do cartao
	}
		
	//metodo construtor com parametros
	public Cartao(int visibilidade, String nome, Usuario dono, boolean invitationOnly, GregorianCalendar dataCriacao) {
		numeroCartoes ++; //a cada novo cartao criado, incrementa-se o numero de cartoes criados
		id ++; //a cada novo cartao criado, incrementa-se o id do cartao
		this.visibilidade = visibilidade;
		this.nome = nome;
		this.dono = dono;
		this.invitationOnly = invitationOnly;
		this.dataCriacao = dataCriacao;		
	}
		
		
	//demais metodos
	///numero de cartoes
	public static int getNumeroCartoes() {
		return numeroCartoes;
	}
	public static void setNumeroCartoes(int numeroCartoes) {
		Cartao.numeroCartoes = numeroCartoes;
	}
	
	///id
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		Cartao.id = id;
	}
	
	///visibilidade
	public int getVisibilidade() {
		return visibilidade;
	}
	public void setVisibilidade(int visibilidade) {
		this.visibilidade = visibilidade;
	}
	
	///nome
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	///dono
	public Usuario getDono() {
		return dono;
	}
	public void setDono(Usuario dono) {
		this.dono = dono;
	}
	
	///invitation only
	public boolean getInvitationOnly() {
		return invitationOnly;
	}
	public void setInvitationOnly(boolean invitationOnly) {
		this.invitationOnly = invitationOnly;
	}
	
	///data de criacao
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
	
	///quatidade de cartões
	public int numeroCartoes() {
		return getNumeroCartoes();
	}
	
	///toString
		@Override
	public String toString() {
		String out = "Características do Cartão: " + "\n";
		out = out + "Dono do Cartão: " + getDono() + "\n";
		out = out + "Nome do Cartão: " + getNome() + "\n";
		out = out + "Id do Cartão: " + getId() + "\n";
		out = out + "Visibilidade do Cartão: " + getVisibilidade() + "\n";
		out = out + "Invitation Only: " + getInvitationOnly() + "\n";
		out = out + "Data de Criação do Catão: " + getDataCriacao() + "\n";
		out = out + "Quantidade de Cartões já criados (não necessariamente deste usuário): " + getNumeroCartoes() + "\n";
		return out;
	}
		
}
