# Lab02 - Introdução a Atributos e Métodos Estáticos

## Objetivo
Familiarização a construção de classes que possuam atributos e métodos estáticos, bem como a utilização de sobrecarga de métodos e de construtores.

## Atividade
Continuação do laboratório anterior adicionando duas novas classes: Sala e Cartao.

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

### Classe Sala
#### Estrutura da classe Sala
##### Atributos
- _numeroSalas_: static int
- _id_: static int
- _capacidadeMaxima_: int
- _numeroUsuarios_: int
- _descricao_: String
- _dono_: Usuario
- _ingressoAutomatico_:  boolean
- _dataCriacao_: GregorianCalendar
##### Funções
- _toString()_: String
- _adiciona()_: boolean
- _removeUsuario()_: boolean
- _getNumeroSalas():_ static int

### Classe Cartao
#### Estrutura da classe Cartao
##### Atributos
- _numeroCartoes_: static int
- _id_: static int
- _visibilidade_: int
- _nome_: String
- _dono_: Usuario
- _invitationOnly_:  boolean
- _dataCriacao_: GregorianCalendar
##### Funções
- _toString()_: String
- _getNumeroCartoes()_: static int

## Classe Main
Na main ainda estão os objetos criados do Lab01.
Foram criados dois objetos do tipo Cartao e dois do tipo Sala, sendo que deve haver a sobrecarga de construtores.

## Questões do lab
Na main se encontram as respostas para as seguintes perguntas:
1. É possível escrever uma classe sem escrever nenhum construtor? Por quê?
2. Um método estático pode acessar uma variável (atributo) não estático da classe? Por quê?
3. Um método não estático pode acessar uma variável (atributo) estático da classe? Por quê?
