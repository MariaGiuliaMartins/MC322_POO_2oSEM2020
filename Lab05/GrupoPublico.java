import java.util.ArrayList;
import java.util.GregorianCalendar;

public class GrupoPublico extends Grupo{
	//construtor
	public GrupoPublico(String nome, String descricao, Usuario dono, boolean status, GregorianCalendar dataCriacao) {
		super(nome, descricao, dono, status, dataCriacao);
	}
	
	//adicionando membros,
	@Override
	public void adicionaMembro(Usuario requisitor, Usuario novo, ArrayList<Permissao> permissao) {
		if (this.getStatus() == true) { //checando se o status é ativo
			for (int i = 0; i < this.getMembros().size(); i++) { //checando se o membro a ser adicionado já faz parte do grupo
				if(this.getMembros().get(i) != novo) { //se o usuario não faz parte do grupo
					this.getMembros().add(novo);
					novo.getGrupos().add(this); //vamos adicionar esse novo grupo na lista de grupos desse usuário
					this.permissaoVisualizar.add(novo); //todo membro novo de um grupo publico tem a permissao de visualizar
					this.permissaoAdicionar.add(novo); //todo membro novo de um grupo publico tem a permissao de adicionar
					this.permissaoRemover.add(novo); //todo membro novo de um grupo publico tem a permissao de remover
					this.permissaoAlterar.add(novo); //todo membro novo de um grupo publico tem a permissao de alterar
					System.out.println("Usuário " + novo.getLogin() + " adicionado com sucesso!!!");
					break;
				}
				else { //se o usuario não fizer parte do grupo, então é adicionado
					System.out.println("Usuário " + novo.getLogin() + " já faz parte do grupo.");
				}
			}
		}
		else {
			System.out.println("O status do grupo não é ativo, então não se pode adicionar um novo usuário.");
		}
	}
	
	//remove membros
	@Override
	public void removeMembro(Usuario requisitor, Usuario del) {
		if (this.getStatus() == true) { //checando se o status é ativo
			for (int i = 0; i < this.getMembros().size(); i++) {
				//checando se o usuário a ser deletado existe
				if (this.getMembros().get(i) == del) { 
					this.getMembros().remove(i);
					//vamos remover este grupo da lista de grupos deste usuário
					del.removerGrupo(this);
					this.permissaoAdicionar.remove(del); //removendo do ArrayList de permissao adicionar
					this.permissaoRemover.remove(del); //removendo do ArrayList de permissao remover
					this.permissaoAlterar.remove(del); //removendo do ArrayList de permissao alterar
					this.permissaoVisualizar.remove(del); //removendo do ArrayList de permissao visualizar
					System.out.println("Usuário " + del.getLogin() + " removido com sucesso!!!");
					break;
				}
			}
		}
		else {
			System.out.println("O status do grupo não é ativo, então não se pode remover o usuário.");
		}
	}
	
	//adicionar permissao
	@Override
	public void adicionarPermissao(Usuario requisitor, Usuario nova_permissao, ArrayList<Permissao> permissao) {
		//checando se o usuario nova_permissao é o dono do grupo
		if (nova_permissao != this.getDono()) {
			//verificando se o requisitor está dentro do arraylist de permissaoAlterar
			for (int i = 0; i < this.getPermissaoAlterar().size(); i++) {
				if(this.getPermissaoAlterar().get(i) == requisitor) { //se estiver
					//verificamos se nova_permissao já possui essa permissao
					for (int j = 0; j < permissao.size(); j++) { //passando pelo arraylist permissao
						if (permissao.get(j) == Permissao.ADICIONAR_MEMBROS) { //se houver a permissao de add
							for (int k = 0; k < this.getPermissaoAdicionar().size(); k++) { //checando se usuario nova_permissao já possui esa permissao
								if (this.getPermissaoAdicionar().get(k) != nova_permissao) {
									this.getPermissaoAdicionar().add(nova_permissao);
								}
							}
							
						}
						if (permissao.get(j) == Permissao.REMOVER_MEMBROS) { //se houver a permissao de remover
							for (int k = 0; k < this.getPermissaoRemover().size(); k++) { //checando se usuario nova_permissao já possui esa permissao
								if (this.getPermissaoRemover().get(k) != nova_permissao) {
									this.getPermissaoRemover().add(nova_permissao);
								}
							}			
						}
						if (permissao.get(j) == Permissao.ALTERAR_PERMISSAO) { //se houver a permissao de alterar
							for (int k = 0; k < this.getPermissaoAlterar().size(); k++) { //checando se usuario nova_permissao já possui esa permissao
								if (this.getPermissaoAlterar().get(k) != nova_permissao) {
									this.getPermissaoAlterar().add(nova_permissao);
								}
							}							
						}
						if (permissao.get(j) == Permissao.VISUALIZA_INFO) { //se houver a permissao de visualizar
							for (int k = 0; k < this.getPermissaoVisualizar().size(); k++) { //checando se usuario nova_permissao já possui esa permissao
								if (this.getPermissaoVisualizar().get(k) != nova_permissao) {
									this.getPermissaoVisualizar().add(nova_permissao);
								}
							}							
						}
						if (permissao.get(j) == Permissao.CRIAR_CARTAO) { //se houver a permissao de criar cartao
							for (int k = 0; k < this.getPermissaoCriarCartao().size(); k++) { //checando se usuario nova_permissao já possui esa permissao
								if (this.getPermissaoCriarCartao().get(k) != nova_permissao) {
									this.getPermissaoCriarCartao().add(nova_permissao);
								}
							}							
						}
					}
				}
				else {
					System.out.println("Usuário " + requisitor.getLogin() + "não pode alterar a permissão de " + nova_permissao.getLogin() + "\n");
				}
			}
		}
	}
	
	//remover permissao
	@Override
	public void removerPermissao(Usuario requisitor, Usuario nova_permissao, ArrayList<Permissao> permissao) {
		//checando se o usuario nova_permissao é o dono do grupo
		if (nova_permissao != this.getDono()) {
			//verificando se o requisitor está dentro do arraylist de permissaoAlterar
			for (int i = 0; i < this.getPermissaoAlterar().size(); i++) {
				if(this.getPermissaoAlterar().get(i) == requisitor) { //se estiver
					//verificamos se nova_permissao já possui essa permissao
					for (int j = 0; j < permissao.size(); j++) { //passando pelo arraylist permissao
						if (permissao.get(j) == Permissao.ADICIONAR_MEMBROS) { //se houver a permissao de add
							for (int k = 0; k < this.getPermissaoAdicionar().size(); k++) { //checando se usuario nova_permissao já possui esa permissao
								if (this.getPermissaoAdicionar().get(k) == nova_permissao) {
									this.getPermissaoAdicionar().remove(nova_permissao);
									break;
								}
							}
							
						}
						if (permissao.get(j) == Permissao.REMOVER_MEMBROS) { //se houver a permissao de remover
							for (int k = 0; k < this.getPermissaoRemover().size(); k++) { //checando se usuario nova_permissao já possui esa permissao
								if (this.getPermissaoRemover().get(k) == nova_permissao) {
									this.getPermissaoRemover().remove(nova_permissao);
									break;
								}
							}			
						}
						if (permissao.get(j) == Permissao.ALTERAR_PERMISSAO) { //se houver a permissao de alterar
							for (int k = 0; k < this.getPermissaoAlterar().size(); k++) { //checando se usuario nova_permissao já possui esa permissao
								if (this.getPermissaoAlterar().get(k) == nova_permissao) {
									this.getPermissaoAlterar().remove(nova_permissao);
									break;
								}
							}							
						}
						if (permissao.get(j) == Permissao.VISUALIZA_INFO) { //se houver a permissao de visualizar
							for (int k = 0; k < this.getPermissaoVisualizar().size(); k++) { //checando se usuario nova_permissao já possui esa permissao
								if (this.getPermissaoVisualizar().get(k) == nova_permissao) {
									this.getPermissaoVisualizar().remove(nova_permissao);
									break;
								}
							}							
						}
						if (permissao.get(j) == Permissao.CRIAR_CARTAO) { //se houver a permissao de criar cartao
							for (int k = 0; k < this.getPermissaoCriarCartao().size(); k++) { //checando se usuario nova_permissao já possui esa permissao
								if (this.getPermissaoCriarCartao().get(k) == nova_permissao) {
									this.getPermissaoCriarCartao().remove(nova_permissao);
								}
							}							
						}
					}
				}
				else {
					System.out.println("Usuário " + requisitor.getLogin() + "não pode remover a permissão de " + nova_permissao.getLogin() + "\n");
				}
			}
		}
	}
	
	//função para visualizar informações do grupo
	public void VisuInfos(Usuario requisitor) {
		//primeiro checamos se o usuario requisitor tem a permissao de vizualizar
		for (int i = 0; i < this.getPermissaoVisualizar().size(); i++) {
			if (getPermissaoVisualizar().get(i) == requisitor) { //se ele tiver, então imprimimos os dados
				System.out.println("Nome do grupo: " + getNome());
				System.out.println("Dono do grupo: " + getDono().getLogin());
				System.out.println("Dono do grupo: " + getStatus());
				System.out.print("Lista de Membros deste Grupo Público:" + "\n");
				for (int j = 0; j < this.membros.size(); j++) {
					System.out.print("-- Membro " + j + ": " + this.membros.get(j).getLogin() + "\n");
				}
			}
		}
		System.out.println();
	}
	
	///adicionar cartao
	public void adicionarCartao(Cartao novo_cartao) {
		this.cartoes.add(novo_cartao);
	}
	
	
	//to String
	@Override
	public String toString() {
		String out = "Lista de Membros deste Grupo Público: \n";
		for (int i = 0; i < this.membros.size(); i++) {
			out = out + "-- Membro " + i + ": ";
			out = out + this.membros.get(i).getLogin()+ ", ";
			out = out + " (id: " + this.membros.get(i).getId() + "), ";
			out = out + "e-mail: " + this.membros.get(i).getEmail() + ",";
			out = out + "Senha: " + this.membros.get(i).getSenha() + ", ";
			out = out + "Descrição do usuário: " + this.membros.get(i).getDescricao() + ", ";
			out = out + "Data de ativação: " + this.membros.get(i).getDataAtivacao() + ", ";
			out = out + "Status: " + this.membros.get(i).getStatus() + ";" + "\n";
		}
		out += "Membros com permissão de adicionar membros: ";
		for (int i = 0; i < this.permissaoAdicionar.size(); i++) {
			 out += this.permissaoAdicionar.get(i).getLogin() + "; ";
		}
		out +=  "\n" + "Membros com permissão de remover membros: ";
		for (int i = 0; i < this.permissaoRemover.size(); i++) {
			out += this.permissaoRemover.get(i).getLogin() + "; ";
		}
		out +=  "\n" + "Membros com permissão de alterar permissões: ";
		for (int i = 0; i < this.permissaoAlterar.size(); i++) {
			out += this.permissaoAlterar.get(i).getLogin() + "; ";
		}
		out +=  "\n" + "Membros com permissão de visualizar dados do grupo: ";
		for (int i = 0; i < this.permissaoVisualizar.size(); i++) {
			out += this.permissaoVisualizar.get(i).getLogin() + "; ";
		}
		out +=  "\n" + "Membros com permissão de criar cartões no grupo: ";
		for (int i = 0; i < this.permissaoCriarCartao.size(); i++) {
			out += this.permissaoCriarCartao.get(i).getLogin() + "; ";
		}
		out +=  "\n" + "Cartões do grupo: ";
		for (int i = 0; i < this.cartoes.size(); i++) {
			out += this.cartoes.get(i).getNome() + "; ";
		}
		out +=  "\n";
		return out;
	}
}
