import java.util.GregorianCalendar;

public class UsuarioComum extends Usuario {
	//construtor
	public UsuarioComum(int id, Perfil perfil, String login, String email, String senha, GregorianCalendar dataAtivacao, boolean status){
		super(id, perfil, login, email, senha, dataAtivacao, status);
	}
	
	//criar grupo
	public void criarGrupo(boolean ehPrivado) {
		
	}

	@Override
	public void criarGrupo(String nome_grupo, String descricao_grupo, boolean visibilidade) {
		
	}
	
	///toString
	@Override
	public String toString() {
		return super.toString();
	}
}
