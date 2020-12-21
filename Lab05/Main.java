/* RESPOSTAS DAS PERGUNTAS - Lab5
 * 1 - Explique o que é polimorfismo, qual a sua importância e por quê deve ser utilizado.
 * 	   Resposta 1: A melhor maniera de explicar o polimorfismo é através da sua propriedade de que duas 
 * ou mais classes, derivadas de uma mesma superclasse, responderem à mesma mensagem, cada uma de uma 
 * forma diferente (e isso ocorre através do override das funções da superclasse). A sua importância está 
 * no fato de que o polimorfismo gera uma economia de código ao mesmo tempo que o torna mais didático com 
 * subclasses que implementam as funções da superclasse de modo específico ao seu uso, para isso é 
 * necessária que as funções tenham exatamente a mesma assinatura na superclasse. 
 * 
 * 2 - Como é o funcionamento do polimorfismo na linguagem Java?
 * 	   Resposta 2:  O polimorfismo em Java se manifesta apenas em chamadas de métodos, quando polimorfismo 
 * está sendo utilizado, o comportamento que será adotado por um método só será definido durante a execução.
 * 
 * 3 - O que acontece se instanciarmos uma subclasse em uma variável da superclasse e tentarmos chamar um 
 * método que não foi implementado na superclasse? Como você resolveria essa situação?
 *     Resposta 3: O aconteceria é que o programa não iria ser compilado e, consequentemente, não iria rodar. 
 * A única forma de resolvermos isso seria através do downcasting para a variável ter o nível do método que 
 * queremos invocar.
 */

import java.util.ArrayList;
import java.util.GregorianCalendar; //para o calendario
//import java.util.Scanner; //para ler a entrada do teclado

public class Main {
	public static void main(String[] args) {
		System.out.println("----------------------------------------- INSTANCIANDO OBJETOS ---------------------------------------------\n");
		
		//usuários convidados
		UsuarioConvidado User1 = new UsuarioConvidado(1, "Matheus", "matheus@gmail.com", "senha_do_matheus", "Sou o Matheus", new GregorianCalendar(1995, 17, 9), true,  new GregorianCalendar(2020, 11, 01));
		UsuarioConvidado User2 = new UsuarioConvidado(2, "Maria Giulia", "maria_giulia@gmail.com", "senha_da_giulia", "Sou a Maria Giulia", new GregorianCalendar(1997, 11, 18), false,  new GregorianCalendar(2021, 11, 01));	

		
		//instanciando os objetos da classe Admin
		Admin Admin1 = new Admin(3, "Lucas", "admin_lucas@gmail.com", "senha_admin_lucas", "Sou o Admin Lucas", new GregorianCalendar(1991, 19, 9), true);
		Admin Admin2 = new Admin(4, "Jhessica", "admin_jhessica@gmail.com", "senha_admin_jhessica", "Sou a Admin Jhessica", new GregorianCalendar(1998, 3, 13), false);
		
		//imprimindo os objetos criados
		System.out.println("Usuário 1:\n" + User1);
		System.out.println("Usuário 2:\n" + User2);
		System.out.println("Admin 1:\n" + Admin1);
		System.out.println("Admin 2:\n" + Admin2);
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println("----------------------------------------- CRIANDO GRUPOS ---------------------------------------------");
		System.out.println("Vamos mostrar que apenas um usuário do tipo Admin pode criar um grupo: \n");
		
		User1.criarGrupo("Grupo a partir de um usuário convidado", "Usuário convidado tentando criar", true);
		User2.criarGrupo("Grupo a partir de um usuário convidado", "Usuário convidado tentando criar", true);
		
		System.out.println("\nVamos criar um grupo privado e um público a partir dos administradores:");
		//vamos instanciar o grupo criado pelo admin1 e pelo admin2 para podermos manipulá-los depois
		Admin1.criarGrupo("Grupo do Lucas", "Grupo criado pelo adm Lucas", true);
		GrupoPrivado gpv = (GrupoPrivado) Admin1.getGrupos().get(0);
		System.out.println(gpv.getNome());
		
		Admin2.criarGrupo("Grupo da Jhessica", "Grupo criado pela adm Jhessica", false);
		GrupoPublico gpu = (GrupoPublico) Admin2.getGrupos().get(0);
		System.out.println(gpu.getNome());
		System.out.println();
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println("----------------------------------------- ADICIONANDO MEMBROS ---------------------------------------------");
		System.out.println("Para poder adicionar alguém em qualquer grupo, seu status deve sempre estar ativo...");
		System.out.println("Vamos imprimir os status de todos os grupos já criados: ");
		System.out.println("Grupo do Lucas - status: " + gpv.getStatus());
		System.out.println("Grupo da Jhessica - status: " + gpu.getStatus());
		System.out.println("\nVamos então adicionar membros no Grupo do Lucas:\n");
		
		//vamos criar alguns arraylists para poder passar como parametro nas nossas funções
		ArrayList<Permissao> so_add = new ArrayList<Permissao>(); //array com a permissao somente de adicionar membros
		so_add.add(Permissao.ADICIONAR_MEMBROS);
		ArrayList<Permissao> add_rem = new ArrayList<Permissao>(); //pode add e remover membros
		add_rem.add(Permissao.ADICIONAR_MEMBROS);
		add_rem.add(Permissao.REMOVER_MEMBROS); 
		ArrayList<Permissao> visu_cartao = new ArrayList<Permissao>(); //pode visualizar infos e criar cartão
		visu_cartao.add(Permissao.VISUALIZA_INFO);
		visu_cartao.add(Permissao.CRIAR_CARTAO);
		
		gpv.adicionaMembro(Admin1, Admin2, visu_cartao); //adicionando a Jhessica com a permissao de visualizar e criar cartao
		gpv.adicionaMembro(Admin1, User1, add_rem); //adicionando o Matheus com a permissao de add e remover membros
		gpv.adicionaMembro(Admin1, User2, so_add); //adicionando a Maria Giulia com a permissao só de add
		System.out.println();

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("----------------------------------------- IMPRIMINDO PERMISSÕES---------------------------------------------");
			
		System.out.println("Permissão de Adicionar: ");
		for (int i = 0; i < gpv.getPermissaoAdicionar().size(); i ++) {
			System.out.println("--> " + gpv.getPermissaoAdicionar().get(i).getLogin());
		}
		
		System.out.println("\nPermissão de Remover: ");
		for (int i = 0; i < gpv.getPermissaoRemover().size(); i ++) {
			System.out.println("--> " + gpv.getPermissaoRemover().get(i).getLogin());
		}
		
		System.out.println("\nPermissão de Alterar: ");
		for (int i = 0; i < gpv.getPermissaoAlterar().size(); i ++) {
			System.out.println("--> " + gpv.getPermissaoAlterar().get(i).getLogin());
		}
		
		System.out.println("\nPermissão de Visualizar: ");
		for (int i = 0; i < gpv.getPermissaoVisualizar().size(); i ++) {
			System.out.println("--> " + gpv.getPermissaoVisualizar().get(i).getLogin());
		}
		
		System.out.println("\nPermissão de Criar Cartão: ");
		for (int i = 0; i < gpv.getPermissaoCriarCartao().size(); i ++) {
			System.out.println("--> " + gpv.getPermissaoCriarCartao().get(i).getLogin());
		}
		
		System.out.println();


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("----------------------------------------- TESTESTANDO PERMISSÕES ---------------------------------------------");
		System.out.println("Para estes testes de permissões sugeridos, vamos fazer com o aministrador Lucas, pois ele possui as permissões a serem testadas.");
		System.out.println();
		System.out.println("A adição de membros ao grupo já foi realizada posteriormente, quando todos são adicionados a seu grupo.");
		System.out.println();
		System.out.println("Vamos então remover um usuário convidado e um admin do grupo do Lucas: ");
		System.out.println();
		gpv.removeMembro(Admin1, User2);
		System.out.println();
		gpv.removeMembro(Admin1, Admin2);
		System.out.println();
		System.out.println("Vamos alterar a permissão do membro convidado Matheus: ");
		//vamos criar alguns arraylists para poder passar como parametro nas nossas funções
		ArrayList<Permissao> criar = new ArrayList<Permissao>(); //array com a permissao somente de criar cartão
		criar.add(Permissao.CRIAR_CARTAO);
		ArrayList<Permissao> alt = new ArrayList<Permissao>(); //pode alterar a permissao
		alt.add(Permissao.ALTERAR_PERMISSAO); 
		ArrayList<Permissao> visu = new ArrayList<Permissao>(); //pode visualizar a permissao
		visu.add(Permissao.VISUALIZA_INFO); 
		System.out.println("Permissão de Alterar antes: ");
		for (int i = 0; i < gpv.getPermissaoAlterar().size(); i ++) {
			System.out.println("--> " + gpv.getPermissaoAlterar().get(i).getLogin());
		}
		gpv.adicionarPermissao(Admin1, User1, alt);
		System.out.println("Permissão de Alterar depois: ");
		for (int i = 0; i < gpv.getPermissaoAlterar().size(); i ++) {
			System.out.println("--> " + gpv.getPermissaoAlterar().get(i).getLogin());
		}
		System.out.println("Permissão de Criar Cartão antes: ");
		for (int i = 0; i < gpv.getPermissaoCriarCartao().size(); i ++) {
			System.out.println("--> " + gpv.getPermissaoCriarCartao().get(i).getLogin());
		}
		gpv.adicionarPermissao(Admin1, User1, criar);
		System.out.println("Permissão de Criar Cartão depois: ");
		for (int i = 0; i < gpv.getPermissaoCriarCartao().size(); i ++) {
			System.out.println("--> " + gpv.getPermissaoCriarCartao().get(i).getLogin());
		}
		System.out.println("Permissão de Visualizar antes: ");
		for (int i = 0; i < gpv.getPermissaoVisualizar().size(); i ++) {
			System.out.println("--> " + gpv.getPermissaoVisualizar().get(i).getLogin());
		}
		gpv.removerPermissao(Admin1, User1, visu);
		System.out.println("Permissão de Visualizar depois: ");
		for (int i = 0; i < gpv.getPermissaoVisualizar().size(); i ++) {
			System.out.println("--> " + gpv.getPermissaoVisualizar().get(i).getLogin());
		}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("----------------------------------------- VISUALIZANDO DADOS DO GRUPO ---------------------------------------------");		
		System.out.println("id do grupo: " + gpv.getId());
		System.out.println("Nome do grupo: " + gpv.getNome());
		System.out.println("Descrição do grupo: " + gpv.getDescricao());
		System.out.println("Dono do grupo: " + gpv.getDono().getLogin());
		System.out.println("Status do grupo: " + gpv.getStatus());
		System.out.println("Data de criação do grupo: " + gpv.getDataCriacao());
		System.out.println("Lista de Membros deste Grupo Privado:");
		for (int i = 0; i < gpv.membros.size(); i++) {
			System.out.println("-- Membro " + i + ": ");
			System.out.print(gpv.membros.get(i).getLogin()+ ", ");
			System.out.print(" (id: " + gpv.membros.get(i).getId() + "), ");
			System.out.print("e-mail: " + gpv.membros.get(i).getEmail() + ",");
			System.out.print("Senha: " + gpv.membros.get(i).getSenha() + ", ");
			System.out.print("Descrição do usuário: " + gpv.membros.get(i).getDescricao() + ", ");
			System.out.print("Data de ativação: " + gpv.membros.get(i).getDataAtivacao() + ", ");
			System.out.print("Status: " + gpv.membros.get(i).getStatus() + ";" + "\n");
		}
		System.out.println();
		System.out.println("Membros com permissão de adicionar membros: ");
		for (int i = 0; i < gpv.permissaoAdicionar.size(); i++) {
			System.out.print(gpv.permissaoAdicionar.get(i).getLogin() + "; ");
		}
		System.out.println();
		System.out.println("Membros com permissão de remover membros: ");
		for (int i = 0; i < gpv.permissaoRemover.size(); i++) {
			System.out.print(gpv.permissaoRemover.get(i).getLogin() + "; ");
		}
		System.out.println();
		System.out.println("Membros com permissão de alterar permissões: ");
		for (int i = 0; i < gpv.permissaoAlterar.size(); i++) {
			System.out.print(gpv.permissaoAlterar.get(i).getLogin() + "; ");
		}
		System.out.println();
		System.out.println("Membros com permissão de visualizar dados do grupo: ");
		for (int i = 0; i < gpv.permissaoVisualizar.size(); i++) {
			System.out.print(gpv.permissaoVisualizar.get(i).getLogin() + "; ");
		}
		System.out.println();
		System.out.println("Membros com permissão de criar cartões no grupo: ");
		for (int i = 0; i < gpv.permissaoCriarCartao.size(); i++) {
			System.out.print(gpv.permissaoCriarCartao.get(i).getLogin() + "; ");
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("----------------------------------------- CRIANDO CARTÕES ---------------------------------------------");
		System.out.println("Os únicos usuários existentes no grupo e com permissões de criar cartões são o Lucas e o Matheus."
				+ "Então ambos vão criar cartões para o Grupo do Lucas:");
		Admin1.criarCartao(gpv.getId());
		User1.criarCartao(gpv.getId());
	}

}
