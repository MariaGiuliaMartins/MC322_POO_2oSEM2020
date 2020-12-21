import java.util.GregorianCalendar;

public class Admin extends Usuario{
	//construtor
	public Admin(int id, String login, String email, String senha, String descricao, GregorianCalendar dataAtivacao, boolean status) {
		super(id, login, email, senha, descricao, dataAtivacao, status);
	}
	
	//desabilitar um grupo
	public void desabilitarGrupo(Grupo grupo_desabilitar) {
		grupo_desabilitar.setStatus(false);//muda o status do grupo
	}
	
	//criar grupo
	public void criarGrupo(String nome_grupo, String descricao_grupo, boolean visibilidade) {
		if (visibilidade == false) { 
			GrupoPublico novo_grupo = new GrupoPublico(nome_grupo, descricao_grupo, this, this.status, (GregorianCalendar) GregorianCalendar.getInstance());
		}
		if (visibilidade == true){ 
			GrupoPrivado novo_grupo = new GrupoPrivado(nome_grupo, descricao_grupo, this, this.status, (GregorianCalendar) GregorianCalendar.getInstance());
		}	
	}
}
