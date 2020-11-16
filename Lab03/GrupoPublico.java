import java.util.GregorianCalendar;

public class GrupoPublico extends Grupo{
	//construtor
	public GrupoPublico(String nome, String descricao, Usuario dono, boolean status, GregorianCalendar dataCriacao) {
		super(nome, descricao, dono, status, dataCriacao);
	}
	
	//adicionando membros --> como o grupo é público, qualquer membro pode adicionar outro
	public void adicionaMembro(Usuario novo) {
		if (this.getStatus() == true) { //checando se o status é ativo
			for (int i = 0; i < this.getMembros().size(); i++) { //checando se o membro a ser adicionado já faz parte do grupo
				if(this.getMembros().get(i) != novo) { //se o usuario não faz parte do grupo
					this.getMembros().add(novo);
					novo.getGrupos().add(this); //vamos adicionar esse novo grupo na lista de grupos desse usuário					
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
	
	//remove membros --> como o grupo é público, qualquer membro pode remover outro
	public void removeMembro(Usuario del) {
		if (this.getStatus() == true) { //checando se o status é ativo
			for (int i = 0; i < this.getMembros().size(); i++) {
				//checando se o usuário a ser deletado existe
				if (this.getMembros().get(i) == del) { 
					this.getMembros().remove(i);
					System.out.println("Usuário " + del.getLogin() + " removido com sucesso!!!");
					//vamos remover este grupo da lista de grupos deste usuário
					del.removerGrupo(this);
					break;
				}
			}
		}
		else {
			System.out.println("O status do grupo não é ativo, então não se pode remover o usuário.");
		}
	}
	
	//to String
	@Override
	public String toString() {
		String out = "Lista de Membros deste Grupo Público: \n";
		for (int i = 0; i < this.membros.size(); i++) {
			out = out + "Membro " + i + ": ";
			out = out + this.membros.get(i).getLogin()+ ", ";
			out = out + " (id: " + this.membros.get(i).getId() + "), ";
			out = out + "e-mail: " + this.membros.get(i).getEmail() + ",";
			out = out + "Senha: " + this.membros.get(i).getSenha() + ", ";
			out = out + "Descrição do usuário: " + this.membros.get(i).getDescricao() + ", ";
			out = out + "Data de ativação: " + this.membros.get(i).getDataAtivacao() + ", ";
			out = out + "Status: " + this.membros.get(i).getStatus() + ";" + "\n";
		}
		return out;
	}
}
