import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Cartao {
	//atributos
	private static int numeroCartoes = 0; //incializada com 0, atributo de classe
	private final int id; //variavel ja inicializada com 0
	private int visibilidade;
	private String nome;
	private Usuario dono;
	protected ArrayList<Label> labels;
	private String assunto;
	private boolean invitationOnly;
	private GregorianCalendar dataCriacao;
	
	//metodo construtor sem parametros
	public Cartao() {
		id = Cartao.numeroCartoes++; //a cada novo cartao criado, incrementa-se o id do cartao
		numeroCartoes ++; //a cada novo cartao criado, incrementa-se o numero de cartoes criados
	}
		
	//metodo construtor com parametros
	public Cartao(int visibilidade, String nome, ArrayList<Label> labels, Usuario dono, String assunto, boolean invitationOnly, GregorianCalendar dataCriacao) {
		id = Cartao.numeroCartoes++;
		numeroCartoes ++; //a cada novo cartao criado, incrementa-se o numero de cartoes criados
		this.visibilidade = visibilidade;
		this.nome = nome;
		this.dono = dono;
		this.labels = labels;
		this.assunto = assunto;
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
	public final int getId() {
		return id;
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
	
	///labels
	public ArrayList<Label> getLabel() {
		return labels;
	}
	
	///assunto
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
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
		out = out + "Labels do Cartão: \n";
		for (int i = 0; i < labels.size(); i++) {
			out += "Label " + i + ":\n";
			out += "-- Rótulo: " + labels.get(i).getRotulo() + "\n";
			out += "-- Cor: " + labels.get(i).getCor() + "\n";					
		}
		out += "Assunto do Cartão: " + getAssunto() + "\n";
		out = out + "Visibilidade do Cartão: " + getVisibilidade() + "\n";
		out = out + "Invitation Only: " + getInvitationOnly() + "\n";
		out = out + "Data de Criação do Catão: " + getDataCriacao() + "\n";
		out = out + "Quantidade de Cartões já criados (não necessariamente deste usuário): " + getNumeroCartoes() + "\n";
		return out;
	}
		
}
