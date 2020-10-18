# Lab01 - Introdução

## Objetivo
Familiarização com o ambiente de desenvolvimento integrado (IDE, Integrated Development Environment) chamado Eclipse e a linguagem de programação Java.

## Atividade
Criação de duas classes: Usuario e Perfil.

### Classe Usuario
Responsável por armazenar os dados únicos de acesso do usuário ao sistema.
#### Estrutura da classe Usuario
##### Atributos
- _id_ : int
- _login_: String
- _email_: String
- _senha_: String
- _dataAtavacao_ : GregorianCalendar
- _satus_: boolean
##### Funções
- _toString_: String

### Classe Perfil
Responsável por armazenar os dados que caracterizam o perfil de um usuário do sistema.
#### Estrutura da classe Perfil
##### Atributos
- _sexo_: char
- _dataNascimento_: GregorianCalendar
- _cidade_: String
- _estado_: String
- _telefone_: String
- _descricao_: String
- _foto_: String
##### Funções
- _toString_: String

## Classe Main
Na main foram criados dois objetos do tipo Usuario e dois objetos do tipo Perfil.

## Questões do lab
Na main se encontram as respostas para as seguintes perguntas:
1. Qual o impacto de se tentar mudar diretamente o valor do atributo login de um dos objetos Usuario no método main? Por quê?
2. Como você trataria o problema levantado na questão anterior? Qual seriam os prós e os contras desta nova abordagem? Que conceito de Orientação a Objetos estaria sendo ”quebrado” neste caso?
