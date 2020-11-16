/* RESPOSTAS DAS PERGUNTAS - Lab3
 * 1 - Tente modificar o valor da dono de um grupo (que é um atributo final). Crie um setter se necessário. 
 * Foi possível fazer a modificação? Explique.
 * 		Resposta 1: Não é possível fazer esta modificação porque um atributo do tipo final é como se fosse uma 
 * espécie de "constante" seu valor é atribuído e nada pode mudá-lo.
 * 
 * 2 - Agora, no método main, crie uma variável final do tipo Grupo, e instancie-a com os valores que preferir. 
 * Tente modificar algum atributo do objeto através de um setter, como o atributo referente ao id. Foi possível 
 * modificar esse atributo, mesmo com o objeto sendo final? Por quê?
 * 		Resposta 2: É possível modificar os atributos dele, pois quando um objeto é final é possível modificar seus
 * atributos, no entanto, não é possível atribuir um objeto diferente a ele pois é final.
 * 
 * 3 - Se ao invés de usar ArrayList para definir a lista de membros da classe Grupo tivéssemos usado um array, 
 * o que mudaria na implementação? Poderíamos continuar adicionado membros como fizemos? Haveria alguma limitação? 
 * Discuta as desvantagens dessa solução.
 * 		Resposta 3: As desvantagens da solução de usar arrays ao invés de ArrayLists é que os arrays não alocam memória 
 * dinamicamente, os elementos não podem ser adicionados em tempo de execução como em um ArrayList. Além disso, em questão 
 * de inserção e remoção de elementos o ArrayList possui essas funções muito mais otimizadas do que em um array, então em 
 * um ArrayList, o tempo de execução de inserção e remoção é menor e, portanto, mais eficiente que em um array.
 * 
 * 4 - Qual o principal benefício da herança?
 * 		Resposta 4: O principal benefício da herança é herdar (ou seja, não precisar ser implementando novamente em 
 * uma classe filha) os atributos, os relacionamentos já existentes para a classe mãe e os comportamentos (suas 
 * operações e funções), e isso gera economia e modularização de código.
 * 
 * 5 - Adicione final na classe Grupo. O que aconteceu com o código? Por que isso aconteceu? Em vez de Grupo ser final 
 * e se definirmos GrupoPublico como final?
 * 		Resposta 5: Quando definimos algo como final fora da main acontece a mesma coisa da questão 1, não é possível 
 * modificá-la. Isso ocorre porque é uma espécie de "constante" e não pode ser alterada em nenhum outro lugar como, por 
 * exemplo, a Main.
 * 
 * 6 - Por que definimos os métodos adicionaMembro e removeMembro nas classes filhas e não na classe mãe (Grupo)?
 * 		Resposta 6: Esses métodos estão em classes filhas distintas por conta de seu comportamento nessas classes. Na 
 * classe filha GrupoPublico, os métodos adicionaMembro e removeMembro podem ser chamados por qualquer membro do grupo, 
 * já na classe filha GrupoPrivado, esses métodos em questão só podem ser chamados pelos donos dos grupos do tipo privado.
 * Logo há essas implementações em grupos distintos porque elas possuem especificidades deiferentes, que, neste caso, foram 
 * checadas em sua própria chamada (além da escrita diferente delas no que diz respeito aos parâmetros passados).
 */

import java.util.GregorianCalendar; //para o calendario
//import java.util.Scanner; //para ler a entrada do teclado

public class Main {

	//private static Scanner digitado;

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
		System.out.println("Criando Grupos a partir de Usuários...\n");
		//vamos criar os grupos
			///grupo publico criado por usuário
		User1.criarGrupo("Grupo 1", "Grupo 1 é público e criado por um Usuário", false);
		GrupoPublico GrupoU1 = (GrupoPublico) User1.getGrupos().get(0); //vamos pegar as informações deste grupo para checar as funções
		System.out.println("GrupoU1 criado por usuário - tipo do objeto: " + GrupoU1.getClass() + "\n" + "Nome: " + GrupoU1.getNome() + 
				"\n" + "Descrição: " + GrupoU1.getDescricao() + "\n" + "Status: " + GrupoU1.getStatus() + 
				"\n" + "Data de Criação: " + GrupoU1.getDataCriacao());
		System.out.println(GrupoU1);
		
			///grupo privado criado por usuário
		User2.criarGrupo("Grupo 2", "Grupo 2 é privado e criado por um Usuário", true);
		GrupoPrivado GrupoU2 = (GrupoPrivado) User2.getGrupos().get(0); //vamos pegar as informações deste grupo para checar as funções
		System.out.println("GrupoU2 criado por usuário - tipo do objeto: " + GrupoU2.getClass() + "\n" + "Nome: " + GrupoU2.getNome() + 
				"\n" + "Descrição: " + GrupoU2.getDescricao() + "\n" + "Status: " + GrupoU2.getStatus() + 
				"\n" + "Data de Criação: " + GrupoU2.getDataCriacao());
		System.out.println(GrupoU2);
		
		System.out.println("Criando Grupos na Main...\n");
		
			///grupo privado com status true criado na main
		GrupoPrivado GrupoPv1 = new GrupoPrivado("Grupo Privado 1", "Grupo Privado 1 é criado na main", User3, true, (GregorianCalendar) GregorianCalendar.getInstance());
		System.out.println("GrupoPv1 criado na Main - tipo do objeto: " + GrupoPv1.getClass() + "\n" + "Nome: " + GrupoPv1.getNome() + 
				"\n" + "Descrição: " + GrupoPv1.getDescricao() + "\n" + "Status: " + GrupoPv1.getStatus() + 
				"\n" + "Data de Criação: " + GrupoPv1.getDataCriacao());
		System.out.println(GrupoPv1);
		
			///grupo privado com status false criado na main
		GrupoPrivado GrupoPv2 = new GrupoPrivado("Grupo Privado 2", "Grupo Privado 2 é criado na main", User4, false, (GregorianCalendar) GregorianCalendar.getInstance());
		System.out.println("GrupoPv2 criado na Main - tipo do objeto: " + GrupoPv2.getClass() + "\n" + "Nome: " + GrupoPv2.getNome() + 
				"\n" + "Descrição: " + GrupoPv2.getDescricao() + "\n" + "Status: " + GrupoPv2.getStatus() + 
				"\n" + "Data de Criação: " + GrupoPv2.getDataCriacao());
		System.out.println(GrupoPv2);
		
			///grupo publico com status true criado na main
		GrupoPublico GrupoPu1 = new GrupoPublico("Grupo Público 1", "Grupo Público 1 é criado na main", User5, true, (GregorianCalendar) GregorianCalendar.getInstance());
		System.out.println("GrupoPu1 criado na Main - tipo do objeto: " + GrupoPu1.getClass() + "\n" + "Nome: " + GrupoPu1.getNome() + 
				"\n" + "Descrição: " + GrupoPu1.getDescricao() + "\n" + "Status: " + GrupoPu1.getStatus() + 
				"\n" + "Data de Criação: " + GrupoPu1.getDataCriacao());
		System.out.println(GrupoPu1);
		
			///grupo publico com status false criado na main
		GrupoPublico GrupoPu2 = new GrupoPublico("Grupo Público 2", "Grupo Público 2 criado na main", User6, false, (GregorianCalendar) GregorianCalendar.getInstance());
		System.out.println("GrupoPu2 criado na Main - tipo do objeto: " + GrupoPu2.getClass() + "\n" + "Nome: " + GrupoPu2.getNome() + 
				"\n" + "Descrição: " + GrupoPu2.getDescricao() + "\n" + "Status: " + GrupoPu2.getStatus() + 
				"\n" + "Data de Criação: " + GrupoPu2.getDataCriacao());
		System.out.println(GrupoPu2);
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println("----------------------------------------- ADICIONANDO MEMBROS ---------------------------------------------\n");
		System.out.println("Para poder adicionar alguém em qualquer grupo, seu status deve sempre estar ativo...");
		System.out.println("--> Para grupos públicos não importa quem adiciona...\n");
		
		//adicionando membros nos grupos - 4 pessoas serão adicionadas nos grupos: 2 admins e 2 usuários
			///adicionando no grupo público criado por usuário
		System.out.println("No GrupoU1 criado por usuário:");
		System.out.println("Membros no início - " + GrupoU1);
		GrupoU1.adicionaMembro(Admin1);
		System.out.print("---- Grupos do Admin1 depois da operação de adicionar - ");
		for (int i = 0; i < Admin1.getGrupos().size(); i++) {
			System.out.print(Admin1.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoU1.adicionaMembro(Admin2);
		System.out.print("---- Grupos do Admin2 depois da operação de adição - ");
		for (int i = 0; i < Admin2.getGrupos().size(); i++) {
			System.out.print(Admin2.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoU1.adicionaMembro(User2);
		System.out.print("---- Grupos do User2 depois da operação de adição - ");
		for (int i = 0; i < User2.getGrupos().size(); i++) {
			System.out.print(User2.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoU1.adicionaMembro(User3);
		System.out.print("---- Grupos do User3 depois da operação de adição - ");
		for (int i = 0; i < User3.getGrupos().size(); i++) {
			System.out.print(User3.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.println("Membros depois da operação de adicionar - " + GrupoU1);

		System.out.println("---\n");
		
			///adicionando no publico 1 criado na main
		System.out.println("No GrupoPu1 criado na Main:");
		System.out.println("Membros no início - " + GrupoPu1);
		GrupoPu1.adicionaMembro(Admin1);
		System.out.print("---- Grupos do Admin1 depois da operação de adição - ");
		for (int i = 0; i < Admin1.getGrupos().size(); i++) {
			System.out.print(Admin1.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPu1.adicionaMembro(Admin2);
		System.out.print("---- Grupos do Admin2 depois da operação de adição - ");
		for (int i = 0; i < Admin2.getGrupos().size(); i++) {
			System.out.print(Admin2.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPu1.adicionaMembro(User1);
		System.out.print("---- Grupos do User1 depois da operação de adição - ");
		for (int i = 0; i < User1.getGrupos().size(); i++) {
			System.out.print(User1.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPu1.adicionaMembro(User2);
		System.out.print("---- Grupos do User2 depois da operação de adição - ");
		for (int i = 0; i < User2.getGrupos().size(); i++) {
			System.out.print(User2.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.println("Membros depois da operação de adicionar - " + GrupoPu1);

		System.out.println("---\n");		
				
			///adicionando no publico 2 criado na main
		System.out.println("No GrupoPu2 criado na Main:");
		System.out.println("Membros no início - " + GrupoPu2);
		GrupoPu2.adicionaMembro(Admin1);
		System.out.print("---- Grupos do Admin1 depois da operação de adição - ");
		for (int i = 0; i < Admin1.getGrupos().size(); i++) {
			System.out.print(Admin1.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPu2.adicionaMembro(Admin2);
		System.out.print("---- Grupos do Admin2 depois da operação de adição - ");
		for (int i = 0; i < Admin2.getGrupos().size(); i++) {
			System.out.print(Admin2.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPu2.adicionaMembro(User3);
		System.out.print("---- Grupos do User3 depois da operação de adição - ");
		for (int i = 0; i < User3.getGrupos().size(); i++) {
			System.out.print(User3.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPu2.adicionaMembro(User4);
		System.out.print("---- Grupos do User4 depois da operação de adição - ");
		for (int i = 0; i < User4.getGrupos().size(); i++) {
			System.out.print(User4.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.println("Membros depois da operação de adicionar - " + GrupoPu2);
		
		
		System.out.println("--> Para grupos privados somente o dono é quem adiciona...\n");
			///adicionando no grupo privado criado por usuário
		System.out.println("No GrupoU2 criado por usuário:");
		System.out.println("Membros no início - " + GrupoU2);
		GrupoU2.adicionaMembro(User2, Admin1);
		System.out.print("---- Grupos do Admin1 depois da operação de adição - ");
		for (int i = 0; i < Admin1.getGrupos().size(); i++) {
			System.out.print(Admin1.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoU2.adicionaMembro(User2, Admin2);
		System.out.print("---- Grupos do Admin2 depois da operação de adição - ");
		for (int i = 0; i < Admin2.getGrupos().size(); i++) {
			System.out.print(Admin2.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoU2.adicionaMembro(User2, User3);
		System.out.print("---- Grupos do User3 depois da operação de adição - ");
		for (int i = 0; i < User3.getGrupos().size(); i++) {
			System.out.print(User3.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoU2.adicionaMembro(User6, User4); //User4 não está np grupo, aqui estamos testando pra ver se dá algum erro
		System.out.print("---- Grupos do User4 depois da operação de adição - ");
		for (int i = 0; i < User4.getGrupos().size(); i++) {
			System.out.print(User4.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.println("Membros depois da operação de adicionar - " + GrupoU2);

		System.out.println("---\n");
		
			///adicionando no grupo privado 1 criado na main
		System.out.println("No GrupoPv1 criado na Main:");
		System.out.println("Membros no início - " + GrupoPv1);
		GrupoPv1.adicionaMembro(User3, Admin1);
		System.out.print("---- Grupos do Admin1 depois da operação de adição - ");
		for (int i = 0; i < Admin1.getGrupos().size(); i++) {
			System.out.print(Admin1.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPv1.adicionaMembro(User3, Admin2);
		System.out.print("---- Grupos do Admin2 depois da operação de adição - ");
		for (int i = 0; i < Admin2.getGrupos().size(); i++) {
			System.out.print(Admin2.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPv1.adicionaMembro(User3, User5);
		System.out.print("---- Grupos do User5 depois da operação de adição - ");
		for (int i = 0; i < User5.getGrupos().size(); i++) {
			System.out.print(User5.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPv1.adicionaMembro(User2, User6);
		System.out.print("---- Grupos do User6 depois da operação de adição - ");
		for (int i = 0; i < User6.getGrupos().size(); i++) {
			System.out.print(User6.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.println("Membros depois da operação de adicionar - " + GrupoPv1);

		System.out.println("---\n");
		
			///adicionando no grupo privado 2 criado na main
		System.out.println("No GrupoPv2 criado na Main:");
		System.out.println("Membros no início - " + GrupoPv2);
		GrupoPv2.adicionaMembro(User4, Admin1);
		System.out.print("---- Grupos do Admin1 depois da operação de adição - ");
		for (int i = 0; i < Admin1.getGrupos().size(); i++) {
			System.out.print(Admin1.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPv2.adicionaMembro(User4, Admin2);
		System.out.print("---- Grupos do Admin2 depois da operação de adição - ");
		for (int i = 0; i < Admin2.getGrupos().size(); i++) {
			System.out.print(Admin2.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPv2.adicionaMembro(User1, User5);
		System.out.print("---- Grupos do User5 depois da operação de adição - ");
		for (int i = 0; i < User5.getGrupos().size(); i++) {
			System.out.print(User5.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPv2.adicionaMembro(User4, User6);
		System.out.print("---- Grupos do User6 depois da operação de adição - ");
		for (int i = 0; i < User6.getGrupos().size(); i++) {
			System.out.print(User6.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.println("Membros depois da operação de adicionar - " + GrupoPv2);
			
					
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println("----------------------------------------- REMOVENDO MEMBROS ---------------------------------------------\n");
		System.out.println("Para poder remover alguém em qualquer grupo, seu status deve sempre estar ativo...");
		System.out.println("--> Para grupos públicos não importa quem remove...\n");
		
		//para cada grupo público vamos retirar um admin, e um usuário
			///remover do grupo público criado por usuário	
		System.out.println("Do GrupoU1 criado por usuário:");
		System.out.println("Membros no início - " + GrupoU1);
		System.out.print("---- Grupos do Admin2 antes da operação de remover - ");
		for (int i = 0; i < Admin2.getGrupos().size(); i++) {
			System.out.print(Admin2.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoU1.removeMembro(Admin2);
		System.out.print("---- Grupos do Admin2 depois da operação de remover - ");
		for (int i = 0; i < Admin2.getGrupos().size(); i++) {
			System.out.print(Admin2.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.print("---- Grupos do User3 antes da operação de remover - ");
		for (int i = 0; i < User3.getGrupos().size(); i++) {
			System.out.print(User3.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoU1.removeMembro(User3);
		System.out.print("---- Grupos do User3 depois da operação de remover - ");
		for (int i = 0; i < User3.getGrupos().size(); i++) {
			System.out.print(User3.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.println("Membros depois da operação de remover - " + GrupoU1);

		System.out.println("---\n");
				
			///removendo do grupo publico 1 criado na main
		System.out.println("Do GrupoPu1 criado na Main:");
		System.out.println("Membros no início - " + GrupoPu1);
		System.out.print("---- Grupos do Admin2 antes da operação de remover - ");
		for (int i = 0; i < Admin2.getGrupos().size(); i++) {
			System.out.print(Admin2.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPu1.removeMembro(Admin2);
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
		GrupoPu1.removeMembro(User2);
		System.out.print("---- Grupos do User2 depois da operação de remover - ");
		for (int i = 0; i < User2.getGrupos().size(); i++) {
			System.out.print(User2.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.println("Membros depois da operação de remover - " + GrupoPu1);

		System.out.println("---\n");		
						
			///removendo do publico 2 criado na main
		System.out.println("Do GrupoPu2 criado na Main:");
		System.out.println("Membros no início - " + GrupoPu2);
		System.out.print("---- Grupos do Admin1 antes da operação de remover - ");
		for (int i = 0; i < Admin1.getGrupos().size(); i++) {
			System.out.print(Admin1.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPu2.removeMembro(Admin1);
		System.out.print("---- Grupos do Admin1 depois da operação de remover - ");
		for (int i = 0; i < Admin1.getGrupos().size(); i++) {
			System.out.print(Admin1.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.print("---- Grupos do User4 antes da operação de remover - ");
		for (int i = 0; i < User4.getGrupos().size(); i++) {
			System.out.print(User4.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPu2.removeMembro(User4);
		System.out.print("---- Grupos do User4 depois da operação de remover - ");
		for (int i = 0; i < User4.getGrupos().size(); i++) {
			System.out.print(User4.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.println("Membros depois da operação de remover - " + GrupoPu2);

		
		System.out.println("--> Para grupos privados somente o dono é quem remove...\n");
		//para cada grupo privado vamos retirar um admin, e um usuário através do dono e um usuário atraves de um membro genérico
		
			///removendo do grupo privado criado por usuário
		System.out.println("Do GrupoU2 criado por usuário:");
		System.out.println("Membros no início - " + GrupoU2);
		System.out.print("---- Grupos do Admin1 antes da operação de remover - ");
		for (int i = 0; i < Admin1.getGrupos().size(); i++) {
			System.out.print(Admin1.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoU2.removeMembro(User2, Admin1);
		System.out.print("---- Grupos do Admin1 depois da operação de remover - ");
		for (int i = 0; i < Admin1.getGrupos().size(); i++) {
			System.out.print(Admin1.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.print("---- Grupos do User4 antes da operação de remover - ");
		for (int i = 0; i < User4.getGrupos().size(); i++) {
			System.out.print(User4.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoU2.removeMembro(User2, User4);
		System.out.print("---- Grupos do User4 depois da operação de remover - ");
		for (int i = 0; i < User4.getGrupos().size(); i++) {
			System.out.print(User4.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.print("---- Grupos do User3 antes da operação de remover - ");
		for (int i = 0; i < User3.getGrupos().size(); i++) {
			System.out.print(User3.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoU2.removeMembro(User5, User3);
		System.out.print("---- Grupos do User3 depois da operação de remover - ");
		for (int i = 0; i < User3.getGrupos().size(); i++) {
			System.out.print(User3.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.println("Membros depois da operação de remover - " + GrupoU2);

		System.out.println("---\n");
		
			///removendo no grupo privado 1 criado na main
		System.out.println("Do GrupoPv1 criado na Main:");
		System.out.println("Membros no início - " + GrupoPv1);
		System.out.print("---- Grupos do Admin2 antes da operação de remover - ");
		for (int i = 0; i < Admin2.getGrupos().size(); i++) {
			System.out.print(Admin2.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPv1.removeMembro(User3, Admin2);
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
		GrupoPv1.removeMembro(User3, User5);
		System.out.print("---- Grupos do User5 depois da operação de remover - ");
		for (int i = 0; i < User5.getGrupos().size(); i++) {
			System.out.print(User5.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.print("---- Grupos do User6 antes da operação de remover - ");
		for (int i = 0; i < User6.getGrupos().size(); i++) {
			System.out.print(User6.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPv1.removeMembro(User2, User6);
		System.out.print("---- Grupos do User6 depois da operação de remover - ");
		for (int i = 0; i < User6.getGrupos().size(); i++) {
			System.out.print(User6.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.println("Membros depois da operação de remover - " + GrupoPv1);

		System.out.println("---\n");

			///adicionando no grupo privado 2 criado na main
		System.out.println("Do GrupoPv2 criado na Main:");
		System.out.println("Membros no início - " + GrupoPv2);
		System.out.print("---- Grupos do Admin1 antes da operação de remover - ");
		for (int i = 0; i < Admin1.getGrupos().size(); i++) {
			System.out.print(Admin1.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPv2.removeMembro(User4, Admin1);
		System.out.print("---- Grupos do Admin1 depois da operação de remover - ");
		for (int i = 0; i < Admin1.getGrupos().size(); i++) {
			System.out.print(Admin1.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.print("---- Grupos do User6 antes da operação de remover - ");
		for (int i = 0; i < User6.getGrupos().size(); i++) {
			System.out.print(User6.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPv2.removeMembro(User4, User6);
		System.out.print("---- Grupos do User6 depois da operação de remover - ");
		for (int i = 0; i < User6.getGrupos().size(); i++) {
			System.out.print(User6.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.print("---- Grupos do User5 antes da operação de remover - ");
		for (int i = 0; i < User5.getGrupos().size(); i++) {
			System.out.print(User5.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		GrupoPv2.removeMembro(User6, User5);
		System.out.print("---- Grupos do User5 depois da operação de remover - ");
		for (int i = 0; i < User5.getGrupos().size(); i++) {
			System.out.print(User5.getGrupos().get(i).getNome() + ", ");
		}
		System.out.println();
		System.out.println("Membros depois da operação de remover - " + GrupoPv2);

		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println("----------------------------------------- DONOS DOS GRUPOS ---------------------------------------------\n");
		System.out.println("Vamos tentar agora modificar os donos dos grupos...\n");
		//printando o dono dos grupos publicos
		System.out.println("Donos dos grupos públicos...");
		System.out.println("Dono do grupo público GrupoU1 criado por usuário: " + GrupoU1.getDono().getLogin());
		System.out.println("Dono do grupo público GrupoPu1 criado na Main: " + GrupoPu1.getDono().getLogin());
		System.out.println("Dono do grupo público GrupoPu2 criado na Main: " + GrupoPu2.getDono().getLogin() + "\n");
		
		//pritnando os donos dos grupos privados
		System.out.println("Donos dos grupos privados...");
		System.out.println("Dono do grupo privado GrupoU2 criado por usuário: " + GrupoU2.getDono().getLogin());
		System.out.println("Dono do grupo privado GrupoPv1 criado na Main: " + GrupoPv1.getDono().getLogin());
		System.out.println("Dono do grupo privado GrupoPv2 criado na Main: " + GrupoPv2.getDono().getLogin() + "\n");
		
		System.out.println("A variável dono é final, então não há um modo de modificá-la!!!"); 
		System.out.println("Não tem nem como criar um setDono() por conta dele ser final.");
		System.out.println("Por isso apenas printamos acima os donos." + "\n");
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println("----------------------------------------- ANALISANDO OS ADMINS ---------------------------------------------\n");
		System.out.println("Vamos ver agora os admins dos grupos e o fato de poderem mudar o status dos grupos...");
		System.out.println("Como os grupos possuem 2 Admins, vamos mostrar que é possível que qualquer um mude o status...");
		System.out.println("Observe que os grupos que já estavam com status false continuam com esse mesmo status...\n");
		
		//especificações de um grupo público - REFERENTE AO ADMIN
			///apenas admin pode mudar status do grupo
		System.out.println("Status inicial do GrupoU1 público criado por um usuário: " + GrupoU1.getStatus());
		Admin1.desabilitarGrupo(GrupoU1);
		System.out.println("Status final do GrupoU1 público criado por um usuário: " + GrupoU1.getStatus() + "\n");
		
		System.out.println("Status inicial do GrupoU2 privado e criado por um usuário: " + GrupoU2.getStatus());
		Admin2.desabilitarGrupo(GrupoU2);
		System.out.println("Status final do GrupoU2 privado e criado por um usuário: " + GrupoU2.getStatus() + "\n");
		
		System.out.println("Status inicial do GrupoPv1 privado e criado na Main: " + GrupoPv1.getStatus());
		Admin1.desabilitarGrupo(GrupoPv1);
		System.out.println("Status final do GrupoPv1 privado e criado na Main: " + GrupoPv1.getStatus() + "\n");
		
		System.out.println("Status inicial do GrupoPv2 privado e criado na Main: " + GrupoPv2.getStatus());
		Admin2.desabilitarGrupo(GrupoPv2);
		System.out.println("Status final do GrupoPv2 privado e criado na Main: " + GrupoPv2.getStatus() + "\n");
		
		System.out.println("Status inicial do GrupoPu1 público e criado na Main: " + GrupoPu1.getStatus());
		Admin1.desabilitarGrupo(GrupoPu1);
		System.out.println("Status final do GrupoPu1 público e criado na Main: " + GrupoPu1.getStatus() + "\n");
		
		System.out.println("Status inicial do GrupoPu2 público e criado na Main: " + GrupoPu2.getStatus());
		Admin2.desabilitarGrupo(GrupoPu1);
		System.out.println("Status final do GrupoPu2 público e criado na Main: " + GrupoPu2.getStatus() + "\n");
		
		System.out.println("Não é possível outra pessoa que não seja Admin mudar o status de um grupo...");
		System.out.println("Se tentarmos, por exemplo, o comando User3.desabilitaGrupo(GrupoU1), " + "\n"
				+ "veremos que este método nem existe para esse objeto, logo não é possível.\n");		
	}

}
