import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;


public abstract class Usuario {
	//atributos
	private int id;
	private Perfil perfil;
	private String login;
	private String email;
	private String senha;
	private GregorianCalendar dataAtivacao;
	protected ArrayList<Grupo> grupos;
	protected boolean status;
	
	//Método Construtor
	public Usuario(int id, Perfil perfil, String login, String email, String senha, GregorianCalendar dataAtivacao, boolean status) {
		this.id = id;
		this.perfil = perfil;
		this.login = login;
		this.email = email;
		this.senha = senha;
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
	
	///perfil
	public Perfil getPerfil() {
		return perfil;
	}
	
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
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
	
	
	///executar a tarefa de maior prioridade
	public void executarTarefaDeMaiorPrioridade() {
		/*
		 * Função que muda o label de um cartão de TO_DO para DONE e o troca de array lis conforme sua prioridade
		 */
		
		///vamos criar um array list auxiliar para separar os cartoes que ese usuario é responsavel
		ArrayList<Cartao> aux = new ArrayList<Cartao> ();
		
		//primeiro percorremos todos os grupos que this usuario faz parte
		for (int i = 0; i < this.getGrupos().size(); i++) {
			//para cada grupo, devemos pegar os cartões do qual this usuario é responsavel e que não foram executados
			for (int j = 0; j < this.getGrupos().get(i).getCartoesAFazer().size(); j++) {
				//então devemos ver em quais desses cartões this usuario é o responsável
				if(this.getGrupos().get(i).getCartoesAFazer().get(j).getResponsavel() == this) { 
					//se este usuario for responsavel por algum cartao, adicionamos em aux
					aux.add(this.getGrupos().get(i).getCartoesAFazer().get(j));
					break;
				}
			}
		}
		
		//agora que temos a lista de cartões que este usuário é responsável podemos executar o de maior prioridade
		if (aux.size() != 0) { //se houver cartões no qual este usuario é responsavel
			//temos que ordenar aux de acordo com a sua prioridade implementada na função compareTo em Cartao
			Collections.sort(aux);
		}
		else {
			System.out.println("Usuário " + this.getLogin() + " não é responsável por nenhum cartão, logo não se pode executar cartão algum.");
		}
		
		//agora que temos os cartoes separados de interesse e oredenados corretamente, podemos então executar o de maior prioridade
		//primeiro devemos encontrar o grupo que o cartão com maior prioridade faz parte
		for (int i = 0; i < this.getGrupos().size(); i++) { //percorrendo a lista de grupos do this usuario
			for (int j = 0; j < this.getGrupos().get(i).getCartoesAFazer().size(); j++) { //percorrendo a lista de cartoes de cada grupo
				//checando a qual grupo o cartao de mior prioridade pertence
				if (this.getGrupos().get(i).getCartoesAFazer().get(j).equals(aux.get(0))) { //se forem iguais
					//removemos do array de cartoes a fazer do grupo
					this.getGrupos().get(i).getCartoesAFazer().remove(j);
					//mudamos o label do cartao
					aux.get(0).setLabel(Label.DONE);
					//e adicionamos em cartoes feitos do mesmo grupo
					this.getGrupos().get(i).getCartoesFeitos().add(aux.get(0));
				}
			}
		}
		
		
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
	public void criarCartao(int id, int visibilidade, int prioridade, String nomeCartao, Usuario responsavelCartao, String assunto, boolean invitation) {
		/* Função que cria um cartão a partir de um usuario
		 * 
		 * Input: id do grupo, 
		 * 		  visibilidade do cartao,
		 * 	 	  prioridade do cartao,
		 * 		  nome do cartão,
		 * 		  usuario respansavel pelo cartao,
		 * 		  assunto do cartao,
		 * 	 	  booleano de convite,
		 * 
		 * Output: novo cartão atribuido ao grupo que que this usuário passa como id no método
		 * 		  
		 * obs: o label não entra como parametro pois é instanciado automaticamente como TO_DO,
		 * 		data de criação que é pega automaticamente do sistema,
		 * 		dono do cartão é this usuario que cria
		 */
		
		
		//primeiro procuramos a qual grupo o usuario se refere a partir do id passado como parâmetro
		for (int i = 0; i < this.getGrupos().size(); i++) {
			if (this.getGrupos().get(i).getId() == id) { //se encontramos o grupo passado
				//agora temos que ver se o usuário responsavel está neste grupo
				for (int j = 0; j <this.getGrupos().get(i).getMembros().size(); j++) {
					if (this.getGrupos().get(i).getMembros().get(j) == responsavelCartao) { //se encontramos o responsavel em membros
						//temos que ver se este usuario possui a permissao de criar cartao neste grupo
						for (int k = 0; k < this.getGrupos().get(i).getPermissaoCriarCartao().size(); k++){
							if (this.getGrupos().get(i).getPermissaoCriarCartao().get(k) == this) { //se esse usuario tem a permissao de criar cartoes
								//primeiro checamos se este usuario é comum ou um adm
								if(this instanceof UsuarioComum) {
									//criamos o novo cartao
									Cartao novo_cartao = new Cartao(visibilidade, prioridade, nomeCartao, Label.TO_DO, (UsuarioComum) this, responsavelCartao, assunto, invitation, (GregorianCalendar)Calendar.getInstance());
									this.getGrupos().get(i).adicionarCartao(novo_cartao);
									System.out.println(this.getLogin() + " criou um cartão com sucesso!!!");
								}
								else if (this instanceof Admin) {
									//criamos o novo cartao
									Cartao novo_cartao = new Cartao(visibilidade, prioridade, nomeCartao, Label.TO_DO, (Admin) this, responsavelCartao, assunto, invitation, (GregorianCalendar)Calendar.getInstance());
									this.getGrupos().get(i).adicionarCartao(novo_cartao);
									System.out.println(this.getLogin() + " criou um cartão com sucesso!!!");
								}
								else {
									System.out.println("Usuário " + this.getLogin() + " não é um Usuário Comum ou Admin, então não pode criar o cartão.");
								}
								
							}
						}
					}
				}
			}
		}
	}
	
	
	///toString
	@Override
	public String toString() {
		String out = getLogin() + " (id: " + getId() + ")\n";
		out += "Perfil" + getPerfil() + "\n";
		out = out + "Login: " + getLogin() + "\n";
		out = out + "e-mail: " + getEmail() + "\n";
		out = out + "Senha: " + getSenha() + "\n";
		out = out + "Data de ativação: " + getDataAtivacao() + "\n";
		out = out + "Grupos que este usuário faz parte: \n";
		for (int i = 0; i < getGrupos().size(); i++) {
			out += "Grupo " + i + ": " + getGrupos().get(i).getNome() + "; ";
		}
		out = out + "Status: " + getStatus() + "\n";
		return out;
	}
}
