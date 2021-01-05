import java.util.GregorianCalendar;


public class Cartao implements Comparable<Cartao> {
	//atributos
	private static int numeroCartoes = 0; //incializada com 0, atributo de classe
	private final int id; //variavel ja inicializada com 0
	private int visibilidade;
	private int prioridade;
	private String nome;
	private Usuario dono;
	private Usuario responsavel;
	private Label labels;
	private String assunto;
	private boolean invitationOnly;
	private GregorianCalendar dataCriacao;
	
	//metodo construtor sem parametros
	public Cartao() {
		id = Cartao.numeroCartoes++; //a cada novo cartao criado, incrementa-se o id do cartao
		numeroCartoes ++; //a cada novo cartao criado, incrementa-se o numero de cartoes criados
	}
		
	//metodo construtor com parametros para usuario comum
	public Cartao(int visibilidade, int prioridade, String nome, Label labels, UsuarioComum dono, Usuario responsavel, String assunto, boolean invitationOnly, GregorianCalendar dataCriacao) {
		id = Cartao.numeroCartoes++;
		numeroCartoes ++; //a cada novo cartao criado, incrementa-se o numero de cartoes criados
		this.visibilidade = visibilidade;
		this.prioridade = prioridade;
		this.nome = nome;
		this.dono = dono;
		this.responsavel = responsavel;
		this.labels = labels;
		this.assunto = assunto;
		this.invitationOnly = invitationOnly;
		this.dataCriacao = dataCriacao;		
	}
	
	//metodo construtor com parametros para admin
	public Cartao(int visibilidade, int prioridade, String nome, Label labels, Admin dono, Usuario responsavel, String assunto, boolean invitationOnly, GregorianCalendar dataCriacao) {
		id = Cartao.numeroCartoes++;
		numeroCartoes ++; //a cada novo cartao criado, incrementa-se o numero de cartoes criados
		this.visibilidade = visibilidade;
		this.prioridade = prioridade;
		this.nome = nome;
		this.dono = dono;
		this.responsavel = responsavel;
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
	
	///prioridade
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
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
	public void setDono(UsuarioComum dono) {
		this.dono = dono;
	}
	
	///resposavel
	public Usuario getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}
	
	///labels
	public Label getLabel() {
		return labels;
	}
	public void setLabel(Label labels) {
		this.labels = labels;
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
	
	///compareTo
	@SuppressWarnings("static-access")
	public int compareTo(Cartao comparando) {
		/* Função que compara this cartão com o Cartao comparando.
		 * Primeiro checamos quem tem a maior prioridade. Caso forem iguais, comparamos por datas de criação.
		 * Explicando os retornos:
		 * 		1  -> this tem prioridade maior
		 * 		-1 -> Cartao comparando tem prioridade maior
		 *  	0  -> ambos os cartões tem a mesma prioridade baseado em suas datas (bem improvavel de ocorrer)
		 */
		//se a prioridade deste cartao for maior que a do que está sendo comparado retornamos 1
		if (this.prioridade > comparando.prioridade) {
			return 1; 
		}
		//se a prioridade for menor, retornamos -1
		else if (this.prioridade < comparando.prioridade) {
			return -1;
		}
		//se a prioridade for igual temos que fazer outra comparação. Faremos pela data de criação dos cartões
		else{
			//se os anos forem iguais
			if (this.dataCriacao.YEAR == comparando.dataCriacao.YEAR) {
				//se os meses forem iguais
				if (this.dataCriacao.MONTH == comparando.dataCriacao.MONTH) {
					//vemos os dias
					if (this.dataCriacao.DATE == comparando.dataCriacao.DATE) {
						return 0;
					}
					else if (this.dataCriacao.DATE < comparando.dataCriacao.DATE) {
						return 1;
					}
					else {
						return -1;
					}
				}
				//se este cartao for de um mês mais antigo
				else if (this.dataCriacao.MONTH < comparando.dataCriacao.MONTH) {
					return 1;
				}
				else {
					return -1;
				}
			}
			//se este cartao for de um ano mais antigo
			else if (this.dataCriacao.YEAR < comparando.dataCriacao.YEAR) {
				return 1;
			}
			//se este cartao for mais novo
			else {
				return -1;
			}
		}
	}
	
	///toString
		@Override
	public String toString() {
		String out = "Características do Cartão: " + "\n";
		out = out + "Dono do Cartão: " + getDono() + "\n";
		out = out + "Nome do Cartão: " + getNome() + "\n";
		out = out + "Id do Cartão: " + getId() + "\n";
		out = out + "Labels do Cartão: \n" + getLabel() + "\n";
		out += "Assunto do Cartão: " + getAssunto() + "\n";
		out = out + "Visibilidade do Cartão: " + getVisibilidade() + "\n";
		out = out + "Invitation Only: " + getInvitationOnly() + "\n";
		out = out + "Data de Criação do Catão: " + getDataCriacao() + "\n";
		out = out + "Quantidade de Cartões já criados (não necessariamente deste usuário): " + getNumeroCartoes() + "\n";
		return out;
	}
		
}
