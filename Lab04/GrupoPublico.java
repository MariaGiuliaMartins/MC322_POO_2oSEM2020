import java.util.ArrayList;
import java.util.GregorianCalendar;

public class GrupoPublico extends Grupo{
	//construtor
	public GrupoPublico(String nome, String descricao, Usuario dono, boolean status, GregorianCalendar dataCriacao) {
		super(nome, descricao, dono, status, dataCriacao);
	}
	
	//adicionando membros
	public void adicionaMembro(Usuario requisitor, Usuario novo, ArrayList<Permissao> permissao) {
		if (this.getStatus() == true) { //checando se o status é ativo
			for (int i = 0; i < this.getMembros().size(); i++) { //checando se o membro a ser adicionado já faz parte do grupo
				if(this.getMembros().get(i) != novo) { //se o usuario não faz parte do grupo
					this.getMembros().add(novo);
					novo.getGrupos().add(this); //vamos adicionar esse novo grupo na lista de grupos desse usuário
					this.permissaoVisualizar.add(novo); //todo membro novo de um grupo privado tem a permissao de visualizar
					for (int j = 0; j < permissao.size(); j++) { //passando pelo arraylist permissao
						//checando quais permissoes estao dentro do ArrayList de permissoes passado como parametro
						if (permissao.get(j) == Permissao.ADICIONAR_MEMBROS) { //se houver a permissao de add
							this.permissaoAdicionar.add(novo); //adicionamos esse usuario lá							
						}
						if (permissao.get(j) == Permissao.REMOVER_MEMBROS) { //se houver a permissao de remover
							this.permissaoRemover.add(novo); //adicionamos esse usuario lá							
						}
						if (permissao.get(j) == Permissao.ALTERAR_PERMISSAO) { //se houver a permissao de alterar
							this.permissaoAlterar.add(novo); //adicionamos esse usuario lá							
						}
					}
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
	public void adicionarPermissao(Usuario requisitor, Usuario nova_permissao, ArrayList<Permissao> permissao) {
		//checando se o usuario nova_permissao é o dono do grupo
		if (nova_permissao != this.getDono()) {
			//verificando se o requisitor está dentro do arraylist de permissaoAlterar
			for (int i = 0; i < this.getPerimissaoAlterar().size(); i++) {
				if(this.getPerimissaoAlterar().get(i) == requisitor) { //se estiver
					//verificamos se nova_permissao já possui essa permissao
					for (int j = 0; j < permissao.size(); j++) { //passando pelo arraylist permissao
						if (permissao.get(j) == Permissao.ADICIONAR_MEMBROS) { //se houver a permissao de add
							for (int k = 0; k < this.getPerimissaoAdicionar().size(); k++) { //checando se usuario nova_permissao já possui esa permissao
								if (this.getPerimissaoAdicionar().get(k) != nova_permissao) {
									this.getPerimissaoAdicionar().add(nova_permissao);
								}
							}
							
						}
						if (permissao.get(j) == Permissao.REMOVER_MEMBROS) { //se houver a permissao de remover
							for (int k = 0; k < this.getPerimissaoRemover().size(); k++) { //checando se usuario nova_permissao já possui esa permissao
								if (this.getPerimissaoRemover().get(k) != nova_permissao) {
									this.getPerimissaoRemover().add(nova_permissao);
								}
							}			
						}
						if (permissao.get(j) == Permissao.ALTERAR_PERMISSAO) { //se houver a permissao de alterar
							for (int k = 0; k < this.getPerimissaoAlterar().size(); k++) { //checando se usuario nova_permissao já possui esa permissao
								if (this.getPerimissaoAlterar().get(k) != nova_permissao) {
									this.getPerimissaoAlterar().add(nova_permissao);
								}
							}							
						}
						if (permissao.get(j) == Permissao.VISUALIZA_INFO) { //se houver a permissao de visualizar
							for (int k = 0; k < this.getPerimissaoVisualizar().size(); k++) { //checando se usuario nova_permissao já possui esa permissao
								if (this.getPerimissaoVisualizar().get(k) != nova_permissao) {
									this.getPerimissaoVisualizar().add(nova_permissao);
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
	public void removerPermissao(Usuario requisitor, Usuario nova_permissao, ArrayList<Permissao> permissao) {
		//checando se o usuario nova_permissao é o dono do grupo
		if (nova_permissao != this.getDono()) {
			//verificando se o requisitor está dentro do arraylist de permissaoAlterar
			for (int i = 0; i < this.getPerimissaoAlterar().size(); i++) {
				if(this.getPerimissaoAlterar().get(i) == requisitor) { //se estiver
					//verificamos se nova_permissao já possui essa permissao
					for (int j = 0; j < permissao.size(); j++) { //passando pelo arraylist permissao
						if (permissao.get(j) == Permissao.ADICIONAR_MEMBROS) { //se houver a permissao de add
							for (int k = 0; k < this.getPerimissaoAdicionar().size(); k++) { //checando se usuario nova_permissao já possui esa permissao
								if (this.getPerimissaoAdicionar().get(k) == nova_permissao) {
									this.getPerimissaoAdicionar().remove(nova_permissao);
									break;
								}
							}
							
						}
						if (permissao.get(j) == Permissao.REMOVER_MEMBROS) { //se houver a permissao de remover
							for (int k = 0; k < this.getPerimissaoRemover().size(); k++) { //checando se usuario nova_permissao já possui esa permissao
								if (this.getPerimissaoRemover().get(k) == nova_permissao) {
									this.getPerimissaoRemover().remove(nova_permissao);
									break;
								}
							}			
						}
						if (permissao.get(j) == Permissao.ALTERAR_PERMISSAO) { //se houver a permissao de alterar
							for (int k = 0; k < this.getPerimissaoAlterar().size(); k++) { //checando se usuario nova_permissao já possui esa permissao
								if (this.getPerimissaoAlterar().get(k) == nova_permissao) {
									this.getPerimissaoAlterar().remove(nova_permissao);
									break;
								}
							}							
						}
						if (permissao.get(j) == Permissao.VISUALIZA_INFO) { //se houver a permissao de visualizar
							for (int k = 0; k < this.getPerimissaoVisualizar().size(); k++) { //checando se usuario nova_permissao já possui esa permissao
								if (this.getPerimissaoVisualizar().get(k) == nova_permissao) {
									this.getPerimissaoVisualizar().remove(nova_permissao);
									break;
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
		for (int i = 0; i < this.getPerimissaoVisualizar().size(); i++) {
			if (getPerimissaoVisualizar().get(i) == requisitor) { //se ele tiver, então imprimimos os dados
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
		out +=  "\n";
		return out;
	}
}
