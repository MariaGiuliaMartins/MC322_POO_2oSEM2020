import java.util.GregorianCalendar;

public class Sala {
	//atributos
	private static int numeroSalas = 0; //atributo de classe
	private final int id; //variavel ja inicializada com 0
	private int capacidadeMaxima;
	private int numeroUsuarios = 0; //iniciada com 0
	private String descricao;
	private UsuarioComum dono;
	private boolean ingressoAutomatico;
	private GregorianCalendar dataCriacao;
	
	
	//metodo construtor sem parametros
	public Sala() {
		id = Sala.numeroSalas++; //a cada nova sala criada, incrementa-se o id da sala
		numeroSalas ++; //a cada sala nova, o numero de salas aumenta		
		numeroUsuarios ++; //quando se cria uma sala, pelo menos 1 usuário já existe
	}
		
	//metodo construtor com parametros
	public Sala(int capacidadeMaxima, String descricao, UsuarioComum dono, boolean ingressoAutomatico, GregorianCalendar dataCriacao) {
		id = Sala.numeroSalas++;
		numeroSalas ++;
		numeroUsuarios ++; 
		this.capacidadeMaxima = capacidadeMaxima;
		this.descricao = descricao;
		this.dono = dono;
		this.ingressoAutomatico = ingressoAutomatico;
		this.dataCriacao = dataCriacao;		
	}
	
	
	
	//demais metodos
	///numero de salas
	public static int getNumeroSalas() {
		return numeroSalas;
	}
	public static void setNumeroSalas(int numeroSalas) {
		Sala.numeroSalas = numeroSalas;
	}
		
	///id	
	public final int getId() {
		return id;
	}
	
	///capacidade maxima
	public int getCapacidadeMaxima() {
		return capacidadeMaxima;
	}
	public void setCapacidadeMaxima(int capacidadeMaxima) {
		this.capacidadeMaxima = capacidadeMaxima;
	}
	
	///numero de usuarios
	public int getNumeroUsuarios() {
		return numeroUsuarios;
	}
	public void setNumeroUsuarios(int numeroUsuarios) {
		this.numeroUsuarios = numeroUsuarios;
	}
	
	///descricao
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	///dono
	public UsuarioComum getDono() {
		return dono;
	}
	public void setDono(UsuarioComum dono) {
		this.dono = dono;
	}
	
	////ingresso automatico
	public boolean isIngressoAutomatico() {
		return ingressoAutomatico;
	}
	public void setIngressoAutomatico(boolean ingressoAutomatico) {
		this.ingressoAutomatico = ingressoAutomatico;
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
	
	///adiciona usuario
	public boolean adicionaUsuario() {
		if (numeroUsuarios < capacidadeMaxima) { //se ainda nao ultrapssou a capacidade maxima
			numeroUsuarios ++; //a cada usuario que entra, incrementa-se
			System.out.println("Novo usuário adicionado com sucesso.\n");
			return true;
		}else {
			System.out.println("Limite de usuários atingido, não se pode adicionar mais usuários.\n");
			return false;
		}
	}
	
	///remove usuario
	public boolean removeUsuario() {
		if (numeroUsuarios != 0) { //se ainda ha usuarios na sala
			numeroUsuarios --;
			System.out.println("Usuário removido com sucesso.\n");
			return true;
		}else {
			System.out.println("Não há usuários a serem removidos, a sala está vazia.\n");
			return false;
		}
		
	}
	
	
	///toString
	@Override
	public String toString() {
		String out = "Características da Sala: " + "\n";
		out = out + "Dono da Sala: " + getDono() + "\n";
		out = out + "Id da Sala: " + getId() + "\n";
		out = out + "Quantidade de Usuários: " + getNumeroUsuarios() + "/" + getCapacidadeMaxima() + "\n";
		out = out + "Data de Cração da Sala: " + getDataCriacao() + "\n";
		out = out + "Descrição da Sala: " + getDescricao() + "\n";	
		out = out + "Número de usuários da sala: " + getNumeroUsuarios() + "\n";
		out = out + "Salas criadas até agora (não necessariamente pertencem a esse usuário): " + getNumeroSalas() + "\n";
		return out;
	}
	
	
}
