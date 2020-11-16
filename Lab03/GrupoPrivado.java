import java.util.GregorianCalendar;

public class GrupoPrivado extends Grupo {
	//construtor
	public GrupoPrivado(String nome, String descricao, Usuario dono, boolean status, GregorianCalendar dataCriacao) {
		super(nome, descricao, dono, status, dataCriacao);
	}
	//adicionando membros --> como o grupo é privado, somente o dono pode adicionar alguém
	public void adicionaMembro(Usuario requisitor, Usuario novo) {
		if(this.getStatus() == true) { //checando se o status é ativo
			if(this.getDono() == requisitor) { //checando se o requisitor é o dono do grupo
				this.getMembros().add(novo);
				// adicionando este grupo na lista de grupos do novo usuário
				novo.getGrupos().add(this);
				System.out.println("Usuário " + novo.getLogin() + " adicionado com sucesso!!!");
			}
			else {
				System.out.println("Usuário requisitor " + requisitor.getLogin() + " não é o dono do grupo, então não se pode adicionar novo usuário.");
			}
		}
		else {
			System.out.println("O status do grupo não é ativo, então não se pode adicionar novo usuário.");
		}
	}
	
	//remove membros --> como o grupo é privado, somente o dono pode remover alguém
	public void removeMembro(Usuario requisitor, Usuario del) {
		if(this.getStatus() == true) { //checando se o status é ativo
			if(this.getDono() == requisitor) { //checando se o requisitor é o dono do grupo
				for (int i = 0; i < this.getMembros().size(); i++) { 
					if (this.getMembros().get(i)== del) {//checando se o usuário a ser removido existe
						this.getMembros().remove(i);
						//removendo esse grupo da lista de grupos desse usuário removido
						del.removerGrupo(this);;
						System.out.println("Usuário " + del.getLogin() + " removido com sucesso!!!");
						break;
					}
				}
			}
			else {
				System.out.println("Usuário requisitor " + requisitor.getLogin() + " não é o dono do grupo, então não se pode remover o usuário.");
			}
		}else {
			System.out.println("O status do grupo não é ativo, então não se pode remover o usuário.");
		}
	}
	
	//to String
	@Override
	public String toString() {
		String out = "Lista de Membros deste Grupo Privado: \n";
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
