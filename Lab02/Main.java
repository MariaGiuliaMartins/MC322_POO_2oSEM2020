/* RESPOSTAS DAS PERGUNTAS - Lab2
 * 1 - É possível escrever uma classe sem escrever nenhum construtor? Por quê?
 * 		A criação de uma classe sem construtor é possível de ser implementada, no entanto, quando
 * isso ocorre, um construtor padrão é cirado, ou seja, um construtor sem parâmetros é criado. Logo,
 * não é possível forçar um classe a não ter um construtor porque este é um elemento obrigatório em 
 * uma classe.
 * 
 * 2 - Um método estático pode acessar uma variável (atributo) não estático da classe? Por quê?
 * 		Um método estático não pode acessar um atributo não estático da classe. Isso ocorre porque um 
 * método estático não depende da criação de um objeto para ser chamado, no entanto o método não estático 
 * depende, então fica inviável um método estático lidar com atributos não estático. Outra explicação é que
 * o método estático serve para acessar o comportamento da sala e não de um objeto, para o úlitmo caso, 
 * utiliza-se o método não estático.
 * 
 * 3 - Um método não estático pode acessar uma variável (atributo) estático da classe? Por quê?
 * 		Um método estático pode acessar uma variávek estática, no entanto não é possível alterar o conteúdo 
 * dessa variável, pois a variável estática pertence à classe e não ao objeto (este que está diretamente 
 * ligado ao método não estático).
 */

import java.util.GregorianCalendar; //para o calendario
import java.util.Scanner; //para ler a entrada do teclado

public class Main {

	private static Scanner digitado;

	public static void main(String[] args) {
		//instanciando os objetos
		Usuario User1 = new Usuario(202819, "Maria Giulia", "giulia@gmail.com", "senha_da_Giulia", new GregorianCalendar(2017, 03, 15), false);
		Usuario User2 = new Usuario(184145, "Matheus", "matheus@gmail.com", "senha_do_Matheus", new GregorianCalendar(2016, 03, 15), true);	
		Perfil perf1 = new Perfil('f', new GregorianCalendar(1997, 11, 18), "Campinas", "SP", "+55 19 9 1818-1818", "Perfil 1", "foto_Maria_Giulia.png");
		Perfil perf2 = new Perfil('m', new GregorianCalendar(1995, 9, 17), "Diadema", "SP", "+55 19 9 1717-1717", "Perfil 2", "foto_Matheus.png");
		
		//imprimindo os objetos criados
		System.out.println("Usuário 1:\n" + User1);
		System.out.println("Usuário 2:\n" + User2);
		System.out.println("Perfil 1:\n" + perf1);
		System.out.println("Perfil 2:\n" + perf2);
		
		System.out.println("\n");
		System.out.println("Olá "+ User1.getLogin() + ", vamos criar uma sala e um cartão...");
		System.out.println("Para isso, é preciso que preencha alguns dados abaixo.");
		
		
		//criando a sala com contrutor com parametros
		boolean preenchendo_dados_sala1 = true;
		while(preenchendo_dados_sala1) {
			digitado = new Scanner(System.in);
				
			System.out.println("Descreva a sua sala: ");				
			String descricao1 = digitado.nextLine();
			
			System.out.println("Digite a capacidade da sua sala: ");
			int capacidade1 = digitado.nextInt();
							
			System.out.println("Se quiser permitir a entrada de pessoas automaticamente, digite true, senão digite false: ");
			boolean ingressoAutomatico1 = digitado.nextBoolean();
			
			System.out.println("Dia de criação da sua sala: ");
			int dia = digitado.nextInt();
			System.out.println("Mês de criação da sua sala: ");
			int mes = digitado.nextInt();
			System.out.println("Ano de criação da sua sala: ");
			int ano = digitado.nextInt();
			GregorianCalendar dataCriacao1 = new GregorianCalendar(ano, mes, dia);
			
			Sala sala1 = new Sala(capacidade1, descricao1, User1, ingressoAutomatico1, dataCriacao1);
			System.out.println("Sala criada com sucesso!!!");
			
			System.out.println("Deseja adicionar mais usuários? (responda 1 para sim ou 0 para não): ");
			int resposta1 = digitado.nextInt();
			if (resposta1 == 1) {
				System.out.println("Quantos? \n");
				int quant1 = digitado.nextInt();
				while(quant1 != 0) { //adicionando o número de usuários correspondentes
					sala1.adicionaUsuario();
					quant1--;
				}
			}	
				
				
			System.out.println("Sala 1: \n" + sala1);
			
			preenchendo_dados_sala1 = false;
		}
		
		System.out.println("\n");
		System.out.println("Agora vamos criar seu cartão.");
		
		//criando um cartao com o construtor com parametros
		boolean preenchendo_dados_cartao1 = true;
		while(preenchendo_dados_cartao1) {
			digitado = new Scanner(System.in);
				
			System.out.println("Dê um nome a seu cartão: ");				
			String nome1 = digitado.nextLine();
			
			System.out.println("Digite um número inteiro para a visibilidade do seu cartão (quanto maior o número, mais visível): ");
			int visibilidade1 = digitado.nextInt();
							
			System.out.println("Digite true ou false para o campo invitation only: ");
			boolean invitationOnly1 = digitado.nextBoolean();
			
			System.out.println("Dia de criação do seu cartao: ");
			int dia = digitado.nextInt();
			System.out.println("Mês de criação do seu cartão: ");
			int mes = digitado.nextInt();
			System.out.println("Ano de criação do seu cartao: ");
			int ano = digitado.nextInt();
			GregorianCalendar dataCriacao2 = new GregorianCalendar(ano, mes, dia);
			
			Cartao cartao1 = new Cartao(visibilidade1, nome1, User1, invitationOnly1, dataCriacao2);
			System.out.println("Cartão criado com sucesso!!!");
				
								
			System.out.println("Cartão 1: \n" + cartao1);
			
			preenchendo_dados_cartao1 = false;
		}
		
		System.out.println("--------------------------------------------------------------------------");
		
		System.out.println("Olá "+ User2.getLogin() + ", vamos criar uma sala e um cartão...");
		System.out.println("Para isso, é preciso que preencha alguns dados abaixo.");
		
		//criando a sala com contrutor sem parametros
		boolean preenchendo_dados_sala2 = true;
		while(preenchendo_dados_sala2) {
			//criando a sala
			Sala sala2 = new Sala();
			
			sala2.setDono(User2);
			
			digitado = new Scanner(System.in);
		
			System.out.println("Descreva a sua sala: ");				
			String descricao2 = digitado.nextLine();
			sala2.setDescricao(descricao2);
			
			System.out.println("Digite a capacidade da sua sala: ");
			int capacidade2 = digitado.nextInt();
			sala2.setCapacidadeMaxima(capacidade2);
							
			System.out.println("Se quiser permitir a entrada de pessoas automaticamente, digite true, senão digite false: ");
			boolean ingressoAutomatico2 = digitado.nextBoolean();
			sala2.setIngressoAutomatico(ingressoAutomatico2);
			
			System.out.println("Dia de criação da sua sala: ");
			int dia = digitado.nextInt();
			System.out.println("Mês de criação da sua sala: ");
			int mes = digitado.nextInt();
			System.out.println("Ano de criação da sua sala: ");
			int ano = digitado.nextInt();
			GregorianCalendar dataCriacao3 = new GregorianCalendar(ano, mes, dia);
			sala2.setDataCriacao(dataCriacao3);
			
			System.out.println("Sala criada com sucesso!!! \n");
			
			System.out.println("Deseja adicionar mais usuários? (responda 1 para sim ou 0 para não):");
			int resposta2 = digitado.nextInt();
			if (resposta2 == 1) {
				System.out.println("Quantos?");
				int quant2 = digitado.nextInt();
				while(quant2 != 0) { //adicionando o número de usuários correspondentes
					sala2.adicionaUsuario();
					quant2--;
				}
			}	
				
			System.out.println("Sala 2: \n" + sala2);
			
			preenchendo_dados_sala2 = false;
		}
		
		System.out.println("\n");
		System.out.println("Agora vamos criar seu cartão.");
		
		//criando um cartao com o construtor com parametros
		boolean preenchendo_dados_cartao2 = true;
		while(preenchendo_dados_cartao2) {
			//criando o cartao
			Cartao cartao2 = new Cartao();
			cartao2.setDono(User2);
			digitado = new Scanner(System.in);
				
			System.out.println("Dê um nome a seu cartão: ");				
			String nome2 = digitado.nextLine();
			cartao2.setNome(nome2);
			
			System.out.println("Digite um número inteiro para a visibilidade do seu cartão (quanto maior o número, mais visível): ");
			int visibilidade2 = digitado.nextInt();
			cartao2.setVisibilidade(visibilidade2);
							
			System.out.println("Digite true ou false para o campo invitation only: ");
			boolean invitationOnly2 = digitado.nextBoolean();
			cartao2.setInvitationOnly(invitationOnly2);
			
			System.out.println("Dia de criação do seu cartao: ");
			int dia = digitado.nextInt();
			System.out.println("Mês de criação do seu cartão: ");
			int mes = digitado.nextInt();
			System.out.println("Ano de criação do seu cartao: ");
			int ano = digitado.nextInt();
			GregorianCalendar dataCriacao4 = new GregorianCalendar(ano, mes, dia);
			cartao2.setDataCriacao(dataCriacao4);
			
			System.out.println("Cartão criado com sucesso!!! \n");
														
			System.out.println("Cartão 2: \n" + cartao2);
			
			preenchendo_dados_cartao2 = false;
		}
		
		System.out.println("Checando informações relevantes:");
		System.out.println("Número de salas criadas: " + Sala.getNumeroSalas());
		System.out.println("Número de cartões criados: " + Cartao.getNumeroCartoes());
		
	}

}
