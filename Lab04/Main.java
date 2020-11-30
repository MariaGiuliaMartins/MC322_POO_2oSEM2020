/* RESPOSTAS DAS PERGUNTAS - Lab4
 * 1 - Há alguma diferença entre utilizar atributos final e Enumerações ? Explique.
 * 		Resposta 1: Há diferenças em utilizar atributos do tipo final, sendo que a principal dela é a chamada segurança do tipo.
 * Com um conjunto de constantes do tipo final, qualquer valor do mesmo tipo intrínseco pode ser usado, introduzindo erros. Já 
 * com uma enumeração, apenas os valores aplicáveis podem ser usados, então evita-se erros. Além disso, enumerações possuem 
 * diversas funções já implementadas (por exemplo EnumSet e EnumMap) e de fácil uso, coisa que com atributos do tipo final deveriam ser 
 * implementadas pelo 	programador.
 * 
 * 2 - Na main tente instanciar uma nova Permissao (enum) com a palavra-chave new, o que acontece? Qual seria o motivo desse
resultado?
 * 		Resposta 2: Não é possível instanciar uma nova permissão na Main, pois ela é uma enumeração e, portanto, suas "definições de 
 * permissões" estão dentro da implementação da sua enumeração. Para adicionar uma nova permissão, deveríamos ir na enumeração e adicionar 
 * em seu escopo.
 * 
 * 3 - Sobre os relacionamentos entre as classes: Em teoria, qual o tipo de relacionamento entre as Grupo(Privado e Público)
e Usuario? E entre Usuario e Sala? (Lembre-se que relacionamentos são classificados em: Associação, Agregação e
Composição.)
 * 		Resposta 3: Relação entre Grupo (Privado e Público) e Usuário é do tipo Associação. Relação entre Usuário e Sala é do tipo Contenção.
 * 
 * 4 - Qual a multiplicidade dos relacionamentos citados na questão anterior?
 * 		Resposta 4: Tanto para Grupo (Privado e Público) e Usuário como para Usuário e Sala não temos uma multiplicidade específica, 
 * pois um grupo pode ter muitos usuários e um usuário pode fazer parte de muitos grupos, assim como uma sala pode ter muitos usuários 
 * e um usuário pode fazer parte de várias salas.
 */

import java.util.ArrayList;
import java.util.GregorianCalendar; //para o calendario
//import java.util.Scanner; //para ler a entrada do teclado

public class Main {
	public static void main(String[] args) {
		System.out.println("----------------------------------------- INSTANCIANDO OBJETOS ---------------------------------------------\n");
		/*instanciando os objetos do tipo Usuario, os status serão sempre true pois pego os status do usuario para ser do grupo que criam
		então, com isso, o Admin ao longo do código pode modificá-lo*/
		Usuario User1 = new Usuario(1, "Nome um", "nome_um@gmail.com", "senha_do_um", "Sou o User 1", new GregorianCalendar(2001, 01, 01), true);
		Usuario User2 = new Usuario(2, "Nome dois", "nome_dois@gmail.com", "senha_do_dois", "Sou o User 2", new GregorianCalendar(2002, 02, 02), true);	
		Usuario User3 = new Usuario(3, "Nome três", "nome_tres@gmail.com", "senha_do_tres", "Sou o User 3", new GregorianCalendar(2003, 03, 03), true);
		Usuario User4 = new Usuario(4, "Nome quatro", "nome_quatro@gmail.com", "senha_do_quatro", "Sou o User 4", new GregorianCalendar(2004, 04, 04), true);
		Usuario User5 = new Usuario(5, "Nome cinco", "nome_cinco@gmail.com", "senha_do_cinco", "Sou o User 5", new GregorianCalendar(2005, 05, 05), true);
		Usuario User6 = new Usuario(6, "Nome seis", "nome_seis@gmail.com", "senha_do_seis", "Sou o User 6", new GregorianCalendar(2006, 06, 06), true);

		
		//instanciando os objetos da classe Admin
		Admin Admin1 = new Admin(7, "Nome Admin um", "admin_um@gmail.com", "senha_admin_um", "Sou o Admin 1", new GregorianCalendar(2007, 07, 07), true);
		Admin Admin2 = new Admin(8, "Nome Admin dois", "admin_dois@gmail.com", "senha_admin_dois", "Sou o Admin 2", new GregorianCalendar(2008, 8, 8), true);
		
		//imprimindo os objetos criados
		System.out.println("Usuário 1:\n" + User1);
		System.out.println("Usuário 2:\n" + User2);
		System.out.println("Usuário 3:\n" + User3);
		System.out.println("Usuário 4:\n" + User4);
		System.out.println("Usuário 5:\n" + User5);
		System.out.println("Usuário 6:\n" + User6);
		System.out.println("Admin 1:\n" + Admin1);
		System.out.println("Admin 2:\n" + Admin2);
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println("----------------------------------------- CRIANDO GRUPOS ---------------------------------------------\n");
		
		//grupo privado com status true criado na main
		GrupoPrivado GrupoPv = new GrupoPrivado("Grupo Privado", "Grupo Privado é criado na main", User3, true, (GregorianCalendar) GregorianCalendar.getInstance());
		System.out.println("Grupo Privado - tipo do objeto: " + GrupoPv.getClass() + "\n" + "Nome: " + GrupoPv.getNome() + 
				"\n" + "Dono: " + GrupoPv.getDono().getLogin() +
				"\n" + "Descrição: " + GrupoPv.getDescricao() + "\n" + "Status: " + GrupoPv.getStatus() + 
				"\n" + "Data de Criação: " + GrupoPv.getDataCriacao());
		System.out.println(GrupoPv);
		
		//grupo publico com status true criado na main
		GrupoPublico GrupoPu = new GrupoPublico("Grupo Público", "Grupo Público é criado na main", User5, true, (GregorianCalendar) GregorianCalendar.getInstance());
		System.out.println("Grupo Público - tipo do objeto: " + GrupoPu.getClass() + "\n" + "Nome: " + GrupoPu.getNome() + 
				"\n" + "Dono: " + GrupoPu.getDono().getLogin() +
				"\n" + "Descrição: " + GrupoPu.getDescricao() + "\n" + "Status: " + GrupoPu.getStatus() + 
				"\n" + "Data de Criação: " + GrupoPu.getDataCriacao());
		System.out.println(GrupoPu);
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println("----------------------------------------- ADICIONANDO MEMBROS ---------------------------------------------\n");
		System.out.println("Para poder adicionar alguém em qualquer grupo, seu status deve sempre estar ativo...");
		
		
		//vamos criar alguns arraylists para poder passar como parametro nas nossas funções
		ArrayList<Permissao> so_add = new ArrayList<Permissao>(); //array com a permissao somente de adicionar membros
		so_add.add(Permissao.ADICIONAR_MEMBROS);
		ArrayList<Permissao> add_rem = new ArrayList<Permissao>(); //pode add e remover membros
		add_rem.add(Permissao.ADICIONAR_MEMBROS);
		add_rem.add(Permissao.REMOVER_MEMBROS); 
		
		
		///adicionando no grupo privado 1 criado na main
		System.out.println("No Grupo Privado somente o dono pode adicionar e conceder permissoes:");
		System.out.println("Situação do grupo no início - " + GrupoPv);
		GrupoPv.adicionaMembro(User3, Admin1, so_add);
		System.out.print("---- Grupos do Admin1 depois da operação de adição - ");
		for (int i = 0; i < Admin1.getGrupos().size(); i++) {
			System.out.print(Admin1.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPv.adicionaMembro(User3, Admin2, add_rem);
		System.out.print("---- Grupos do Admin2 depois da operação de adição - ");
		for (int i = 0; i < Admin2.getGrupos().size(); i++) {
			System.out.print(Admin2.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPv.adicionaMembro(User3, User5, so_add);
		System.out.print("---- Grupos do User5 depois da operação de adição - ");
		for (int i = 0; i < User5.getGrupos().size(); i++) {
			System.out.print(User5.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPv.adicionaMembro(User2, User6, add_rem);
		System.out.print("---- Grupos do User6 depois da operação de adição - ");
		for (int i = 0; i < User6.getGrupos().size(); i++) {
			System.out.print(User6.getGrupos().get(i).getNome() + ", ");
		}
		GrupoPv.adicionaMembro(User3, User6, add_rem);
		System.out.print("---- Grupos do User6 depois da operação de adição - ");
		for (int i = 0; i < User6.getGrupos().size(); i++) {
			System.out.print(User6.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.println("Situação do grupo depois da operação de adicionar - "  + "\n" + GrupoPv);
		
		
		System.out.println("No Grupo Público todos os membros têm todas as permissões:");
		System.out.println("Situaçãodo grupo no início - " + GrupoPu);
		GrupoPu.adicionaMembro(User5, Admin1, so_add);
		System.out.print("---- Grupos do Admin1 depois da operação de adição - ");
		for (int i = 0; i < Admin1.getGrupos().size(); i++) {
			System.out.print(Admin1.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPu.adicionaMembro(Admin1, Admin2, add_rem);
		System.out.print("---- Grupos do Admin2 depois da operação de adição - ");
		for (int i = 0; i < Admin2.getGrupos().size(); i++) {
			System.out.print(Admin2.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPu.adicionaMembro(User5, User1, so_add);
		System.out.print("---- Grupos do User1 depois da operação de adição - ");
		for (int i = 0; i < User1.getGrupos().size(); i++) {
			System.out.print(User1.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPu.adicionaMembro(User1, User2, add_rem);
		System.out.print("---- Grupos do User2 depois da operação de adição - ");
		for (int i = 0; i < User2.getGrupos().size(); i++) {
			System.out.print(User2.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.println("Situação do grupo depois da operação de adicionar - " + "\n" + GrupoPu );

					
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println("----------------------------------------- REMOVENDO MEMBROS ---------------------------------------------\n");
	
		//removendo no grupo privado 1 criado na main
		System.out.println("Do Grupo Privado:");
		System.out.println("Situação no início - " + GrupoPv);
		System.out.print("---- Grupos do Admin2 antes da operação de remover - ");
		for (int i = 0; i < Admin2.getGrupos().size(); i++) {
			System.out.print(Admin2.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPv.removeMembro(User3, Admin2);
		System.out.print("---- Grupos do Admin2 depois da operação de remover - ");
		for (int i = 0; i < Admin2.getGrupos().size(); i++) {
			System.out.print(Admin2.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.print("---- Grupos do User5 antes da operação de remover - ");
		for (int i = 0; i < User5.getGrupos().size(); i++) {
			System.out.print(User5.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPv.removeMembro(User6, User5);
		System.out.print("---- Grupos do User5 depois da operação de remover - ");
		for (int i = 0; i < User5.getGrupos().size(); i++) {
			System.out.print(User5.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.println("Membros depois da operação de remover - " + GrupoPv);		
				
				
		//removendo do grupo publico 1 criado na main
		System.out.println("Do Grupo Público criado:");
		System.out.println("Membros no início - " + GrupoPu);
		System.out.print("---- Grupos do Admin2 antes da operação de remover - ");
		for (int i = 0; i < Admin2.getGrupos().size(); i++) {
			System.out.print(Admin2.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPu.removeMembro(User2, Admin2);
		System.out.print("---- Grupos do Admin2 depois da operação de remover - ");
		for (int i = 0; i < Admin2.getGrupos().size(); i++) {
			System.out.print(Admin2.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.print("---- Grupos do User2 antes da operação de remover - ");
		for (int i = 0; i < User2.getGrupos().size(); i++) {
			System.out.print(User2.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPu.removeMembro(User5, User2);
		System.out.print("---- Grupos do User2 depois da operação de remover - ");
		for (int i = 0; i < User2.getGrupos().size(); i++) {
			System.out.print(User2.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.println("Membros depois da operação de remover - " + GrupoPu);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("----------------------------------------- TESTANDO VISUALIZAÇÃO ---------------------------------------------\n");
		
		System.out.println("Vamos testar a permissão de visualização do usuário User6 do Grupo Privado \n");
		GrupoPv.VisuInfos(User6);
		
		System.out.println("Vamos testar a permissão de visualização usuário User5 do Grupo Privado \n");
		GrupoPu.VisuInfos(User5);



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("----------------------------------------- MODIFICANDO PERMISSÕES ---------------------------------------------\n");
		
		//vamos criar alguns arraylists para poder passar como parametro nas nossas funções
		ArrayList<Permissao> rem = new ArrayList<Permissao>(); //array com a permissao somente de remover membros
		rem.add(Permissao.REMOVER_MEMBROS);
		ArrayList<Permissao> alt = new ArrayList<Permissao>(); //pode alterar a permissao
		alt.add(Permissao.ALTERAR_PERMISSAO); 
		
		System.out.println("Vamos modificar a permissão do usuário Admin1 do Grupo Privado: \n");
		System.out.println("Primeiro vamos adicionar a permissão de remover membros \n");
		GrupoPv.adicionarPermissao(User3, Admin1, rem);
		System.out.println(GrupoPv);
		System.out.println("Agora vamos remover a permissão de adicionar membros \n");
		GrupoPv.removerPermissao(User3, Admin1, so_add);
		System.out.println(GrupoPv);
		
		System.out.println("---");
		
		System.out.println("Vamos modificar a permissão do usuário User1 do Grupo Público: \n");
		System.out.println("Primeiro vamos adicionar a permissão de aletrar permissão\n");
		GrupoPu.adicionarPermissao(User5, User1, alt);
		System.out.println(GrupoPu);
		System.out.println("Agora vamos remover a permissão de adicionar membros \n");
		GrupoPu.removerPermissao(User5, User1, so_add);
		System.out.println(GrupoPu);
	}

}
