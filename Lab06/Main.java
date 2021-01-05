/* RESPOSTAS DAS PERGUNTAS - Lab6
 * 1 - Baseado nos conceitos de interface e classe abstrata e na arquitetura hierarquica da classe Grupo e 
 * suas subclasses GrupoPublico e GrupoPrivado, a classe Grupo deverá:
 * 	   Resposta 1: (b) ser alterada e implementada como uma Classe Abstrata
 * 
 * 2 - Qual foi a estratégia abordada: Interface, Classe Abstrata ou manutenção da classe concreta? Explique 
 * sua escolha.
 * 	   Resposta 2: A Classe Grupo deve ser alterada e implementada como abstrata pois queremos compartilhar o 
 * seu código para as suas classes herdeiras (Grupo Privado e Grupo Público) que estão intimamente relacionadas 
 * com ela. Além disso, acredito que não há outras classes nesse projeto que exijam dos métodos que Grupo possui.
 * 
 * 3 - Em outra possível abordagem, a classe Usuario poderia ser implementada como uma Interface? Caso sim, por quê? 
 * Quais alterações seriam necessárias?
 * 	   Resposta 3: A classe Usuario poderia ser implementada sim como uma Interface. Nesta abordagem, no entanto,
 * para ser prática como uma interface, deveria haver outras classes com interação entre elas (por exemplo se fosse 
 * possível um perfil criar um grupo neste projeto), ou um caso que queremos especificar o comportamento de um tipo de 
 * dado, ou ainda no caso de um uso de herança múltipla de tipo. Entre as alterações necessárias estão: a mudança na 
 * sintaxe da classe Usuario, transformando-a em um Interface e também as implementações dos métodos cujas assinaturas 
 * estariam localizadas na nova Interface.
 */

import java.util.ArrayList;
import java.util.GregorianCalendar; //para o calendario

public class Main {
	public static void main(String[] args) {
		System.out.println("----------------------------------------- INSTANCIANDO OBJETOS ---------------------------------------------\n");
		System.out.println("Vamos criar 9 obbjetos: 3 usuários comuns, 3 usuários convidados e 3 admins\n");
		
		//criando perfis
		UsuarioComum UserCom1 = new UsuarioComum(1, new Perfil(Sexo.Mulher, new GregorianCalendar (2001, 01, 01), "Cidade UserCom1", Estado.Acre, "telefone UserCom1", "Sou o UserCom1", "foto UserCom1"), "Login UserCom1", "email UserCom1", "senha UserCom1", new GregorianCalendar(2010, 1, 1), true);
		System.out.println(UserCom1.getLogin());
		
		UsuarioComum UserCom2 = new UsuarioComum(2, new Perfil(Sexo.Mulher, new GregorianCalendar (2002, 02, 02), "Cidade UserCom2", Estado.Alagoas, "telefone UserCom2", "Sou o UserCom2", "foto UserCom2"), "Login UserCom2", "email UserCom2", "senha UserCom2", new GregorianCalendar(2010, 2, 2), true);
		System.out.println(UserCom2.getLogin());
		
		UsuarioComum UserCom3 = new UsuarioComum(3, new Perfil(Sexo.Mulher, new GregorianCalendar (2003, 03, 03), "Cidade UserCom3", Estado.Amapa, "telefone UserCom3", "Sou o UserCom3", "foto UserCom3"), "Login UserCom3", "email UserCom3", "senha UserCom3", new GregorianCalendar(2010, 3, 3), false);
		System.out.println(UserCom3.getLogin());
		
		UsuarioConvidado UserConv1 = new UsuarioConvidado(4, new Perfil(Sexo.Homem, new GregorianCalendar (2004, 04, 04), "Cidade UserConv1", Estado.Amazonas, "telefone UserConv1", "Sou o UserConv1", "foto UserConv1"), "Login UserConv1", "email UserConv1", "senha UserConv1", new GregorianCalendar(2010, 4, 4), true, new GregorianCalendar(2011, 1, 1));
		System.out.println(UserConv1.getLogin());
		
		UsuarioConvidado UserConv2 = new UsuarioConvidado(5, new Perfil(Sexo.Homem, new GregorianCalendar (2005, 05, 05), "Cidade UserConv2", Estado.Bahia, "telefone UserConv2", "Sou o UserConv2", "foto UserConv2"), "Login UserConv2", "email UserConv2", "senha UserConv2", new GregorianCalendar(2010, 5, 5), true, new GregorianCalendar(2011, 2, 2));
		System.out.println(UserConv2.getLogin());
		
		UsuarioConvidado UserConv3 = new UsuarioConvidado(6, new Perfil(Sexo.Homem, new GregorianCalendar (2006, 06, 06), "Cidade UserConv3", Estado.Ceara, "telefone UserConv3", "Sou o UserConv3", "foto UserConv3"), "Login UserConv3", "email UserConv3", "senha UserConv3", new GregorianCalendar(2010, 6, 6), false, new GregorianCalendar(2011, 3, 3));
		System.out.println(UserConv3.getLogin());
		
		Admin Admin1 = new Admin(7, new Perfil(Sexo.Mulher, new GregorianCalendar (2007, 07, 07), "Cidade Admin1", Estado.DistritoFederal, "telefone Admin1", "Sou o Admin1", "foto Admin1"), "Login Admin1", "email Admin1", "senha Admin1", new GregorianCalendar(2010, 7, 7), true);
		System.out.println(Admin1.getLogin()); 
		
		Admin Admin2 = new Admin(8, new Perfil(Sexo.Mulher, new GregorianCalendar (2008, 8, 8), "Cidade Admin2", Estado.EspiritoSanto, "telefone Admin2", "Sou o Admin2", "foto Admin2"), "Login Admin2", "email Admin2", "senha Admin2", new GregorianCalendar(2010, 8, 8), true);
		System.out.println(Admin2.getLogin());
		
		Admin Admin3 = new Admin(9, new Perfil(Sexo.Mulher, new GregorianCalendar (2009, 9, 9), "Cidade Admin3", Estado.Goias, "telefone Admin3", "Sou o Admin3", "foto Admin3"), "Login Admin3", "email Admin3", "senha Admin3", new GregorianCalendar(2010, 9, 9), false);
		System.out.println(Admin3.getLogin());
		
		System.out.println();
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println("----------------------------------------- CRIANDO GRUPOS ---------------------------------------------");
		System.out.println("Vamos criar 2 grupos, um público e um privado, a partir dos admins: \n");
		
		//vamos instanciar o grupo criado pelo admin1 e pelo admin2 para podermos manipulá-los depois
		//grupo publico
		Admin1.criarGrupo("Grupo Privado", "Grupo privado criado pelo Admin1", true);
		GrupoPrivado gpv = (GrupoPrivado) Admin1.getGrupos().get(0);
		System.out.println(gpv.getNome());
		
		Admin2.criarGrupo("Grupo Público", "Grupo público criado pelo Admin2", false);
		GrupoPublico gpu = (GrupoPublico) Admin2.getGrupos().get(0);
		System.out.println(gpu.getNome());
		System.out.println();
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println("----------------------------------------- ADICIONANDO MEMBROS ---------------------------------------------");
		System.out.println("Para poder adicionar alguém em qualquer grupo, seu status deve sempre estar ativo...");
		System.out.println("Vamos imprimir os status de todos os grupos já criados: ");
		System.out.println("Grupo do Admin1 - status: " + gpv.getStatus());
		System.out.println("Grupo do Admin2 - status: " + gpu.getStatus());
		System.out.println("\nVamos então adicionar membros em ambos os grupos:\n");
		
		//array list para a função de adicionar membro; 
		ArrayList<Permissao> visu_cartao = new ArrayList<Permissao>(); //pode visualizar infos e criar cartão
		visu_cartao.add(Permissao.VISUALIZA_INFO);
		
		gpv.adicionaMembro(Admin1, Admin3, visu_cartao); 
		gpv.adicionaMembro(Admin1, UserConv1, visu_cartao); 
		gpv.adicionaMembro(Admin1, UserCom1, visu_cartao);
		gpv.adicionaMembro(Admin1, UserCom2, visu_cartao);
		
		System.out.println("\nNo grupo privado temos os seguintes membros ao adicionar:\n");
		for (int i = 0; i < gpv.getMembros().size(); i ++) {
			System.out.println(gpv.getMembros().get(i).getLogin());
		}
		System.out.println("---");

		gpu.adicionaMembro(Admin2, Admin3, visu_cartao); 
		gpu.adicionaMembro(Admin2, UserConv2, visu_cartao); 
		gpu.adicionaMembro(Admin2, UserCom2, visu_cartao);
		gpu.adicionaMembro(Admin2, UserCom3, visu_cartao);

		System.out.println("\nNo grupo público temos os seguintes membros ao adicionar:\n");
		for (int i = 0; i < gpu.getMembros().size(); i ++) {
			System.out.println(gpu.getMembros().get(i).getLogin());
		}
		System.out.println();
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("----------------------------------------- CRIANDO CARTÕES ---------------------------------------------\n");
		
		System.out.println("No grupo privado Admin1 vai criar todos os 6 cartões: \n");
		
		Admin1.criarCartao(gpv.getId(), 1, 5 , "Cartão 1 grupo privado", Admin1, "Assunto do Cartão 1 grupo privado", true);
		Admin1.criarCartao(gpv.getId(), 2, 5 , "Cartão 2 grupo privado", Admin3, "Assunto do Cartão 2 grupo privado", true);
		Admin1.criarCartao(gpv.getId(), 3, 4 , "Cartão 3 grupo privado", UserConv1, "Assunto do Cartão 3 grupo privado", true);
		Admin1.criarCartao(gpv.getId(), 4, 3 , "Cartão 4 grupo privado", UserConv1, "Assunto do Cartão 4 grupo privado", true);
		Admin1.criarCartao(gpv.getId(), 5, 2 , "Cartão 5 grupo privado", UserCom1, "Assunto do Cartão 5 grupo privado", true);
		Admin1.criarCartao(gpv.getId(), 6, 1 , "Cartão 6 grupo privado", UserCom2, "Assunto do Cartão 6 grupo privado", true);
		
		System.out.println("\nCartões do Grupo Privado a serem executados:\n");
		for (int i = 0; i < gpv.getCartoesAFazer().size(); i++) {
			System.out.println("-- Cartão " + i + ":");
			System.out.print("Nome: " + gpv.getCartoesAFazer().get(i).getNome() + "; ");
			System.out.print("Responsável: " + gpv.getCartoesAFazer().get(i).getResponsavel().getLogin() + "; ");
			System.out.println("Prioridade: " + gpv.getCartoesAFazer().get(i).getPrioridade());
		}
		System.out.println();
		
		System.out.println("No grupo público Admin2 vai criar todos os 6 cartões: \n");
		
		Admin2.criarCartao(gpu.getId(), 6, 5 , "Cartão 1 grupo público", Admin2, "Assunto do Cartão 1 grupo público", true);
		Admin2.criarCartao(gpu.getId(), 5, 5 , "Cartão 2 grupo público", Admin3, "Assunto do Cartão 2 grupo público", true);
		Admin2.criarCartao(gpu.getId(), 4, 4 , "Cartão 3 grupo público", UserConv2, "Assunto do Cartão 3 grupo público", true);
		Admin2.criarCartao(gpu.getId(), 3, 3 , "Cartão 4 grupo público", UserConv2, "Assunto do Cartão 4 grupo público", true);
		Admin2.criarCartao(gpu.getId(), 2, 2 , "Cartão 5 grupo público", UserCom2, "Assunto do Cartão 5 grupo público", true);
		Admin2.criarCartao(gpu.getId(), 1, 1 , "Cartão 6 grupo público", UserCom3, "Assunto do Cartão 6 grupo público", true);
		
		System.out.println("\nCartões do Grupo Público a serem executados:\n");
		for (int i = 0; i < gpu.getCartoesAFazer().size(); i++) {
			System.out.println("-- Cartão " + i + ":");
			System.out.print("Nome: " + gpu.getCartoesAFazer().get(i).getNome() + "; ");
			System.out.print("Responsável: " + gpu.getCartoesAFazer().get(i).getResponsavel().getLogin() + "; ");
			System.out.println("Prioridade: " + gpu.getCartoesAFazer().get(i).getPrioridade());
		}
		System.out.println();

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("----------------------------------------- EXECUTANDO CARTÕES CRIADOS ---------------------------------------------");
		
		System.out.println("Executando cartões do Grupo Privado:\n");
		
		System.out.println("Cartões do Grupo Privado a serem executados:\n");
		for (int i = 0; i < gpv.getCartoesAFazer().size(); i++) {
			System.out.println("-- Cartão " + i + ":");
			System.out.print("Nome: " + gpv.getCartoesAFazer().get(i).getNome() + "; ");
			System.out.print("Responsável: " + gpv.getCartoesAFazer().get(i).getResponsavel().getLogin() + "; ");
			System.out.println("Prioridade: " + gpv.getCartoesAFazer().get(i).getPrioridade());
		}
		System.out.println();
		
		Admin3.executarTarefaDeMaiorPrioridade();
		Admin1.executarTarefaDeMaiorPrioridade();
		UserCom1.executarTarefaDeMaiorPrioridade();
		UserConv1.executarTarefaDeMaiorPrioridade();
		UserCom2.executarTarefaDeMaiorPrioridade();
		
		System.out.println("Cartões do Grupo Privado já executados:\n");
		for (int i = 0; i < gpv.getCartoesFeitos().size(); i++) {
			System.out.println("-- Cartão " + i + ":");
			System.out.print("Nome: " + gpv.getCartoesFeitos().get(i).getNome() + "; ");
			System.out.print("Responsável: " + gpv.getCartoesFeitos().get(i).getResponsavel().getLogin() + "; ");
			System.out.println("Prioridade: " + gpv.getCartoesFeitos().get(i).getPrioridade());
		}
		System.out.println();
		
		System.out.println("Executando cartões do Grupo Público:\n");
		
		System.out.println("Cartões do Grupo Público a serem executados:\n");
		for (int i = 0; i < gpu.getCartoesAFazer().size(); i++) {
			System.out.println("-- Cartão " + i + ":");
			System.out.print("Nome: " + gpu.getCartoesAFazer().get(i).getNome() + "; ");
			System.out.print("Responsável: " + gpu.getCartoesAFazer().get(i).getResponsavel().getLogin() + "; ");
			System.out.println("Prioridade: " + gpu.getCartoesAFazer().get(i).getPrioridade());
		}
		System.out.println();
		
		Admin2.executarTarefaDeMaiorPrioridade();
		Admin3.executarTarefaDeMaiorPrioridade();
		UserConv2.executarTarefaDeMaiorPrioridade();
		UserCom2.executarTarefaDeMaiorPrioridade();
		UserCom3.executarTarefaDeMaiorPrioridade();
		
		System.out.println("Cartões do Grupo Público já executados:\n");
		for (int i = 0; i < gpu.getCartoesFeitos().size(); i++) {
			System.out.println("-- Cartão " + i + ":");
			System.out.print("Nome: " + gpu.getCartoesFeitos().get(i).getNome() + "; ");
			System.out.print("Responsável: " + gpu.getCartoesFeitos().get(i).getResponsavel().getLogin() + "; ");
			System.out.println("Prioridade: " + gpu.getCartoesFeitos().get(i).getPrioridade());
		}
		System.out.println();
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("----------------------------------------- VISUALIZANDO DADOS DO GRUPO ---------------------------------------------");		
		
		System.out.println("Grupo Privado:");
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
			System.out.print("Data de ativação: " + gpv.membros.get(i).getDataAtivacao() + ", ");
			System.out.print("Status: " + gpv.membros.get(i).getStatus() + ";" + "\n");
		}
		System.out.println();
		System.out.println("Membros com permissão de adicionar membros: ");
		for (int i = 0; i < gpv.permissaoAdicionar.size(); i++) {
			System.out.print(gpv.permissaoAdicionar.get(i).getLogin() + "; ");
		}
		System.out.println();
		System.out.println("\nMembros com permissão de remover membros: ");
		for (int i = 0; i < gpv.permissaoRemover.size(); i++) {
			System.out.print(gpv.permissaoRemover.get(i).getLogin() + "; ");
		}
		System.out.println();
		System.out.println("\nMembros com permissão de alterar permissões: ");
		for (int i = 0; i < gpv.permissaoAlterar.size(); i++) {
			System.out.print(gpv.permissaoAlterar.get(i).getLogin() + "; ");
		}
		System.out.println();
		System.out.println("\nMembros com permissão de visualizar dados do grupo: ");
		for (int i = 0; i < gpv.permissaoVisualizar.size(); i++) {
			System.out.print(gpv.permissaoVisualizar.get(i).getLogin() + "; ");
		}
		System.out.println();
		System.out.println("\nMembros com permissão de criar cartões no grupo: ");
		for (int i = 0; i < gpv.permissaoCriarCartao.size(); i++) {
			System.out.print(gpv.permissaoCriarCartao.get(i).getLogin() + "; ");
		}
		
		
		System.out.println("\n\nGrupo Público:");
		System.out.println("id do grupo: " + gpu.getId());
		System.out.println("Nome do grupo: " + gpu.getNome());
		System.out.println("Descrição do grupo: " + gpu.getDescricao());
		System.out.println("Dono do grupo: " + gpu.getDono().getLogin());
		System.out.println("Status do grupo: " + gpu.getStatus());
		System.out.println("Data de criação do grupo: " + gpu.getDataCriacao());
		System.out.println("Lista de Membros deste Grupo PÚblico:");
		for (int i = 0; i < gpu.membros.size(); i++) {
			System.out.println("-- Membro " + i + ": ");
			System.out.print(gpu.membros.get(i).getLogin()+ ", ");
			System.out.print(" (id: " + gpu.membros.get(i).getId() + "), ");
			System.out.print("e-mail: " + gpu.membros.get(i).getEmail() + ",");
			System.out.print("Senha: " + gpu.membros.get(i).getSenha() + ", ");
			System.out.print("Data de ativação: " + gpu.membros.get(i).getDataAtivacao() + ", ");
			System.out.print("Status: " + gpu.membros.get(i).getStatus() + ";" + "\n");
		}
		System.out.println();
		System.out.println("Membros com permissão de adicionar membros: ");
		for (int i = 0; i < gpu.permissaoAdicionar.size(); i++) {
			System.out.print(gpu.permissaoAdicionar.get(i).getLogin() + "; ");
		}
		System.out.println();
		System.out.println("\nMembros com permissão de remover membros: ");
		for (int i = 0; i < gpu.permissaoRemover.size(); i++) {
			System.out.print(gpu.permissaoRemover.get(i).getLogin() + "; ");
		}
		System.out.println();
		System.out.println("\nMembros com permissão de alterar permissões: ");
		for (int i = 0; i < gpu.permissaoAlterar.size(); i++) {
			System.out.print(gpu.permissaoAlterar.get(i).getLogin() + "; ");
		}
		System.out.println();
		System.out.println("\nMembros com permissão de visualizar dados do grupo: ");
		for (int i = 0; i < gpu.permissaoVisualizar.size(); i++) {
			System.out.print(gpu.permissaoVisualizar.get(i).getLogin() + "; ");
		}
		System.out.println();
		System.out.println("\nMembros com permissão de criar cartões no grupo: ");
		for (int i = 0; i < gpu.permissaoCriarCartao.size(); i++) {
			System.out.print(gpu.permissaoCriarCartao.get(i).getLogin() + "; ");
		}
	}

}