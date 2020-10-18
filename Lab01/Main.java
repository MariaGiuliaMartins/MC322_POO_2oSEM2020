/* RESPOSTAS DAS PERGUNTAS
 * 1 - Qual o impacto de se tentar mudar diretamente o valor do atributo login de um dos objetos Usuario no método main? Por
quê?
	Caso mudemos diretamente o valor do atributo login de um dos objetos Usuario no método main, não seria possível. Isso ocorre
	porque esse atributo é do tipo private, ou seja, não pode ser alterado depois de criado (a não ser pela própria classe).


 * 2 - Como você trataria o problema levantado na questão anterior? Qual seriam os prós e os contras desta nova abordagem?
Que conceito de Orientação a Objetos estaria sendo ”quebrado” neste caso?
	Caso precisasse mudar diretamente o valor do atributo login, eu poderia fazer de 2 formas: 1a forma - deleteria o login já atribuído ao perfil da pessoa e criaria 
um novo com novos atributos, consequentemente, com um novo login; 2a forma - mudaria o tipo de atributo da variável login de private para public, podendo mudar então 
o login do usuário.
	Prós:
		1a forma - manteria o tipo de atributo do login, assim todos os outros logins ficariam seguros.
		2a forma - não precisaria criar um novo usuário para o perfil que se dejesa mudar o login.
	Contras:
	 	1a forma - gastaria um certo tempo deletando um usuário já existente para ter criar outro novamente com todas os atributos novamente, podendo, então alterar o login.  
	 	2a forma - ao mudar o tipo de atributo para public, todos teriam acesso ao login do usuário, o que não é seguro para o sistema.
*/

import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) {
		//instanciando os objetos
		Usuario User1 = new Usuario(202819, "Maria Giulia", "giulia@gmail.com", "senha_da_Giulia", new GregorianCalendar(2017, 02, 15), false);
		Usuario User2 = new Usuario(184145, "Matheus", "matheus@gmail.com", "senha_do_Matheus", new GregorianCalendar(2016, 02, 15), true);	
		Perfil perf1 = new Perfil('f', new GregorianCalendar(1997, 11, 18), "Campinas", "SP", "+55 19 9 1818-1818", "Perfil 1", "foto_Maria_Giulia.png");
		Perfil perf2 = new Perfil('m', new GregorianCalendar(1995, 9, 17), "Diadema", "SP", "+55 19 9 1717-1717", "Perfil 2", "foto_Matheus.png");
		
		//imprimindo os objetos criados
		System.out.println("Usuário 1:\n" + User1);
		System.out.println("Usuário 2:\n" + User2);
		System.out.println("Perfil 1:\n" + perf1);
		System.out.println("Perfil 2:\n" + perf2);
	}

}
